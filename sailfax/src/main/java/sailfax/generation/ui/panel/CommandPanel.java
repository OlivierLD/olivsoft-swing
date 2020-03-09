package sailfax.generation.ui.panel;

import astro.calc.GeoPoint;
import chart.components.util.Spatial;
import chart.components.util.World;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.Graphics;
import user.util.GeomUtil;
import chart.components.ui.ChartPanel;
import chart.components.ui.ChartPanelParentInterface;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import java.io.File;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import javax.swing.ImageIcon;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLElement;

import org.w3c.dom.NodeList;

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

  private transient MainChartPanelInterface parent = null;
  
  private boolean showWorld000 = true;
  private boolean showWorld180 = false;

  private transient List<Object[]> charts2Display = null;
  private transient Image red  = new ImageIcon(this.getClass().getResource("bullet_ball_glass_red.png")).getImage();
  
  public CommandPanel(MainChartPanelInterface mcp)
  {
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
    jScrollPane1.getViewport().add(chartPanel, null);
    this.add(jScrollPane1, BorderLayout.CENTER);

    world000RadioButton.setSelected(true);
    chartGroup.add(world000RadioButton);
    chartGroup.add(world180RadioButton);
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

    String placesFileName = "places.xml";
    DOMParser parser = new DOMParser();
    try
    {
      parser.parse(new File(placesFileName).toURI().toURL());
      XMLDocument doc = parser.getDocument();
      NodeList place = doc.selectNodes("//place");
      List<GeoPoint> alPos  = new ArrayList<GeoPoint>(place.getLength());
      List<String> alName = new ArrayList<String>(place.getLength());
      for (int i=0; i<place.getLength(); i++)
      {
        GeoPoint gp = null;
        XMLElement xe = (XMLElement)place.item(i);
        String placeName = xe.getAttribute("name").replace("\\n", "\n");
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
  
  public void resetCharts2Enhance()
  {
    charts2Display = null;
  }
  
  public void setChartToEnhance(String name, 
                                double t,
                                double b, 
                                double l,
                                double r)
  {    
    if (charts2Display == null)
      charts2Display = new ArrayList<Object[]>();
    charts2Display.add(new Object[] {name, 
                                     new Double(t),
                                     new Double(b),
                                     new Double(l),
                                     new Double(r)});
  }
  
  public void chartPanelPaintComponent(Graphics gr)
  {
    java.awt.Point gp1;
    java.awt.Point gp2;

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
      eLong = -0.0;
    }
    chartPanel.setWidthFromChart(nLat, sLat, wLong, eLong);
    chartPanel.setEastG(eLong);
    chartPanel.setWestG(wLong);
    chartPanel.setNorthL(nLat);
    chartPanel.setSouthL(sLat);
    chartPanel.setHorizontalGridInterval(20D);
    chartPanel.setVerticalGridInterval(20D);
//  Dimension d = chartPanel.getPreferredSize();
    World.paintChart(null, chartPanel, (Graphics2D)gr, Color.orange);
    World.drawChart(chartPanel, gr);
    
    // Some plots
    for (int i=0; i<gpa.length; i++)
    {
      Point gp = chartPanel.getPanelPoint(gpa[i].getL(), gpa[i].getG());
      chartPanel.postit(gr, ptLabels[i], gp.x, gp.y, Color.yellow);
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
    
    // Draw the selected charts
    try
    {
      Color orig = gr.getColor();
      gr.setColor(Color.RED);
      if (charts2Display != null)
      {
        Iterator iterator = charts2Display.iterator();
        while (iterator.hasNext())
        {
          Object[] row = (Object[])iterator.next();
          String chartno = (String)row[0];
          double topLeftLat = ((Double)row[1]).doubleValue();
          double topLeftLong = ((Double)row[3]).doubleValue();
          double bottomRightLat = ((Double)row[2]).doubleValue();
          double bottomRightLong = ((Double)row[4]).doubleValue();
          gp1 = chartPanel.getPanelPoint(topLeftLat, topLeftLong);
          gp2 = chartPanel.getPanelPoint(bottomRightLat, bottomRightLong);
        
          gr.drawRect(gp1.x, gp1.y, Math.abs(gp2.x - gp1.x), Math.abs(gp2.y - gp1.y));
          if (gp1.x > gp2.x)
          {
            gr.drawRect(0, gp1.y, gp2.x, Math.abs(gp2.y - gp1.y));
            gr.drawString("(" + chartno + ")", 2, gp1.y + 10);
          }
          gr.drawString(chartno, gp1.x + 2, gp1.y + 10);
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
      gr.setColor(orig);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private JRadioButton world000RadioButton = new JRadioButton("World 0\272");
  private JRadioButton world180RadioButton = new JRadioButton("World 180\272");
  
  private ButtonGroup  chartGroup       = new ButtonGroup();

  public boolean onEvent(EventObject e, int type)
  {
    if (type == ChartPanel.MOUSE_CLICKED)
    {
      MouseEvent me = (MouseEvent)e;
      int mask = me.getModifiers();
      if ((mask & MouseEvent.BUTTON2_MASK) != 0 || (mask & MouseEvent.BUTTON3_MASK) != 0)
      {
        // right button
        me.consume();
      }
      else if ((mask & MouseEvent.BUTTON1_MASK) != 0)
      {
        // left button
      }
    }
    return true;
  }

  private void world000RadioButton_actionPerformed(ActionEvent e)
  {
    if (this.world000RadioButton.isSelected())
    {
      showWorld000 = true;
      showWorld180 = false;
    }
    chartPanel.repaint();
  }

  private void world180RadioButton_actionPerformed(ActionEvent e)
  {
    if (this.world180RadioButton.isSelected())
    {
      showWorld180 = true;
      showWorld000 = false;
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

  public void zoomFactorHasChanged(double d) {}
}
