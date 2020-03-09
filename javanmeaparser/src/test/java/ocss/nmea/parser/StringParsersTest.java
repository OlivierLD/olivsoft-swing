package ocss.nmea.parser;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StringParsersTest
{
  public StringParsersTest()
  {
  }

  /**
   * @see StringParsers#parseRMC(String)
   */
  @Test
  public void testParseRMC()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

    String str = "$IIRMC,220526.00,A,3754.34,N,12223.20,W,3.90,250,,015,E,N*07";

    RMC rmc = StringParsers.parseRMC(str);
//  Date date = rmc.getRmcDate();
    Date time = rmc.getRmcTime();
    GeoPos gp = rmc.getGp();
    double cog = rmc.getCog();
    double sog = rmc.getSog();

//    System.out.println("Date:" + date);
//    System.out.println("Time:" + time + ", [" + sdf.format(time) + "]");
//    System.out.println("Pos:" + gp.toString() + "(" + gp.lat + ", " + gp.lng + ")");
//    System.out.println("COG:" + cog);
//    System.out.println("SOG:" + sog);

    Assertions.assertTrue(cog == 250, "Invalid COG");
    Assertions.assertTrue(sog == 3.9, "Invalid SOG");
    Assertions.assertTrue("22:05:26".equals(sdf.format(time)), "Invalid Time");
    Assertions.assertTrue((gp.lat == 37.90566666666667 && gp.lng == -122.38666666666667), "Invalid Position");
  }

  /**
   * @see StringParsers#durationToDate(String)
   */
  @Test
  public void testDurationToDate()
  {
    String tz = null; // TimeZone.getDefault().getID();
    String str = "2006-05-05T17:35:48.000Z";
    long ld = StringParsers.durationToDate(str, tz);
//  System.out.println(str + " => " + SDF2.format(new Date(ld)) + ", ld:" + ld + ", Tz:" + tz);
    Assertions.assertTrue((ld / 1000) == 1146850548L, "Bad duration (" + Long.toString(ld / 1000) + ") instead of 1146850548. Tz:" + tz);
  }

  /**
   * @see StringParsers#validCheckSum(String)
   */
  @Test
  public void testValidCheckSum()
  {
    String str = "$IIRMC,220526.00,A,3754.34,N,12223.20,W,3.90,250,,015,E,N*07";
    boolean b = StringParsers.validCheckSum(str);
    Assertions.assertTrue(b, str + " is invalid");
  }

//  public static void main(String[] args)
//  {
//    StringParsersTest spt = new StringParsersTest();
//    spt.testDurationToDate();
//    spt.testParseRMC();
//  }
}
