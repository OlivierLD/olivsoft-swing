package nightsky.full;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import nightsky.NightPanelHolder;
import nightsky.NightSkyPanel;
import nightsky.NightSkyPanelWithConstellations;

public class DualFrame
  extends JFrame
{
  private NightPanelHolder nphOne = null;
  private NightPanelHolder nphTwo = null;
  private JTabbedPane tabbedPane  = new JTabbedPane();
  
  public DualFrame()
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
    NightSkyPanel panelOne = new NightSkyPanelWithConstellations();
    NightSkyPanel panelTwo = new NightSkyPanelWithConstellations(NightSkyPanel.SKY_CHART_OPTION);
    nphOne = new NightPanelHolder(NightSkyPanel.STAR_FINDER_OPTION, panelOne, NightPanelHolder.WITH_CONSTELLATIONS);
    nphTwo = new NightPanelHolder(NightSkyPanel.SKY_CHART_OPTION,   panelTwo, NightPanelHolder.WITH_CONSTELLATIONS);

    this.getContentPane().setLayout(new BorderLayout());
    tabbedPane.add("Star Finder", nphOne);
    tabbedPane.setToolTipTextAt(0, 
                                "<html>" +
                                "You are sitting at the center of the blue circle,<br>" +
                                "under the blue dot.<br>" +
                                "You are looking in the direction of the cardinal points." +
                                "</html>");
    tabbedPane.add("Sky Map",     nphTwo);
    tabbedPane.setToolTipTextAt(1, 
                                "<html>" +
                                "You are sitting at the center of the blue circle,<br>" +
                                "under the blue dot.<br>" +
                                "<b>Place the chart over your head!</b><br>" +
                                "You are looking in the direction of the cardinal points." +
                                "</html>");
//                                "<html>" +
//                                "You are sitting <b>at the center of the circle</b>.<br>" +
//                                "When you sit at the <b><font color='red'>N</font></b>, you are looking North." +
//                                "</html>");
    this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    this.setSize(new Dimension(650, 650));
    this.setTitle("Dual Display");
  }
}
