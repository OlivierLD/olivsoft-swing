package olivsoftdesktopuserexits.rpisensor.adc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Read an Analog to Digital Converter
 */
public class ADCObserver
{
  private final static boolean DISPLAY_DIGIT = false;
  // Note: "Mismatch" 23-24. The wiring says DOUT->#23, DIN->#24
  // 23: DOUT on the ADC is IN on the GPIO. ADC:Slave, GPIO:Master
  // 24: DIN on the ADC, OUT on the GPIO. Same reason as above.
  // SPI: Serial Peripheral Interface
  private static Pin spiClk  = RaspiPin.GPIO_01; // Pin #18, clock
  private static Pin spiMiso = RaspiPin.GPIO_04; // Pin #23, data in.  MISO: Master In Slave Out
  private static Pin spiMosi = RaspiPin.GPIO_05; // Pin #24, data out. MOSI: Master Out Slave In
  private static Pin spiCs   = RaspiPin.GPIO_06; // Pin #25, Chip Select
 
  public static enum MCP3008_input_channels
  {
    CH0(0),
    CH1(1),
    CH2(2),
    CH3(3),
    CH4(4),
    CH5(5),
    CH6(6),
    CH7(7);
    
    private int ch;
    
    MCP3008_input_channels(int chNum)
    {
      this.ch = chNum;
    }
    
    public int ch() { return this.ch; }
  }
  
  private MCP3008_input_channels[] adcChannel; // Between 0 and 7, 8 channels on the MCP3008
  
  private static GpioPinDigitalInput  misoInput        = null;
  private static GpioPinDigitalOutput mosiOutput       = null;
  private static GpioPinDigitalOutput clockOutput      = null;
  private static GpioPinDigitalOutput chipSelectOutput = null;
  
  private boolean go = true;
  
  public ADCObserver(MCP3008_input_channels channel)
  {
    this(new MCP3008_input_channels[] { channel })  ;
  }
  
  public ADCObserver(MCP3008_input_channels[] channel)
  {
    adcChannel = channel;
  }
  
  public void start()
  {
    GpioController gpio = null;
    boolean pi4jAvailable = false;
    try 
    {
      Class c = Class.forName("com.pi4j.io.gpio.GpioFactory");       
      String osName = System.getProperty("os.name");
      System.out.println("OS:" + osName);
      pi4jAvailable = "Linux".equals(osName);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    if (pi4jAvailable)
    {
      try
      {
        gpio             = GpioFactory.getInstance();
        mosiOutput       = gpio.provisionDigitalOutputPin(spiMosi, "MOSI", PinState.LOW);
        clockOutput      = gpio.provisionDigitalOutputPin(spiClk,  "CLK",  PinState.LOW);
        chipSelectOutput = gpio.provisionDigitalOutputPin(spiCs,   "CS",   PinState.LOW);
        
        misoInput        = gpio.provisionDigitalInputPin(spiMiso, "MISO");
      }
      catch (Exception ex)
      {
        System.err.println("PI4J not available");
        ex.printStackTrace();
      }
    }
    boolean simulation = "y".equalsIgnoreCase(System.getProperty("simulation", "n"));
    
    int lastRead[] = new int[adcChannel.length];
    for (int i=0; i<lastRead.length; i++)
      lastRead[i] = 0;
    int tolerance = 5;
    while (go)
    {
      for (int i=0; i<adcChannel.length; i++)
      {
        int adc = simulation ? (int)(1023 * Math.random()) : readAdc(adcChannel[i]);
        int postAdjust = Math.abs(adc - lastRead[i]);
        if (postAdjust > tolerance)
        {
          ADCContext.getInstance().fireValueChanged(adcChannel[i], adc);
          lastRead[i] = adc;
        }
      }
      try { Thread.sleep(100L); } catch (InterruptedException ie) { ie.printStackTrace(); }
    }
    System.out.println("Shutting down...");
    if (gpio != null)
      gpio.shutdown();
  }   
  
  public void stop()
  {
    go = false;  
  }
  
  private int readAdc(MCP3008_input_channels channel)
  {
    chipSelectOutput.high();
    
    clockOutput.low();
    chipSelectOutput.low();
  
    int adccommand = channel.ch();
    adccommand |= 0x18; // 0x18: 00011000
    adccommand <<= 3;
    // Send 5 bits: 8 - 3. 8 input channels on the MCP3008.
    for (int i=0; i<5; i++) //
    {
      if ((adccommand & 0x80) != 0x0) // 0x80 = 0&10000000
        mosiOutput.high();
      else
        mosiOutput.low();
      adccommand <<= 1;      
      clockOutput.high();
      clockOutput.low();      
    }

    int adcOut = 0;
    for (int i=0; i<12; i++) // Read in one empty bit, one null bit and 10 ADC bits
    {
      clockOutput.high();
      clockOutput.low();      
      adcOut <<= 1;

      if (misoInput.isHigh())
      {
//      System.out.println("    " + misoInput.getName() + " is high (i:" + i + ")");
        // Shift one bit on the adcOut
        adcOut |= 0x1;
      }
      if (DISPLAY_DIGIT)
        System.out.println("ADCOUT: 0x" + Integer.toString(adcOut, 16).toUpperCase() + 
                                 ", 0&" + Integer.toString(adcOut, 2).toUpperCase());
    }
    chipSelectOutput.high();

    adcOut >>= 1; // Drop first bit
    return adcOut;
  }
}
