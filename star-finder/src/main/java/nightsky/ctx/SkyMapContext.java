package nightsky.ctx;

import java.util.ArrayList;
import java.util.List;

import oracle.xml.parser.v2.DOMParser;

public class SkyMapContext
{
  private static SkyMapContext context = null;
  private List<SkyMapEventListener> applicationListeners = null;
  private DOMParser parser = null;
  
  private SkyMapContext()
  {
    applicationListeners = new ArrayList<SkyMapEventListener>(2); // 2: Initial Capacity
    parser = new DOMParser();
  }
  
  public static synchronized SkyMapContext getInstance()
  {
    if (context == null)
      context = new SkyMapContext();
    return context;
  }
  
  public void release()
  {
    context = null;
    parser = null;
    System.gc();
  }

  public List<SkyMapEventListener> getListeners()
  {
    return applicationListeners;
  }
  
  public synchronized void addApplicationListener(SkyMapEventListener l)
  {
    if (!this.getListeners().contains(l))
    {      
      this.getListeners().add(l);
  //    System.out.println("Now having " + Integer.toString(this.getListeners().size()) + " listener(s)");
    }
  }

  public synchronized void removeApplicationListener(SkyMapEventListener l)
  {
    this.getListeners().remove(l);
  }
  
  public void fireInternalFrameClosed()
  {
    for (int i=0; i < this.getListeners().size(); i++)
    {
      SkyMapEventListener l = this.getListeners().get(i);
      l.internalFrameClosed();
    }    
  }    
  
  public DOMParser getParser()
  {
    return parser;
  }
}
