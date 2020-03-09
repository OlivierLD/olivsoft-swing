package olivsoftdesktopuserexits;

import com.pi4j.io.serial.Serial;

import com.pi4j.io.serial.SerialPortException;

import java.text.NumberFormat;

import java.util.Date;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Pressure;
import ocss.nmea.parser.Speed;

import ocss.nmea.parser.Temperature;

import olivsoftdesktop.DesktopUserExitInterface;

import olivsoftdesktopuserexits.fona.manager.FONAClient;
import olivsoftdesktopuserexits.fona.manager.FONAManager;
import olivsoftdesktopuserexits.fona.manager.FONAManager.NetworkStatus;

/**
 * Used to monitor the NMEA station by SMS.
 * SMS can be sent to the FONA that is connected on the NMEACache.
 * FONA receives an SMS and replies with the requested data.
 * 
 * Menu:
 * SMS  Returned data
 * ---+---------------
 * ?    Menu (this one)
 * W    True Wind Speed and Direction
 * B    Battery tension (requires the battery probe)
 * P    Atmospheric Pressure (requires the BMP180 sensor)
 * PG   Position
 * AT   Air Temperature
 * WT   Water Temperature
 * FB   FONA Battery state
 * FS   FONA Signal quality
 * ---+---------------
 * Hidden commands:
 * ---+---------------
 *  V   verbose on/off
 * ---+---------------
 * 
 * Subscription, like
 * SUB:B:7:1   Means subscribe to 'B', for 7 days, every 1 hour.
 */
public class FONAUserExit
  implements DesktopUserExitInterface,
             FONAClient
{
  private static FONAManager fona;

  private String requester = null;

  public FONAUserExit()
  {
    super();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    fona = new FONAManager(this);
    
    FONAManager.setVerbose(false);
    
    String port = System.getProperty("fona.serial.port", Serial.DEFAULT_COM_PORT);
    int br      = Integer.parseInt(System.getProperty("fona.baud.rate", "9600"));
    
    System.out.println("[FONA] Serial Communication.");
    System.out.println(" ... connect using port " + port + " : " + Integer.toString(br)); // +  ", N, 8, 1.");
    System.out.println(" ... data received on serial port should be displayed below.");

    // create an instance of the serial communications class
    // final Serial serial = SerialFactory.createInstance();
    try
    {
      System.out.println("Opening port [" + port + ":" + Integer.toString(br) + "]");
      fona.openSerial(port, br);
      System.out.println("Port is opened.");
      System.out.println("Establishing connection (can take up to 3 seconds).");
      while (!fona.isConnected())
      {
        fona.tryToConnect();
        if (!fona.isConnected())
        {
          FONAManager.delay(1);
        }
      }
      System.out.println("Connection established.");
    }
    catch (SerialPortException ex)
    {
      System.out.println(" => [FONA] Serial Setup Failed : " + ex.getMessage());
      return;
    }
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating");
    fona.stopReading();
    fona.closeSerial();
  }

  @Override
  public void describe()
  {
    System.out.println("Listens to FONA messages.");
    System.out.println("Returns the request NMEA data. (see menu)");
  }

  @Override
  public void networkStatusResponse(NetworkStatus ns)
  {
    System.out.println(ns.label());
  }

  @Override
  public void smsDeletedResponse(int sms, boolean ok)
  {
    System.out.println(FONAManager.SDF.format(new Date()) + " :Message #" + sms + " deleted:" + (ok?"OK":"Failed"));
  }
  
  @Override
  public void recievedSMS(final int sms)
  {
    Thread readit = new Thread()
      {
        public void run()
        {
          fona.readMessNum(sms);    
        }
      };
    readit.start();
    Thread deleteit = new Thread()
      {
        public void run()
        {
          FONAManager.delay(10f);
//        System.out.println("\t\t>>>> Deleting mess #" + sms);
          fona.deleteSMS(sms);    
        }
      };
    deleteit.start();
  }

  @Override
  public void fonaConnected()
  {
    System.out.println(FONAManager.SDF.format(new Date()) + " :FONA Connected!");
  }

  @Override
  public void moduleNameAndRevision(String str)
  {
    System.out.println("Module:" + str);
  }

  @Override
  public void debugOn()
  {
    System.out.println("Debug ON");
  }

  @Override
  public void batteryResponse(String percent, String mv)
  {
//  System.out.println("Load:" + percent + "%, " + mv + " mV");
    if (requester != null)
    {
      final String _mc = "Load:" + percent + "%, " + mv + " mV";
      Thread senderThread = new Thread()
        {
          public void run()
          {
            FONAManager.delay(30f);
            fona.sendSMS(requester, _mc); 
            requester = null;
          }
        };
      senderThread.start();
    }
  }

  @Override
  public void signalResponse(String s)
  {
//  System.out.println("Signal:" + s + " dB. Must be higher than 5, the higher the better.");
    if (requester != null)
    {
      final String _mc = "Signal:" + s + " dB. Must be higher than 5, the higher the better.";
      Thread senderThread = new Thread()
        {
          public void run()
          {
            FONAManager.delay(30f);
            fona.sendSMS(requester, _mc); 
            requester = null;
          }
        };
      senderThread.start();
    }
  }

  @Override
  public void simCardResponse(String s)
  {
    System.out.println("SIM Card # " + s);
  }

  @Override
  public void networkNameResponse(String s)
  {
    System.out.println("Network:" + s);
  }

  @Override
  public void numberSMSResponse(int n)
  {
    System.out.println("Number of SMS :" +n);
  }

  @Override
  public void readSMS(final FONAManager.ReceivedSMS sms)
  {
    String cmd = sms.getContent();
//  System.out.println("From " + sms.getFrom() + ", " + sms.getMessLen() + " char : " + sms.getContent());
    String messContent = "";
    if ("?".equalsIgnoreCase(cmd))
    {
      messContent = "W:Wind, B:Battery, P:Pressure, PG:Position, AT:AirTemp, WT:WaterTemp, FB:FONA Batt, FS:FONA Signal";
      // Hidden: V
      // Subscription SUB:X:7:1 : Subscribe to X, for 7 days, every 1 hour.
    }
    else if ("V".equalsIgnoreCase(cmd))
    {
      boolean b = !FONAManager.getVerbose();
      FONAManager.setVerbose(b);
//    System.out.println("\t\t>>> Verbose is now " + (b?"on":"off"));
    }
    else if ("W".equalsIgnoreCase(cmd) ||
             "B".equalsIgnoreCase(cmd) ||
             "P".equalsIgnoreCase(cmd) ||
             "PG".equalsIgnoreCase(cmd) ||
             "AT".equalsIgnoreCase(cmd) ||
             "WT".equalsIgnoreCase(cmd))
    {
      NMEADataCache dc = NMEAContext.getInstance().getCache();
      try
      {
        if ("W".equalsIgnoreCase(cmd))
        {
          double tws = ((Speed) dc.get(NMEADataCache.TWS)).getValue();
          double twd = ((Angle360) dc.get(NMEADataCache.TWD)).getValue();
          messContent = "True Wind: " + 
                        NumberFormat.getInstance().format(tws) + " kts, " + 
                        NumberFormat.getInstance().format(twd);
        }
        else if ("PG".equalsIgnoreCase(cmd))
        {
          String pos = "";
          try { pos = ((GeoPos)dc.get(NMEADataCache.POSITION)).toString().replace('\272', ' '); } catch (Exception ex) {}
          messContent = "Pos: " + pos;
        }
        else if ("B".equalsIgnoreCase(cmd))
        {
          float bat = -1;
          try { bat = ((Float)dc.get(NMEADataCache.BATTERY, true)).floatValue(); } catch (Exception ex) {}
          messContent = "Bat: " + NumberFormat.getInstance().format(bat) + " V";
        }
        else if ("P".equalsIgnoreCase(cmd))
        {
          double bpress = 0d;
          try { bpress = ((Pressure)dc.get(NMEADataCache.BARO_PRESS, true)).getValue(); } catch (Exception ex) {}
          messContent = "Press: " + NumberFormat.getInstance().format(bpress) + " hPa";
        }
        else if ("AT".equalsIgnoreCase(cmd))
        {
          double atemp = 0d;
          try { atemp = ((Temperature)dc.get(NMEADataCache.AIR_TEMP, true)).getValue(); } catch (Exception ex) {}              
          messContent = "Air: " + NumberFormat.getInstance().format(atemp) + " C";
        }
        else if ("WT".equalsIgnoreCase(cmd))
        {
          double temp = 0d;
          try { temp = ((Temperature)dc.get(NMEADataCache.WATER_TEMP, true)).getValue(); } catch (Exception ex) {}
          messContent = "Water: " + NumberFormat.getInstance().format(temp) + " C";
        }
      }
      catch (NullPointerException npe)
      {
        messContent = "Cache not initialized (yet)";
      }
    } 
    else if ("FB".equalsIgnoreCase(cmd) ||
             "FS".equalsIgnoreCase(cmd))
    {
      /* FONA Data
       * FB   FONA Battery state
       * FS   FONA Signal quality
       */
      messContent = "";
      requester = sms.getFrom();
//    while (requester.startsWith("+"))
//      requester = requester.substring(1);
      if ("FB".equalsIgnoreCase(cmd))
        fona.requestBatteryLevel();
      else if ("FS".equalsIgnoreCase(cmd))
        fona.requestRSSI();
    }
    else if (cmd.toUpperCase().startsWith("SUB:"))
    {
      String subscription = cmd.substring("SUB:".length());
      String[] sa = subscription.split(":");
      if (sa != null && sa.length == 3)
      {
        try
        {
          final int subPeriod = Integer.parseInt(sa[2]);
          final String subType = sa[0];
          final int subLength = Integer.parseInt(sa[1]);
          if ("W".equalsIgnoreCase(subType)  ||
              "B".equalsIgnoreCase(subType)  ||
              "P".equalsIgnoreCase(subType)  ||
              "PG".equalsIgnoreCase(subType) ||
              "AT".equalsIgnoreCase(subType) ||
              "WT".equalsIgnoreCase(subType))
          {
            final String dest = sms.getFrom();
            Thread subThread = new Thread("Subscription" + subType)
              {
                public void run()
                {
                  long started = System.currentTimeMillis();
                  boolean ok = true;
                  while (ok)
                  {
                    FONAManager.ReceivedSMS _sms = new FONAManager.ReceivedSMS(dest, null, subType);
                    readSMS(_sms);
                    if ((System.currentTimeMillis() - started) < (subLength * 24 * 3600 * 1000))
                      FONAManager.delay(3600f * subPeriod);
                    else
                      ok = false;
                  }
                  System.out.println("Subscription from " + dest + " terminated.");
                }
              };
            subThread.start();
          }
          else
            messContent = "Unknown subscription type[" + subType + "]";
        }
        catch (NumberFormatException nfe)
        {
          nfe.printStackTrace();
        }
      }
      else
      {
        messContent = "Bad subsciption format [" + cmd + "/" + subscription + "]. Should be like SUB:B:7:1";
      }
    }
    else
    {
      messContent = "Command [" + cmd + "] unknown, try [?]";
    }
    if (messContent.trim().length() > 0)
    {      final String _mc = messContent;
//    System.out.println("\t\t>>> Sending [" + _mc + "]");
      Thread senderThread = new Thread()
      {
        public void run()
        {
          fona.sendSMS(sms.getFrom(), _mc);
        }
      };
      senderThread.start();

    }
  }

  @Override
  public void someoneCalling()
  {
    System.out.println("Dring dring!");
  }
}
