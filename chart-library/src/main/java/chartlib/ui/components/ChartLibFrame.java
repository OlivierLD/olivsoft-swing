package chartlib.ui.components;


import chartlib.ChartLibInterface;

import chartlib.ctx.ChartLibContext;

import chartlib.event.ChartLibListener;

import coreutilities.Utilities;

import coreutilities.sql.SQLUtil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.PrintWriter;

import java.net.URL;

import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLElement;
import oracle.xml.parser.v2.XSLProcessor;
import oracle.xml.parser.v2.XSLStylesheet;

import org.w3c.dom.Text;

import tools.util.StaticUtil;


public class ChartLibFrame 
     extends JFrame 
  implements ChartLibInterface 
{
  private JLabel statusBar = new JLabel();
  private JMenuItem menuHelpAbout = new JMenuItem();
  private JMenu menuHelp = new JMenu();
  private JMenuItem menuFilePrint = new JMenuItem();
  private JMenuItem menuFileGoogleMap = new JMenuItem();
  private JMenuItem menuFileExit = new JMenuItem();
  private JMenu menuFile = new JMenu();
  private JMenuBar menuBar = new JMenuBar();
  private JPanel panelCenter = new JPanel();
  private BorderLayout layoutMain = new BorderLayout();
  private BorderLayout borderLayout1 = new BorderLayout();
  private TablePanel chartTablePanel = null;
  private CommandPanel commandPanel = null;
  private ProvidersPanel providersPanel = null;

  private Connection conn = null;
  private JPanel mainJPanel = new JPanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private JTabbedPane mainJTabbedPane = new JTabbedPane();
  private JPanel bottomPanel = new JPanel();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JLabel nbRecLabel = new JLabel();
  
  private ChartLibFrame instance = null;

  public ChartLibFrame(Connection c)
  {
    conn = c;
    instance = this;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    ChartLibContext.getInstance().addChartLibListener(new ChartLibListener()
      {
        public void dataChanged(String[] newProviders)
        {
          chartTablePanel = new TablePanel(conn, instance);
          mainJTabbedPane.setComponentAt(0, chartTablePanel);          
        }
      });
  }

  private void jbInit() throws Exception
  {
    this.setJMenuBar(menuBar);
    this.getContentPane().setLayout(layoutMain);
    panelCenter.setLayout(borderLayout1);
    mainJPanel.setLayout(borderLayout2);
    bottomPanel.setLayout(borderLayout3);
    nbRecLabel.setText("...");
    this.setSize(new Dimension(965, 547));
    this.setTitle("Chart Library");
    try { this.setIconImage(new ImageIcon(this.getClass().getResource("book.gif")).getImage()); } catch (Exception ignore) {}
    
    
    menuFile.setText("File");    
    menuFilePrint.setText("Print Selection");
    menuFilePrint.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          filePrint_ActionPerformed(ae);
        }
      });
    menuFileGoogleMap.setText("Show selection in Google Map...");
    menuFileGoogleMap.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          fileGoogleMap_ActionPerformed(ae);
        }
      });
    menuFileExit.setText("Exit");
    menuFileExit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          fileExit_ActionPerformed(ae);
        }
      });
    menuHelp.setText("Help");
    menuHelpAbout.setText("About");
    menuHelpAbout.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          helpAbout_ActionPerformed(ae);
        }
      });
    statusBar.setText("");
    menuFile.add(menuFilePrint);
    menuFile.add(menuFileGoogleMap);
    menuFile.add(menuFileExit);
    menuBar.add(menuFile);
    menuHelp.add(menuHelpAbout);
    menuBar.add(menuHelp);
    this.getContentPane().add(statusBar, BorderLayout.NORTH);
    mainJPanel.add(mainJTabbedPane, BorderLayout.CENTER);
    panelCenter.add(mainJPanel, BorderLayout.CENTER);
    this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    this.getContentPane().add(bottomPanel, BorderLayout.WEST);
    this.getContentPane().add(nbRecLabel, BorderLayout.SOUTH);

    chartTablePanel = new TablePanel(conn, this);
    commandPanel    = new CommandPanel(conn, this);
    providersPanel  = new ProvidersPanel(conn, this);
    
    mainJTabbedPane.add("Your Charts", chartTablePanel);
    mainJTabbedPane.add("Visualize",   commandPanel);
    mainJTabbedPane.add("Providers",   providersPanel);
  }

  private static DOMParser parser = null;

  void filePrint_ActionPerformed(ActionEvent e)
  {
    try 
    { 
      Object[][] data = chartTablePanel.data;
      //  1, Integer, chartno
      //  2, String, title
      //  3, Latitude, top left
      //  4, Longitude, top left
      //  5, Latitude, bottom right
      //  6, Longitude, bottom right
      //  7, String, provider
      //  8, Short, year
      //  9, Short, nbcopies
      // 10, String, comment
      XMLDocument doc = new XMLDocument();
      XMLElement root = (XMLElement)doc.createElement("selection-root");
      doc.appendChild(root);
      for (int i=0; i<data.length; i++)
      {
        Integer chartno = (Integer)data[i][0];
        String title    = (String)data[i][1];
        String provider = (String)data[i][6];
        Short year      = (Short)data[i][7];
        XMLElement chart = (XMLElement)doc.createElement("chart");
        chart.setAttribute("chart-no", chartno.toString());
        chart.setAttribute("provider", provider);
        chart.setAttribute("year", year.toString());
        Text txt = doc.createTextNode("text#");
        chart.appendChild(txt);
        txt.setNodeValue(title);
        root.appendChild(chart);
      }
      doc.print(System.out);
      // in HTML
      URL xslURL = new File("charthtml.xsl").toURI().toURL();
      //  System.out.println("Transforming using " + xslURL.toString());
      if (parser == null)
        parser = new DOMParser();
      parser.parse(xslURL);
      XMLDocument xsldoc = parser.getDocument();                  
      // instantiate a stylesheet
      XSLProcessor processor = new XSLProcessor();
      processor.setBaseURL(xslURL);
      XSLStylesheet xslss = processor.newXSLStylesheet(xsldoc);
       
      // display any warnings that may occur
      processor.showWarnings(true);
      processor.setErrorStream(System.err);
       
      // Process XSL    
      PrintWriter pw = new PrintWriter(new File("selection.html"));
      //  processor.setParam("xmlnx:url", "prm1", "value1");
      processor.processXSL(xslss, doc, pw);    
      pw.close();
      Utilities.openInBrowser("selection.html");
    } 
    catch (Exception ex) 
    { ex.printStackTrace(); }
  }

  void fileGoogleMap_ActionPerformed(ActionEvent e)
  {
    StaticUtil.showGoogleMap(chartTablePanel.data);
  }

  private static int sign(double d)
  {
    int s = 0;
    if (d > 0.0D)
      s = 1;
    if (d < 0.0D)
      s = -1;
    return s;
  }

  void fileExit_ActionPerformed(ActionEvent e)
  {
    try { SQLUtil.shutdown(conn); } catch (Exception ex) { ex.printStackTrace(); }
    System.exit(0);
  }

  void helpAbout_ActionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this, new ChartLibFrame_AboutBoxPanel1(), "About Chartlib", JOptionPane.PLAIN_MESSAGE);
  }

  public void setChartNumber(int i)
  {
    String str = Integer.toString(i) + " chart(s) selected.";
//  System.out.println(str);
    this.nbRecLabel.setText(str);
//  this.repaint();
  }
  
  public void setChartToEnhance(int[] ia)
  {
    commandPanel.setChartToEnhance(ia);
    mainJTabbedPane.setSelectedIndex(1); // The chart 
    chartTablePanel.setSelectedRows(ia);    
  }

  public Object[][] getData()
  {
    return chartTablePanel.getData();
  }
}
