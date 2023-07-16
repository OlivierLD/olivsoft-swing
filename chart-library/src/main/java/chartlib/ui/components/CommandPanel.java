package chartlib.ui.components;

import astro.calc.GeoPoint;
import astro.calc.GreatCircle;
import astro.calc.GreatCircleWayPoint;

import chart.components.ui.ChartPanel;
import chart.components.ui.ChartPanelParentInterface;
import chart.components.util.Spatial;
import chart.components.util.World;

import chartlib.ChartLibInterface;

import chartlib.ctx.ChartLibContext;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.io.File;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLElement;

import org.w3c.dom.NodeList;

import tools.components.Latitude;
import tools.components.Longitude;

import user.util.GeomUtil;


public class CommandPanel 
     extends JPanel 
  implements ChartPanelParentInterface 
{
  private BorderLayout borderLayout1 = new BorderLayout();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private ChartPanel chartPanel = new ChartPanel(this);
  private JPanel bottomPanel = new JPanel();
  private JButton zoomInButton = new JButton();
  private JButton zoomOutButton = new JButton();
  private JButton grabScrollButton = new JButton();
  private Cursor defaultCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

  private transient Connection c = null;
  private transient ChartLibInterface parent = null;
  
  private boolean showCharts = true;
  private boolean showOnlySelectedCharts= false;
  
  private boolean showChartsWithName = false;
  private boolean showWorld000 = true;
  private boolean showWorld180 = true;
  private boolean showBay   = false;

  private int[] chart2enhance = null;
  private JCheckBox selectedOnlyCheckBox = new JCheckBox();

  private transient Image red  = new ImageIcon(this.getClass().getResource("bullet_ball_glass_red.png")).getImage();

  public CommandPanel(Connection conn,
                      ChartLibInterface mcp)
  {
    c = conn;
    parent = mcp;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  static GeoPoint[] gpa = null;
  static String[] ptLabels = null;

  private void jbInit() throws Exception
  {
    this.setLayout(borderLayout1);
    
//  zoomInButton.setText("Zoom In");
    this.setSize(new Dimension(729, 396));
    zoomInButton.setPreferredSize(new Dimension(24, 24));      
    zoomInButton.setIcon(new ImageIcon(getClass().getResource("zoomin.gif")));
    zoomInButton.setToolTipText("Zoom In");
    zoomInButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButton1_actionPerformed(e);
        }
      });
//  zoomOutButton.setText("Zoom Out");
    zoomOutButton.setPreferredSize(new Dimension(24, 24));      
    zoomOutButton.setIcon(new ImageIcon(getClass().getResource("zoomout.gif")));
    zoomOutButton.setToolTipText("Zoom Out");
    zoomOutButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButton2_actionPerformed(e);
        }
      });
    grabScrollButton.setPreferredSize(new Dimension(24, 24));      
    grabScrollButton.setIcon(new ImageIcon(getClass().getResource("ddz.png")));
    grabScrollButton.setToolTipText("Switch to Drag Drop Zoom");
    grabScrollButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e)
      {
        gsButton_actionPerformed(e);
      }
    });
    showChartCheckBox.setText("Show Charts");
    showChartCheckBox.setSelected(showCharts);
    showChartCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          showChartCheckBox_actionPerformed(e);
        }
      });
    withNameCheckBox.setText("With Name");
    withNameCheckBox.setSelected(showChartsWithName);
    withNameCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          withNameCheckBox_actionPerformed(e);
        }
      });
    jScrollPane1.getViewport().add(chartPanel, null);
    this.add(jScrollPane1, BorderLayout.CENTER);
    
    bottomPanel.add(showChartCheckBox, null);
    bottomPanel.add(selectedOnlyCheckBox, null);
    bottomPanel.add(withNameCheckBox, null);
    world000RadioButton.setSelected(true);
    chartGroup.add(world000RadioButton);
    chartGroup.add(world180RadioButton);
    chartGroup.add(calRadioButton);

    bottomPanel.add(world000RadioButton, null);
    world000RadioButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            world000RadioButton_actionPerformed(e);
          }
        });
    bottomPanel.add(world180RadioButton, null);
    world180RadioButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            world180RadioButton_actionPerformed(e);
          }
        });
    bottomPanel.add(calRadioButton, null);
    calRadioButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            calRadioButton_actionPerformed(e);
          }
        });
    selectedOnlyCheckBox.setText("Selected Only");
    selectedOnlyCheckBox.setEnabled(false);
    selectedOnlyCheckBox.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            selectedOnlyCheckBox_actionPerformed(e);
          }
        });
    bottomPanel.add(zoomInButton, null);
    bottomPanel.add(zoomOutButton, null);
    bottomPanel.add(grabScrollButton, null);
    this.add(bottomPanel, BorderLayout.SOUTH);

    //  double nLat = 38.5, sLat = 32.0, wLong = -126.0;
    double nLat = 74.0, sLat = -70.0, wLong = -180.0, eLong = 180.0;
    chartPanel.setWidthFromChart(nLat, sLat, wLong, eLong);

    chartPanel.setEastG(eLong);
    chartPanel.setWestG(wLong);
    chartPanel.setNorthL(nLat);
    chartPanel.setSouthL(sLat);
    
    chartPanel.setHorizontalGridInterval(20.0);
    chartPanel.setVerticalGridInterval(20.0);   
    
    chartPanel.setDdRectColor(Color.green);
    chartPanel.setMouseDraggedType(ChartPanel.MOUSE_DRAG_GRAB_SCROLL);

    String placesFileName = "sql" + File.separator + "places.xml";
    DOMParser parser = new DOMParser();
    try
    {
      URL url = new File(placesFileName).toURI().toURL();
      System.out.println("Parsing " + url.toString());
      parser.parse(url);
      XMLDocument doc = parser.getDocument();
      NodeList place = doc.selectNodes("//place");
      List<GeoPoint> alPos  = new ArrayList<GeoPoint>(place.getLength());
      List<String> alName = new ArrayList<String>(place.getLength());
      for (int i=0; i<place.getLength(); i++)
      {
        GeoPoint gp = null;
        XMLElement xe = (XMLElement)place.item(i);
        String placeName = xe.getAttribute("name");
        String degL = ((XMLElement)xe.getElementsByTagName("latitude").item(0)).getAttribute("deg");
        String minL = ((XMLElement)xe.getElementsByTagName("latitude").item(0)).getAttribute("min");
        String sgnL = ((XMLElement)xe.getElementsByTagName("latitude").item(0)).getAttribute("sign");
        String degG = ((XMLElement)xe.getElementsByTagName("longitude").item(0)).getAttribute("deg");
        String minG = ((XMLElement)xe.getElementsByTagName("longitude").item(0)).getAttribute("min");
        String sgnG = ((XMLElement)xe.getElementsByTagName("longitude").item(0)).getAttribute("sign");
        double l = GeomUtil.sexToDec(degL, minL);
        if (sgnL.equals("S")) l = -l;
        double g = GeomUtil.sexToDec(degG, minG);
        if (sgnG.equals("W")) g = -g;
        gp = new GeoPoint(l, g);
        alPos.add(gp);
        alName.add(placeName);
      }
      gpa = alPos.toArray(new GeoPoint[alPos.size()]);
      ptLabels = alName.toArray(new String[alName.size()]);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private void jButton1_actionPerformed(ActionEvent e)
  {
    chartPanel.zoomIn();
  }

  private void jButton2_actionPerformed(ActionEvent e)
  {
    chartPanel.zoomOut();
  }

  private void gsButton_actionPerformed(ActionEvent e)
  {
    try
    {
      if (chartPanel.getMouseDraggedType() == ChartPanel.MOUSE_DRAG_GRAB_SCROLL)
      {
        chartPanel.setMouseDraggedType(ChartPanel.MOUSE_DRAG_ZOOM);
        defaultCursor = chartPanel.getCursor();
        grabScrollButton.setIcon(new ImageIcon(getClass().getResource("grab.png")));
        grabScrollButton.setToolTipText("Switch to Grab Scroll");
//      System.out.println("Switching to GrabScroll");
      }
      else
      {
        chartPanel.setMouseDraggedType(ChartPanel.MOUSE_DRAG_GRAB_SCROLL);
        defaultCursor = chartPanel.getCursor();
        grabScrollButton.setIcon(new ImageIcon(getClass().getResource("ddz.png")));
        grabScrollButton.setToolTipText("Switch to Drag Drop Zoom");
//      System.out.println("Switching to DDZoom");
      }
      chartPanel.setCursor(defaultCursor);
    }
    catch(Exception exception) { }
    chartPanel.repaint();
  }

  Spatial spatial = null;
  
  public void setChartToEnhance(int[] ia)
  {
    ChartLibContext.getInstance().fireChartsSelected(ia);
    chart2enhance = ia;
    selectedOnlyCheckBox.setEnabled(ia != null);
    if (ia == null)
    {
      showOnlySelectedCharts = false;
      selectedOnlyCheckBox.setSelected(false);
    }
  }
  
  public void chartPanelPaintComponent(Graphics gr)
  {
    Point gp1 = null;
    Point gp2 = null;

    double nLat = 0D;
    double sLat = 0D;
    double wLong = 0D;
    double eLong = 0D;

    if (showWorld000)
    {
      nLat = 74.0;
      sLat = -70.0;
      wLong = -180.0;
      eLong = 180.0;
    }
    else if (showWorld180)
    {
      nLat = 74.0;
      sLat = -70.0;
      wLong = 1.0;
      eLong = -1.0;
    }
    else if (showBay)
    {
      nLat = 39.0;
      sLat =  37.0;
      wLong = -124.0;
      eLong = -121.0;
    }
    
    if (showBay)
    {
      if (spatial == null)
        spatial = new Spatial();        
      spatial.drawChart(chartPanel, gr);
    }
    else
    {
//    World.drawChart(chartPanel, gr); //, 0, Color.RED);
      World.paintChart(null, chartPanel, (Graphics2D)gr, Color.orange);
      World.drawChart(chartPanel, gr); //, 0, Color.RED);
    }

    chartPanel.setWidthFromChart(nLat, sLat, wLong, eLong);
    chartPanel.setEastG(eLong);
    chartPanel.setWestG(wLong);
    chartPanel.setNorthL(nLat);
    chartPanel.setSouthL(sLat);

    if (showCharts)
    {
      // Draw the charts
      boolean justSelection = true;
      try
      {
        Color orig = gr.getColor();
        gr.setColor(Color.RED);
        
        if (!justSelection)
        {
          Statement stmt = c.createStatement();
          ResultSet rSet = stmt.executeQuery("select chartno, " +
                                                    "title, " + 
                                                    "topLeftLat, " +
                                                    "topLeftLong, " + 
                                                    "bottomRightLat, "  +
                                                    "bottomRightLong " +
                                             "from charts");
          while (rSet.next())
          {
            int chartno = rSet.getInt(1);
            if ((showOnlySelectedCharts && isInList(chartno, chart2enhance)) || !showOnlySelectedCharts)
            {
              String title = rSet.getString(2);
              double topLeftLat = rSet.getDouble(3);
              double topLeftLong = rSet.getDouble(4);
              double bottomRightLat = rSet.getDouble(5);
              double bottomRightLong = rSet.getDouble(6);
              gp1 = chartPanel.getPanelPoint(topLeftLat, topLeftLong);
              gp2 = chartPanel.getPanelPoint(bottomRightLat, bottomRightLong);
              
    //        if (chartno == chart2enhance)
    //          gr.setColor(Color.blue);
                
              gr.drawRect(gp1.x, gp1.y, Math.abs(gp2.x - gp1.x), Math.abs(gp2.y - gp1.y));
              if (gp1.x > gp2.x)
              {
                gr.drawRect(0, gp1.y, gp2.x, Math.abs(gp2.y - gp1.y));
                gr.drawString("(" + Integer.toString(chartno) + ")", 2, gp1.y + 10);
              }
              String mess = Integer.toString(chartno); // Add the name?
              if (showChartsWithName)
                mess += (" - " + title);
              gr.drawString(mess, gp1.x + 2, gp1.y + 10);
              
              // Chart to enhance (blue transparency) ?
              if (isInList(chartno, chart2enhance))
              {
                // Transparency
                float alpha = 0.35f;
                ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                gr.setColor(Color.blue);
                gr.fillRect(gp1.x, gp1.y, Math.abs(gp2.x - gp1.x), Math.abs(gp2.y - gp1.y));
                if (gp1.x > gp2.x)
                  gr.fillRect(0, gp1.y, gp2.x, Math.abs(gp2.y - gp1.y));
                alpha = 1.0f;
                ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                gr.setColor(Color.RED);
              }
            }
          }
          rSet.close();
          stmt.close();
        }
        else
        {
          Object[][] selection = parent.getData();
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
           for (int i=0; i<selection.length; i++)
           {
             int chartno = ((Integer)selection[i][0]).intValue();
             if ((showOnlySelectedCharts && isInList(chartno, chart2enhance)) || !showOnlySelectedCharts)
             {
               String title = (String)selection[i][1];
               double topLeftLat = ((Latitude)selection[i][2]).getValue();
               double topLeftLong = ((Longitude)selection[i][3]).getValue();
               double bottomRightLat = ((Latitude)selection[i][4]).getValue();
               double bottomRightLong = ((Longitude)selection[i][5]).getValue();
               gp1 = chartPanel.getPanelPoint(topLeftLat, topLeftLong);
               gp2 = chartPanel.getPanelPoint(bottomRightLat, bottomRightLong);
               
             //        if (chartno == chart2enhance)
             //          gr.setColor(Color.blue);
                 
               gr.drawRect(gp1.x, gp1.y, Math.abs(gp2.x - gp1.x), Math.abs(gp2.y - gp1.y));
               if (gp1.x > gp2.x)
               {
                 gr.drawRect(0, gp1.y, gp2.x, Math.abs(gp2.y - gp1.y));
                 gr.drawString("(" + Integer.toString(chartno) + ")", 2, gp1.y + 10);
               }
               String mess = Integer.toString(chartno); // Add the name?
               if (showChartsWithName)
                 mess += (" - " + title);
               gr.drawString(mess, gp1.x + 2, gp1.y + 10);
             }
             // Chart to enhance (blue transparency) ?
             if (isInList(chartno, chart2enhance))
             {
               // Transparency
               float alpha = 0.35f;
               ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
               gr.setColor(Color.blue);
               gr.fillRect(gp1.x, gp1.y, Math.abs(gp2.x - gp1.x), Math.abs(gp2.y - gp1.y));
               if (gp1.x > gp2.x)
                 gr.fillRect(0, gp1.y, gp2.x, Math.abs(gp2.y - gp1.y));
               alpha = 1.0f;
               ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
               gr.setColor(Color.RED);
             }
           }
        }
        gr.setColor(orig);
      }
      catch (SQLException sqle)
      {
        sqle.printStackTrace();
      }
    }
    // SF Channel
//  double ls = GeomUtil.sexToDec("37", "46");
//  double gs = - GeomUtil.sexToDec("122", "35");    

    if (from != null && to != null)
    {
      drawRhumbLine(gr, from.getL(), from.getG(), to.getL(), to.getG());
      plotGreatCircle(gr, from.getL(), from.getG(), to.getL(), to.getG());
    }

    // Some plots
    for (int i=0; i<gpa.length; i++)
    {
      Point gp = chartPanel.getPanelPoint(gpa[i].getL(), gpa[i].getG());
      chartPanel.postit(gr, ptLabels[i].replace("\\n", "\n"), gp.x, gp.y, Color.yellow);
      if (false)
      {
        Color orig = gr.getColor();
        gr.setColor(Color.red);
        gr.drawOval(gp.x - 5, gp.y - 5, 10, 10);
        gr.drawOval(gp.x - 3, gp.y - 3, 6, 6);
        gr.setColor(orig);
      }
      else
        gr.drawImage(red, gp.x-8, gp.y-8, null);
    }
  }
  
  private boolean isInList(int no, int[] array)
  {
    boolean ret = false;
    if (array != null)
    {
      for (int i=0; i<array.length; i++)
      {
        if (array[i] == no)
        {
          ret = true;
          break;
        }
      }
    }
    return ret;
  }
  
  private void drawRhumbLine(Graphics g,
                             double ls, double gs,
                             double lf, double gf)
  {
    g.setColor(Color.red);
    Point start = chartPanel.getPanelPoint(ls, gs);
    Point finish = chartPanel.getPanelPoint(lf, gf);
    
    if (start != null && finish != null)
      g.drawLine(start.x, start.y, finish.x, finish.y);      
  }
  
  private void plotGreatCircle(Graphics g,
                               double ls, double gs,
                               double lf, double gf)
  {
    g.setColor(Color.blue);
    GreatCircle gc = new GreatCircle();
    gc.setStart(new GeoPoint(Math.toRadians(ls),
                             Math.toRadians(gs)));
    gc.setArrival(new GeoPoint(Math.toRadians(lf),
                               Math.toRadians(gf)));
    gc.calculateGreatCircle(20);
    Vector route = gc.getRoute();
    
    Enumeration enumeration = route.elements();

    GreatCircleWayPoint previous = null;
    while (enumeration.hasMoreElements())
    {
      GreatCircleWayPoint gcwp = (GreatCircleWayPoint)enumeration.nextElement();
      Point b = chartPanel.getPanelPoint(Math.toDegrees(gcwp.getPoint().getL()), 
                                                  Math.toDegrees(gcwp.getPoint().getG()));
//    g.drawOval(b.x - 2, b.y - 2, 4, 4);                                                  
      if (previous != null)
      {
        Point a = chartPanel.getPanelPoint(Math.toDegrees(previous.getPoint().getL()), 
                                                    Math.toDegrees(previous.getPoint().getG()));
        g.drawLine(a.x, a.y, b.x, b.y);
      }
      previous = gcwp;
    }
  } 
  
  GeoPoint from = null;
  GeoPoint to   = null;
  private JCheckBox showChartCheckBox = new JCheckBox();
  private JCheckBox withNameCheckBox  = new JCheckBox();
  private JRadioButton world000RadioButton = new JRadioButton("World 0\272");
  private JRadioButton world180RadioButton = new JRadioButton("World 180\272");
  private JRadioButton calRadioButton   = new JRadioButton("SF Bay");
  private ButtonGroup  chartGroup       = new ButtonGroup();

  private PanelPopup popup = null;
  
  public boolean onEvent(EventObject e, int type)
  {
    if (type == ChartPanel.MOUSE_CLICKED)
    {
      MouseEvent me = (MouseEvent)e;
      int mask = me.getModifiers();
      if ((mask & MouseEvent.BUTTON2_MASK) != 0 || (mask & MouseEvent.BUTTON3_MASK) != 0)
      {
        if (popup == null)
        {
          popup = new PanelPopup(this, me.getX(), me.getY());
        }
        popup.show(chartPanel, me.getX(), me.getY());
        me.consume();
      }
      else if ((mask & MouseEvent.BUTTON1_MASK) != 0)
      {
        int x = me.getX();
        int y = me.getY();
        
        if (to != null)
          from = to = null;
          
        GeoPoint gp = chartPanel.getGeoPos(x, y);
        if (from == null)
          from = gp;
        else
        {
          to = gp;
          // Display data
          GreatCircle gc = new GreatCircle();
          gc.setStart(new GeoPoint(Math.toRadians(from.getL()),
                                   Math.toRadians(from.getG())));
          gc.setArrival(new GeoPoint(Math.toRadians(to.getL()),
                                     Math.toRadians(to.getG())));
          gc.calculateGreatCircle(20);
          double gcDist = gc.getDistance();
          gc.calculateRhumLine();
          double rlDist = gc.getRhumbLineDistance();
          double rlZ    = gc.getRhumbLineRoute();
          
          DecimalFormat df = new DecimalFormat("##0.00");
          
          String mess = "GC:" + df.format(Math.toDegrees(gcDist * 60.0)) + "'\n" +
                        "RL:" + df.format(rlDist) + "'\n" +
                        " Z:" + df.format(Math.toDegrees(rlZ)) + " true";
          JOptionPane.showMessageDialog(this, mess, "Route", JOptionPane.INFORMATION_MESSAGE);
          
          // Get the charts for this trip
          try
          {
            String sqlStmt = "select chartno, title, provider " + 
                             "from charts " + 
                             "where inTrack(?, ?, ?, ?, " + 
                                            "topLeftLat, topLeftLong, " + 
                                            "bottomRightLat, bottomRightLong) = true";
            PreparedStatement pStmt = c.prepareStatement(sqlStmt);
            pStmt.setDouble(1, from.getL());
            pStmt.setDouble(2, from.getG());
            pStmt.setDouble(3, to.getL());
            pStmt.setDouble(4, to.getG());
            ResultSet rSet = pStmt.executeQuery();
            String result = "";
            Vector<Integer> v = new Vector<Integer>();
            while (rSet.next())
            {
              int idx = rSet.getInt(1);
              v.add(new Integer(idx));
              result += (rSet.getString(3) + " - " + Integer.toString(idx) + ", " + rSet.getString(2) + "\n");
            }
            rSet.close();
            pStmt.close();
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(result);
            clipboard.setContents(stringSelection, null);    
            JOptionPane.showMessageDialog(this, result, "Take those charts (it's in the clipboard)", JOptionPane.INFORMATION_MESSAGE);
            Integer[] array = v.toArray(new Integer[v.size()]);
            int[] charts = new int[array.length];
            for (int i=0; i<array.length; i++)
              charts[i] = array[i].intValue();
            this.setChartToEnhance(charts);
            this.repaint();
          }
          catch (SQLException sqlE)
          {
            sqlE.printStackTrace();
          }
        }
      }
    }
    return true;
  }

  private void showChartCheckBox_actionPerformed(ActionEvent e)
  {
    showCharts = this.showChartCheckBox.isSelected();
    withNameCheckBox.setEnabled(this.showChartCheckBox.isSelected());
    chartPanel.repaint();
  }

  private void withNameCheckBox_actionPerformed(ActionEvent e)
  {
    showChartsWithName = this.withNameCheckBox.isSelected();
    chartPanel.repaint();
  }

  private void world000RadioButton_actionPerformed(ActionEvent e)
  {
    if (this.world000RadioButton.isSelected())
    {
      showWorld000 = true;
      showWorld180 = false;
      showBay   = false;
    }
    chartPanel.repaint();
  }

  private void world180RadioButton_actionPerformed(ActionEvent e)
  {
    if (this.world180RadioButton.isSelected())
    {
      showWorld000 = false;
      showWorld180 = true;
      showBay   = false;
    }
    chartPanel.repaint();
  }

  private void calRadioButton_actionPerformed(ActionEvent e)
  {
    if (this.calRadioButton.isSelected())
    {
      showBay   = true;
      showWorld000 = false;
      showWorld180 = false;
    }
    chartPanel.repaint();
  }

  public String getMessForTooltip()
  {
    return null;
  }

  public boolean replaceMessForTooltip()
  {
    return false;
  }
  
  public void videoFrameCompleted(Graphics gr, Point pt) {}
  public void videoCompleted() {}
  public void chartDDZ(double top, double bottom, double left, double right){}

  public void zoomFactorHasChanged(double d)
  {
  }

  private void selectedOnlyCheckBox_actionPerformed(ActionEvent e)
  {
    showOnlySelectedCharts = !showOnlySelectedCharts;
    chartPanel.repaint();
  }

  class PanelPopup extends JPopupMenu
                implements ActionListener,
                           PopupMenuListener
  {
    CommandPanel parent;

    JMenuItem findChartsForThisPoint;
    JMenu     locateChartsForThisPoint;
    JMenuItem unselectCharts;

    private final String FIND_CHARTS     = "Find charts for this point";
    private final String LOCATE_CHART    = "Locate chart...";
    private final String UNSELECT_CHARTS = "Unselect Charts";
    int value = -1; 
    int _x = 0, _y = 0;
    
    public PanelPopup(CommandPanel ccp, int x, int y)
    {
      super();
      this.parent = ccp;
      this._x = x; 
      this._y = y;
      this.add(findChartsForThisPoint = new JMenuItem(FIND_CHARTS));
      findChartsForThisPoint.addActionListener(this);
      this.add(locateChartsForThisPoint = new JMenu(LOCATE_CHART));
//    findChartsForThisPoint.addActionListener(this);

      this.add(unselectCharts = new JMenuItem(UNSELECT_CHARTS));
      unselectCharts.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
      if (event.getActionCommand().equals(FIND_CHARTS))
      {
        GeoPoint gp = chartPanel.getGeoPos(_x, _y);
        List<List<?>> v = getChartForPoint(gp);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
//      Enumeration chartEnum = v.elements();        
        String result = "";
    //  while (chartEnum.hasMoreElements())
        for (List l : v)  
        {
//        ArrayList chartData = (ArrayList)chartEnum.nextElement();
          result += ((String)l.get(2) + " - " + ((Integer)l.get(0)).toString() + " - " + (String)l.get(1) + "\n");
        }
        StringSelection stringSelection = new StringSelection(result);
        clipboard.setContents(stringSelection, null);    
        JOptionPane.showMessageDialog(this, result, "Take those charts (it's in the clipboard)", JOptionPane.INFORMATION_MESSAGE);
        List[] array = v.toArray(new ArrayList[v.size()]);
        int[] charts = new int[array.length];
        for (int i=0; i<array.length; i++)
          charts[i] = ((Integer)array[i].get(0)).intValue();
        parent.setChartToEnhance(charts);
        parent.repaint();
      }
      else if (event.getActionCommand().equals(UNSELECT_CHARTS))
      {
        parent.setChartToEnhance(null);
        parent.repaint();
      }
      else // if (event.getActionCommand().equals(LOCATE_CHART)) // Request for chart
      {        
//      System.out.println("Event is:" + event.getActionCommand());
        String eventStr = event.getActionCommand();
        // Isolate chart number
        int blankIdx = 0;
        for (int i=0; i<eventStr.length(); i++)
        {
          if (eventStr.charAt(i) == ' ')
          {
            blankIdx = i;
            break;
          }          
        }
        String numStr = eventStr.substring(0, blankIdx);
//      System.out.println("Chart " + numStr);
        parent.setChartToEnhance(new int[] { new Integer(numStr).intValue() });
        parent.repaint();        
      }
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
    {
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
    {
    }

    public void popupMenuCanceled(PopupMenuEvent e)
    {
    }

    public void show(Component c, int x, int y)
    {
      _x = x; _y = y;
      unselectCharts.setEnabled(chart2enhance != null);
      
      locateChartsForThisPoint.removeAll();
      List<List<?>> v = getChartForPoint(chartPanel.getGeoPos(_x, _y));
//    Enumeration chartEnum = v.elements();        
//    while (chartEnum.hasMoreElements())
      for (List<?> l : v)
      {
//      ArrayList chartData = (ArrayList)chartEnum.nextElement();
        Chart chart = null;
        chart = new Chart((Integer)l.get(0), (String)l.get(1), (String)l.get(2));
        JMenuItem chartMenuItem = new JMenuItem(chart.toString());
        locateChartsForThisPoint.add(chartMenuItem);
        chartMenuItem.addActionListener(this);
      }      
      super.show(c, x, y);
    }
    
    private List<List<?>> getChartForPoint(GeoPoint gp)
    {
      List<List<?>> v = new Vector<List<?>>();
      try
      {
        String sqlStmt = "select chartno, title, provider " + 
                         "from charts " + 
                         "where inTrack(?, ?, ?, ?, " + 
                                       "topLeftLat, topLeftLong, " + 
                                       "bottomRightLat, bottomRightLong) = true";
        PreparedStatement pStmt = c.prepareStatement(sqlStmt);
        pStmt.setDouble(1, gp.getL());
        pStmt.setDouble(2, gp.getG());
        pStmt.setDouble(3, gp.getL());
        pStmt.setDouble(4, gp.getG());
        ResultSet rSet = pStmt.executeQuery();
        while (rSet.next())
        {
          int idx = rSet.getInt(1);
          List<Object> data = new ArrayList<Object>(2);
          data.add(new Integer(idx));
          data.add(rSet.getString(2));
          data.add(rSet.getString(3));
          v.add(data);
        }
        rSet.close();
        pStmt.close();
      }
      catch (SQLException sqlE)
      {
        sqlE.printStackTrace();
      }
      return v;
    }
  }
  
  public class Chart
  {
    int chartNo = 0;
    String chartTitle = "";
    String provider = "";
    
    public Chart(int no, String title)
    {
      chartNo = no;
      chartTitle = title;
    }
    
    public Chart(int no, String title, String provider)
    {
      chartNo = no;
      chartTitle = title;
      this.provider = provider;
    }
    
    public String toString()
    {
      return (Integer.toString(chartNo) + " - " + (provider.trim().length() > 0?provider + " - ":"") + chartTitle);
    }
  }
}
