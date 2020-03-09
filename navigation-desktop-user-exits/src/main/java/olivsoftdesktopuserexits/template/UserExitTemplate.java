package olivsoftdesktopuserexits.template;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.UTCDate;

import olivsoftdesktop.DesktopUserExitInterface;

/**
 * Listen to the NMEA Stream, receieves an event every time a string is read (manageNMEAString).
 */
public class UserExitTemplate
  implements DesktopUserExitInterface
{
  public UserExitTemplate()
  {
    super();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    NMEAContext.getInstance().addNMEAReaderListener(new NMEAReaderListener("UserExit", "Template")
    {
      @Override
      public void manageNMEAString(String nmeaString)
      {
        NMEADataCache dc = NMEAContext.getInstance().getCache();
        try
        {
          double tws = ((Speed) dc.get(NMEADataCache.TWS)).getValue();
          double twd = ((Angle360) dc.get(NMEADataCache.TWD)).getValue(); // Read here all the data you want
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
            // TODO Do something smart here...
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
    
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
  }
  
  @Override
  public void describe()
  {
    System.out.println("Describe the user exit here. Will be displayed when user-exit starts.");
  }
}
