package sailfax.chrono.sort;

public class SortAlgorithm 
{
  /**
   * When true stop sorting.
   */
  protected boolean stopRequested = false;
  /**
   * Stop sorting.
   */
  public void stop() 
  {
    stopRequested = true;
  }

  /**
   * Initialize
   */
  public void init() 
  {
    stopRequested = false;
  }

  /**
   * This method will be called to
   * sort an array of integers.
   */
  void sort(long a[]) throws Exception 
  { }
}
