package sailfax.generation.contracts;

public interface DisplayMapRequestor
{
  public void resetAllRequests();
  public void displayChart(String station, String name, double top, double bottom, double left, double right);
  public void switchToChartPanel();
}
