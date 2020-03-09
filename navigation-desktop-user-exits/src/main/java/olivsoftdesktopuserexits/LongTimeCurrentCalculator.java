package olivsoftdesktopuserexits;

import astro.calc.GeoPoint;
import astro.calc.GreatCircle;

import chart.components.util.MercatorUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.UTCDate;
import ocss.nmea.parser.UTCHolder;
import ocss.nmea.parser.UTCTime;

import olivsoftdesktop.DesktopUserExitInterface;

/*
 * Use it with -ue:olivsoftdesktopuserexits.LongTimeCurrentCalculator
 * -Dbuffer.length buffer length in ms (default 600000, 10 minutes)
 */
public class LongTimeCurrentCalculator
  implements DesktopUserExitInterface
{
  private final static boolean DEBUG = "true".equals(System.getProperty("current.verbose", "false"));

  private Thread watcher = null;
  private boolean keepWatching = true;
  private long betweenLoops = 1000L; // 1 sec

  // Time, Position, CMG, BSP.
  private List<TimeCurrent> timeCurrent = new ArrayList<TimeCurrent>();
  private List<UTCHolder> timeBuffer    = new ArrayList<UTCHolder>();
  private List<GeoPos> positionBuffer   = new ArrayList<GeoPos>();
  private List<Angle360> cmgBuffer      = new ArrayList<Angle360>();
  private List<Angle360> hdgBuffer      = new ArrayList<Angle360>();
  private List<Speed> bspBuffer         = new ArrayList<Speed>();

  private GeoPoint[] groundData = null;
  private GeoPoint[] drData     = null;
  
  // buffer.length in milliseconds
  private long bufferLength = Long.parseLong(System.getProperty("buffer.length", "600000")); // Default 10 minutes

  public LongTimeCurrentCalculator()
  {
    super();
  }

  @Override
  public void start()
  {
    System.out.println("Method 'start':" + this.getClass().getName() + " User exit is starting...");
    final long _betweenLoops = betweenLoops;
    watcher = new Thread("CurrentCalculatorWatcher")
      {
        private final long BETWEEN_LOOPS = _betweenLoops;
        private long waitTime = BETWEEN_LOOPS;
        public void run()
        {
          this.setPriority(Thread.MIN_PRIORITY);
          while (keepWatching)
          {
            waitTime = BETWEEN_LOOPS;
            NMEADataCache cache = NMEAContext.getInstance().getCache();
            if (cache != null)
            {
              if (DEBUG)
                System.out.println("There is a cache...");
              try 
              { 
          //    synchronized (cache)
                {
    //            long time       = new Date().getTime();
                  Object ot = /*(UTCDate)*/cache.get(NMEADataCache.GPS_DATE_TIME);
                  if (ot == null)
                  {
                    ot = /*(UTCTime)*/cache.get(NMEADataCache.GPS_TIME);
                    if (DEBUG) System.out.println("Time from NMEADataCache.GPS_TIME");
                  }
                  else if (DEBUG)
                    System.out.println("Time from NMEADataCache.GPS_DATE_TIME");
                    
                  UTCHolder utcDate = null;
                  if (ot instanceof UTCDate)
                    utcDate = new UTCHolder((UTCDate)ot);
                  else
                    utcDate = new UTCHolder((UTCTime)ot);
                  Angle360 cmg    = (Angle360)cache.get(NMEADataCache.CMG); 
                  GeoPos position = (GeoPos)cache.get(NMEADataCache.POSITION);
                  Speed bsp       = (Speed)cache.get(NMEADataCache.BSP); 
                  Angle360 hdg    = (Angle360)cache.get(NMEADataCache.HDG_TRUE); 
                  // From a file: reset?
              //            if (timeBuffer.size() > 1 && ((timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() > utcDate.getValue().getTime())))
                  if (timeBuffer != null &&
                      timeBuffer.size() > 1 && 
                      timeBuffer.get(timeBuffer.size() - 1) != null && 
                      !timeBuffer.get(timeBuffer.size() - 1).isNull() && 
                      utcDate != null && 
                      !utcDate.isNull() && 
                      utcDate.getValue() != null &&
                      ((timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() - utcDate.getValue().getTime()) > 1000 ))
                  {
                    // Buffer Reset
              //    System.out.println("== Reseting data buffers: last date in buffer=[" + SDF2.format(timeBuffer.get(timeBuffer.size() - 1).getValue()) + "] > current Date=[" + SDF2.format(utcDate.getValue()) + "]");
                    resetDataBuffers();
                  }
                  
                  if (timeBuffer != null && 
                      utcDate != null && 
                      !utcDate.isNull() && 
                      utcDate.getValue() != null &&
                      (timeBuffer.size() == 0 || 
                       (timeBuffer.size() > 0 && 
                        timeBuffer.get(timeBuffer.size() - 1).getValue() != null && 
                        (timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() < utcDate.getValue().getTime()))))
                  {
                    if (utcDate != null && cmg != null && position != null && bsp != null && hdg != null)
                    {
                      if (timeBuffer.size() > 0)
                      {
                        UTCHolder oldest = timeBuffer.get(0);
                        boolean keepGoing = true;
                        
                        while (keepGoing && oldest.getValue().getTime() < (utcDate.getValue().getTime() - bufferLength))
                        {
                          timeBuffer.remove(0);
                          positionBuffer.remove(0);
                          cmgBuffer.remove(0);
                          bspBuffer.remove(0);
                          hdgBuffer.remove(0);
  
                          if (timeBuffer.size() > 0)
                            oldest = timeBuffer.get(0);
                          else
                            keepGoing = false;
                        }
  //                      if (timeBuffer.size() > 0)
  //                      {  
  //                        fromLabel.setText(SDF.format(oldest.getValue()));
  //                        toLabel.setText(SDF.format(utcDate.getValue()));
  //                      }
                      }
                      else
                      {
                        // When reseting a simulation file
              //                  System.out.println("--> Timebuffer is empty");
              //                  resetDataBuffers();
  //                      fromLabel.setText(" - ");
  //                      toLabel.setText(" - ");
                      }
                      
                      timeBuffer.add(utcDate);
                      positionBuffer.add(position);
              //                System.out.println("Adding position:" + position.toString());
                      cmgBuffer.add(cmg);
                      bspBuffer.add(bsp);
                      hdgBuffer.add(hdg);
                      groundData = new GeoPoint[positionBuffer.size()];
                      int index = 0;
                      for (GeoPos gp : positionBuffer)
                      {
                        groundData[index++] = new GeoPoint(gp.lat, gp.lng);
                      }
                      index = 0;
                      drData     = new GeoPoint[positionBuffer.size()];
                      GeoPos drPos = positionBuffer.get(0);
                      int size = positionBuffer.size();
                      for (int i=0; i<size; i++)
                      {
                        if (i > 0)
                        {
                          long timeInterval = timeBuffer.get(i).getValue().getTime() - timeBuffer.get(i-1).getValue().getTime();
                          double bspeed = bspBuffer.get(i).getDoubleValue();
              //                    System.out.println("-- TimeInterval:" + timeInterval + ", bsp:" + bspeed);
                          if (bspeed > 0)
                          {
                            double dist = bspeed * ((double)timeInterval / (double)3600000L); // in minutes (miles)
                            double rv   = cmgBuffer.get(i - 1).getValue();
              //                      System.out.println("** In " + timeInterval + " ms, at " + bspeed + " kts, from " + drPos.toString() + " dist:" + dist + ", hdg:" + hdg + "... ");
                            if (dist > 0)
                            {
                              GeoPoint pt = MercatorUtil.deadReckoning(drPos.lat, drPos.lng, dist, rv);                      
              //                        System.out.println("In " + timeInterval + " ms, from " + drPos.toString() + " dist:" + dist + ", hdg:" + hdg + ", ends up " + pt.toString());
                              drPos = new GeoPos(pt.getL(), pt.getG());
                            }
              //            else
              //              System.out.println("** dist : 0");
                          }
              //          else
              //            System.out.println("-- speed : 0");
                        } 
                        if (false)
                        {
                          if (i == 0)
                            System.out.println("-----------------------");
                          System.out.println("Adding to drData (" + i + ") :" + drPos.toString());
                        }
                        drData[i] = new GeoPoint(drPos.lat, drPos.lng);
                      }
                  //  setBoundaries();
                  //  repaint();
                      GeoPoint geoFrom = new GeoPoint(Math.toRadians(drData[drData.length - 1].getL()),         
                                                      Math.toRadians(drData[drData.length - 1].getG())); 
                      GeoPoint geoTo   = new GeoPoint(Math.toRadians(groundData[groundData.length - 1].getL()), 
                                                      Math.toRadians(groundData[groundData.length - 1].getG())); 
                      double dist = GreatCircle.calculateRhumLineDistance(geoFrom, geoTo);
                      double dir  = Math.toDegrees(GreatCircle.calculateRhumLineRoute(geoFrom, geoTo));
                      double hourRatio = (double)(timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() - timeBuffer.get(0).getValue().getTime()) / (double)3600000L;
                      double speed = dist / hourRatio;
                      timeCurrent.add(new TimeCurrent(timeBuffer.get(timeBuffer.size() - 1).getValue().getTime(), speed, dir));
                      // trim current buffer
                      long oldest = timeCurrent.get(0).getTime();
                      boolean keepGoing = true;          
                      while (keepGoing && oldest < (timeCurrent.get(timeCurrent.size() - 1).getTime() - bufferLength))
                      {
                        timeCurrent.remove(0);
                        if (timeBuffer.size() > 0)
                          oldest = timeCurrent.get(0).getTime();
                        else
                          keepGoing = false;
                      }
            //        System.out.println("Current Buffer [" + (bufferLength / 1000) + "] = " + timeCurrent.size() + " element(s)");
            //        System.out.println("-- Speed:" + speed + " (" + dist + " nm in " + hourRatio + " hour(s).)");
                      // Inject in the cache
               //     System.out.println("Current display on " + bufferLength + " ms :" + NMEAContext.DF3.format(dir) + "\272 @" + NMEAContext.DF22.format(speed) + " kts");
                   // NMEAContext.getInstance().getCache().put(match.key, new Angle180EW(Double.parseDouble(str)));
                   /* Map<Long, NMEADataCache.CurrentDefinition> currentMap = */
                      if (DEBUG)
                        System.out.println("Inserting Current: on:" + bufferLength + " ms, " + speed + " kts, dir:" + dir);                      
                      
                   // ((Map<Long, NMEADataCache.CurrentDefinition>)NMEAContext.getInstance().getCache().get(NMEADataCache.CALCULATED_CURRENT)).put(bufferLength, new NMEADataCache.CurrentDefinition(bufferLength, new Speed(speed), new Angle360(dir)));
                      ((Map<Long, NMEADataCache.CurrentDefinition>)NMEAContext.getInstance().getCache().get(NMEADataCache.CALCULATED_CURRENT)).put(bufferLength, new NMEADataCache.CurrentDefinition(bufferLength, new Speed(speed), new Angle360(dir)));
                      
                      if (DEBUG)
                      {
                        Map<Long, NMEADataCache.CurrentDefinition> map = (Map<Long, NMEADataCache.CurrentDefinition>)NMEAContext.getInstance().getCache().get(NMEADataCache.CALCULATED_CURRENT);
                        System.out.println("Calculated Current Map:" + map.size() + " entry(ies)");
                      }
                    }
                  }
                  else if (DEBUG)
                  {
                //  if (!utcDate.isNull() && (timeBuffer.size() == 0 || (timeBuffer.size() > 0 && (timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() < utcDate.getValue().getTime()))))
                    System.out.println("utcDate is " + (utcDate == null || utcDate.isNull()?"":"not ") + "null");    
                    System.out.println("timeBuffer.size() = " + timeBuffer.size());
                    System.out.println("utcDate        :" + (utcDate.isNull()?"":new Date(utcDate.getValue().getTime()).toString()));
                    System.out.println("last timeBuffer:" + (timeBuffer.size() > 0?new Date(timeBuffer.get(timeBuffer.size() - 1).getValue().getTime()).toString():"none"));
                    try
                    {
                      if (timeBuffer.size() > 0)
                        System.out.println("-> " + ((timeBuffer.get(timeBuffer.size() - 1).getValue().getTime() < utcDate.getValue().getTime()) ? "true":"false"));
                    }
                    catch (Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  }
                }
              }
              catch (Exception ex) 
              {
                ex.printStackTrace();
              }
            }
            else
              System.out.println("... No cache yet");
            synchronized (this)
            {
              if (DEBUG)
                System.out.println("  ...User exit going to wait, at " + new Date().toString() + " (will wait for " + (waitTime / 1000) + " s)");
              try { wait(waitTime); } 
              catch (InterruptedException ie)
              {
                System.out.println("Told to stop!");
                keepWatching = false;
              }
            }
          }
          System.out.println("Stop waiting.");
        }
      };
    keepWatching = true;
    watcher.start();
  }

  private void resetDataBuffers()
  {
    timeBuffer     = new ArrayList<UTCHolder>();
    positionBuffer = new ArrayList<GeoPos>();
    cmgBuffer      = new ArrayList<Angle360>();
    hdgBuffer      = new ArrayList<Angle360>();
    bspBuffer      = new ArrayList<Speed>();
    timeCurrent    = new ArrayList<TimeCurrent>();
  }
  
  @Override
  public void stop()
  {
    System.out.println(this.getClass().getName() + " is terminating (" + System.currentTimeMillis() + ")");
    keepWatching = false;
    synchronized (watcher)
    {
      watcher.notify();
    }
  }

  @Override
  public void describe()
  {
    System.out.println("Calculates the current speed and direction within a given time interval.");
  }

  private static class TimeCurrent
  {
    private final long time; 
    private final double speed; 
    private final double dir;
   
    public TimeCurrent(long time, double speed, double dir)
    {
      this.time = time;
      this.speed = speed;
      this.dir = dir;
    }

    public long getTime()
    {
      return time;
    }

    public double getSpeed()
    {
      return speed;
    }

    public double getDir()
    {
      return dir;
    }
  }
}
