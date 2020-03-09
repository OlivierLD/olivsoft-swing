package tools.util;

import coreutilities.Utilities;

import java.awt.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import tools.components.Latitude;
import tools.components.Longitude;

public class StaticUtil 
{
  /**
   * Parses the double accordingly to the local format
   * Like 123.45 for US ans 123,45 for France
   * @param str
   * @return
   * @throws Exception
   */
  public static double parseDouble(String str) throws Exception
  {
    double result = Double.MIN_VALUE;
    try
    {
      result = Double.parseDouble(str);
    }
    catch (NumberFormatException nfe)
    {
      try 
      {
        Number number = NumberFormat.getNumberInstance(Locale.getDefault()).parse(str);
        result = number.doubleValue();      
      } 
      catch (ParseException e) 
      {
        throw e;
      }
    }
    return result;
  }

  public static void showGoogleMap(Object[][] data)
  {
    try 
    { 
      //  1, Integer, chartno
      //  2, String, title
      //  3, Latitude, top left
      //  4, Longitude, top left
      //  5, Latitude, bottom right
      //  6, Longitude, bottom right
      //  7, String, provider
      //  8, Short, year
      //  9, Short, nbcopies
      // 10, String, comment
      BufferedWriter bw = new BufferedWriter(new FileWriter("chartdata.js"));
      // Calculate chart center
      double maxTop    = -Double.MAX_VALUE;
      double minBottom =  Double.MAX_VALUE;
      double maxRight  = -Double.MAX_VALUE;
      double minLeft   =  Double.MAX_VALUE;
      
      for (int i=0; i<data.length; i++)
      {
        if (((Latitude) data[i][2]).getValue() > maxTop)
          maxTop = ((Latitude) data[i][2]).getValue();
        if (((Latitude) data[i][4]).getValue() < minBottom)
          minBottom = ((Latitude) data[i][4]).getValue();
        double _gLeft  = ((Longitude) data[i][3]).getValue();
        double _gRight = ((Longitude) data[i][5]).getValue();
        if (sign(_gLeft) != sign(_gRight))
          _gLeft -= 360;
        if (_gRight > maxRight)
          maxRight = _gRight;
        if (_gLeft < minLeft)
          minLeft = _gLeft;
      }      
      double centerLat = (maxTop + minBottom) / 2D;
      double centerLng = (maxRight + minLeft) / 2D;
      
      bw.write("centerlatitude=" + Double.toString(centerLat) + ";\n");
      bw.write("centerlongitude=" + Double.toString(centerLng) + ";\n\n");
      // Charts polygons
      bw.write("var chart = new Array(\n");
      
      for (int i=0; i<data.length; i++)
      {
        Latitude topLeftL     = (Latitude) data[i][2];
        Longitude topLeftG     = (Longitude) data[i][3];
        Latitude bottomRightL = (Latitude) data[i][4];
        Longitude bottomRightG = (Longitude) data[i][5];
        bw.write("{tll:" + Double.toString(topLeftL.getValue()) + ",\n");
        bw.write(" tlg:" + Double.toString(topLeftG.getValue()) + ",\n");
        bw.write(" brl:" + Double.toString(bottomRightL.getValue()) + ",\n");
        bw.write(" brg:" + Double.toString(bottomRightG.getValue()) + "}\n");
        if (i < (data.length - 1))
          bw.write(",\n");
      }
      bw.write(");\n");
      bw.flush();
      bw.close();
      
      System.out.println("Opening googlemap.html from " + System.getProperty("user.dir"));
      Utilities.openInBrowser("googlemap.html");
    } 
    catch (Exception ex) 
    { 
      System.err.println("Ooops... In " + System.getProperty("user.dir"));
      ex.printStackTrace(); 
    }
  }  
  
  private static int sign(double d)
  {
    int s = 0;
    if (d > 0.0D)
      s = 1;
    if (d < 0.0D)
      s = -1;
    return s;
  }

}