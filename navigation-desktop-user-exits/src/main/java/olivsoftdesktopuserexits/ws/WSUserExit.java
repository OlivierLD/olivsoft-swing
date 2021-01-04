package olivsoftdesktopuserexits.ws;

import java.net.URI;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle180;
import ocss.nmea.parser.Angle180EW;
import ocss.nmea.parser.Angle180LR;
import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.Depth;
import ocss.nmea.parser.Distance;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Pressure;
import ocss.nmea.parser.SolarDate;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.Temperature;
import ocss.nmea.parser.TrueWindDirection;
import ocss.nmea.parser.UTC;
import ocss.nmea.parser.UTCDate;

import ocss.nmea.parser.UTCTime;

import olivsoftdesktop.DesktopUserExitInterface;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import org.json.JSONObject;

/**
 * Listen to the NMEA Stream, receieves an event every time a string is read (manageNMEAString).
 * Then feeds a WebSocket server with a corresponding json object.
 * 
 * Can use 2 system variables: 
 *   ws.host (default localhost)
 *   ws.port (default 9876)
 *   
 * Also
 *   ws.verbose (default false)
 */
public class WSUserExit
  implements DesktopUserExitInterface
{
  private WebSocketClient wsClient = null;
  private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy HH:mm:ss 'UTC'");
  private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss 'UTC'");
  
  public WSUserExit()
  {
    super();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    try 
    { 
      wsClient = new WebSocketClient(new URI("ws://" + System.getProperty("ws.host", "localhost") + ":" + System.getProperty("ws.port", "9876") + "/"))
      {
        @Override
        public void onOpen(ServerHandshake serverHandshake)
        {
          System.out.println("WS On Open");
        }

        @Override
        public void onMessage(String string)
        {
//        System.out.println("WS On Message");
        }

        @Override
        public void onClose(int i, String string, boolean b)
        {
          System.out.println("WS On Close");
        }

        @Override
        public void onError(Exception exception)
        {
          System.out.println("WS On Error");
          exception.printStackTrace();
        }
      }; 
      wsClient.connect();
    }
    catch (Exception ex) 
    {
      ex.printStackTrace();
    }
    NMEAContext.getInstance().addNMEAReaderListener(new NMEAReaderListener("UserExit", "Web Sockets")
    {
      @Override
      public void manageNMEAString(String nmeaString)
      {
        NMEADataCache cache = NMEAContext.getInstance().getCache();
        synchronized (cache)
        {
          double bsp = 0, sog = 0, aws = 0, tws = 0, csp = 0;
          double cog = 0, hdg = 0, twd = 0, cmg = 0, cdr = 0, b2wp = 0;
          double awa = 0, twa = 0, leeway = 0, decl = 0, dev = 0, dbt = 0;
          double lat = 0, lng = 0, atemp = 0, wtemp = 0, log = 0, dlog = 0, xte = 0;
          double d2wp = 0, apress = 0;
          long gpstime = 0L, gpsdatetime = 0L, solartime = 0L;
          String pos = "", gpstimefmt = "", gpsdatetimefmt = "", towp = "";
          double vmgwind = 0, vmgwp = 0, perf = 0;
          double bspFactor = 0, awsFactor = 0, awaOffset = 0, hdgOffset = 0;
          double maxLeeway = 0;          
          String devFile     = "";
          double defaultDecl = 0;
          int damping        = 0;          
          String polarFile   = "";
          double polarFactor = 0;
          
          boolean displayWT = true, displayAT = true,
                  displayGDT = false, displayPRMSL = false, displayHUM = false, displayVOLT = false;

          double hum = 0L, bat = 0L;
          
          try
          {
            Set<String> keys = cache.keySet();
            for (String k : keys) // Dump the cache
            {
              Object cached = cache.get(k);
              if (cached instanceof Speed)
              {
                if (k.equals(NMEADataCache.BSP))
                  bsp = ((Speed)cached).getValue();
                else if (k.equals(NMEADataCache.SOG))
                  sog = ((Speed)cached).getValue();
                else if (k.equals(NMEADataCache.AWS))
                  aws = ((Speed)cached).getValue();
                else if (k.equals(NMEADataCache.TWS))
                  tws = ((Speed)cached).getValue();
                else if (k.equals(NMEADataCache.CSP))
                  csp = ((Speed)cached).getValue();
              }
              else if (cached instanceof Angle360)
              {
                if (k.equals(NMEADataCache.COG))
                  cog = ((Angle360)cached).getValue();
                else if (k.equals(NMEADataCache.HDG_TRUE))
                  hdg = ((Angle360)cached).getValue();
                else if (k.equals(NMEADataCache.TWD))
                  twd = ((Angle360)cached).getValue();
                else if (k.equals(NMEADataCache.CMG))
                  cmg = ((Angle360)cached).getValue();
                else if (k.equals(NMEADataCache.CDR))
                  cdr = ((Angle360)cached).getValue();
                else if (k.equals(NMEADataCache.B2WP))
                  b2wp = ((Angle360)cached).getValue();
              }
              else if (cached instanceof Angle180)
              {
                if (k.equals(NMEADataCache.AWA))
                  awa = ((Angle180)cached).getValue();
                else if (k.equals(NMEADataCache.TWA))
                  twa = ((Angle180)cached).getValue();
              }
              else if (cached instanceof Angle180LR)
              {
                if (k.equals(NMEADataCache.LEEWAY))
                  leeway = ((Angle180LR)cached).getValue();
              }
              else if (cached instanceof Angle180EW)
              {
                if (k.equals(NMEADataCache.DECLINATION))
                {
                  double d = ((Angle180EW)cached).getValue();
                  if (d != -Double.MAX_VALUE)
                    decl = d;
                }
                if (k.equals(NMEADataCache.DEVIATION))
                  dev = ((Angle180EW)cached).getValue();
              }
              else if (cached instanceof GeoPos)
              {
                if (k.equals(NMEADataCache.POSITION))
                {
                  lat = ((GeoPos)cached).lat;
                  lng = ((GeoPos)cached).lng;
                  try 
                  { 
                    pos = ((GeoPos)cached).toString().replaceAll("�","&deg;");
                  }
                  catch (Exception ex) { ex.printStackTrace(); }
                }        
              }
              else if (cached instanceof Depth)
              {
                if (k.equals(NMEADataCache.DBT))
                  dbt = ((Depth)cached).getValue();
              }
              else if (cached instanceof Temperature)
              {
                if (k.equals(NMEADataCache.WATER_TEMP))
                  wtemp = ((Temperature)cached).getValue();
                else if (k.equals(NMEADataCache.AIR_TEMP))
                  atemp = ((Temperature)cached).getValue();
              }
              else if (cached instanceof Distance)
              {
                if (k.equals(NMEADataCache.LOG))
                  log = ((Distance)cached).getValue();
                else if (k.equals(NMEADataCache.DAILY_LOG))
                  dlog = ((Distance)cached).getValue();
                else if (k.equals(NMEADataCache.XTE))
                  xte = ((Distance)cached).getValue();
                else if (k.equals(NMEADataCache.D2WP))
                  d2wp = ((Distance)cached).getValue();
              }
              else if (cached instanceof Pressure)
              {
                if (k.equals(NMEADataCache.BARO_PRESS))
                  apress = ((Pressure)cached).getValue();
              }
              else if (cached instanceof UTCTime)
              {
                if (k.equals(NMEADataCache.GPS_TIME))
                {
                  gpstime = ((UTCTime)cached).getValue().getTime();
                  gpstimefmt = TIME_FORMAT.format(((UTCTime)cached).getValue());
                }
              }
              else if (cached instanceof UTCDate)
              {
                if (k.equals(NMEADataCache.GPS_DATE_TIME))
                {
                  gpsdatetime = ((UTCDate)cached).getValue().getTime();
                  gpsdatetimefmt = DATE_FORMAT.format(((UTCDate)cached).getValue());
                }
              }
              else if (cached instanceof SolarDate)
              {
                if (k.equals(NMEADataCache.GPS_SOLAR_TIME))
                  solartime= ((SolarDate)cached).getValue().getTime();
              }
              else if (cached instanceof Double)
              {
                if (k.equals(NMEADataCache.RELATIVE_HUMIDITY))
                  hum = ((Double)cached).doubleValue();
             // else if (k.equals(NMEADataCache.BARO_PRESS)) // Redundant?
             //   apress = ((Double)cached).doubleValue();
              }
              else if (cached instanceof Float)
              {
                if (k.equals(NMEADataCache.BATTERY))
                  bat = ((Float)cached).floatValue();
              }
              else if (cached instanceof Boolean)
              {
                if (k.equals(NMEADataCache.DISPLAY_WEB_WT))
                  displayWT = ((Boolean)cached).booleanValue();
                else if (k.equals(NMEADataCache.DISPLAY_WEB_AT))
                  displayAT = ((Boolean)cached).booleanValue();
                else if (k.equals(NMEADataCache.DISPLAY_WEB_GDT))
                  displayGDT = ((Boolean)cached).booleanValue();
                else if (k.equals(NMEADataCache.DISPLAY_WEB_PRMSL))
                  displayPRMSL = ((Boolean)cached).booleanValue();
                else if (k.equals(NMEADataCache.DISPLAY_WEB_HUM))
                  displayHUM = ((Boolean)cached).booleanValue();
                else if (k.equals(NMEADataCache.DISPLAY_WEB_VOLT))
                  displayVOLT = ((Boolean)cached).booleanValue();
              }
              else if (cached instanceof String)
              {
                if (k.equals(NMEADataCache.TO_WP))
                  towp = (String)cached;
              }
              else
              {
                if ("true".equals(System.getProperty("ws.verbose", "false")))
                  System.out.println(">>> WS-EXTRA >>> Unmanaged cache data:" + k + " is a " + cached.getClass().toString());
              }
            }
            // VMG & Perf
            double vmg = 0d;
            try
            {
              double _sog = (((Speed)cache.get(NMEADataCache.SOG)).getValue());
              double _cog = ((Angle360)cache.get(NMEADataCache.COG)).getValue();
              double _twd = (((TrueWindDirection)cache.get(NMEADataCache.TWD)).getValue());
              double _twa = _twd - _cog;
              if (_sog > 0) // Try with GPS Data first
                vmg = _sog * Math.cos(Math.toRadians(_twa));
              else
              {
                _twa = ((Angle180)cache.get(NMEADataCache.TWA)).getValue();
                double _bsp = ((Speed)cache.get(NMEADataCache.BSP)).getValue();
                if (_bsp > 0)
                  vmg = _bsp * Math.cos(Math.toRadians(_twa));
              }
              vmgwind = vmg;
  
              if (cache.get(NMEADataCache.TO_WP) != null && cache.get(NMEADataCache.TO_WP).toString().trim().length() > 0)
              {
                double _b2wp = ((Angle360)cache.get(NMEADataCache.B2WP)).getValue();
                _sog = (((Speed)cache.get(NMEADataCache.SOG)).getValue());
                _cog = ((Angle360)cache.get(NMEADataCache.COG)).getValue();
                if (_sog > 0)
                {
                  double angle = _b2wp - _cog;
                  vmg = _sog * Math.cos(Math.toRadians(angle));
                }
                else
                {
                  double angle = _b2wp - ((Angle360)cache.get(NMEADataCache.HDG_TRUE)).getValue();
                  double _bsp = ((Speed)cache.get(NMEADataCache.BSP)).getValue();
                  vmg = _bsp * Math.cos(Math.toRadians(angle));
                }
                vmgwp = vmg;
              }
            }
            catch (Exception ex)
            {
              System.err.println("Perf & VMG:" + ex.getMessage());
            }
            if (cache.get(NMEADataCache.PERF) != null && ((Double)cache.get(NMEADataCache.PERF)).doubleValue() > -1d)
              perf = ((Double)cache.get(NMEADataCache.PERF)).doubleValue();
            
            // Calibration Parameters
            bspFactor   = ((Double)cache.get(NMEADataCache.BSP_FACTOR)).doubleValue();
            awsFactor   = ((Double)cache.get(NMEADataCache.AWS_FACTOR)).doubleValue();
            awaOffset   = ((Double)cache.get(NMEADataCache.AWA_OFFSET)).doubleValue();
            hdgOffset   = ((Double)cache.get(NMEADataCache.HDG_OFFSET)).doubleValue();
            maxLeeway   = ((Double)cache.get(NMEADataCache.MAX_LEEWAY)).doubleValue();
            
            devFile     = ((String)cache.get(NMEADataCache.DEVIATION_FILE)).toString();
            defaultDecl = ((Angle180EW)cache.get(NMEADataCache.DEFAULT_DECLINATION)).getDoubleValue();
            damping     = ((Integer)cache.get(NMEADataCache.DAMPING)).intValue();
            
            polarFile   = ((String)cache.get(NMEADataCache.POLAR_FILE_NAME)).toString();
            polarFactor = ((Double)cache.get(NMEADataCache.POLAR_FACTOR)).doubleValue();
            
            JSONObject json = new JSONObject();
            json.put("wtemp", wtemp);
            json.put("gpstime", gpstime);
            json.put("gpstimefmt", gpstimefmt);
            json.put("d2wp", d2wp);
            json.put("cog", cog);
            json.put("leeway", leeway);
            if (!Double.isInfinite(csp) && Math.abs(csp) != Double.MAX_VALUE) 
              json.put("csp", csp);
            else
              json.put("csp", 0);
            json.put("bsp", bsp);
            json.put("lat", lat);
            json.put("lng", lng);
            json.put("pos", pos);
            json.put("b2wp", b2wp);
            json.put("xte", xte);
            json.put("gpsdatetime", gpsdatetime);
            json.put("gpsdatetimefmt", gpsdatetimefmt);
            json.put("D", decl);
            json.put("aws", aws);
            if (!Double.isInfinite(cdr) && !Double.isNaN(cdr)) 
              json.put("cdr", cdr);
            else
              json.put("cdr", 0);
            json.put("towp", towp);
            if (!Double.isInfinite(tws)) 
              json.put("tws", tws);
            else
              json.put("tws", 0);
            json.put("dbt", dbt);
            json.put("log", log);
            json.put("awa", awa);
            json.put("hdg", hdg);
            json.put("cmg", cmg);
            json.put("twd", twd);
            json.put("prmsl", apress);
            json.put("d", dev);
            json.put("atemp", atemp);
            json.put("twa", twa);
            json.put("daylog", dlog);
            json.put("sog", sog);
            json.put("gpssolardate", solartime);
            json.put("vmgwind", vmgwind);
            json.put("vmgwp", vmgwp);
            json.put("perf", perf);
            json.put("bspfactor", bspFactor);
            json.put("awsfactor", awsFactor);
            json.put("awaoffset", awaOffset);
            json.put("hdgoffset", hdgOffset);
            json.put("maxleeway", maxLeeway);
            json.put("devfile", devFile);
            json.put("defaultdecl", defaultDecl);
            json.put("damping", damping);
            json.put("polarfile", polarFile);
            json.put("polarspeedfactor", polarFactor);
            // Extra
            json.put("hum", hum);
            json.put("bat", bat);
            
            json.put("displayWT", displayWT);
            json.put("displayAT", displayAT);
            json.put("displayGDT", displayGDT);
            json.put("displayPRMSL", displayPRMSL);
            json.put("displayHUM", displayHUM);
            json.put("displayVOLT", displayVOLT);
            
            // TODO Cache age?
            wsClient.send(json.toString()); // And boom
          }
          catch (Exception e)
          {
            System.out.println("-- Sending WS Data, Exception: " + e.getClass().getName() + " --");
            if ("true".equals(System.getProperty("ws.verbose", "false")))
            {
              System.out.println("wtemp:" + wtemp);
              System.out.println("gpstime:" + gpstime);
              System.out.println("gpstimefmt:" + gpstimefmt);
              System.out.println("d2wp:" + d2wp);
              System.out.println("cog:" + cog);
              System.out.println("leeway:" + leeway);
              System.out.println("csp:" + csp);
              System.out.println("bsp:" + bsp);
              System.out.println("lat:" + lat);
              System.out.println("lng:" + lng);
              System.out.println("pos:" + pos);
              System.out.println("b2wp:" + b2wp);
              System.out.println("xte:" + xte);
              System.out.println("gpsdatetime:" + gpsdatetime);
              System.out.println("gpsdatetimefmt:" + gpsdatetimefmt);
              System.out.println("D:" + dev);
              System.out.println("aws:" + aws);
              System.out.println("cdr:" + cdr);
              System.out.println("towp:" + towp);
              System.out.println("tws:" + tws);
              System.out.println("dbt:" + dbt);
              System.out.println("log:" + log);
              System.out.println("awa:" + awa);
              System.out.println("hdg:" + hdg);
              System.out.println("cmg:" + cmg);
              System.out.println("twd:" + twd);
              System.out.println("prmsl:" + apress);
              System.out.println("d:" + dev);
              System.out.println("atemp:" + atemp);
              System.out.println("twa:" + twa);
              System.out.println("daylog:" + dlog);
              System.out.println("sog:" + sog);
              System.out.println("gpssolardate:" + solartime);
              System.out.println("vmgwind:" + vmgwind);
              System.out.println("vmgwp:" + vmgwp);
              System.out.println("perf:" + perf);
              System.out.println("bspfactor:" + bspFactor);
              System.out.println("awsfactor:" + awsFactor);
              System.out.println("awaoffset:" + awaOffset);
              System.out.println("hdgoffset:" + hdgOffset);
              System.out.println("maxleeway:" + maxLeeway);
              System.out.println("devfile:" + devFile);
              System.out.println("defaultdecl:" + defaultDecl);
              System.out.println("damping:" + damping);
              System.out.println("polarfile:" + polarFile);
              System.out.println("polarspeedfactor:" + polarFactor);

              System.out.println("hum:" + hum);
              System.out.println("bat:" + bat);
            }
          }
        }
      }
    });    
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    wsClient.close();
  }
  
  @Override
  public void describe()
  {
    System.out.println("Feeds a WebSocket server with NMEA data.");
  }
  
  // Sample main, for tests
  public static void main(String... args) throws Exception
  {
    String uri = "ws://" + System.getProperty("ws.host", "localhost") + ":" + System.getProperty("ws.port", "9876") + "/";
    System.out.println("Connecting to " + uri);
    WebSocketClient wsc = new WebSocketClient(new URI(uri))
    {
      @Override
      public void onOpen(ServerHandshake serverHandshake)
      {
        System.out.println("On Open");
      }

      @Override
      public void onMessage(String string)
      {
        System.out.println("On Message");
      }

      @Override
      public void onClose(int i, String string, boolean b)
      {
        System.out.println("On Close");
      }

      @Override
      public void onError(Exception exception)
      {
        System.out.println("On Error");
      }
    };
    wsc.connect();
    System.out.println("WS Connected.");
    for (int i=0; i<10; i++)
    {
      JSONObject json = new JSONObject();
      json.put("wtemp", 26.50);
      json.put("gpstime", 1290377286000L);
      json.put("gpstimefmt", "14:08:06 UTC");
      json.put("d2wp", 561.7);
      json.put("cog", 223);
      json.put("leeway", 0);
      json.put("csp", 0.79);
      json.put("bsp", 6.83);
      json.put("lat", -9.10875);
      json.put("lng", -140.20975);
      json.put("pos", "S  09\u00b006.53 / W 140\u00b012.59");
      json.put("b2wp", 230);
      json.put("xte", 3.0);
      json.put("gpsdatetime", 1290377286000L);
      json.put("gpsdatetimefmt", "21 Nov 2010 14:08:06 UTC");
      json.put("D", 10);
      json.put("aws", 14.60);
      json.put("cdr", 140);
      json.put("towp", "RANGI   ");
      json.put("tws", 18.96);
      json.put("dbt", 1.60);
      json.put("log", 3013.0);
      json.put("awa", -126);
      json.put("hdg", 229);
      json.put("cmg", 227);
      json.put("twd", 85);
      json.put("prmsl", 0.0);
      json.put("d", -1);
      json.put("atemp", 0.00);
      json.put("twa", -143);
      json.put("daylog", 12.3);
      json.put("sog", 6.91);
      json.put("gpssolardate", 1290343635660L);
      json.put("vmgwind", -5.11);
      json.put("vmgwp", 6.85);
      json.put("perf", 1.03);
      json.put("bspfactor", 1.0);
      json.put("awsfactor", 1.0);
      json.put("awaoffset", 0.0);
      json.put("hdgoffset", 0.0);
      json.put("maxleeway", 15.0);
      json.put("devfile", "/OlivSoft/all-scripts/dp_2011_04_15.csv");
      json.put("defaultdecl", 15.0);
      json.put("damping", 30);
      json.put("polarfile", "/OlivSoft/all-scripts/polars/CheoyLee42.polar-coeff");
      json.put("polarspeedfactor", 0.8);
      try {
        wsc.send(json.toString());
      } catch (Exception ex) {
        System.err.println("Oops:" + ex.toString());
      }
      try { Thread.sleep(1000L); } catch (Exception ex) {}
    }
    wsc.close();
  }
}
