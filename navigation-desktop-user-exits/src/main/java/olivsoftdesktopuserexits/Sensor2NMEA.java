package olivsoftdesktopuserexits;

import olivsoftdesktop.DesktopUserExitInterface;

import olivsoftdesktopuserexits.rpisensor.AdafruitBMP180Reader;
import olivsoftdesktopuserexits.rpisensor.AdafruitHTU21DFReader;

/**
 * Reads a sensor (BMP180 and/or HTU21DF) connected to the Raspberry PI
 * and turn the data into NMEA strings to broadcast them.
 *
 * to be used with -ue:olivsoftdesktopuserexits.Sensor2NMEA
 * along with -DBMP180=y|n -DHTU21DF=y|n
 */
public class Sensor2NMEA
  implements DesktopUserExitInterface
{
  private AdafruitBMP180Reader  sensorBMP180Reader  = null;
  private AdafruitHTU21DFReader sensorHTU21DFReader = null;
  
  public Sensor2NMEA()
  {
    super();
    if ("Y".equalsIgnoreCase(System.getProperty("BMP180", "n")))
      sensorBMP180Reader = new AdafruitBMP180Reader();
    if ("Y".equalsIgnoreCase(System.getProperty("HTU21DF", "n")))
      sensorHTU21DFReader = new AdafruitHTU21DFReader();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    System.out.println("BMP180:" + System.getProperty("BMP180", "n") + ", HTU21DF:" + System.getProperty("HTU21DF", "n"));
    // Start reading the sensor and broadcasting NMEA data
    if (sensorBMP180Reader != null)
    {
      Thread ue1 = new Thread("NMEASensorBMP180Reader")
        {
          public void run()
          {
            this.setPriority(Thread.MIN_PRIORITY);
            sensorBMP180Reader.startReading();
          }
        };
      ue1.start();
    }
    if (sensorHTU21DFReader != null)
    {
      Thread ue2 = new Thread("NMEASensorHTU21DFReader")
        {
          public void run()
          {
            this.setPriority(Thread.MIN_PRIORITY);
            sensorHTU21DFReader.startReading();
          }
        };
      ue2.start();
    }
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    if (sensorBMP180Reader != null)
      sensorBMP180Reader.stopReading();
    if (sensorHTU21DFReader != null)
      sensorHTU21DFReader.stopReading();
  }
  
  @Override
  public void describe()
  {
    System.out.println("Designed to run on the Raspberry PI.");
    System.out.println("Reads the BMP180 and/or HTU21DF sensor, and turns it Air Temperature and Barometric Pressure data into XDR, MTA & MMB NMEA Strings.");
    System.out.println("Those data will be treated as if they were coming from the NMEA Station.");
  }
}
