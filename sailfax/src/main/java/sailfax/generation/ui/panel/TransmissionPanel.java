package sailfax.generation.ui.panel;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import javax.swing.JTabbedPane;

import sailfax.generation.contracts.DisplayMapRequestor;
import sailfax.generation.contracts.DisplayTxRequestor;
import sailfax.generation.data.ReadTransmissionData;
import sailfax.generation.data.ReadTransmissionData.StationData;
import sailfax.generation.table.MapTablePanel;
import sailfax.generation.table.FreqTablePanel;
import sailfax.generation.table.TransmissionTablePanel;
import sailfax.generation.table.TransmissionTablePanelHolder;

public class TransmissionPanel
     extends JPanel
  implements DisplayMapRequestor ,
             DisplayTxRequestor
{
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel topPanel = new JPanel();
  private JLabel stationNameLabel = new JLabel();
  private JPanel centerPanel = new JPanel();
  private JSplitPane verticalSplitPane = new JSplitPane();
  private JSplitPane horizontalSplitPane = new JSplitPane();
  private BorderLayout borderLayout2 = new BorderLayout();
  
  private TransmissionTablePanelHolder ttp = null;
  private MapTablePanel                mtp = null;

  private transient ReadTransmissionData.BulletinData bulletinData = null;
  private transient DisplayMapRequestor parent;

  public TransmissionPanel(DisplayMapRequestor parent, 
                           ReadTransmissionData.BulletinData data)
  {
    this.parent = parent;
    bulletinData = data;
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public Object[][] getTransData()
  {
    return ttp.getData();
  }
  
  private void jbInit()
    throws Exception
  {
    List<ReadTransmissionData.FreqData> allFrequencies = new ArrayList<ReadTransmissionData.FreqData>();
    String stationName = "", callsign = "";
    Iterator stations = bulletinData.stations.iterator();
    while (stations.hasNext())
    {
      StationData sd = (StationData)stations.next();
      allFrequencies.addAll(sd.freqs);
      stationName += ((stationName.length()>0?"; ":"") + sd.stationName);
      callsign += ((callsign.length()>0?"/":"") + sd.callsign);
    }
    
    ttp = new TransmissionTablePanelHolder(callsign, this, allFrequencies, bulletinData.maps);
    mtp = new MapTablePanel(callsign, this);
    this.setLayout(borderLayout1);
    stationNameLabel.setFont(new Font("Tahoma", 1, 12));
    stationNameLabel.setForeground(Color.blue);
    stationNameLabel.setText(stationName);
    centerPanel.setLayout(borderLayout2);
    verticalSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    topPanel.add(stationNameLabel, null);
    this.add(topPanel, BorderLayout.NORTH);
    centerPanel.add(verticalSplitPane, BorderLayout.CENTER);
    this.add(centerPanel, BorderLayout.CENTER);
    verticalSplitPane.setRightComponent(ttp);
    verticalSplitPane.setLeftComponent(horizontalSplitPane);
    horizontalSplitPane.setLeftComponent(mtp);
    JTabbedPane stationTabbedPane = new JTabbedPane();
    horizontalSplitPane.setRightComponent(stationTabbedPane);
    // Populate the tables
    ttp.setValues(bulletinData.transmissions);
//  ttp.setStatus(Integer.toString(bulletinData.transmissions.size()) + " transmission(s)");
    mtp.setValues(bulletinData.maps);
    mtp.setStatus(Integer.toString(bulletinData.maps.size()) + " map(s)");
    
    List stats = bulletinData.stations;
    Iterator si = stats.iterator();
    while (si.hasNext())
    {
      FreqTablePanel ftp = new FreqTablePanel();
      StationData stationData = (StationData)si.next();
      ftp.setValues(stationData.freqs);
      ftp.setStatus(Integer.toString(stationData.freqs.size()) + " frequency(ies)");
      stationTabbedPane.add(stationData.callsign, ftp);
    }
  }
  
  public void paintComponent(Graphics g)
  {
    verticalSplitPane.setDividerLocation(this.getSize().height / 3);
    horizontalSplitPane.setDividerLocation(this.getSize().width / 2);
  }

  public void resetAllRequests()
  {
    parent.resetAllRequests();
  }

  public void displayChart(String cs,
                           String name,
                           double top, 
                           double bottom, 
                           double left, 
                           double right)
  {
    parent.displayChart(cs, name, top, bottom, left, right);
  }

  public void switchToChartPanel()
  {
    parent.switchToChartPanel();
  }
  
  /**
   * 
   * @deprecated
   */
  public void setSelectedTransmissionLine(int i)
  {
    ttp.setSelectedLine(i);
  }

  public void setSelectedTransmissionLine(String start, String stop)
  {
    ttp.setSelectedLine(start, stop);
  }

  public void switchToTxPanel(String[] data)
  {
  }

  public Object[] getSkedFaxes()
  {
    return ((DisplayTxRequestor)parent).getSkedFaxes();
  }
}
