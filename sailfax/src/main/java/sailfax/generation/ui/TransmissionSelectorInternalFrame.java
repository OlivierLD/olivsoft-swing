package sailfax.generation.ui;

/**
 * This one is duplicated from TransmissionSelectorFrame
 * It extends JInternalFrame instead of JFrame.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import java.util.List;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.event.InternalFrameAdapter;

import javax.swing.event.InternalFrameEvent;

import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLElement;

import sailfax.Utilities;

import sailfax.chrono.DataParser;
import sailfax.chrono.table.TablePanel;

import sailfax.ctx.SailFaxContext;

import sailfax.generation.contracts.DisplayMapRequestor;
import sailfax.generation.contracts.DisplayTxRequestor;
import sailfax.generation.data.ReadTransmissionData;
import sailfax.generation.data.ReadTransmissionData.StationData;
import sailfax.generation.ui.panel.CommandPanel;
import sailfax.generation.ui.panel.SailFaxAboutBox;
import sailfax.generation.ui.panel.TransmissionPanel;

public class TransmissionSelectorInternalFrame
  extends JInternalFrame
  implements DisplayMapRequestor, DisplayTxRequestor
{
  private static final String SKEDFILE_NAME = "SkedFile.txt";
  private final static String AIRMAIL_LOCATION = System.getProperty("airmail.location", ".");
  private final static SimpleDateFormat UTC_DATE_FORMAT = new SimpleDateFormat("E dd-MMM-yyyy HH:mm:ss Z");
  
  private final static String TITLE_ROOT = "Transmission Selector";

  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuFile = new JMenu();
//private JMenuItem menuFileExit = new JMenuItem();
  private JMenu menuHelp = new JMenu();
  private JMenuItem menuHelpHelp = new JMenuItem();
  private JMenuItem menuHelpAbout = new JMenuItem();

  private BorderLayout layoutMain = new BorderLayout();
  private JPanel panelCenter = new JPanel();
  private JLabel statusBar = new JLabel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JTabbedPane jTabbedPane1 = new JTabbedPane();
  private JPanel jPanel1 = new JPanel();
  private JButton generateButton = new JButton();
  private CommandPanel chartCommandPanel = new CommandPanel(null);
  private TablePanel chronoFaxTablePanel = new TablePanel(this, AIRMAIL_LOCATION + File.separator + SKEDFILE_NAME);

  String dataFileName = null;
  List allData = null;

  public TransmissionSelectorInternalFrame()
  {
    this(null);
  }
  public TransmissionSelectorInternalFrame(String dataFile)
  {
    dataFileName = dataFile;
    // Static read
    DataParser.setSkedFileName(AIRMAIL_LOCATION + File.separator + SKEDFILE_NAME);
    DataParser.readData();

    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    Thread refreshTitleThread = new Thread()
      {
        public void run()
        {
          while (true)
          {
            String title = TITLE_ROOT + " UTC:" + UTC_DATE_FORMAT.format(GregorianCalendar.getInstance().getTime());
            UTC_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
            setTitle(title);
            try { Thread.sleep(1000L); } catch (Exception ex) {}
          }
        }
      };
    refreshTitleThread.start();
    this.getContentPane().setLayout(layoutMain);
    panelCenter.setLayout(borderLayout1);
    this.setSize(new Dimension(730, 656));
    this.setTitle(TITLE_ROOT);
    try { this.setFrameIcon(new ImageIcon(this.getClass().getResource("script.png"))); } catch (Exception ignore) {}
    statusBar.setText("");
    generateButton.setText("Generate");
    generateButton.setActionCommand("generateFile");
    generateButton.setToolTipText("Generate the SkedFile.txt based on your selections in the tabs above.");
    generateButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          generateButton_actionPerformed(e);
        }
      });
    this.getContentPane().add(statusBar, BorderLayout.SOUTH);
    panelCenter.add(jTabbedPane1, BorderLayout.CENTER);
    this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    jPanel1.add(generateButton, null);
    this.getContentPane().add(jPanel1, BorderLayout.SOUTH);

    if (dataFileName == null)
      allData = ReadTransmissionData.readFaxSchedule();
    else
      allData = ReadTransmissionData.readFaxSchedule(dataFileName);
    Iterator iterator = allData.iterator();
    while (iterator.hasNext())
    {
      ReadTransmissionData.BulletinData bd =
        (ReadTransmissionData.BulletinData) iterator.next();
      String callSign = getTabName(bd); // sd.callsign;
      jTabbedPane1.addTab(callSign, new TransmissionPanel(this, bd));
    }
    jTabbedPane1.addTab("Chart", chartCommandPanel);
    jTabbedPane1.addTab("Chronology", chronoFaxTablePanel);

    menuFile.setText("File");
    menuHelp.setText("Help");
//  menuFileExit.setText("Exit");
    menuHelpHelp.setText("Help");
    menuHelpAbout.setText("About");

//    menuFileExit.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent ae)
//        {
//          System.exit(0);
//        }
//      });
    menuHelpHelp.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          helpHelp_ActionPerformed(ae);
        }
      });
    menuHelpAbout.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          helpAbout_ActionPerformed(ae);
        }
      });

    this.setJMenuBar(menuBar);

    this.addInternalFrameListener(new InternalFrameAdapter()
      {
        public void internalFrameClosed(InternalFrameEvent e)
        {
          this_internalFrameClosed(e);
        }
      });
    menuBar.add(menuFile);
    menuBar.add(menuHelp);

//  menuFile.add(menuFileExit);

    menuHelp.add(menuHelpHelp);
    menuHelp.add(menuHelpAbout);

  }

  void helpAbout_ActionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this, new SailFaxAboutBox(), "About", JOptionPane.PLAIN_MESSAGE);
  }

  void helpHelp_ActionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this,
                                  "You need that?\n... coming soon, I swear.",
                                  "Help", JOptionPane.PLAIN_MESSAGE);
  }

  private String getTabName(ReadTransmissionData.BulletinData bd)
  {
    String ret = "";
    Iterator si = bd.stations.iterator();
    while (si.hasNext())
    {
      ret +=
          ((ret.length() > 0? "/": "") + ((StationData) si.next()).callsign);
    }
    return ret;
  }
 
  private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
  
  private void generateButton_actionPerformed(ActionEvent e)
  {
    boolean go = true;
    File f = new File(AIRMAIL_LOCATION + File.separator + SKEDFILE_NAME);
    try
    {
      if (f.exists())
      {
        int resp =
          JOptionPane.showConfirmDialog(this, 
                                        "SkedFile.txt already exists.\nOk to override it?",
                                        "SkedFile.txt generation",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION)
        {
          go = true;
          // Create backup
          String newName = AIRMAIL_LOCATION + File.separator + SKEDFILE_NAME + "." + sdf.format(new Date());
          JOptionPane.showMessageDialog(this, "Backup file created:\n" + newName, "SkedFile.txt generatrion", JOptionPane.INFORMATION_MESSAGE);
          f.renameTo(new File(newName));
          f = new File(AIRMAIL_LOCATION + File.separator + SKEDFILE_NAME);
        }
        else
          go = false;
      }
      if (go)
      {
        // The output file
        BufferedWriter br = new BufferedWriter(new FileWriter(f));
        // The XML structure, for publishing
        XMLDocument xml = new XMLDocument();

        String str = "; File generated on " + new Date().toString();
        br.write(str + "\r\n");

        XMLElement xmlRoot =
          (XMLElement) xml.createElement("schedule-root");
        xmlRoot.setAttribute("desc", str.substring(2));
        xml.appendChild(xmlRoot);

        for (int i = 0; i < jTabbedPane1.getComponentCount() - 1; i++)
        {
          Component c = jTabbedPane1.getComponentAt(i);
          if (c instanceof TransmissionPanel)
          {
            TransmissionPanel tp = (TransmissionPanel) c;
            Object data[][] = tp.getTransData();

            // Loop and write
            ReadTransmissionData.BulletinData bd =
              (ReadTransmissionData.BulletinData) allData.get(i);
            String stationName = "", callsign = "";
            Iterator stations = bd.stations.iterator();
            while (stations.hasNext())
            {
              StationData sd = (StationData) stations.next();
              stationName += (sd.stationName + " ");
              callsign += ((callsign.length() > 0? "/": "") + sd.callsign);
            }
            String header = "; " + stationName;
            //        System.out.println(header);
            br.write(header + "\r\n");
            for (int j = 0; j < data.length; j++)
            {
              if (((Boolean) data[j][0]).booleanValue())
              {
                // Selected
                //              System.out.println("Type:" + (String)data[j][4]);
                String line = "";
                if (((String) data[j][4]).equals("fax"))
                {
                  line = " " + (String) data[j][1] + " " + // starts
                      (String) data[j][2] + " " + // stops
                      (String) data[j][3] + " " + // freq
                      (String) data[j][4] + " " + // type
                      "size=120/576 " + // size
                      callsign + " " + (String) data[j][1] + " " +
                      (String) data[j][5]; // Content
                }
                else
                {
                  line = " " + (String) data[j][1] + " " + // starts
                      (String) data[j][2] + " " + // stops
                      (String) data[j][3] + " " + // freq
                      (String) data[j][4] + " " + // type
                      callsign + " " + (String) data[j][1] + " " +
                      (String) data[j][5]; // Content
                }
                //            System.out.println(line);
                br.write(line + "\r\n");
                XMLElement bulletin =
                  (XMLElement) xml.createElement("bulletin");
                xmlRoot.appendChild(bulletin);
                bulletin.setAttribute("starts", (String) data[j][1]);
                bulletin.setAttribute("stops", (String) data[j][2]);
                bulletin.setAttribute("freq", (String) data[j][3]);
                bulletin.setAttribute("type", (String) data[j][4]);
                bulletin.setAttribute("size", "size=120/576 ");
                bulletin.setAttribute("content",
                                      callsign + " " + (String) data[j][1] +
                                      " " + (String) data[j][5]);
              }
            }
          }
          else
            System.out.println("Oops!");
        }
        br.close();
        System.out.println("File is generated");
        // Generate XML
        PrintWriter pw = new PrintWriter(new File("schedule.xml"));
        xml.print(pw);
        pw.close();
        Utilities.xslTransform("schedule.xml", "scheduleToHTML.xsl",
                               "schedule.html");
//      Runtime.getRuntime().exec("cmd /k start schedule.html");
        coreutilities.Utilities.openInBrowser("schedule.html");
      }
      else
        System.out.println("Generation aborted");
    }
    catch (Exception ioe)
    {
      ioe.printStackTrace();
    }
    chronoFaxTablePanel.refreshData();
  }

  public void resetAllRequests()
  {
    chartCommandPanel.resetCharts2Enhance();
  }

  public void displayChart(String cs, String name, double top,
                           double bottom, double left, double right)
  {
    chartCommandPanel.setChartToEnhance(cs + " " + name, top, bottom, left,
                                        right);
  }

  public void switchToChartPanel()
  {
    jTabbedPane1.setSelectedIndex(jTabbedPane1.getComponentCount() - 2);
  }

  public void switchToTxPanel(String[] txData)
  {
    String str = "";
    for (int i = 0; i < txData.length; i++)
      str += (txData[i] + " ");
    System.out.println("Switching to " + str);
    /* Find the transmission
     * txData[0] : start
     * txData[1] : stop
     * txData[2] : freq
     * txData[3] : type
     * txData[4] : comment
     */
    Iterator iterator = allData.iterator();
    while (iterator.hasNext())
    {
      ReadTransmissionData.BulletinData bd =
        (ReadTransmissionData.BulletinData) iterator.next();
      List stations = bd.stations;
      Iterator stats = stations.iterator();
      String callsign = "";
      while (stats.hasNext())
      {
        StationData sd = (StationData) stats.next();
        //      System.out.println("; " + sd.callsign + " " + sd.stationName);
        callsign += ((callsign.length() > 0? "/": "") + sd.callsign);
        //      System.out.println(callsign);
        List fd = sd.freqs;
        Iterator freqs = fd.iterator();
        while (freqs.hasNext())
        {
          ReadTransmissionData.FreqData f =
            (ReadTransmissionData.FreqData) freqs.next();
          //        System.out.println("; " + f.freq + ", " + f.times + ", " + f.emission + ", " + f.power);
        }
      }
      List<ReadTransmissionData.MapData> md = bd.maps;
      Iterator<ReadTransmissionData.MapData> maps = md.iterator();
      while (maps.hasNext())
      {
        ReadTransmissionData.MapData m =
          (ReadTransmissionData.MapData) maps.next();
        //      System.out.println("; " + m.id + ":" + m.top + " " + m.bottom + " - " + m.left + " " + m.right);
      }

      List<ReadTransmissionData.TransmissionData> td = bd.transmissions;
      Iterator<ReadTransmissionData.TransmissionData> trans = td.iterator();
      int txId = 0;
      while (trans.hasNext())
      {
        ReadTransmissionData.TransmissionData t = trans.next();

        if (txData[0].equals(t.starts) && txData[1].equals(t.stops) &&
            txData[4].startsWith(callsign.trim()))
        {
          //        System.out.println("Found something...\n" +
          //                           "Comparing:" + t.content + "\n" +
          //                           "with     :" + txData[4]);
          System.out.println(t.starts + " " + t.stops + " " + "freq" +
                             " " + t.mode + " " + "size=" + t.rpm + " " +
                             t.content + " " +
                             ((t.map != null)? "(Map " + t.map + ")": ""));
          // Find the tab
          for (int i = 0; i < jTabbedPane1.getTabCount(); i++)
          {
            if (jTabbedPane1.getTitleAt(i).equals(callsign.trim()))
            {
              jTabbedPane1.setSelectedIndex(i);
              Component c = jTabbedPane1.getComponentAt(i);
              if (c instanceof TransmissionPanel)
              {
                //              ((TransmissionPanel)c).setSelectedTransmissionLine(txId);
                ((TransmissionPanel) c).setSelectedTransmissionLine(t.starts,
                                                                    t.stops);
              }
              break;
            }
          }
          break;
        }
        txId++;
      }
    }
  }

  public Object[] getSkedFaxes()
  {
    return DataParser.getFaxes();
  }

  private void this_internalFrameClosed(InternalFrameEvent e)
  {
    SailFaxContext.getInstance().fireInternalFrameClosed();
  }
}
