package sailfax.ctx;

import java.util.ArrayList;

import java.util.List;

import sailfax.event.SailfaxEventListener;

public class SailFaxContext
{
    private static SailFaxContext applicationContext = null;  
    private transient List<SailfaxEventListener> sailFaxListeners = null;
    
    private SailFaxContext()
    {
      sailFaxListeners = new ArrayList<SailfaxEventListener>(2); // 2: Initial Capacity
    }
      
    public static synchronized SailFaxContext getInstance()
    {
      if (applicationContext == null)
        applicationContext = new SailFaxContext();
      return applicationContext;
    }
      
    public List<SailfaxEventListener> getListeners()
    {
      return sailFaxListeners;
    }    

    public synchronized void addSailFaxListener(SailfaxEventListener l)
    {
      if (!sailFaxListeners.contains(l))
      {
        sailFaxListeners.add(l);
      }
    }

    public synchronized void removeSailFaxListener(SailfaxEventListener l)
    {
      sailFaxListeners.remove(l);
    }

    public void fireInternalFrameClosed()
    {
      for (int i=0; i<sailFaxListeners.size(); i++)
      {
        SailfaxEventListener l = sailFaxListeners.get(i);
        l.internalFrameClosed();
      }
    }
    
}
