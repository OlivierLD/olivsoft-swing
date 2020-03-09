package nmeasniffer;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import ocss.nmea.parser.StringParsers;

public class Sniffer
{
  private final Set<String> validPortList;
  private boolean verbose;

  public Sniffer()
  {
    this.validPortList = new HashSet<>();
    this.verbose = false;
  }

  public void snif(String[] serialPorts, Integer[] br)
  {
    int[] bra = new int[br.length];
    int idx = 0;
    for (Integer i : br)
      bra[(idx++)] = i.intValue();
    snif(serialPorts, bra);
  }

  public void snif(String[] serialPorts, int[] br)
  {
    for (int i = 0; i < serialPorts.length; i++)
    {
      System.out.println(new StringBuilder().append("Sniffing ").append(serialPorts[i]).append(" ...").toString());

      CommPortIdentifier com = null;
      try
      {
        com = CommPortIdentifier.getPortIdentifier(serialPorts[i]);
      }
      catch (NoSuchPortException nspe)
      {
        System.err.println("No Such Port");
        nspe.printStackTrace();
        return;
      }
      CommPort thePort = null;
      try
      {
        thePort = com.open("NMEAPort", 10000);
      }
      catch (PortInUseException piue)
      {
        System.out.println(new StringBuilder().append(". Port [").append(serialPorts[i]).append("] In Use").toString());
        continue;
      }
      int portType = com.getPortType();

      if (portType == CommPortIdentifier.PORT_SERIAL)
      {
        SerialPort sp = (SerialPort)thePort;
        try
        {
          if (this.verbose)
          {
            System.out.println(new StringBuilder().append(" - [").append(sp.getName()).append("] br:").append(sp.getBaudRate()).append(" DataBits:").append(sp.getDataBits()).append(" Parity:").append(sp.getParity()).append(" Stop:").append(sp.getStopBits()).toString());
          }
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
        sp.close();
      }

      String port = serialPorts[i];
      Thread waiter = Thread.currentThread();

      for (int j = 0; j < br.length; j++)
      {
        System.out.println(new StringBuilder().append(" Spawning thread for ").append(port).append(":").append(br[j]).toString());
        SnifferThread st = new SnifferThread(port, br[j], waiter);
        st.setDaemon(true);
        st.start();

        synchronized (waiter)
        {
          try
          {
            waiter.wait(5000L);
          }
          catch (InterruptedException ie)
          {
            System.out.println("Wait has been interrupted");
            ie.printStackTrace();
          }

          if (st.isAlive())
          {
            if (this.verbose)
              System.out.println("SnifferThread still alive...");
            try
            {
              st.stopReading();
            }
            catch (Exception ex)
            {
              ex.printStackTrace();
            }
            st.interrupt();
          }
          else if (this.verbose)
          {
            System.out.println("SnifferThread is already gone");
          }
        }
        st.stopReading();
      }
    }

    System.out.println("Done!");
    String mess = "";
    mess = new StringBuilder().append(mess).append("Found ").append(this.validPortList.size()).append("/").append(serialPorts.length).append(" possible NMEA port").append(this.validPortList.size() > 1 ? "s" : "").toString();
    for (String s : this.validPortList)
      mess = new StringBuilder().append(mess).append("\n  - ").append(s).toString();
    System.out.println(mess);
    JOptionPane.showMessageDialog(null, mess, "NMEA Serial Port Sniffer", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String[] args) throws Exception
  {
    if (args.length > 0)
      System.out.println(new StringBuilder().append(args.length).append(" arg(s).").toString());
    String[] serialPorts = listSerialPorts();
    System.out.println("Scanning");
    for (String s : serialPorts)
    {
      System.out.println(new StringBuilder().append(" - ").append(s).toString());
    }
    Sniffer sniffer = new Sniffer();
    sniffer.verbose = "true".equals(System.getProperty("verbose", "false"));
    sniffer.snif(serialPorts, new int[] { 1200, 2400, 4800, 9600, 19200 });
  }

  public static String[] listSerialPorts()
  {
    List<String> portList = new ArrayList<>();

    Enumeration en = CommPortIdentifier.getPortIdentifiers();
    while (en.hasMoreElements())
    {
      CommPortIdentifier portId = (CommPortIdentifier)en.nextElement();
      if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
      {
        portList.add(portId.getName());
      }
    }
    String[] sa = (String[])portList.toArray(new String[portList.size()]);
    if (sa.length == 0)
    {
      System.out.println("Found no Serial Port...");
    }
    return sa;
  }

  public class SnifferThread extends Thread
  {
    private SnifferNMEAReader snr = null;
    private String comPort = null;
    private int br = 0;
    private SnifferThread instance = this;
    private Thread waiter = null;

    public SnifferThread(String comPort, int br, Thread waiter)
    {
      super();
      this.waiter = waiter;
      this.comPort = comPort;
      this.br = br;
    }

    public synchronized void stopReading()
    {
      try
      {
        this.snr.stopReader();
      }
      catch (NullPointerException npe)
      {
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }

    public void run()
    {
      Thread reader = new Thread()
      {
        public void run() {
          try
          {
            snr = new SnifferNMEAReader(instance, verbose, comPort, br);
          }
          catch (Exception ex)
          {
            System.out.println(getClass().getName() + ":" + ex.toString());
          }
        }
      };
      reader.start();
    }

    public void dataEvent(SnifferNMEAReader snr, String port, int br, String str)
    {
      String s = str;
      while (s.endsWith("\n") || s.endsWith("\r"))
        s = s.substring(0, s.length() - 2);

      System.out.println("\n\tSniffer.dataEvent from " + port + ":" + String.valueOf(br) + " [" + s + "]");
      if (StringParsers.validCheckSum(str))
      {
        System.out.println("\t-> Port " + port + ":" + Integer.toString(br) + " seems good. (" + s + ")");
        Sniffer.this.validPortList.add(port + ":" + Integer.toString(br));
        synchronized (this.waiter)
        {
          this.waiter.notify();
        }
        try
        {
          snr.stopReader();
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }
      else
      {
        System.out.println("... Invalid NMEA Data read from " + port + ":" + String.valueOf(br));
      }
    }

    public void cutTheCrap(SnifferNMEAReader snr, String port, Throwable t)
    {
      if (verbose)
        System.out.println("...Stop sniffer (on error) [" + port + "] " + t.toString());

      try
      {
        snr.stopReader();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
  }
}
