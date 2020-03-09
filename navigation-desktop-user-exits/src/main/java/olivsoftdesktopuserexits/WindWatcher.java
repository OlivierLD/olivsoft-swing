package olivsoftdesktopuserexits;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.UTCDate;

import olivsoftdesktop.DesktopUserExitInterface;

import olivsoftdesktopuserexits.emailutil.EmailReceiver;
import olivsoftdesktopuserexits.emailutil.EmailSender;

import olivsoftdesktopuserexits.ziputil.ZipWriter;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Gather wind data everytime the cache is touched.
 * Put TWS, TWD, DATE, LAT, LNG in a json object array.
 *
 * Send the json object attached to an email on a regular base.
 */
public class WindWatcher
  implements DesktopUserExitInterface
{
  private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
  private static boolean verbose = "true".equals(System.getProperty("verbose", "false"));

  private static String SEND_PROVIDER    = "google";
  private static String RECEIVE_PROVIDER = "google";

  private Thread watcher = null;
  private boolean keepWatching = true;
  private EmailSender sender = null;
  
  private long betweenLoops = 600 * 1000L; // 10 minutes default
  
  private List<JSONObject> dataCollection = null;
  
  private WindWatcher instance = this;
  final Properties props;

  
  public WindWatcher()
  {
    super();
    props = new Properties();
    String propFile = "email.properties";
    try
    {
      FileInputStream fis = new FileInputStream(propFile);
      props.load(fis);
    }
    catch (Exception e)
    {
      System.err.println("email.properies file problem..., from " + System.getProperty("user.dir"));
      throw new RuntimeException("File not found:email.properies");
    }
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    SEND_PROVIDER = props.getProperty("ue.preferred.provider", SEND_PROVIDER);
    RECEIVE_PROVIDER = props.getProperty("ue.preferred.provider", RECEIVE_PROVIDER);

    sender = new EmailSender(SEND_PROVIDER);
    try
    {
      betweenLoops = Long.parseLong(props.getProperty("ue.between.loops.in.minute"));
    }
    catch (NumberFormatException nfe)
    {
      throw new RuntimeException("Bad Loop interval:" + props.getProperty("ue.between.loops.in.minute"));
    }
    
    NMEAContext.getInstance().addNMEAReaderListener(new NMEAReaderListener("UserExit", "WindWatcher")
    {
      @Override
      public void manageNMEAString(String nmeaString)
      {
        NMEADataCache dc = NMEAContext.getInstance().getCache();
        try
        {
          double tws = ((Speed) dc.get(NMEADataCache.TWS)).getValue();
          double twd = ((Angle360) dc.get(NMEADataCache.TWD)).getValue();
          long date = 0L;
          UTCDate utcDate = (UTCDate)NMEAContext.getInstance().getCache().get(NMEADataCache.GPS_DATE_TIME);      
          if (utcDate != null && utcDate.getValue() != null)
          {
            Date d = utcDate.getValue();
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));      
            date = cal.getTime().getTime();
          }
          GeoPos pos = null;
          try { pos = ((GeoPos)dc.get(NMEADataCache.POSITION)); } catch (Exception ex) {}
          if (!Double.isInfinite(tws))
          {
            if (dataCollection == null)
              dataCollection = new ArrayList<JSONObject>();
            synchronized (dataCollection)
            {
              JSONObject windSample = new JSONObject();
              windSample.put("twd", twd);
              windSample.put("tws", tws);
              windSample.put("date", date);
              windSample.put("lat", pos.lat);
              windSample.put("lng", pos.lng);
              dataCollection.add(windSample);
            }
          }
        }
        catch (NullPointerException npe)
        {
          // Just wait til next time...
          System.out.println("Cache not initialized (yet), waiting 1 s.");
          try { Thread.sleep(1000L); } catch (Exception ex) {}
        }
      }
    });
    
    final long _betweenLoops = betweenLoops;
    watcher = new Thread("WindWatcher") // Send the data (through email)
      {
        private final long BETWEEN_LOOPS = _betweenLoops * 60 * 1000;
        private long waitTime = BETWEEN_LOOPS;
        public void run()
        {
          while (keepWatching)
          {
            waitTime = BETWEEN_LOOPS;
            synchronized (this)
            {
              System.out.println("  ...User exit going to wait, at " + new Date().toString() + " (will wait for " + (waitTime / 1000) + " s)");
              try { wait(waitTime); } 
              catch (InterruptedException ie)
              {
                System.out.println("Told to stop!");
                keepWatching = false;
              }
            }
            synchronized (dataCollection)
            {
              try
              {
                JSONArray jsonarray = new JSONArray(dataCollection);
                String attachmentName = "temp" + File.separator + "windsample.json";
                BufferedWriter bw = new BufferedWriter(new FileWriter(attachmentName));
                bw.write(jsonarray.toString(2));
                bw.close();
                dataCollection.clear();
                // Zip the file before sending
                String zipped = "temp" + File.separator + "data.wwzip"; // The zip extension might be banned on some email servers
                ZipWriter.zip(attachmentName, zipped);
                sender.send("Wind Samples", "See attached", zipped);
                System.out.println("Email sent, using [" + SEND_PROVIDER + "].");
              }
              catch (Exception ex)
              {
                System.err.println("Sending email failed through [" + SEND_PROVIDER + "]");
                ex.printStackTrace();
              }
            }
          }
          System.out.println("Stop waiting.");
        }
      };
    keepWatching = true;
    watcher.start();
    
    // Poll email for: exit, send-now
    Thread emailListener = new Thread("WindWatcherEmailListener")
      {
        public void run()
        {
          EmailReceiver receiver = new EmailReceiver(RECEIVE_PROVIDER); // For Google, pop must be explicitely enabled at the account level
          try
          {
            System.out.println("--------------------------");
            System.out.println("Waiting for instructions.");
            System.out.println("Understands emails with subject [" + props.getProperty("ue.email.subject") + "]");
            System.out.println("Managed messages are:");
            System.out.println(" { operation: 'exit' }");
            System.out.println(" { operation: 'send-now' }");
            System.out.println("--------------------------");
            boolean keepLooping = true;
            while (keepLooping)
            {
              List<String> received = receiver.receive();
              if (received.size() > 0)
              System.out.println(SDF.format(new Date())  + " - Retrieved " + received.size() + " message(s).");
              for (String s : received)
              {
          //    System.out.println(s);
                String operation = "";
                try
                {
                  JSONObject json = new JSONObject(s);
                  operation = json.getString("operation");
                }
                catch (Exception ex)
                {
                  System.err.println(ex.getMessage());
                  System.err.println("Message is [" + s + "]");
                }
                if ("exit".equals(operation))
                {
                  keepLooping = false;
                  System.out.println("Will exit next batch.");
              //  break;
                }
                else
                {
                  if ("exit".equals(operation))
                  {
                    System.out.println("Exit request");
                    instance.stop();
                  }
                  else if ("send-now".equals(operation))
                  {
                    System.out.println("Sending now");
                    instance.sendNow();
                  }
                  try { Thread.sleep(1000L); } catch (InterruptedException ie) { ie.printStackTrace(); }
                }
              }
            }
            // TODO shutdown();
            System.out.println("Done.");
            System.exit(0);
          }
          catch (Exception ex)
          {
            System.err.println("In WindWatcher, email listener loop.");
            ex.printStackTrace();
          }
        }
      };
    emailListener.start();
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    keepWatching = false;
    synchronized (watcher)
    {
      watcher.notify();
    }
  }
  
  public void sendNow()
  {
    System.out.println(this.getClass().getName() + " is told to send data now.");
    keepWatching = true; // Useless...
    synchronized (watcher)
    {
      watcher.notify();
    }
  }

  @Override
  public void describe()
  {
    System.out.println("Gathers all wind data (registers an NMEAReaderListener) and sends them through an email on a regular base.");
    System.out.println("Emails sent with [" + props.getProperty("ue.preferred.provider") + "]");
    System.out.println("   received with [" + props.getProperty("ue.preferred.provider") + "]");
    System.out.println("Driven by email.properties (in the all-scripts directory)");
    System.out.println("Can also be driven from emails. Emails must be in plain text, the contain a json object (explained at startup).");
  }
}
