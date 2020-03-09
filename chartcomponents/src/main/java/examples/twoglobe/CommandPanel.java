package examples.twoglobe;

import astro.calc.GeoPoint;
import astro.calc.GreatCircle;
import astro.calc.GreatCircleWayPoint;

import chart.components.ui.ChartPanel;
import chart.components.ui.ChartPanelInterface;
import chart.components.ui.ChartPanelParentInterface;
import chart.components.ui.ChartPanelParentInterface_II;
import chart.components.util.World;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.util.Enumeration;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import user.util.GeomUtil;

public class CommandPanel
  extends JPanel
  implements ChartPanelParentInterface_II
//implements ChartPanelParentInterface
{
  private BorderLayout borderLayout;
  private JScrollPane jScrollPane;
  private ChartPanel chartPanel;
  private JPanel bottomPanel;
  private JButton zoomInButton;
  private JButton zoomOutButton;
  private JButton spinButton;
  private JCheckBox frontOnlyCheckBox;
  private JCheckBox aftOnlyCheckBox;
  private JButton setValuesButton;
  private JTextField leftRight;
  private JTextField foreAft;

  private SampleFrame parent;

  private boolean videoHasBeenPlayed = false;

  public CommandPanel(SampleFrame caller)
  {
    parent = caller;
    borderLayout = new BorderLayout();
    jScrollPane = new JScrollPane();
    chartPanel = new ChartPanel(this, 600, 400);
    chartPanel.setProjection(ChartPanelInterface.GLOBE_VIEW);
    bottomPanel = new JPanel();
    zoomInButton = new JButton();
    zoomOutButton = new JButton();
    spinButton = new JButton();
    frontOnlyCheckBox = new JCheckBox();
    aftOnlyCheckBox = new JCheckBox();
    leftRight = new JTextField();
    leftRight.setPreferredSize(new Dimension(50, 20));
    foreAft = new JTextField();
    foreAft.setPreferredSize(new Dimension(50, 20));
    setValuesButton = new JButton();
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
    setLayout(borderLayout);
    zoomInButton.setText("Zoom In");
    zoomInButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          zoomInActionPerformed(e);
        }
      });
    zoomOutButton.setText("Zoom Out");
    zoomOutButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          zoomOutActionPerformed(e);
        }
      });
    spinButton.setText("Spin");
    spinButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          spinActionPerformed(e);
        }
      });
    frontOnlyCheckBox.setText("Front Only");
    frontOnlyCheckBox.setSelected(false);
    frontOnlyCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          transparentActionPerformed(e);
        }
      });
    aftOnlyCheckBox.setText("Back Only");
    aftOnlyCheckBox.setSelected(false);
    aftOnlyCheckBox.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          antiTransparentActionPerformed(e);
        }
      });

    leftRight.setText("23.0");
    leftRight.setToolTipText("Left-Right tilt (degrees)");
    foreAft.setText("40.0");
    foreAft.setToolTipText("Latitude of the eye (degrees)");
    setValuesButton.setText("Set");
    setValuesButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setValuesActionPerformed(e);
        }
      });
    jScrollPane.getViewport().add(chartPanel, null);
    add(jScrollPane, BorderLayout.CENTER);
    bottomPanel.add(zoomInButton, null);
    bottomPanel.add(zoomOutButton, null);
    bottomPanel.add(spinButton, null);
    bottomPanel.add(frontOnlyCheckBox, null);
    bottomPanel.add(aftOnlyCheckBox, null);
    bottomPanel.add(leftRight, null);
    bottomPanel.add(foreAft, null);
    bottomPanel.add(setValuesButton, null);
    add(bottomPanel, BorderLayout.SOUTH);
    double nLat =  90D;
    double sLat = -90D;
    double wLong = -180.0D;
    double eLong =  180.0D; // chartPanel.calculateEastG(nLat, sLat, wLong);

    chartPanel.setPositionToolTipEnabled(false);

    chartPanel.setGlobeViewLngOffset(-40.0);
    chartPanel.setGlobeViewRightLeftRotation(23.0);
    chartPanel.setGlobeViewForeAftRotation(40.0);

    chartPanel.setTransparentGlobe(true);

    chartPanel.setEastG(eLong);
    chartPanel.setWestG(wLong);
    chartPanel.setNorthL(nLat);
    chartPanel.setSouthL(sLat);
    chartPanel.setHorizontalGridInterval(10D);
    chartPanel.setVerticalGridInterval(10D);
    chartPanel.setWithScale(false);
    chartPanel.setChartColor(Color.black);
    chartPanel.setGridColor(Color.gray);
    chartPanel.setAltGridColor(Color.lightGray);
    chartPanel.setPostitBGColor(new Color(0f, 0f, 0f, 0.5f));
  }

  private void zoomInActionPerformed(ActionEvent e)
  {
    chartPanel.zoomIn();
  }

  boolean spinning = false;
  SpinningThread spinningThread = null;

  private void spinActionPerformed(ActionEvent e)
  {
    spinning = !spinning;
    if (spinning)
    {
      // Start the thread
      spinningThread = new SpinningThread();
      spinningThread.start();
    }
    else
    {
      // Stop the thread
      spinningThread.stopSpinning();
    }
  }

  private void transparentActionPerformed(ActionEvent e)
  {
    boolean frontOnly = frontOnlyCheckBox.isSelected();
    chartPanel.setTransparentGlobe(!frontOnly);
    if (frontOnly)
      aftOnlyCheckBox.setSelected(false);
    chartPanel.repaint();
  }

  private void antiTransparentActionPerformed(ActionEvent e)
  {
    boolean aftOnly = aftOnlyCheckBox.isSelected();
    chartPanel.setAntiTransparentGlobe(!aftOnly);
    if (aftOnly)
      frontOnlyCheckBox.setSelected(false);
    chartPanel.repaint();
  }

  private void zoomOutActionPerformed(ActionEvent e)
  {
    chartPanel.zoomOut();
  }

  private void setValuesActionPerformed(ActionEvent e)
  {
    double lr = 0.0;
    double fa = 0.0;
    try
    {
      lr = Double.parseDouble(leftRight.getText());
      fa = Double.parseDouble(foreAft.getText());
    }
    catch (NumberFormatException nfe)
    {
      System.err.println(nfe.getMessage());
    }
    chartPanel.setGlobeViewRightLeftRotation(lr);
    chartPanel.setGlobeViewForeAftRotation(fa);
    chartPanel.repaint();
  }

  GeoPoint from = null;
  GeoPoint to = null;

  // For video
  GeoPoint[] gpa =
  { new GeoPoint(GeomUtil.sexToDec("37", "56"), -GeomUtil.sexToDec("123", "4")), // SF
    new GeoPoint(GeomUtil.sexToDec("34", "0"), -GeomUtil.sexToDec("120", "0")), // Channel Islands
    new GeoPoint(-GeomUtil.sexToDec("9", "0"), -GeomUtil.sexToDec("140", "0")), // Marquesas
    new GeoPoint(-GeomUtil.sexToDec("15", "29"), -GeomUtil.sexToDec("145", "44")), // Tuamotus
    new GeoPoint(-GeomUtil.sexToDec("18", "0"), -GeomUtil.sexToDec("149", "0")), // Tahiti
    new GeoPoint(-GeomUtil.sexToDec("19", "0"), -GeomUtil.sexToDec("160", "0")), // Cook Islands
    new GeoPoint(-GeomUtil.sexToDec("18", "30"), -GeomUtil.sexToDec("173", "0")), // Tonga
    new GeoPoint(-GeomUtil.sexToDec("18", "0"), -GeomUtil.sexToDec("180", "0")), // Fiji
    new GeoPoint(GeomUtil.sexToDec("21", "15"), -GeomUtil.sexToDec("157", "40")), // Hawaii
    //    new GeoPoint(-GeomUtil.sexToDec("15", "0"), GeomUtil.sexToDec("168", "0")), // Vanuatu
    //    new GeoPoint(-GeomUtil.sexToDec("8", "0"), GeomUtil.sexToDec("159", "0")), // Solomon
    //    new GeoPoint(GeomUtil.sexToDec("9", "0"), GeomUtil.sexToDec("155", "0")), // Caroline
    //    new GeoPoint(GeomUtil.sexToDec("13", "15"), GeomUtil.sexToDec("144", "45")), // Guam
    //    new GeoPoint(GeomUtil.sexToDec("35", "0"),  GeomUtil.sexToDec("140", "0")), // Tokyo
    new GeoPoint(GeomUtil.sexToDec("50", "0"), -GeomUtil.sexToDec("127", "0")), // Vancouver
    new GeoPoint(GeomUtil.sexToDec("37", "56"), -GeomUtil.sexToDec("123", "4")) // SF
    } ;

  private boolean isVisible(double l, double g)
  {
    boolean plot = true;
    if (chartPanel.getProjection() == ChartPanelInterface.GLOBE_VIEW)
    {
      if (!chartPanel.isTransparentGlobe() && chartPanel.isBehind(l, g - chartPanel.getGlobeViewLngOffset()))
        plot = false;
      else if (!chartPanel.isAntiTransparentGlobe() && !chartPanel.isBehind(l, g - chartPanel.getGlobeViewLngOffset()))
        plot = false;
    }
    return plot;
  }

  public void chartPanelPaintComponent(Graphics gr)
  {
    Graphics2D g2d = null;
    if (gr instanceof Graphics2D)
      g2d = (Graphics2D) gr;
    World.drawChart(chartPanel, gr);
    // SF
    if (true)
    {
      double ls = GeomUtil.sexToDec("37", "49");
      double gs = -GeomUtil.sexToDec("122", "28.5");
      Point gp = chartPanel.getPanelPoint(ls, gs);
      if (isVisible(ls, gs))
      {
        circleAround(gr, ls, gs);
        chartPanel.postit(gr, "San Francisco", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("SF:" + ls + ", " + gs);
      // Channel Islands
      ls = GeomUtil.sexToDec("34", "00");
      gs = -GeomUtil.sexToDec("120", "00");
      gp = chartPanel.getPanelPoint(ls, gs);
      if (isVisible(ls, gs))
      {
        circleAround(gr, ls, gs);
        chartPanel.postit(gr, "Channel\nIslands", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Channel Islands:" + ls + ", " + gs);
      double lf = -GeomUtil.sexToDec("9", "0");
      double gf = -GeomUtil.sexToDec("140", "0");

      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Marquesas", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Marquesas:" + lf + ", " + gf);
      //  drawRhumbLine(gr, ls, gs, lf, gf);
      //  plotGreatCircle(gr, ls, gs, lf, gf);

      lf = -GeomUtil.sexToDec("15", "29");
      gf = -GeomUtil.sexToDec("145", "44");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Tuamotus", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Tuamotus:" + lf + ", " + gf);

      lf = -GeomUtil.sexToDec("17", "32");
      gf = -GeomUtil.sexToDec("149", "34");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Tahiti", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Tahiti:" + lf + ", " + gf);

      lf = -GeomUtil.sexToDec("19", "0");
      gf = -GeomUtil.sexToDec("160", "0");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Cook\nIslands", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Cook:" + lf + ", " + gf);

      lf = -GeomUtil.sexToDec("18", "30");
      gf = -GeomUtil.sexToDec("173", "0");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Tonga", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Tonga:" + lf + ", " + gf);

      lf = -GeomUtil.sexToDec("18", "0");
      gf = -GeomUtil.sexToDec("180", "0");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Fiji", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Fiji:" + lf + ", " + gf);

      // Hawai'i
      lf = GeomUtil.sexToDec("21", "15");
      gf = -GeomUtil.sexToDec("157", "40");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Hawai'i", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Hawai'i:" + lf + ", " + gf);

      //    lf = -GeomUtil.sexToDec("15", "0");
      //    gf = GeomUtil.sexToDec("168", "0");
      //    gp = chartPanel.getPanelPoint(lf, gf);
      //    circleAround(gr, lf, gf);
      //    chartPanel.postit(gr, "Vanuatu", gp.x, gp.y, Color.yellow);
      //    System.out.println("Vanuatu:" + lf + ", " + gf);
      //
      //    lf = -GeomUtil.sexToDec("8", "0");
      //    gf = GeomUtil.sexToDec("159", "0");
      //    gp = chartPanel.getPanelPoint(lf, gf);
      //    circleAround(gr, lf, gf);
      //    chartPanel.postit(gr, "Solomon\nIslands", gp.x, gp.y, Color.yellow);
      //    System.out.println("Solomon:" + lf + ", " + gf);
      //
      //    lf = GeomUtil.sexToDec("9", "0");
      //    gf = GeomUtil.sexToDec("155", "0");
      //    gp = chartPanel.getPanelPoint(lf, gf);
      //    circleAround(gr, lf, gf);
      //    chartPanel.postit(gr, "Caroline\nIslands", gp.x, gp.y, Color.yellow);
      //    System.out.println("Carolines:" + lf + ", " + gf);
      //
      //    lf = GeomUtil.sexToDec("13", "15");
      //    gf = GeomUtil.sexToDec("144", "45");
      //    gp = chartPanel.getPanelPoint(lf, gf);
      //    circleAround(gr, lf, gf);
      //    chartPanel.postit(gr, "Guam", gp.x, gp.y, Color.yellow);
      //    System.out.println("Guam:" + lf + ", " + gf);
      //
      //    lf = GeomUtil.sexToDec("35", "0");
      //    gf = GeomUtil.sexToDec("140", "0");
      //    gp = chartPanel.getPanelPoint(lf, gf);
      //    circleAround(gr, lf, gf);
      //    chartPanel.postit(gr, "Tokyo", gp.x, gp.y, Color.yellow);
      //    System.out.println("Tokyo:" + lf + ", " + gf);

      lf = GeomUtil.sexToDec("50", "0");
      gf = -GeomUtil.sexToDec("127", "0");
      gp = chartPanel.getPanelPoint(lf, gf);
      if (isVisible(lf, gf))
      {
        circleAround(gr, lf, gf);
        chartPanel.postit(gr, "Vancouver", gp.x, gp.y, Color.yellow);
      }
      //    System.out.println("Vancouver:" + lf + ", " + gf);

      // Recap
      //    System.out.println("---------------------------");
      for (int i = 0; false && i < gpa.length - 1; i++)
      {
        GeoPoint start = gpa[i];
        GeoPoint finish = gpa[i + 1];
        System.out.println("From " + start.toString() + " to " + finish.toString());
        displayGreatCircle(start.getL(), start.getG(), finish.getL(), finish.getG());
      }
      //    System.out.println("---------------------------");

      if (from != null && to != null)
      {
        ls = from.getL();
        gs = from.getG();
        lf = to.getL();
        gf = to.getG();
        gp = chartPanel.getPanelPoint(ls, gs);
        drawRhumbLine(gr, ls, gs, lf, gf);
        plotGreatCircle(gr, ls, gs, lf, gf, true);
        from = to = null;
      }

      // Plot eye position
      circleAround(gr, chartPanel.getGlobeViewForeAftRotation(), chartPanel.getGlobeViewLngOffset(), Color.cyan);
      String status = "Eye position: " + GeomUtil.decToSex(chartPanel.getGlobeViewForeAftRotation(), GeomUtil.SWING, GeomUtil.NS) + " " + GeomUtil.decToSex(chartPanel.getGlobeViewLngOffset(), GeomUtil.SWING, GeomUtil.EW);
      parent.setStatus(status);

      if (videoHasBeenPlayed)
      {
        // Plot trip
//      System.out.println("Plotting trip... " + Integer.toString(gpa.length) + " steps.");
        for (int i = 0; i < gpa.length - 1; i++)
        {
          GeoPoint start = gpa[i];
          GeoPoint finish = gpa[i + 1];
//        Point gps = chartPanel.getPanelPoint(start.getL(), start.getG());
          plotGreatCircle(gr, start.getL(), start.getG(), finish.getL(), finish.getG());
        }
      }
    }
  }

  public void chartPanelPaintComponentAfter(Graphics g)
  {
    if (true)
    {
      Color gc = chartPanel.getGridColor();
      
      double lr = chartPanel.getGlobeViewRightLeftRotation();
      double fa = chartPanel.getGlobeViewForeAftRotation();    
      
      chartPanel.setGridColor(Color.red);
      chartPanel.setAltGridColor(Color.orange);
      chartPanel.setGlobeViewRightLeftRotation(50d);
      chartPanel.setGlobeViewForeAftRotation(10d);
      chartPanel.redrawGrid(g);
  
      chartPanel.setGridColor(Color.blue);
      chartPanel.setGridColor(Color.cyan);
      chartPanel.setGlobeViewRightLeftRotation(-15d);
      chartPanel.setGlobeViewForeAftRotation(20d);
      chartPanel.redrawGrid(g);
  
      chartPanel.setGridColor(gc);
      chartPanel.setGlobeViewRightLeftRotation(lr);
      chartPanel.setGlobeViewForeAftRotation(fa);
    }
  }

  private void circleAround(Graphics gr, double lat, double lng)
  {
    circleAround(gr, lat, lng, null);
  }

  private void circleAround(Graphics gr, double lat, double lng, Color c)
  {
    final int RADIUS = 10;
    Stroke originalStroke = null;
    Color originalColor = null;
    if (gr instanceof Graphics2D)
    {
      originalStroke = ((Graphics2D) gr).getStroke();
      Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
      ((Graphics2D) gr).setStroke(stroke);
    }
    originalColor = gr.getColor();
    gr.setColor(c == null? Color.red: c);
    Point gp = chartPanel.getPanelPoint(lat, lng);
    gr.drawOval(gp.x - RADIUS, gp.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
    ((Graphics2D) gr).setStroke(originalStroke);
    gr.setColor(originalColor);
  }

  private void displayGreatCircle(double ls, double gs, double lf, double gf)
  {
    GreatCircle gc = new GreatCircle();
    gc.setStart(new GeoPoint(Math.toRadians(ls), Math.toRadians(gs)));
    gc.setArrival(new GeoPoint(Math.toRadians(lf), Math.toRadians(gf)));
    gc.calculateRhumLine();
    System.out.println("Between " + GeomUtil.decToSex(ls, GeomUtil.SWING, GeomUtil.NS) + " - " + GeomUtil.decToSex(gs, GeomUtil.SWING, GeomUtil.EW) + " and " + GeomUtil.decToSex(lf, GeomUtil.SWING, GeomUtil.NS) + " - " +
                       GeomUtil.decToSex(gf, GeomUtil.SWING, GeomUtil.EW) + ":");
    System.out.println("Distance:" + gc.getRhumbLineDistance() + " nm");
    double heading = gc.getRhumbLineRoute();
    System.out.println("Heading " + Integer.toString((int) Math.toDegrees(heading)));
  }

  private void drawRhumbLine(Graphics2D g, double ls, double gs, double lf, double gf)
  {
    g.setColor(Color.red);
    g.setStroke(new BasicStroke(1.0F));
    Point start = chartPanel.getPanelPoint(ls, gs);
    Point finish = chartPanel.getPanelPoint(lf, gf);
    if (start != null && finish != null)
      g.drawLine(start.x, start.y, finish.x, finish.y);
  }

  private void drawRhumbLine(Graphics g, double ls, double gs, double lf, double gf)
  {
    g.setColor(Color.red);
    Point start = chartPanel.getPanelPoint(ls, gs);
    Point finish = chartPanel.getPanelPoint(lf, gf);
    if (start != null && finish != null)
      g.drawLine(start.x, start.y, finish.x, finish.y);
  }

  private void plotGreatCircle(Graphics g, double ls, double gs, double lf, double gf)
  {
    plotGreatCircle(g, ls, gs, lf, gf, false);
  }

  private void plotGreatCircle(Graphics g, double ls, double gs, double lf, double gf, boolean print)
  {
    g.setColor(Color.blue);
    GreatCircle gc = new GreatCircle();
    gc.setStart(new GeoPoint(Math.toRadians(ls), Math.toRadians(gs)));
    gc.setArrival(new GeoPoint(Math.toRadians(lf), Math.toRadians(gf)));
    gc.calculateGreatCircle(20);
    if (print)
      System.out.println("Distance:" + Math.toDegrees(gc.getDistance()) * 60 + " nm");
    Vector route = gc.getRoute();
    Enumeration enumeration = route.elements();
    GreatCircleWayPoint gcwp;
    for (GreatCircleWayPoint previous = null; enumeration.hasMoreElements(); previous = gcwp)
    {
      gcwp = (GreatCircleWayPoint) enumeration.nextElement();
      Point b = chartPanel.getPanelPoint(Math.toDegrees(gcwp.getPoint().getL()), Math.toDegrees(gcwp.getPoint().getG()));
      //    g.drawOval(b.x - 2, b.y - 2, 4, 4);
      if (previous != null)
      {
        Point a = chartPanel.getPanelPoint(Math.toDegrees(previous.getPoint().getL()), Math.toDegrees(previous.getPoint().getG()));
        g.drawLine(a.x, a.y, b.x, b.y);
      }
    }
  }

  public boolean onEvent(EventObject e, int type)
  {
    if (type == ChartPanel.MOUSE_CLICKED)
    {
      if (from == null)
        from = chartPanel.getGeoPos(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
      else
        to = chartPanel.getGeoPos(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
      chartPanel.repaint();
    }
    return true;
  }

  public void afterEvent(EventObject eventobject, int i)
  {
  }

  public String getMessForTooltip()
  {
    return null;
  }

  public boolean replaceMessForTooltip()
  {
    return false;
  }

  public void videoCompleted()
  {
    videoHasBeenPlayed = true;
    System.out.println("Video completed");
  }

  public void videoFrameCompleted(Graphics g, Point p)
  {
  }

  public void zoomFactorHasChanged(double d)
  {
  }

  public void chartDDZ(double top, double bottom, double left, double right)
  {
  }

  class SpinningThread
    extends Thread
  {
    private boolean go = true;

    public SpinningThread()
    {
      super();
    }

    public void stopSpinning()
    {
      go = false;
    }

    public void run()
    {
      while (go)
      {
        try
        {
          double g = chartPanel.getGlobeViewLngOffset();
          g -= 1.0;
          while (g < -180)
            g += 360;
          chartPanel.setGlobeViewLngOffset(g);
//        System.out.println("G:" + g);
          synchronized (this)
          {
            chartPanel.repaint();
          }
          sleep(500L);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
