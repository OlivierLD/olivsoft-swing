package olivsoftdesktopuserexits.sample;

import java.util.ConcurrentModificationException;
import java.util.List;

import java.util.Map;
import java.util.Set;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;

import nmea.server.ctx.NMEADataCache;

import ocss.nmea.api.NMEAEvent;
import ocss.nmea.api.NMEAListener;
import ocss.nmea.parser.Angle180;
import ocss.nmea.parser.Angle180EW;
import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.StringGenerator;
import ocss.nmea.parser.StringParsers;

import ocss.nmea.parser.TrueWindSpeed;

import olivsoftdesktop.DesktopUserExitInterface;

/**
 * An example.
 * Shows how to inject NMEA Sentences in the cache.
 * Injects True Wind speed and direction
 *         Current speed and direction
 *
 * to be used with -ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion
 */
public class TrueWindSentenceInsertion
  implements DesktopUserExitInterface
{
  private boolean keepGoing = true;
  private static boolean verbose = "true".equals(System.getProperty("tw.verbose", "false"));

  // Warning! 2 characters. No more, no less.
  private final static String DEFAULT_PREFIX = "OS"; // Oliv Soft
  private static String GENERATED_STRINGS_PREFIX = System.getProperty("generated.nmea.prefix", DEFAULT_PREFIX);
  
  public TrueWindSentenceInsertion()
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
    if (GENERATED_STRINGS_PREFIX.trim().length() != 2)
    {
      System.out.println(String.format(" >>> Invalid NMEA Prefix [%s], reseting to [%s].", GENERATED_STRINGS_PREFIX, DEFAULT_PREFIX));
      GENERATED_STRINGS_PREFIX = DEFAULT_PREFIX;
    }
    System.out.println("-------------------------------");
    System.out.println(String.format(" >> NMEA Device Prefix for generated strings: [%s]", GENERATED_STRINGS_PREFIX));
    System.out.println("-------------------------------");

    Thread ue = new Thread("TrueWindSentenceInsertion")
      {
        public void run()
        {
          this.setPriority(Thread.MIN_PRIORITY);
          while (keepRunning())
          {            
            try
            {
              NMEADataCache ndc = NMEAContext.getInstance().getCache();
              double twa = 0d; 
              double tws = 0d; 
              double twd = 0;
              double decl = 0;
              double csp = 0;
              int cdr = 0;
              synchronized (ndc)
              {
                // True Wind
                try { twa = ((Angle180) ndc.get(NMEADataCache.TWA)).getValue(); } 
                catch (NullPointerException ignore) {}
                catch (Exception ignore) { System.err.println("From " + this.getClass().getName() + ", getting TWA from the cache:" + ignore.toString()); }
                try { tws = ((TrueWindSpeed) ndc.get(NMEADataCache.TWS)).getValue(); } 
                catch (NullPointerException ignore) {}
                catch (Exception ignore) { System.err.println("From " + this.getClass().getName() + ", getting TWS from the cache:" + ignore.toString()); }
                try { twd = ((Angle360) ndc.get(NMEADataCache.TWD)).getValue(); } 
                catch (NullPointerException ignore) {}
                catch (Exception ignore) { System.err.println("From " + this.getClass().getName() + ", getting TWD from the cache:" + ignore.toString()); }
                try { decl = ((Angle180EW) ndc.get(NMEADataCache.DECLINATION)).getValue(); } 
                catch (NullPointerException ignore) {}
                catch (Exception ignore) { System.err.println("From " + this.getClass().getName() + ", getting Decl from the cache:" + ignore.toString()); }
                
                try
                {
                  long currentTimeBuffer = 0L;
                  Map<Long, NMEADataCache.CurrentDefinition> currentMap = 
                                      ((Map<Long, NMEADataCache.CurrentDefinition>)ndc.get(NMEADataCache.CALCULATED_CURRENT));
                  Set<Long> keys = currentMap.keySet();
              //  if (keys.size() != 1)
              //    System.out.println("1 - Nb entry(ies) in Calculated Current Map:" + keys.size());
                  for (Long l : keys)
                  {
                    int tbl = (int)(l / (60 * 1000));
                    if (tbl > currentTimeBuffer) // Take the bigger one.
                    {
                      currentTimeBuffer = tbl;
                      csp = currentMap.get(l).getSpeed().getValue();
                      cdr = (int)Math.round(currentMap.get(l).getDirection().getValue());
                    }
                  }
                }
                catch (NullPointerException ignore) {}
                catch (Exception ignore) 
                {
                  System.err.println("From " + this.getClass().getName() + ", getting CALCULATED_CURRENT from the cache:" + ignore.toString()); 
                }        
              }
          //  System.out.println("From TrueWindSentenceInsertion, TWS:" + tws);
              
              String nmeaVWT = StringGenerator.gerenateVWT(GENERATED_STRINGS_PREFIX, tws, twa);      
              String nmeaMWV = StringGenerator.generateMWV(GENERATED_STRINGS_PREFIX, tws, 
                                                           (int)Math.round(twa), 
                                                           StringParsers.TRUE_WIND);
              String nmeaMWD = StringGenerator.generateMWD(GENERATED_STRINGS_PREFIX, twd, tws, decl);

              broadcastNMEASentence(nmeaMWV);
              broadcastNMEASentence(nmeaVWT);
              broadcastNMEASentence(nmeaMWD);
              if (csp != 0 && cdr != 0)
              {
                String nmeaVDR = StringGenerator.generateVDR(GENERATED_STRINGS_PREFIX, csp, cdr, cdr - decl);
                broadcastNMEASentence(nmeaVDR);
              }

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
    System.out.println("Shows how to inject True Wind and Current NMEA Sentences in the cache.");
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
    if (verbose)
      System.out.println("...TrueWindSentenceInsertion (" + System.currentTimeMillis() + ") Broadcasting [" + nmea + "]");
//  synchronized (NMEAContext.getInstance().getCache())
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
        try
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
        catch (ConcurrentModificationException cmex)
        {
          System.err.println("--> Conflict in " + this.getClass().getName() + " (ConcurrentModificationException)");
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }
    }
    if (verbose)
      System.out.println("...TrueWindSentenceInsertion " + System.currentTimeMillis() + " Broadcasted!");
  }  
  
  private static String lpad(String str, String with, int len)
  {
    String s = str;
    while (s.length() < len)
      s = with + s;
    return s;
  }
}
