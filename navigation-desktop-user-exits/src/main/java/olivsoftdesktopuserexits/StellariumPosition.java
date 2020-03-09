package olivsoftdesktopuserexits;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.GeoPos;

import olivsoftdesktop.DesktopUserExitInterface;

/**
 * Refresh position data everytime the cache is touched.
 * Write the position into some files, to be used by Stellarium for a user position.
 */
public class StellariumPosition
  implements DesktopUserExitInterface
{
  private GeoPos currentPos = null;
  private static boolean verbose = "true".equals(System.getProperty("verbose", "false"));

  private Thread watcher = null;
  private boolean keepWatching = true;
  
  private long betweenLoops = 60 * 1000L; // 1 minute default
  private Properties stellariumProperties = null;
  private String locationName = "GPS Position";
  
  public StellariumPosition()
  {
    super();
    stellariumProperties = new Properties();
    try
    {
      stellariumProperties.load(new FileReader("stellarium.properties"));
      locationName = stellariumProperties.getProperty("location.name", locationName);
      System.out.println(">>> DEBUG-UE >>> Location Name is [" + locationName + "]");
    }
    catch (Exception ex)
    {
      System.err.println("Reading stellarium.properties:");
      ex.printStackTrace();
    }
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    NMEAContext.getInstance().addNMEAReaderListener(new NMEAReaderListener("UserExit", "Stellarium")
    {
      @Override
      public void manageNMEAString(String nmeaString)
      {
        NMEADataCache dc = NMEAContext.getInstance().getCache();
        try
        {
          GeoPos pos = null;
          try 
          { 
            synchronized (dc)
            {
              pos = ((GeoPos)dc.get(NMEADataCache.POSITION)); 
              currentPos = pos;
            }
          } 
          catch (Exception ex) {}
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
    watcher = new Thread("StellariumListener")
      {
        private final long BETWEEN_LOOPS = _betweenLoops;
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
            if (currentPos != null)
            {
              synchronized (currentPos)
              {
                try
                {
                  System.out.println(currentPos.toString());
                  // Write the files                                                                                                                                     2 meters (alt.)
                  //                                                                                                                                                     |             
                  String userLocationLine = locationName + "\t\tAutomatic\t\0\t147127\t" + Double.toString(currentPos.lat) + "\t" + Double.toString(currentPos.lng) + "\t2\t2\t\tEarth\t";
                  System.out.println(userLocationLine);
                  BufferedWriter bw = new BufferedWriter(new FileWriter("stellarium.txt"));
                  bw.write(userLocationLine + "\n");
                  bw.close();
                  // Modify the actual user_positions.txt
                  // Located somewhere like C:/Users/olediour.ORADEV/AppData/Roaming/Stellarium/data/user_locations.txt
                  if (stellariumProperties != null)
                  {
                    String ul = stellariumProperties.getProperty("user.locations");
                    File ulf = new File(ul);
                    if (!ulf.exists())
                      System.err.println("File [" + ul + "] not found");
                    else
                    {
                      // Read
                      BufferedReader br = new BufferedReader(new FileReader(ulf));
                      List<String> fileContent = new ArrayList<String>();
                      String line = "";
                      while (line != null)
                      {
                        line = br.readLine();
                        if (line != null)
                          fileContent.add(line);
                      }
                      br.close();
                      // Does the "GPS Position" line already exist?
                      boolean found = false;
                      for (int i=0; i<fileContent.size(); i++)
                      {
                        String s = fileContent.get(i);
                        if (s.startsWith(locationName)) // 
                        {
                          found = true;
                          fileContent.set(i, userLocationLine);
                          break;
                        }
                      }
                      if (!found)
                        fileContent.add(userLocationLine);
                      // Write
                      BufferedWriter ubw = new BufferedWriter(new FileWriter(ulf));
                      for (String s : fileContent)
                        ubw.write(s + "\n");
                      ubw.close();
                    }
                  }
                }
                catch (Exception ex)
                {
                  ex.printStackTrace();
                }
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
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    keepWatching = false;
    synchronized (watcher)
    {
      watcher.notify();
    }
  }
  
  @Override
  public void describe()
  {
    System.out.println("This user-exit will insert the GPS Position in the user_locations.txt file of Stellarium");
    System.out.println("This way, when Stellarium is started, there is a position named 'GPS Position' in the location list.");
    System.out.println("If this is set to the default position, then Stellarium will show the sky at the vessel's location.");
    System.out.println("This is something Navigatrix is doing, and that is quite convenient!");
    System.out.println("This relies on a file named 'stellarium.properties', that must contain a property named 'user.locations' " +   
                       "giving the location of the user_locations.txt file of Stellarium. Use forward slashes '/' for the path, even on Windows.");
    System.out.println("'stellarium.properties' can also contain a property name 'location.name' (default is 'GPS Position') that will " +
                       "be used in user_locations.txt");
  }
}
