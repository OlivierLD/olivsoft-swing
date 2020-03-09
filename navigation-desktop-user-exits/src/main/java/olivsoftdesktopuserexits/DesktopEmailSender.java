package olivsoftdesktopuserexits;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;
import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.UTCDate;
import olivsoftdesktop.DesktopUserExitInterface;
import olivsoftdesktopuserexits.emailutil.EmailSender;

public class DesktopEmailSender
  implements DesktopUserExitInterface
{
  private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
  private final static DecimalFormat DF22   = new DecimalFormat("##0.00 'kts'");
  private final static DecimalFormat DF30   = new DecimalFormat("##0'\272'");
  private static String SEND_PROVIDER = "google";
  private Thread watcher = null;
  private boolean keepWatching = true;
  private EmailSender sender = null;
  
  private double windThreshold = -1;
  private long betweenLoops = 600 * 1000L; // 10 minutes default
  
  public DesktopEmailSender()
  {
    super();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    Properties props = new Properties();
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
    SEND_PROVIDER = props.getProperty("ue.preferred.provider", SEND_PROVIDER);
    sender = new EmailSender(SEND_PROVIDER);
    try
    {
      windThreshold = Double.parseDouble(props.getProperty("ue.wind.threshold"));
      System.out.println("Will send emails when the wind is above [" + windThreshold + "]");
    }
    catch (NumberFormatException nfe)
    {
      throw new RuntimeException("Bad wind threshold:" + props.getProperty("ue.wind.threshold"));
    }
    try
    {
      betweenLoops = Long.parseLong(props.getProperty("ue.between.loops.in.minute"));
    }
    catch (NumberFormatException nfe)
    {
      throw new RuntimeException("Bad Loop interval:" + props.getProperty("ue.between.loops.in.minute"));
    }
    final long _betweenLoops = betweenLoops;
    watcher = new Thread("EmailSenderWatcher")
      {
        private boolean started = false;
        private final long BETWEEN_LOOPS = _betweenLoops * 60 * 1000;
        private final long TEN_SECONDS   =  10000L;
        private long waitTime = BETWEEN_LOOPS;
        public void run()
        {
          while (keepWatching)
          {
            waitTime = BETWEEN_LOOPS;
            NMEADataCache dc = NMEAContext.getInstance().getCache();
            try
            {
              double tws = ((Speed) dc.get(NMEADataCache.TWS)).getValue();
              double twd = ((Angle360) dc.get(NMEADataCache.TWD)).getValue();
              String date = "";
              UTCDate utcDate = (UTCDate)NMEAContext.getInstance().getCache().get(NMEADataCache.GPS_DATE_TIME);      
              if (utcDate != null && utcDate.getValue() != null)
              {
                Date d = utcDate.getValue();
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                cal.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));      
                date = SDF.format(cal.getTime());
              }
              String pos = "";
              try { pos = ((GeoPos)dc.get(NMEADataCache.POSITION)).toString(); } catch (Exception ex) {}
              if (!started)
              {
                started = true;
                System.out.println(" -- User exit started for good.");
              }
              if (tws > windThreshold && !Double.isInfinite(tws))
              {
                String alertMessage = 
                  (date.trim().length() > 0 ? "Date:" + date + "\n": "") +
                  (pos.trim().length() > 0 ? "Pos:" + pos + "\n" : "") + 
                  "Wind is over " + DF22.format(windThreshold) + ":" + DF22.format(tws) + ", TWD:" + DF30.format(twd);
                System.out.println(alertMessage);        
                // Send an email...
                try
                {
                  sender.send(alertMessage);
                  System.out.println("Email sent.");
                }
                catch (Exception ex)
                {
                  System.err.println("Sending email failed through [" + SEND_PROVIDER + "]");
                  ex.printStackTrace();
                }
              }
            }
            catch (NullPointerException npe)
            {
              // Just wait til next time...
              System.out.println("Cache not initialized (yet)");
              waitTime = TEN_SECONDS;
            }
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
          }
          System.out.println("Stop waiting.");
        }
      };
    keepWatching = true;
    watcher.start();
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating");
    keepWatching = false;
    synchronized (watcher)
    {
      watcher.notify();
    }
  }

  @Override
  public void describe()
  {
    System.out.println("Polls the NMEA Cache on a regular base, and sends an email if the TWS is above a given threshold.");
    System.out.println("Driven by a properties file named email.properties, in the all-scripts directory.");
  }
}
