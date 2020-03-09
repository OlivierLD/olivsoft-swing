package olivsoftdesktopuserexits.rpisensor;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

import java.util.List;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.api.NMEAEvent;
import ocss.nmea.api.NMEAListener;
import ocss.nmea.parser.Angle180EW;
import ocss.nmea.parser.StringGenerator;
import ocss.nmea.parser.Temperature;
import ocss.nmea.parser.TrueWindDirection;
import ocss.nmea.parser.TrueWindSpeed;

/*
 * Altitude, Pressure, Temperature
 */
public class AdafruitHTU21DFReader
{
  public final static int HTU21DF_ADDRESS = 0x40;
  // HTU21DF Registers
  public final static int HTU21DF_READTEMP = 0xE3;
  public final static int HTU21DF_READHUM  = 0xE5;

  public final static int HTU21DF_READTEMP_NH = 0xF3; // NH = no hold
  public final static int HTU21DF_READHUMI_NH = 0xF5;

  public final static int HTU21DF_WRITEREG = 0xE6;
  public final static int HTU21DF_READREG  = 0xE7;
  public final static int HTU21DF_RESET    = 0xFE;

  private static boolean verbose    = "true".equals(System.getProperty("sensor.verbose", "false"));
  private static boolean regVerbose = "true".equals(System.getProperty("sensor.register.verbose", "false"));
  
  private I2CBus bus;
  private I2CDevice htu21df;
  
  public AdafruitHTU21DFReader()
  {
    this(HTU21DF_ADDRESS);
  }
  
  public AdafruitHTU21DFReader(int address)
  {
    try
    {
      // Get i2c bus
      bus = I2CFactory.getInstance(I2CBus.BUS_1); // Depends onthe RasPI version
      if (regVerbose)
        System.out.println("Connected to bus. OK.");

      // Get device itself
      htu21df = bus.getDevice(address);
      if (regVerbose)
        System.out.println("Connected to device. OK.");
    }
    catch (IOException e)
    {
      System.err.println(e.getMessage());
    }
  }
  
  public boolean begin()
    throws Exception
  {
    reset();

    htu21df.write((byte) HTU21DF_READREG);
    int r = htu21df.read();
    if (verbose)
      System.out.println("DBG: Begin: 0x" + lpad(Integer.toHexString(r), "0", 2));

    return (r == 0x02);
  }

  public void reset()
    throws Exception
  {
    //  htu21df.write(HTU21DF_ADDRESS, (byte)HTU21DF_RESET);
    htu21df.write((byte) HTU21DF_RESET);
    if (verbose)
      System.out.println("DBG: Reset OK");
    waitfor(15); // Wait 15ms
  }

  public float readTemperature()
    throws Exception
  {
    // Reads the raw temperature from the sensor
    if (verbose)
      System.out.println("Read Temp: Written 0x" + lpad(Integer.toHexString((HTU21DF_READTEMP & 0xff)), "0", 2));
    htu21df.write((byte) (HTU21DF_READTEMP)); //  & 0xff));
    waitfor(50); // Wait 50ms
    byte[] buf = new byte[3];
    /*int rc  = */htu21df.read(buf, 0, 3);
    int msb = buf[0] & 0xFF;
    int lsb = buf[1] & 0xFF;
    int crc = buf[2] & 0xFF;
    int raw = ((msb << 8) + lsb) & 0xFFFC;

    //  while (!Wire.available()) {}

    if (verbose)
    {
      System.out.println("Temp -> 0x" + lpad(Integer.toHexString(msb), "0", 2) + " " + "0x" +
                         lpad(Integer.toHexString(lsb), "0", 2) + " " + "0x" + lpad(Integer.toHexString(crc), "0", 2));
      System.out.println("DBG: Raw Temp: " + (raw & 0xFFFF) + ", " + raw);
    }

    float temp = raw; // t;
    temp *= 175.72;
    temp /= 65536;
    temp -= 46.85;

    if (verbose)
      System.out.println("DBG: Temp: " + temp);
    return temp;
  }

  public float readHumidity()
    throws Exception
  {
    // Reads the raw (uncompensated) humidity from the sensor
    htu21df.write((byte) HTU21DF_READHUM);
    waitfor(50); // Wait 50ms
    byte[] buf = new byte[3];
    /* int rc  = */htu21df.read(buf, 0, 3);
    int msb = buf[0] & 0xFF;
    int lsb = buf[1] & 0xFF;
    int crc = buf[2] & 0xFF;
    int raw = ((msb << 8) + lsb) & 0xFFFC;

    //  while (!Wire.available()) {}

    if (verbose)
    {
      System.out.println("Hum -> 0x" + lpad(Integer.toHexString(msb), "0", 2) + " " + "0x" +
                         lpad(Integer.toHexString(lsb), "0", 2) + " " + "0x" + lpad(Integer.toHexString(crc), "0", 2));
      System.out.println("DBG: Raw Humidity: " + (raw & 0xFFFF) + ", " + raw);
    }

    float hum = raw;
    hum *= 125;
    hum /= 65536;
    hum -= 6;

    if (verbose)
      System.out.println("DBG: Humidity: " + hum);
    return hum;
  }
      
  private static void waitfor(long howMuch)
  {
    try 
    { 
      synchronized (Thread.currentThread())
      {
        Thread.currentThread().wait(howMuch); 
      }
    } catch (InterruptedException ie) { ie.printStackTrace(); }
  }
  
  
  private boolean go = true;
  
  public void stopReading()
  {
    go = false;
    synchronized (Thread.currentThread())
    {
      System.out.println(this.getClass().getName() + ":Stopping the reader");
      Thread.currentThread().notify();
    }
  }
  
  public void startReading()
  {
    try
    {
      System.out.println("Starting " + this.getClass().getName() + "...");
      try
      {
        if (!this.begin())
        {
          System.out.println("Sensor not found!");
          System.exit(1);
        }
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
        return;
      }
      go = true;
      while (go)
      {
        float hum = 0;
        float temp = 0;
        // 1 - Read
        try
        {
          hum = this.readHumidity();
        }
        catch (Exception ex)
        {
          System.err.println(ex.getMessage());
          ex.printStackTrace();
        }

        try
        {
          temp = this.readTemperature();
        }
        catch (Exception ex)
        {
          System.err.println(ex.getMessage());
          ex.printStackTrace();
        }
        // 2 - Broadcast
        String nmeaXDR = StringGenerator.generateXDR("RP", 
                                                    new StringGenerator.XDRElement(StringGenerator.XDRTypes.HUMIDITY, 
                                                                                   hum, 
                                                                                   "HTU21DF")); // %, Humidity
        if (verbose)
        {
          System.out.println("Generated XDR:" + nmeaXDR);
        }
        broadcastNMEASentence(nmeaXDR);
          
        waitfor(1000L); // One sec.
      }
      System.out.println(this.getClass().getName() + ":Reader stopped.");
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private static String lpad(String s, String with, int len)
  {
    String str = s;
    while (str.length() < len)
      str = with + str;
    return str;
  }
  
  private synchronized void broadcastNMEASentence(String nmea)
  {
    if (verbose)
      System.out.println("... AdafruitHTU21DFReader (" + System.currentTimeMillis() + ") Broadcasting [" + nmea + "]");

//  synchronized (NMEAContext.getInstance().getCache())
    {
      try
      {
        List<NMEAListener> listOne = NMEAContext.getInstance().getNMEAListeners();
        if (verbose)
          System.out.println("Broadcasting to " + listOne.size() + " NMEAListener(s)");
        synchronized (listOne)
        {
          for (NMEAListener l : listOne)
          {
            synchronized (l)
            {
              l.dataDetected(new NMEAEvent(this, nmea));
            }
          }
        }
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
      
      try
      {
        List<NMEAReaderListener> listTwo = NMEAContext.getInstance().getReaderListeners();
        if (verbose)
        {
          System.out.println("Broadcasting to " + listTwo.size() + " NMEAReaderListener(s)");
          for (NMEAReaderListener l : listTwo)
          {
            System.out.println("   " + l.getGroupID() + "/" + l.getListenerName());
          }
        }
        synchronized (listTwo)
        {
          for (NMEAReaderListener l : listTwo)
          {
            synchronized (l)
            {
              l.manageNMEAString(nmea);
            }
          }
        }
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
    if (verbose)
      System.out.println("... AdafruitHTU21DFReader (" + System.currentTimeMillis() + ") Broadcasted!");

  }
}
