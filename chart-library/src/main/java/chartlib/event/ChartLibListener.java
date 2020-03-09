package chartlib.event;

import java.util.EventListener;

public abstract class ChartLibListener implements EventListener 
{
  public void dataChanged(String[] newProviders) {}
  public void chartsSelected(int[] ia) {}
  
  public void internalFrameClosed() {}
}
