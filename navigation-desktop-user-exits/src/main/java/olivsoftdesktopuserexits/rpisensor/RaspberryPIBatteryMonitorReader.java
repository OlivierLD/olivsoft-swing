package olivsoftdesktopuserexits.rpisensor;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;

import ocss.nmea.api.NMEAEvent;
import ocss.nmea.api.NMEAListener;
import ocss.nmea.parser.StringGenerator;
import ocss.nmea.parser.StringParsers;

import olivsoftdesktopuserexits.rpisensor.adc.ADCContext;
import olivsoftdesktopuserexits.rpisensor.adc.ADCListener;
import olivsoftdesktopuserexits.rpisensor.adc.ADCObserver;

/*
 * Battery Voltage
 * Mounted on a Slice of PI
 * @see http://....
 */
public class RaspberryPIBatteryMonitorReader 
{
  private static boolean debug = false;
  private ADCObserver.MCP3008_input_channels channel = null;
  private final static NumberFormat VF = new DecimalFormat("00.00");
  
  private static ADCObserver obs;
  
  private long lastLogTimeStamp = 0;
  private int lastVolumeLogged  = 0;
  
  public RaspberryPIBatteryMonitorReader(int ch) throws Exception
  {
    debug = "y".equalsIgnoreCase(System.getProperty("bat.verbose")) ||
            "yes".equalsIgnoreCase(System.getProperty("bat.verbose")) ||
            "true".equalsIgnoreCase(System.getProperty("bat.verbose"));
    channel = findChannel(ch);

    if (tuning)
    {
      minADC = 0;
      minVolt = 0f;
      maxADC = tuningADC;
      maxVolt = tuningVolt;
    }
    final int deltaADC = maxADC - minADC;
    final float deltaVolt = maxVolt - minVolt;
    final float b = ((maxVolt * minADC) - (minVolt * maxADC)) / deltaADC;
    final float a = (maxVolt - b) / maxADC;
    if (debug)
    {
      System.out.println("Volt [" + minVolt + ", " + maxVolt + "]");
      System.out.println("ADC  [" + minADC + ", " + maxADC + "]");
      System.out.println("a=" + a+ ", b=" + b);
    }
    System.out.println("Value range: ADC=0 => V=" + b + ", ADC=1023 => V=" + ((a * 1023) + b));
    obs = new ADCObserver(channel); // Note: We could instantiate more than one observer (on several channels).
    ADCContext.getInstance().addListener(new ADCListener()
       {
         @Override
         public void valueUpdated(ADCObserver.MCP3008_input_channels inputChannel, int newValue) 
         {
           if (inputChannel.equals(channel))
           {
             long now = System.currentTimeMillis();
             int volume = (int)(newValue / 10.23); // [0, 1023] ~ [0x0000, 0x03FF] ~ [0&0, 0&1111111111]
             if (Math.abs(now - lastLogTimeStamp) > 1000 || Math.abs(volume - lastVolumeLogged) > 1)
             {
               if (Math.abs(volume - lastVolumeLogged) > 1 || Math.abs(now - lastLogTimeStamp) > 10000) // 1 %, 10s
               {
                 float voltage = 0;
                 if (false)
                 {
                   if (newValue < minADC)
                   {
                     voltage = /* 0 + */ minVolt * ((float)newValue / (float)minADC);
                   }
                   else if (newValue >= minADC && newValue <= maxADC)
                   {  
                     voltage = minVolt + (deltaVolt * (float)(newValue - minADC) / (float)deltaADC);
                   }
                   else // value > maxADC
                   {
                     voltage = maxVolt + ((15 - maxVolt) * (float)(newValue - maxADC) / (float)(1023 - maxADC));
                   }
                 }
                 else
                 {
                   voltage = (a * newValue) + b;
                 }
                 if (debug)
                 {
                   System.out.print("readAdc:" + Integer.toString(newValue) + 
                                                 " (0x" + lpad(Integer.toString(newValue, 16).toUpperCase(), "0", 2) + 
                                                 ", 0&" + lpad(Integer.toString(newValue, 2), "0", 8) + ") "); 
                   System.out.println("Volume:" + volume + "% (" + newValue + ") Volt:" + VF.format(voltage));
                 }
                 // Broadcast a "Special" NMEA Sentence, non standard
                 String nmeaBattery = generateVoltage("RP", voltage, newValue, volume);
                 broadcastNMEASentence(nmeaBattery);
                 // Standard one
                 nmeaBattery = generateXDRVoltage("RP", voltage);
                 broadcastNMEASentence(nmeaBattery);

                 lastLogTimeStamp = now;
                 lastVolumeLogged = volume;
               }
             }
           }
         }
       });
//  obs.start();         
  }

  public static String generateVoltage(String devicePrefix, float volt, int adc, int volume)
  {
    String bat = devicePrefix + "BAT,";
    bat += (VF.format(volt) + ",V," + adc + "," + volume);
    // Checksum
    int cs = StringParsers.calculateCheckSum(bat);
    bat += ("*" + lpad(Integer.toString(cs, 16).toUpperCase(), "0", 2));
    
    return "$" + bat;
  }
  
  public static String generateXDRVoltage(String devicePrefix, float volt)
  {
    String bat = "";
    StringGenerator.XDRElement xdr = new StringGenerator.XDRElement(StringGenerator.XDRTypes.VOLTAGE, volt, "RPi");
    bat = StringGenerator.generateXDR(devicePrefix, xdr);
    return bat;
  }

  private void broadcastNMEASentence(String nmea)
  {
    if (debug)
      System.out.println("Braodcasting [" + nmea + "]");
    synchronized (NMEAContext.getInstance().getNMEAListeners())
    {
      for (NMEAListener l : NMEAContext.getInstance().getNMEAListeners())
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
//  synchronized (NMEAContext.getInstance().getCache())
    {
      synchronized (NMEAContext.getInstance().getReaderListeners())
      {
        for (NMEAReaderListener l : NMEAContext.getInstance().getReaderListeners())
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
  
  private final static String DEBUG_PRM       = "-debug=";
  private final static String CALIBRATION_PRM = "-calibration";
  private final static String CAL_PRM         = "-cal";
  private final static String CHANNEL_PRM     = "-ch=";
  private final static String MIN_VALUE       = "-min=";
  private final static String MAX_VALUE       = "-max=";
  private final static String TUNE_VALUE      = "-tune=";
  private final static String SCALE_PRM       = "-scale=";
  
  private static int minADC        =    0;
  private static int maxADC        = 1023;
  private static float minVolt     =    0f;
  private static float maxVolt     =   15f;
  private static float tuningVolt  =   15f;
  private static int tuningADC     = 1023;
  private static boolean scale     = false;
  private static boolean tuning    = false;
  
  // A main for the calibration and scale.
  public static void main(String[] args)
  {
    // test 
    if (false)
    {
      String test = RaspberryPIBatteryMonitorReader.generateVoltage("RP", 13.6f, 981, 95);
      System.out.println("TEST [" + test + "]");
    }
    try
    {
      RaspberryPIBatteryMonitorReader rpbmr = new RaspberryPIBatteryMonitorReader(ADCObserver.MCP3008_input_channels.CH0.ch());
      rpbmr.startReading(args);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  /**
   * From a UserExit, pass the tune parameter as System Variables, like -Dtune=973:14
   * 
   * @param args See below in the code
   * @throws Exception
   */
  public void startReading(String[] args) throws Exception
  {
    System.out.println("Parameters are:");
    System.out.println("  -calibration or -cal");
    System.out.println("  -debug=y|n|yes|no|true|false - example -debug=y        (default is n)");
    System.out.println("  -ch=[0-7]                    - example -ch=0           (default is 0)");
    System.out.println("  -min=minADC:minVolt          - example -min=280:3.75   (default is    0:0.0)");
    System.out.println("  -max=maxADC:maxVolt          - example -min=879:11.25  (default is 1023:15.0)");
    System.out.println("  -tune=ADC:volt               - example -tune=973:12.6  (default is 1023:15.0)");
    System.out.println("  -scale=y|n                   - example -scale=y        (default is n)");
    System.out.println("");
    System.out.println(" -min & -max are required if -tune is not here, and vice versa.");
    int channel = 0;
    for (String prm : args)
    {
      if (prm.startsWith(CHANNEL_PRM))
        channel = Integer.parseInt(prm.substring(CHANNEL_PRM.length()));
      else if (prm.startsWith(CALIBRATION_PRM) || prm.startsWith(CAL_PRM))
        debug = true;
      else if (!debug && prm.startsWith(DEBUG_PRM))
        debug = ("y".equals(prm.substring(DEBUG_PRM.length())) || 
                 "yes".equals(prm.substring(DEBUG_PRM.length())) || 
                 "true".equals(prm.substring(DEBUG_PRM.length())));
      else if (prm.startsWith(SCALE_PRM))
        scale = ("y".equals(prm.substring(SCALE_PRM.length())));
      else if (prm.startsWith(TUNE_VALUE))
      {
        System.out.println("======================");
        System.out.println(">>> " + prm);
        System.out.println("======================");
        tuning = true;
        String val = prm.substring(TUNE_VALUE.length());
        tuningADC = Integer.parseInt(val.substring(0, val.indexOf(":"))); 
        tuningVolt = Float.parseFloat(val.substring(val.indexOf(":") + 1)); 
      }
      else if (prm.startsWith(MIN_VALUE))
      {
        String val = prm.substring(MIN_VALUE.length());
        minADC = Integer.parseInt(val.substring(0, val.indexOf(":"))); 
        minVolt = Float.parseFloat(val.substring(val.indexOf(":") + 1)); 
      }
      else if (prm.startsWith(MAX_VALUE))
      {
        String val = prm.substring(MAX_VALUE.length());
        maxADC = Integer.parseInt(val.substring(0, val.indexOf(":"))); 
        maxVolt = Float.parseFloat(val.substring(val.indexOf(":") + 1)); 
      }
    }
    String prms = "Prms: ADC Channel:" + channel;
    if (tuning)
      prms += ", tuningADC:" + tuningADC + ", tuningVolt:" + tuningVolt;
    else
      prms += ", MinADC:" + minADC + ", MinVolt:" + minVolt + ", MaxADC:" + maxADC + ", maxVolt:" + maxVolt;
    System.out.println(prms);
    if (scale)
    {
      if (tuning)
      {
        minADC = 0;
        minVolt = 0f;
        maxADC = tuningADC;
        maxVolt = tuningVolt;
      }
      final int deltaADC = maxADC - minADC;
   // final float deltaVolt = maxVolt - minVolt;
      
      float b = ((maxVolt * minADC) - (minVolt * maxADC)) / deltaADC;
      float a = (maxVolt - b) / maxADC;
      
  //  System.out.println("a=" + a + "(" + ((maxVolt - b) / maxADC) + "), b=" + b);
      
      System.out.println("=== Scale ===");
      System.out.println("Value range: ADC:0 => V:" + b + ", ADC:1023 => V:" + ((a * 1023) + b));
      System.out.println("Coeff A:" + a + ", coeff B:" + b);
      for (int i=0; i<1024; i++)
        System.out.println(i + ";" + ((a * i) + b));
      System.out.println("=============");
      System.exit(0);
    }
//  new RaspberryPIBatteryMonitorReader(channel);
    obs.start();         
  }
  
  public void stopReading()
  {
    System.out.println("\nShutting down");
    if (obs != null)
      obs.stop();    
  }

  private static ADCObserver.MCP3008_input_channels findChannel(int ch) throws IllegalArgumentException
  {
    ADCObserver.MCP3008_input_channels channel = null;
    switch (ch)
    {
      case 0:
        channel = ADCObserver.MCP3008_input_channels.CH0;
        break;
      case 1:
        channel = ADCObserver.MCP3008_input_channels.CH1;
        break;
      case 2:
        channel = ADCObserver.MCP3008_input_channels.CH2;
        break;
      case 3:
        channel = ADCObserver.MCP3008_input_channels.CH3;
        break;
      case 4:
        channel = ADCObserver.MCP3008_input_channels.CH4;
        break;
      case 5:
        channel = ADCObserver.MCP3008_input_channels.CH5;
        break;
      case 6:
        channel = ADCObserver.MCP3008_input_channels.CH6;
        break;
      case 7:
        channel = ADCObserver.MCP3008_input_channels.CH7;
        break;
      default:
        throw new IllegalArgumentException("No channel " + Integer.toString(ch));
    }
    return channel;
  }
  
  private static String lpad(String str, String with, int len)
  {
    String s = str;
    while (s.length() < len)
      s = with + s;
    return s;
  }
}
