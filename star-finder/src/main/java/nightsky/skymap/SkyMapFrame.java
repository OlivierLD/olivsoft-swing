package nightsky.skymap;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import nightsky.NightPanelHolder;
import nightsky.NightSkyPanel;
import nightsky.NightSkyPanelWithConstellations;

public class SkyMapFrame
  extends JFrame
{
  private NightPanelHolder nsp = new NightPanelHolder(NightSkyPanel.SKY_CHART_OPTION,
                                                      new NightSkyPanelWithConstellations(NightSkyPanel.SKY_CHART_OPTION),
                                                      NightPanelHolder.WITH_CONSTELLATIONS);
    
  public SkyMapFrame()
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
    this.getContentPane().setLayout(new BorderLayout());
    this.setSize( new Dimension(800, 800) );
    this.setTitle("Sky Map. You sit at the center of the blue circle.");

    this.getContentPane().add(nsp, BorderLayout.CENTER);
  }
}
