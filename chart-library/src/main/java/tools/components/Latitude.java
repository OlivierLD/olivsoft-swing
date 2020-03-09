package tools.components;


public final class Latitude extends LatLong 
{
  public Latitude(String str) throws Exception
  {
    super(str, LatLong.LAT);
    if (this.getValue() > 90.0 || this.getValue() < -90.0)
      throw new Exception("Value too big for a latitude. [-90, 90]");
  }

  public Latitude(double d, int type) throws Exception
  {
    super(d, type);
    if (this.getValue() > 90.0 || this.getValue() < -90.0)
      throw new Exception("Value too big for a latitude. [-90, 90]");
  }
}