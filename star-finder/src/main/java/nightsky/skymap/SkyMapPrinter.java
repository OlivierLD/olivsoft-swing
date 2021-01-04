package nightsky.skymap;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Toolkit;

import java.io.File;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;

import nightsky.NightSkyPanel;
import nightsky.NightSkyPanelWithConstellations;

public class SkyMapPrinter
{
  private final static int WIDTH  = 1000;
  private final static int HEIGHT = 1000;
  private final static NumberFormat NF = new DecimalFormat("00");
  
  private static void snapshot(String fileName, final NightSkyPanel nsp)
  {
    try
    {
      SwingUtilities.invokeAndWait(new Runnable()
      {
        public void run()
        {
          nsp.repaint();
        }
      });
    }
    catch (Exception ex) 
    {
      ex.printStackTrace();      
    }
    File output = new File(fileName);
    nsp.genImage(output, "jpg", nsp.getWidth(), nsp.getHeight());
//  try { Thread.sleep(1000L); } catch (Exception ex) {}
  }

  public static void main(String... args)
  {
    System.setProperty("for.print", "true");
    NightSkyPanel nsp = new NightSkyPanelWithConstellations(NightSkyPanel.SKY_CHART_OPTION);
    nsp.setWithCelestSphere(false);
    nsp.setWithConstellationNames(false);
    nsp.setWithConstellations(false);
    nsp.setWithStarNames(false);
    nsp.setWithStars(false);
    nsp.setWithWanderingBodies(false);
    nsp.setWithVisibleSky(true);
    nsp.setHemisphere(NightSkyPanel.NORTH_HEMISPHERE);
    
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());
    frame.setSize( new Dimension(WIDTH, HEIGHT) );
    frame.getContentPane().add(nsp, BorderLayout.CENTER);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
    {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width)
    {
      frameSize.width = screenSize.width;
    }
    frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);    
    
    int step = 1;
    for (int i=1; i<90; i+=step)
    {
      nsp.setLatitude(i); // 40: Boulder, 37.5, SF
      snapshot("N_" + NF.format(i) + ".jpg", nsp);
    }
    nsp.setHemisphere(NightSkyPanel.SOUTH_HEMISPHERE);
    for (int i=1; i<90; i+=step)
    {
      nsp.setLatitude(i);
      snapshot("S_" + NF.format(i) + ".jpg", nsp);
    }
    
    nsp.setWithCelestSphere(true);
    nsp.setWithVisibleSky(false);
    nsp.setWithConstellations(true);
    nsp.setWithConstellationNames(true);
    nsp.setWithStarNames(true);
    nsp.setWithStars(true);
    nsp.setHemisphere(NightSkyPanel.NORTH_HEMISPHERE);
    snapshot("Hemisphere_NORTH.jpg", nsp);
    nsp.setHemisphere(NightSkyPanel.SOUTH_HEMISPHERE);
    snapshot("Hemisphere_SOUTH.jpg", nsp);

//  try { Thread.sleep(10000L); } catch (Exception ex) {}

    frame.setVisible(false);
    frame.dispose();
  }
}
