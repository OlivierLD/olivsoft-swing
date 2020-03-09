package nightsky.full;


import app.almanac.AlmanacComputer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.TimeZone;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import nauticalalmanac.Context;

import nightsky.NightPanelHolder;
import nightsky.NightSkyPanel;
import nightsky.NightSkyPanelWithConstellations;

import nightsky.ctx.SkyMapContext;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.UTCDate;


public class DualInternalFrame
  extends JInternalFrame
{
  @SuppressWarnings("compatibility:1361712621122706791")
  public final static long serialVersionUID = 1L;
  
  private NightPanelHolder nphOne = null;
  private NightPanelHolder nphTwo = null;
  private JTabbedPane tabbedPane  = new JTabbedPane();
  
  private final static SimpleDateFormat SDF_UTC = new SimpleDateFormat("yyyy MMM dd HH:mm:ss 'UTC'");
//static { SDF_UTC.setTimeZone(TimeZone.getTimeZone("Etc/UTC")); }
  
  private final static String TITLE_RADICAL = "Dual Display";
  
  private transient NMEAReaderListener nmeaListener = null;
  
  public DualInternalFrame()
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    NightSkyPanel panelOne = new NightSkyPanelWithConstellations();
    NightSkyPanel panelTwo = new NightSkyPanelWithConstellations(NightSkyPanel.SKY_CHART_OPTION);
    nphOne = new NightPanelHolder(NightSkyPanel.STAR_FINDER_OPTION, panelOne, NightPanelHolder.WITH_CONSTELLATIONS);
    nphTwo = new NightPanelHolder(NightSkyPanel.SKY_CHART_OPTION, panelTwo, NightPanelHolder.WITH_CONSTELLATIONS);

    this.getContentPane().setLayout(new BorderLayout());
    int tab = 0;
    tabbedPane.add("Star Finder", nphOne);
    tabbedPane.setToolTipTextAt(tab, 
                                "<html>" +
                                "You are sitting at the center of the blue circle,<br>" +
                                "under the blue dot.<br>" +
                                "You are looking in the direction of the cardinal points." +
                                "</html>");
    tab++;
    tabbedPane.add("Sky Map",     nphTwo);
    tabbedPane.setToolTipTextAt(tab, 
                                "<html>" +
                                "You are sitting at the center of the blue circle,<br>" +
                                "under the blue dot.<br>" +
                                "<b>Place the chart over your head!</b><br>" +
                                "You are looking in the direction of the cardinal points." +
                                "</html>");
    this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    this.setSize(new Dimension(650, 650));
    this.setTitle(TITLE_RADICAL);
    this.addInternalFrameListener(new InternalFrameAdapter()
      {
        public void internalFrameClosed(InternalFrameEvent e)
        {
          this_internalFrameClosed(e);
        }
      });
    // NMEA Listener
    nmeaListener = new NMEAReaderListener("Sky", "SkyMap")
      {
        /**
         * On this event, activate the possibility to read from the NMEA Port.
         * If activated, send position to the sky panels.
         */
        @Override
        public void manageNMEAString(String string)
        {
//        super.manageNMEAString(string);
          // Activate the NMEA Choice if not there yet
//        System.out.println("From SkyMap Internal Frame: [" + string + "]");
          
          // If NMEA Stream chosen, send position to the sky panels
          // Read the cache to find the already calculated (parsed) position
          GeoPos gps = (GeoPos)NMEAContext.getInstance().getCache().get(NMEADataCache.POSITION, true);
          if (gps != null)
          {
//          System.out.println("Your fix:" + gps.toString());
            nphOne.setObserverLatitude(gps.lat);
            nphTwo.setObserverLatitude(gps.lat);
            
            UTCDate utcDate = (UTCDate)NMEAContext.getInstance().getCache().get(NMEADataCache.GPS_DATE_TIME, true);
            if (utcDate != null)
            {
              Calendar cal = GregorianCalendar.getInstance();
              cal.setTime(utcDate.getValue());
              cal.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
//            System.out.println("UTC Date is " + cal.getTime().toString());  
              int y  = cal.get(Calendar.YEAR);
              int m  = cal.get(Calendar.MONTH) + 1;
              int d  = cal.get(Calendar.DAY_OF_MONTH);
              int h  = cal.get(Calendar.HOUR_OF_DAY);
              int mi = cal.get(Calendar.MINUTE);
              int s  = cal.get(Calendar.SECOND);
              float deltaT = Float.parseFloat(System.getProperty("deltaT", "65.584"));
              AlmanacComputer.calculate(y, m, d, h, mi, s, deltaT); 
              // Calculate Aries LHA...
              double ghaAries = Context.GHAAtrue;
//            System.out.println("At " + SDF_UTC.format(utcDate.getValue()) + ", GHA Aries=" + ghaAries);
              double lhaAries = ghaAries + gps.lng;
              while (lhaAries < 0.0)
                lhaAries += 360.0;
              while (lhaAries > 360.0)
                lhaAries -= 360.0;
              nphOne.setLHAAries(lhaAries);
              nphTwo.setLHAAries(lhaAries);
              
              setTitle(TITLE_RADICAL + " Pos:" + gps.toString() + " LHA Aries:" + ((int)Math.round(lhaAries<0?360+lhaAries:lhaAries) + "\272") + ", " + SDF_UTC.format(utcDate.getValue()));
            }
          }
          else
            System.out.println("No position yet...");
        }
      };
    NMEAContext.getInstance().addNMEAReaderListener(nmeaListener);
  }

  private void this_internalFrameClosed(InternalFrameEvent e)
  {
    NMEAContext.getInstance().removeNMEAReaderListener(nmeaListener);
    SkyMapContext.getInstance().fireInternalFrameClosed();
//  SkyMapContext.getInstance().removeApplicationListener(sp.getStarFinderEventListener());
  }
}
