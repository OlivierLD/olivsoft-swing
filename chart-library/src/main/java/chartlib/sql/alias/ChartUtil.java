package chartlib.sql.alias;
import chart.components.util.MercatorUtil;

public class ChartUtil 
{
  public static boolean inTrack(double fromL,
                                double fromG,
                                double toL,
                                double toG,
                                double topLeftL,
                                double topLeftG,
                                double bottomRightL,
                                double bottomRightG)
  {
    boolean bool = false;

    /** TODO fix that, the "Looping too much". Pilot charts for example */
//   System.out.println("Fixing : tlL=" + topLeftL + 
//                             ", tlG=" + topLeftG +
//                             ", brL=" + bottomRightL +
//                             ", brG=" + bottomRightG);
    int nbloop = 0;
    while (topLeftG > bottomRightG && (sign(topLeftG) != sign(bottomRightG) || Math.min(topLeftG, bottomRightG) < 180))
    {
      fromG += 180.0;     
      if (fromG > 360) fromG -= 360;
      toG += 180.0;
      if (toG > 360) toG -= 360;
      topLeftG += 180.0;
      if (topLeftG > 360) topLeftG -= 360;
      bottomRightG += 180.0;
      if (bottomRightG > 360) bottomRightG -= 360;
      if (nbloop++ > 10)
      {
        System.out.println("Looping too much");
        break;
      }
    }
    double _fL = incLat(fromL);
    double _fG = fromG;
    double _tL = incLat(toL);
    double _tG = toG;
    
    // Get the route equation y = ax + b, L = aG + b, L = f(G).
    double a = (_tL - _fL) / (_tG - _fG);
    double b = _fL - (a * _fG);
    
//    System.out.println("From:" + _fL + "/" + _fG + ", calcL:" + ((a * _fG) + b) + ", calcG:" + ((_fL - b) / a));
//    System.out.println("To  :" + _tL + "/" + _tG + ", calcL:" + ((a * _tG) + b) + ", calcG:" + ((_tL - b) / a));
    
    // Valeur de l'equation en bas de la carte
    double imgLeft  = (a * topLeftG) + b;
    // Valeur de l'equation en haut de la carte
    double imgRight = (a * bottomRightG) + b;
    
    double antTop    = Double.MIN_VALUE;
    double antBottom = Double.MIN_VALUE;
    // Reciproque x = (y-b)/a, G = (L-b)/a
    if (a != 0)
    {
      antTop    = (incLat(topLeftL) - b) / a;
      antBottom = (incLat(bottomRightL) - b) / a;
    }
    
//    System.out.println("Img Left:" + imgLeft);
//    System.out.println("Img Right:" + imgRight);
//    
//    System.out.println("AntTop   :" + antTop);
//    System.out.println("AntBottom:" + antBottom);
//    
//    System.out.println("Img(antTop)    = " + ((a * antTop) + b));
//    System.out.println("Img(antBottom) = " + ((a * antBottom) + b));
//    
//    System.out.println("Chart bottom:" + incLat(bottomRightL) + ", top:" + incLat(topLeftL));
//    System.out.println("Chart left  :" + topLeftG + ", right:" + bottomRightG);
    
    if ((imgLeft >= incLat(bottomRightL) && imgLeft <= incLat(topLeftL)) ||
        (imgRight >= incLat(bottomRightL) && imgRight <= incLat(topLeftL)))    
      bool = true;        
    
    if (!bool &&
        (a != 0 && ((antTop >= topLeftG && antTop <= bottomRightG) ||
                    (antBottom >= topLeftG && antBottom <= bottomRightG))))
      bool = true;
    
    if (!bool && // One (at least) extremity in the chart ?
        ((fromL < topLeftL && fromL > bottomRightL &&
          fromG > topLeftG && fromG < bottomRightG) ||
         (toL < topLeftL && toL > bottomRightL &&
          toG > topLeftG && toG < bottomRightG)))
      bool = true;

    if (bool && // Check the limits. You can be on the route and out of bounds
        (Math.max(fromL, toL) < bottomRightL ||
         Math.min(fromL, toL) > topLeftL ||
         Math.max(fromG, toG) < topLeftG ||
         Math.min(fromG, toG) > bottomRightG))
      bool = false;    
//    System.out.println("->" + bool);
    return bool;
  }
  
  private static double incLat(double l)
  {
    return MercatorUtil.getIncLat(l);
  }
  
  private static int sign(double d)
  {
    return (d<0.0?-1:1);
  }
  
  public static void main(String... args)
  {
    boolean b = inTrack(38.50, -124.0, 36.50, -122.0,
                        38.0833333, -123.5,
                        37.45, -122.41666);
    System.out.println(b);
    b = inTrack(37.50, -126.0, 38.25, -120.50,
                        38.0833333, -123.5,
                        37.45, -122.41666);
    System.out.println(b);
    b = inTrack(38.33, -123.5, 36.0, -122.0,
                        38.0833333, -123.5,
                        37.45, -122.41666);
    System.out.println(b);
    b = inTrack(/*from*/         38.33, -123.5, 
                /* to */         36.0, -122.0,
                /* top left */   73.0, 123.0,
                /* bottom right*/-4.0, -75.0);
    System.out.println(b);
    // Pilot Chart
    b = inTrack(/*from*/         38.33, -123.5, 
                /* to */         36.0, -122.0,
                /* top left */   73, 123,
                /* bottom right*/-4, -75);
    System.out.println(b);
    b = inTrack(/*from*/         38.33, -123.5, 
                /* to */         36.0, -122.0,
                /* top left */    -12, 176.5,
                /* bottom right*/-22.0, 168);
    System.out.println(b);
  }
}