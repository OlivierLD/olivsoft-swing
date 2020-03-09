package sailfax.generation.table;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import sailfax.generation.contracts.DisplayMapRequestor;
import sailfax.generation.data.ReadTransmissionData;

public class TransmissionTablePanelHolder
  extends JPanel
implements DisplayMapRequestor
{
  private BorderLayout borderLayout1 = new BorderLayout();
  private List<ReadTransmissionData.MapData> maps;

  private DisplayMapRequestor parent;
  private String callsign;
  
  private TransmissionTablePanel faxTransmissionPanel   = null;
  private TransmissionTablePanel sitorTransmissionPanel = null;
  
  private JSplitPane jsplitPane = null;

  public TransmissionTablePanelHolder(String callsign, 
                                      DisplayMapRequestor parent, 
                                      List<ReadTransmissionData.FreqData> freqs, 
                                      List<ReadTransmissionData.MapData> maps)
  {
    this.callsign = callsign;
    this.parent = parent;
    this.maps = maps;
    try
    {
      List<ReadTransmissionData.FreqData> alFax = new ArrayList<ReadTransmissionData.FreqData>(2);
      List<ReadTransmissionData.FreqData> alSitor = new ArrayList<ReadTransmissionData.FreqData>(2);
      Iterator<ReadTransmissionData.FreqData> f = freqs.iterator();
      while (f.hasNext())
      {
        ReadTransmissionData.FreqData rtfd = ((ReadTransmissionData.FreqData) f.next());
        if ("SITOR".equals(rtfd.emission))
          alSitor.add(rtfd);
        else
          alFax.add(rtfd);
      }
      faxTransmissionPanel = new TransmissionTablePanel(callsign, parent, alFax, maps);
      if (alSitor.size() > 0)
      {
        sitorTransmissionPanel = new TransmissionTablePanel(callsign, parent, alSitor, maps);
        jsplitPane = new JSplitPane();
        jsplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jsplitPane.setRightComponent(sitorTransmissionPanel);
        jsplitPane.setLeftComponent(faxTransmissionPanel);
        jsplitPane.setResizeWeight(.5D);
//      jsplitPane.setDividerLocation(0.5D);
      }
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
    this.setLayout(borderLayout1);
    if (jsplitPane != null)
      this.add(jsplitPane, BorderLayout.CENTER);
    else
      this.add(faxTransmissionPanel, BorderLayout.CENTER);
  }

  public void resetAllRequests()
  {
     parent.resetAllRequests();
  }

  public void displayChart(String station, 
                           String name, 
                           double top, 
                           double bottom, 
                           double left, 
                           double right)
  {
     parent.displayChart(station, name, top, bottom, left, right);
  }

  public void switchToChartPanel()
  {
     parent.switchToChartPanel();
  }

  public void setStatus(String str)
  {
    faxTransmissionPanel.setStatus(str);  
  }
  
  public void setValues(List<ReadTransmissionData.TransmissionData> td)
  {
    if (sitorTransmissionPanel != null)
    {
      // Split in two
      List<ReadTransmissionData.TransmissionData> faxData = new ArrayList<ReadTransmissionData.TransmissionData>();
      List<ReadTransmissionData.TransmissionData> sitorData = new ArrayList<ReadTransmissionData.TransmissionData>();
      Iterator<ReadTransmissionData.TransmissionData> mainIterator = td.iterator();
      while (mainIterator.hasNext())
      {
        ReadTransmissionData.TransmissionData tdata = mainIterator.next();
        if (tdata.mode.equalsIgnoreCase("SITOR") || tdata.mode.equalsIgnoreCase("FEC") || tdata.mode.equalsIgnoreCase("FEX"))
          sitorData.add(tdata);
        else
          faxData.add(tdata);
      }
      faxTransmissionPanel.setValues(faxData);
      sitorTransmissionPanel.setValues(sitorData);
    }
    else
      faxTransmissionPanel.setValues(td);
  }
  
  public void setSelectedLine(int i)
  {
//  System.out.println("TransmissionTablePanelHolder.setSelectedLine:" + i);
    // ttp.setSelectedTransmissionLine(i);
  }  
  
  public void setSelectedLine(String start, String stop)
  {
    System.out.println("TransmissionTablePanelHolder.setSelectedLine:" + start + "/" + stop);
    // Look for the lines
    int i = 0;
    Object[][] data = faxTransmissionPanel.getData();
    boolean found = false;
    for (i=0; i<data.length; i++)
    {
      if (((String)data[i][1]).equals(start) && ((String)data[i][2]).equals(stop))
      {
        found = true;
        break;
      }
    }
    if (found)
      faxTransmissionPanel.setSelectedLine(i);
    else
    {
      if (sitorTransmissionPanel != null)
      {
        data = sitorTransmissionPanel.getData();
        for (i=0; i<data.length; i++)
        {
          if (((String)data[i][1]).equals(start) && ((String)data[i][2]).equals(stop))
          {
            found = true;
            break;
          }
        }
        if (found)
          sitorTransmissionPanel.setSelectedLine(i);
      }
    }
    if (!found)
      System.out.println("Transmission not found.");
  }  
     
  public Object[][] getData()
  {
    Object[][] data = faxTransmissionPanel.getData();
    if (sitorTransmissionPanel != null) // Concatenate when necessary
    {
      Object[][] sitorData = sitorTransmissionPanel.getData();
      Object[][] newData = new Object[data.length + sitorData.length][];
      for (int i=0; i<data.length; i++)
        newData[i] = data[i];
      for (int i=0; i<sitorData.length; i++)
        newData[data.length + i] = sitorData[i];
      data = newData;
    }
    return data;
  }
}
