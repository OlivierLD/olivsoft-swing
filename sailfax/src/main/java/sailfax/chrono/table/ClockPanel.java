package sailfax.chrono.table;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.swing.JPanel;

import sailfax.Utilities;


public class ClockPanel
  extends JPanel
implements MouseMotionListener
{
//private List<Integer> tx = null;
  private Map<Integer, String[]> tx = null;
  private final static DecimalFormat DF2 = new DecimalFormat("00");
  private final static SimpleDateFormat HOURS_FMT = new SimpleDateFormat("HH");
  private final static SimpleDateFormat MINUTES_FMT = new SimpleDateFormat("mm");

  private Date ut = null;
  
  public ClockPanel()
  {
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
    this.setLayout( null );
    this.addMouseMotionListener(this);
  }
  
  public void paintComponent(Graphics gr)
  {
    ((Graphics2D)gr).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                      RenderingHints.VALUE_TEXT_ANTIALIAS_ON);      
    ((Graphics2D)gr).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                      RenderingHints.VALUE_ANTIALIAS_ON);      
    int radius = (int)(0.85d * Math.min(this.getWidth(), this.getHeight()) / 2);
//  gr.setColor(Color.lightGray);
//  gr.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    drawGlossyCircularDisplay((Graphics2D)gr, 
                              new Point((this.getWidth() / 2), (this.getHeight() / 2)), 
                              this.getWidth(),
                              this.getHeight(),
                              radius, 
                              Color.lightGray, 
                              Color.darkGray, 1f);
    gr.setColor(Color.lightGray);
    // Current time
    String utcStr = HOURS_FMT.format(ut) + ":" + MINUTES_FMT.format(ut) + " UTC";
    Font f = gr.getFont();
    Font f2 = f.deriveFont(Font.BOLD, 20f);
    gr.setFont(f2);
    int utcLength = gr.getFontMetrics(f2).stringWidth(utcStr);
    gr.drawString(utcStr,(this.getWidth() / 2) - (utcLength/2), (this.getHeight() / 2) - (radius / 2));   
    gr.setFont(f);

//    gr.fillOval((this.getWidth() / 2) - radius,
//                (this.getHeight() / 2) - radius,
//                2 * radius,
//                2 * radius);
    
    // Transmissions starts
    int x = (this.getWidth() / 2);
    int y = (this.getHeight() / 2);
    
    gr.setColor(Color.white);
    float fSize = 20;
    f2 = f.deriveFont(Font.BOLD, fSize);
    gr.setFont(f2);
    String s = "XXIV"; // "00";
    int sl = gr.getFontMetrics(f2).stringWidth(s);
    gr.drawString(s, x - (sl/2), y - (int)(radius * 0.9)  + (int)fSize + 2);
    s = "XII"; // "12";
    sl = gr.getFontMetrics(f2).stringWidth(s);
    gr.drawString(s, x - (sl/2), y + (int)(radius * 0.9) - 2);
    s = "VI"; // "06";
    sl = gr.getFontMetrics(f2).stringWidth(s);
    gr.drawString(s, x + (int)(radius * 0.9) - sl + 2, y + (int)(fSize / 2));
    s = "XVIII"; // "18";
    sl = gr.getFontMetrics(f2).stringWidth(s);
    gr.drawString(s, x - (int)(radius * 0.9) - 2, y + (int)(fSize / 2));
    
    gr.setColor(Color.lightGray);
    gr.setFont(f);
    float alpha = 1f; // 0.60f;
    Graphics2D g2 = (Graphics2D)gr;
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    if (tx != null)
    {
      g2.setColor(Color.red);
      
      for (Integer i : tx.keySet())
        drawHand(g2, i.intValue(), radius, x, y);
    }

    if (this.ut != null)
    {
      int h = Integer.parseInt(HOURS_FMT.format(ut));
      int m = Integer.parseInt(MINUTES_FMT.format(ut));
      g2.setColor(Color.blue);
      int time = (60 * h) + m;
      drawHand(g2, time, radius + 5, x, y);
    }
    alpha = 1.0f;
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    
    int knobRadius = 10;
    g2.setColor(Color.black);
    g2.fillOval((this.getWidth() / 2) - knobRadius,
                (this.getHeight() / 2) - knobRadius,
                2 * knobRadius,
                2 * knobRadius);
  }
  
  private void drawHand(Graphics gr, int i, int radius, int x, int y)
  {
    // 24 hours = 1440 minutes
    int degrees = (int)(360d * i / 1440d);
    Polygon polygon = new Polygon();
    // Hand end
    int _x = (int)(x + (radius * Math.sin(Math.toRadians(degrees)))); 
    int _y = (int)(y - (radius * Math.cos(Math.toRadians(degrees))));
//  gr.drawLine(x, y, _x, _y);
    polygon.addPoint(_x, _y);
    String s = DF2.format(i / 60) + ":" + (DF2.format(i % 60));
    int sl = gr.getFontMetrics(gr.getFont()).stringWidth(s);
    if (degrees >=0 && degrees < 90) // top right
      ;
    else if (degrees >=90 && degrees < 180) // bottom right
      _y += gr.getFont().getSize();
    else if (degrees >=180 && degrees < 270) // bottom left
    {
      _y += gr.getFont().getSize();
      _x -= sl;
    }
    else if (degrees >=270 && degrees < 360) // top left
      _x -= sl;
      
    gr.drawString(s, _x, _y);
    
    _x = (int)(x + (3 * Math.sin(Math.toRadians(degrees - 90)))); 
    _y = (int)(y - (3 * Math.cos(Math.toRadians(degrees - 90))));
    polygon.addPoint(_x, _y);
    
    _x = (int)(x + (3 * Math.sin(Math.toRadians(degrees + 90)))); 
    _y = (int)(y - (3 * Math.cos(Math.toRadians(degrees + 90))));
    polygon.addPoint(_x, _y);
    
    gr.fillPolygon(polygon);
  }
  
  private static void drawGlossyCircularDisplay(Graphics2D g2d, Point center, int w, int h, int radius, Color lightColor, Color darkColor, float transparency)
  {
    RadialGradientPaint rgp = new RadialGradientPaint(center, 
                                                      (int)(radius * 1.15), 
                                                      new float[] {0f, 0.9f, 1f}, 
                                                      new Color[] {Color.white, Color.gray, Color.white});
    g2d.setPaint(rgp);
    g2d.fillRect(0, 0, w, h);

    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
    g2d.setPaint(null);

    g2d.setColor(darkColor);
    g2d.fillOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);

    Point gradientOrigin = new Point(center.x - radius,
                                     center.y - radius);
    GradientPaint gradient = new GradientPaint(gradientOrigin.x, 
                                               gradientOrigin.y, 
                                               lightColor, 
                                               gradientOrigin.x, 
                                               gradientOrigin.y + (2 * radius / 3), 
                                               darkColor); // vertical, light on top
    g2d.setPaint(gradient);
    g2d.fillOval((int)(center.x - (radius * 0.90)), 
                 (int)(center.y - (radius * 0.95)), 
                 (int)(2 * radius * 0.9), 
                 (int)(2 * radius * 0.95));
  }

//public void setTrans(List<Integer> allTrans)
  public void setTrans(Map<Integer, String[]> allTrans)
  {
    tx = allTrans;
    repaint();
  }

  public void setGMT(Date ut)
  {
    this.ut = ut;
    this.repaint();
  }

  public void mouseDragged(MouseEvent e)
  {
  }

  public void mouseMoved(MouseEvent e)
  {
    this.setToolTipText(detectTx(e));
  }
  
  private String detectTx(MouseEvent me)
  {
    String data = null;
    int cx = (this.getWidth() / 2);
    int cy = (this.getHeight() / 2);
    if (tx != null)
    {
      int mx = me.getPoint().x;
      int my = me.getPoint().y;
      float deltaX = cx - mx;
      float deltaY = my - cy;
      double dir = Utilities.getDir(deltaX, deltaY);
//    System.out.println("Dir:"+ dir);

      for (Integer i : tx.keySet())
      {
        int degrees = (int)(360d * i / 1440d);
        if (Math.abs(dir - degrees) < 2)
        {
          String[] faxData = tx.get(i);
          data = faxData[2] + " kHz, ";
          for (int idx=5; idx<faxData.length; idx++)
            data += (faxData[idx] + " ");
          
          break;
        }
      }
    }
    return data;
  }
}
