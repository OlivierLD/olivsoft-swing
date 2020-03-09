package olivsoftdesktop.utils;

import astro.calc.GeoPoint;
import chart.components.ui.ChartPanel;
import chart.components.ui.ChartPanelInterface;
import user.util.GeomUtil;

import java.awt.*;

public class DayLight
{
  /**
   * Draws the "daylight" of any celectial body, identified by its position (gha/dec)
   * @param gha GHA of the body (in degrees, signed)
   * @param dec Declination of the body (in degrees, signed)
   * @param chartPanel The chartPanel, (sphere)
   * @param gr
   * @param currPos Current position (in degrees), used to calculate the LHA of the body.
   */
  public static void displayDayLight(double gha, double dec, ChartPanel chartPanel, Graphics gr, GeoPoint currPos)
  {
    boolean debug = false;
    // Day light
    double dayCenterLongitude = 0;
    double dayCenterLatitude = 0;
    if (gha < 180)
      dayCenterLongitude = -gha;
    if (gha >= 180)
      dayCenterLongitude = 360 - gha;
    dayCenterLatitude = dec;

    GeoPoint sunPos = new GeoPoint(dayCenterLatitude, dayCenterLongitude);
    //    System.out.println("Sun Position:" + sunPos.toString());
    // the border of the night
    int VISIBLE = 1;
    int INVISIBLE = 2;
    int visibility = 0;
    int firstVisible = -1;
    // Find the first visible point of the night limb
    for (int i=0; i<360; i++) {
      GeoPoint nightGp = deadReckoning(sunPos, 90 * 60, i);
      double lng = nightGp.getG();
      if (lng < -180)
        lng += 360;
      if (lng > 180)
        lng -= 360;

      int localVisibility = isVisible(chartPanel, nightGp.getL(), lng) ? VISIBLE : INVISIBLE;
      if (visibility == INVISIBLE && localVisibility == VISIBLE) // Just became visible
      {
        firstVisible = i;
        break;
      }
      visibility = localVisibility;
    }
    //  System.out.println("First visible point of the night limb:" + firstVisible);

    Polygon night = new Polygon();
    for (int i=firstVisible; i<firstVisible+360; i++)
    {
      GeoPoint nightGp = deadReckoning(sunPos, 90 * 60, i);
      double lng = nightGp.getG();
      if (lng < -180)
        lng += 360;
      if (lng > 180)
        lng -= 360;
      Point pp = chartPanel.getPanelPoint(nightGp);
      if (isVisible(chartPanel, nightGp.getL(), lng))
        night.addPoint(pp.x, pp.y);
    }
    Point firstPoint = new Point(night.xpoints[0], night.ypoints[0]);
    Point lastPoint  = new Point(night.xpoints[night.npoints - 1], night.ypoints[night.npoints - 1]);
    // We are at the bottom
    Point center = chartPanel.getPanelPoint(currPos);
    double startAngle   = GeomUtil.getDir(lastPoint.x - center.x, center.y - lastPoint.y),
            arrivalAngle = GeomUtil.getDir(firstPoint.x - center.x, center.y - firstPoint.y);

    if (debug)
    {
      gr.setColor(Color.yellow);
      Point prev = null;
      for (int i=0; i<night.npoints; i++) {
        if (prev != null) {
          gr.drawLine(prev.x, prev.y, night.xpoints[i], night.ypoints[i]);
        }
        prev = new Point(night.xpoints[i], night.ypoints[i]);
      }

      gr.drawString("Start (" + (int)startAngle + "\272)", lastPoint.x, lastPoint.y);
      gr.drawString("Finish (" + (int)arrivalAngle + "\272)", firstPoint.x, firstPoint.y);
    }
    int bottom = night.npoints;

    int incr = 0, firstBoundary = 0, lastBoundary = 0;
    // For the direction (esat/west), see LHA, instead sunAlt
    double lhaSun = gha + currPos.getG();
    while (lhaSun < 0)
      lhaSun += 360;
    while (lhaSun > 360)
      lhaSun -= 360;
    if (debug)
      System.out.println("Sun LHA:" + lhaSun);

    boolean clockwise = true;  // From the bottom
    if (lhaSun < 90 || lhaSun > 270) // Observer in the sun
    {
      clockwise = (lhaSun > 270);
    } else {  // Observer in the dark
      clockwise = (lhaSun > 180);
    }
    // start should be at the bottom
    //    if (Math.cos(Math.toRadians(startAngle)) > 0 && Math.cos(Math.toRadians(arrivalAngle)) < 0)
    if ((startAngle > 270 || startAngle < 90) && arrivalAngle > 90 && arrivalAngle < 270)
    {
      clockwise = !clockwise;
//          System.out.println("Inverting.");
    }
    //  if (sunAlt > 0) // Daylight, follow the limb, from the bottom toward the west (clockwise)
//          if (lhaSun > 90 && lhaSun < 270) // observer in the dark
    if (clockwise)
    {
      if (debug)
        System.out.println(String.format("LHA Sun: %d. Following sphere limb, clockwise from %d to %d", (int)lhaSun, (int)Math.ceil(startAngle), (int)Math.floor(arrivalAngle)));
      incr = 1;
      firstBoundary = (int)Math.ceil(startAngle);
      lastBoundary = (int)Math.floor(arrivalAngle);
      while (lastBoundary < firstBoundary)
        lastBoundary += 360;
    }
    else  // follow the limb, from the bottom toward the east (counter-clockwise)
    {
      if (debug)
        System.out.println(String.format("LHA Sun: %d. Following sphere limb, counter-clockwise from %d to %d", (int)lhaSun, (int)Math.floor(startAngle), (int)Math.ceil(arrivalAngle)));
      incr = -1;
      firstBoundary = (int)Math.floor(startAngle);
      lastBoundary = (int)Math.ceil(arrivalAngle);
      while (lastBoundary > firstBoundary)
        firstBoundary += 360;
    }
    for (int i=firstBoundary; (incr>0 && i<=lastBoundary) || (incr<0 && i>=lastBoundary); i+=incr)
    {
      GeoPoint earthCirc = deadReckoning(currPos, 90 * 60, i);
      //            double lng = earthCirc.getG();
      //            if (lng < -180)
      //              lng += 360;
      //            if (lng > 180)
      //              lng -= 360;
      Point limbPt = chartPanel.getPanelPoint(earthCirc);
      night.addPoint(limbPt.x, limbPt.y);
    }
    if (debug)
    {
      gr.setColor(Color.red);
      Point prev = null;
      for (int i=bottom; i<night.npoints; i++) {
        if (prev != null) {
          gr.drawLine(prev.x, prev.y, night.xpoints[i], night.ypoints[i]);
        }
        prev = new Point(night.xpoints[i], night.ypoints[i]);
      }
    }
    // Fill the night polygon
    if (true)
    {
      gr.setColor(Color.darkGray);
      ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
      gr.fillPolygon(night);
      ((Graphics2D)gr).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

  }

  /**
   * Spherical Model used here
   *
   * @param start in degrees
   * @param dist in nautical miles
   * @param bearing in degrees
   * @return
   */
  private static GeoPoint deadReckoning(GeoPoint start, double dist, double bearing)
  {
    GeoPoint reached = null;
    double radianDistance = Math.toRadians(dist / 60d);
    double finalLat = (Math.asin((Math.sin(Math.toRadians(start.getL())) * Math.cos(radianDistance)) +
                                         (Math.cos(Math.toRadians(start.getL())) * Math.sin(radianDistance) * Math.cos(Math.toRadians(bearing)))));
    double finalLng = Math.toRadians(start.getG()) + Math.atan2(Math.sin(Math.toRadians(bearing)) * Math.sin(radianDistance) * Math.cos(Math.toRadians(start.getL())),
                                                                Math.cos(radianDistance) - Math.sin(Math.toRadians(start.getL())) * Math.sin(finalLat));
    finalLat = Math.toDegrees(finalLat);
    finalLng = Math.toDegrees(finalLng);

    reached = new GeoPoint(finalLat, finalLng);
    return reached;
  }

  public static boolean isVisible(ChartPanel chartPanel, double l, double g)
  {
    boolean plot = true;
    if (chartPanel.getProjection() == ChartPanelInterface.GLOBE_VIEW)
    {
      if (!chartPanel.isTransparentGlobe() && chartPanel.isBehind(l, g - chartPanel.getGlobeViewLngOffset()))
        plot = false;
    }
    return plot;
  }

}
