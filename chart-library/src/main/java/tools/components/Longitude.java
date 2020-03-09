package tools.components;

public final class Longitude extends LatLong 
{
  public Longitude(String str) throws Exception
  {
    super(str, LatLong.LONG);
    if (this.getValue() > 180.0 || this.getValue() < -180.0)
      throw new Exception("Value too big for a longitude. [-180, 180]");
  }

  public Longitude(double d, int type) throws Exception
  {
    super(d, type);
    if (this.getValue() > 180.0 || this.getValue() < -180.0)
      throw new Exception("Value too big for a longitude. [-180, 180]");
  }
}