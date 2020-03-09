package user.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeomUtilTest
{
  public GeomUtilTest()
  {
  }

  /**
   * @see GeomUtil#getDir(float,float)
   */
  @Test
  public void testGetDirDueN()
  {
    double d = GeomUtil.getDir(0f, 10f);
    Assertions.assertTrue(d == 0d, "(0f, 10f) should return N, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirDueS()
  {
    double d = GeomUtil.getDir(0f, -10f);
    Assertions.assertTrue(d == 180d, "(0f, -10f) should return S, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirDueE()
  {
    double d = GeomUtil.getDir(10f, 0f);
    Assertions.assertTrue(d == 90d, "(10f, 0f) should return E, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirDueW()
  {
    double d = GeomUtil.getDir(-10f, 0f);
    Assertions.assertTrue(d == 270d, "(-10f, 0f) should return W, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirNE()
  {
    double d = GeomUtil.getDir(10f, 10f);
    Assertions.assertTrue(d == 45d, "(10f, 10f) should return NE, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirSE()
  {
    double d = GeomUtil.getDir(10f, -10f);
    Assertions.assertTrue(d == 135d, "(10f, -10f) should return SE, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirSW()
  {
    double d = GeomUtil.getDir(-10f, -10f);
    Assertions.assertTrue(d == 225d, "(-10f, -10f) should return SW, returned " + Double.toString(d) + " instead");
  }

  @Test
  public void testGetDirNw()
  {
    double d = GeomUtil.getDir(-10f, 10f);
    Assertions.assertTrue(d == 315d, "(-10f, 10f) should return NW, returned " + Double.toString(d) + " instead");
  }
}
