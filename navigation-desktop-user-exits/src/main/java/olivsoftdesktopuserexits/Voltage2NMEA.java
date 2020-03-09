package olivsoftdesktopuserexits;

import olivsoftdesktop.DesktopUserExitInterface;

import olivsoftdesktopuserexits.rpisensor.RaspberryPIBatteryMonitorReader;

/**
 * Reads the battry logging board connected to the Raspberry PI
 * and turn the data into NMEA string to broadcast them.
 *
 * to be used with -ue:olivsoftdesktopuserexits.Voltage2NMEA
 */
public class Voltage2NMEA
  implements DesktopUserExitInterface
{
  private RaspberryPIBatteryMonitorReader sensorReader = null;
  private final static int ADC_CHANNEL = 0;
  
  public Voltage2NMEA()
  {
    super();
    try 
    {
      sensorReader = new RaspberryPIBatteryMonitorReader(ADC_CHANNEL);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    // Start reading the sensor and broadcasting NMEA data
    Thread ue = new Thread("BatterySensorReader")
      {
        public void run()
        {
          this.setPriority(Thread.MIN_PRIORITY);
          try
          {
            String tune = "-tune=" + System.getProperty("tune", "1023:15.0");
            System.out.println("Battery Tuning:" + tune);
            String [] prms = new String[] { tune };
            sensorReader.startReading(prms); 
          }
          catch (Exception ex)
          {
            ex.printStackTrace();
          }
        }
      };
    ue.start();
  }

  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    sensorReader.stopReading();
  }
  
  @Override
  public void describe()
  {
    System.out.println("Designed to run on the Raspberry PI.");
    System.out.println("Reads the battery sensor (custom), and turns the voltage it into a non-standrad NMEA Strings.");
    System.out.println("Those data will be treated as if it was coming from the NMEA Station.");
  }
}
