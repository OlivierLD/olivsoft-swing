package olivsoftdesktopuserexits.sample;

import java.util.List;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;

import ocss.nmea.api.NMEAEvent;
import ocss.nmea.api.NMEAListener;
import ocss.nmea.parser.StringParsers;

import olivsoftdesktop.DesktopUserExitInterface;

/**
 * An example.
 * Shows how to inject a custom NMEA Sentence in the cache.
 *
 * to be used with -ue:olivsoftdesktopuserexits.coreutilities.sample.CustomSentenceInsertion
 */
public class CustomSentenceInsertion
  implements DesktopUserExitInterface
{
  private boolean keepGoing = true;
  
  public CustomSentenceInsertion()
  {
    super();
  }
  
  private boolean keepRunning()
  {
    return keepGoing;
  }
  
  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    Thread ue = new Thread("RandomNumberGenerator")
      {
        public void run()
        {
          while (keepRunning())
          {
            try
            {
              String customString = generateSentence("AA", "RND", Double.toString(Math.random()));
              broadcastNMEASentence(customString);       
          //  System.out.println(">>> " + customString);
              Thread.sleep(1000L);
            }
            catch (Exception ex)
            {
              ex.printStackTrace();
            }            
          }
        }
      };
    ue.start();
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    keepGoing = false;
  }
  
  @Override
  public void describe()
  {
    System.out.println("An example.");
    System.out.println("Shows how to inject a custom NMEA Sentence in the cache.");
  }
  
  // Custom methods
  public static String generateSentence(String devicePrefix, String id, String value)
  {
    String custom = devicePrefix + id + "," + value;
    // Checksum
    int cs = StringParsers.calculateCheckSum(custom);
    custom += ("*" + lpad(Integer.toString(cs, 16).toUpperCase(), "0", 2));
    return "$" + custom;
  }
  
  private synchronized void broadcastNMEASentence(String nmea)
  {
    synchronized (NMEAContext.getInstance().getCache())
    {
      List<NMEAListener> listOne = NMEAContext.getInstance().getNMEAListeners();
      synchronized (listOne)
      {
        for (NMEAListener l : listOne)
        {
          synchronized (l)
          {
            try { l.dataDetected(new NMEAEvent(this, nmea)); }
            catch (Exception err)
            {
              err.printStackTrace();
            }
          }
        }
      }
      List<NMEAReaderListener> listTwo = NMEAContext.getInstance().getReaderListeners();
      synchronized (listTwo)
      {
        for (NMEAReaderListener l : listTwo)
        {
          synchronized (l)
          {
            try { l.manageNMEAString(nmea); } 
            catch (Exception err)
            {
              err.printStackTrace();
            }
          }
        }
      }
    }
  }  
  
  private static String lpad(String str, String with, int len)
  {
    String s = str;
    while (s.length() < len)
      s = with + s;
    return s;
  }
}
