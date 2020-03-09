package chartlib.ctx;

import chartlib.event.ChartLibListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton to hold the static data
 * across all the application
 */
public class ChartLibContext
{
  private static ChartLibContext staticObjects = null;
  private transient List<ChartLibListener> chartlibListeners = null;
  
  private ChartLibContext()
  {
    chartlibListeners = new ArrayList<ChartLibListener>(2); // 2: Initial Capacity
  }
  
  public static synchronized ChartLibContext getInstance()
  {
    if (staticObjects == null)
      staticObjects = new ChartLibContext();
    return staticObjects;
  }
  
  public List<ChartLibListener> getListeners()
  {
    return chartlibListeners;
  }
    
  public void release()
  {
    staticObjects = null;
    System.gc();
  }
  
  public synchronized void addChartLibListener(ChartLibListener l)
  {
    if (!chartlibListeners.contains(l))
    {
      chartlibListeners.add(l);
    }
  }

  public synchronized void removeChartLibListener(ChartLibListener l)
  {
    chartlibListeners.remove(l);
  }

  public void fireDataChanged(String[] newProviders)
  {
    for (int i=0; i<chartlibListeners.size(); i++)
    {
      ChartLibListener l = chartlibListeners.get(i);
      l.dataChanged(newProviders);
    }
  }
  
  public void fireChartsSelected(int[] ia)
  {
    for (int i=0; i<chartlibListeners.size(); i++)
    {
      ChartLibListener l = chartlibListeners.get(i);
      l.chartsSelected(ia);
    }
  }

  public void fireInternalFrameClosed()
  {
    for (int i=0; i<chartlibListeners.size(); i++)
    {
      ChartLibListener l = chartlibListeners.get(i);
      l.internalFrameClosed();
    }
  }
}
