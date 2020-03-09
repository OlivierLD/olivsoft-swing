package generatelocator.ctx;

import java.util.ArrayList;
import java.util.List;

public class LocatorContext
{
  private static LocatorContext staticObjects = null;
  private transient List<LocatorEventListener> locatorListeners = null;
  
  private LocatorContext()
  {
    locatorListeners = new ArrayList<LocatorEventListener>(2); // 2: Initial Capacity
  }
  
  public static synchronized LocatorContext getInstance()
  {
    if (staticObjects == null)
      staticObjects = new LocatorContext();
    return staticObjects;
  }
  
  public List<LocatorEventListener> getListeners()
  {
    return locatorListeners;
  }
    
  public void release()
  {
    staticObjects = null;
    System.gc();
  }
  
  public synchronized void addLocatorListener(LocatorEventListener l)
  {
    if (!locatorListeners.contains(l))
    {
      locatorListeners.add(l);
    }
  }

  public synchronized void removeLocatorListener(LocatorEventListener l)
  {
    locatorListeners.remove(l);
  }

  public void fireInternalFrameClosed()
  {
    for (int i=0; i<locatorListeners.size(); i++)
    {
      LocatorEventListener l = locatorListeners.get(i);
      l.internalFrameClosed();
    }
  }
}
