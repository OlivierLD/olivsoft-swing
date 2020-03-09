package sailfax;

import java.io.File;

import java.io.PrintWriter;

import java.net.URL;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XSLProcessor;
import oracle.xml.parser.v2.XSLStylesheet;

public class Utilities
{
  private static DOMParser parser = new DOMParser();
  
  public static void xslTransform(String dataIn, String xsl, String dataOut) throws Exception
  {
    URL xslURL = new File(xsl).toURI().toURL();
//  System.out.println("Transforming using " + xslURL.toString()); 
    parser.parse(xslURL);
    XMLDocument xsldoc = parser.getDocument();           
    
    // instantiate a stylesheet
    XSLProcessor processor = new XSLProcessor();
    processor.setBaseURL(xslURL);
    XSLStylesheet xslss = processor.newXSLStylesheet(xsldoc);
    
    // display any warnings that may occur
    processor.showWarnings(true);
    processor.setErrorStream(System.err);
    
    parser.parse(new File(dataIn).toURI().toURL());
    XMLDocument xml = parser.getDocument();
    // Process XSL    
    PrintWriter pw = new PrintWriter(new File(dataOut));
//  processor.setParam("xmlnx:url", "prm1", "value1");
    processor.processXSL(xslss, xml, pw);    
    pw.close();
  }

  public static double getDir(float x, float y)
  {
    double dir = 0.0D;
    if (y != 0)
      dir = Math.toDegrees(Math.atan((double) x / (double) y));
    if (x <= 0 || y <= 0)
    {
      if (x > 0 && y < 0)
        dir += 180D;
      else if (x < 0 && y > 0)
        dir += 360D;
      else if (x < 0 && y < 0)
        dir += 180D;
      else if (x == 0)
      {
        if (y > 0)
          dir = 0.0D;
        else
          dir = 180D;
      }
      else if (y == 0)
      {
        if (x > 0)
          dir = 90D;
        else
          dir = 270D;
      }
    }
    dir += 180D;
    while (dir >= 360D)
      dir -= 360D;
    return dir;
  }

}
