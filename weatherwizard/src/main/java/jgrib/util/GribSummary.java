/**
 * ===============================================================================
 * $Id: GribSummary.java,v 1.4 2006/07/25 13:44:57 frv_peg Exp $
 * ===============================================================================
 * JGRIB library  
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * Authors:
 * See AUTHORS file
 * ===============================================================================
 */
package jgrib.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;
import java.util.TreeSet;

import jgrib.GribFile;
import jgrib.GribPDSLevel;
import jgrib.GribPDSParamTable;
import jgrib.GribPDSParameter;
import jgrib.GribRecord;
import jgrib.GribRecordGDS;
import jgrib.GribRecordLight;
import jgrib.GribRecordPDS;

import jgrib.util.GribRecHeader;


/**
 * Created by IntelliJ IDEA.
 * User: torc
 * Date: Oct 16, 2003
 * Time: 2:12:06 PM
 * To change this template use Options | File Templates.
 */
public class GribSummary
{

	/**
	 * 
	 * @author torc
	 *
	 */
   private static class DateInfo
   {
	   /**
	    * Autogenerated doc
	    */
      Date mDmin;

	   /**
	    * Autogenerated doc
	    */      
      Date mDmax;
      
	   /**
	    * Autogenerated doc
	    */      
      int N = 0;

	   /**
	    * Autogenerated doc
	    */      
      Date mDLast;

	   /**
	    * Autogenerated doc
	    */     
      long mMinDelta;
      
	   /**
	    * Autogenerated doc
	    */      
      long mMaxDelta;

      /**
       * Autogenerated doc
       */
      public void reset()
      {
         N = 0;
      }

      /**
       * Autogenerated doc
       * @param d
       */
      public void add(Date d)
      {
         //String s = d.toString();
         if (N == 0)
         {
            mDLast = mDmin = mDmax = d;
         }
         else
         {
            if (mDmin.compareTo(d) > 0)
            {
               mDmin = d;
            }
            else if (mDmax.compareTo(d) < 0)
            {
               mDmax = d;
            }

            long delta = d.getTime() - mDLast.getTime();
            if (N == 1)
            {
               mMinDelta = mMaxDelta = delta;
            }
            else
            {
               if (mMinDelta > delta)
               {
                  mMinDelta = delta;
               }
               else if (mMaxDelta < delta)
               {
                  mMaxDelta = delta;
               }
            }
            mDLast = d;
         }
         N++;
      }


      /**
       * Autogenerated doc
       * @param msec
       * @return String 
       */
      private static String ms2str(long msec)
      {
         float s = msec / 1000;
         if (s < 1.0f)
         {
            return msec + "ms";
         }
         float m = s / 60;
         if (m < 1.0f)
         {
            return s + "sec";
         }
         float h = m / 60;
         if (h < 1.0f)
         {
            return m + "min";
         }
         float d = h / 24;
         if (d < 1.0f)
         {
            return h + "hr";
         }
         return d + "days";
      }

      
      /**
       * @see java.lang.Object#toString()
       */
    public String toString()
      {

         String str = " Dates(" + N + ")";
         if (N > 0)
         {
            if (N > 1)
            {
               if (mMinDelta == mMaxDelta)
               {
                  str += " delta[" + ms2str(mMinDelta) + "]";
               }
               else
               {
                  //str += mMinDelta  + "," +mMaxDelta + "\n";
                  str += " delta[" + ms2str(mMinDelta) + " - " +
                        ms2str(mMaxDelta) + "]";
               }
            }
            return str + ":\n       min " + mDmin + "\n       max " + mDmax;
         }
		return str;
      }

    
      /**
       * @see java.lang.Object#equals(java.lang.Object)
       */
    public boolean equals(Object o)
      {
         if (this == o)
         {
            return true;
         }
         if (!(o instanceof DateInfo))
         {
            return false;
         }

         final DateInfo dateInfo = (DateInfo) o;

         if (N != dateInfo.N)
         {
            return false;
         }
         if (mMaxDelta != dateInfo.mMaxDelta)
         {
            return false;
         }
         if (mMinDelta != dateInfo.mMinDelta)
         {
            return false;
         }
         if (mDmax != null ? !mDmax.equals(dateInfo.mDmax) : dateInfo.mDmax != null)
         {
            return false;
         }
         if (mDmin != null ? !mDmin.equals(dateInfo.mDmin) : dateInfo.mDmin != null)
         {
            return false;
         }

         return true;
      }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
      {
         int result;
         result = (mDmin != null ? mDmin.hashCode() : 0);
         result = 29 * result + (mDmax != null ? mDmax.hashCode() : 0);
         result = 29 * result + N;
         result = 29 * result + (int) (mMinDelta ^ (mMinDelta >>> 32));
         result = 29 * result + (int) (mMaxDelta ^ (mMaxDelta >>> 32));
         return result;
      }
   }

   /**
    * 
    * @author torc
    *
    */
   private static class FldIter
   {
	   
	   /**
	    * Autogenerated doc
	    */      	   
      private GribRecordLight[] mLights;
      
	   /**
	    * Autogenerated doc
	    */            
      private GribFldComparator mFldCmp;
      
	   /**
	    * Autogenerated doc
	    */            
      private GribRecHeader[] mHds;
      
	   /**
	    * Autogenerated doc
	    */            
      private int i;

      /**
       * 
       * @param lights
       */
      public FldIter(GribRecordLight[] lights)
      {
         mLights = lights;
         mFldCmp = new GribFldComparator(new int[]{ GribRecHeader.F_GDS, 
                                                    GribRecHeader.F_LEV_TYP, 
                                                    GribRecHeader.F_PAR, 
                                                    GribRecHeader.F_DATE, 
                                                    GribRecHeader.F_LEV_Z });
         TreeSet<GribRecHeader> tree = new TreeSet<GribRecHeader>(mFldCmp);
         for (int i = 0; i < lights.length; i++)
         {
            GribRecordLight light = lights[i];
            GribRecHeader hd = new GribRecHeader(i, light);
            tree.add(hd);
         }
         mHds = tree.toArray(new GribRecHeader[0]);
      }

      /**
       * 
       * @param f0
       * @return true/false
       */
      public boolean next(int f0)
      {
         int f;
         if (i == mHds.length - 1)
         {
            return false;
         }
         do
         {
            GribRecHeader hd0 = mHds[i++];
            GribRecHeader hd1 = i < mHds.length ? mHds[i] : null;
            f = mFldCmp.compare(hd0, hd1);
            if (f == 0)
            {
               _assert(false); //return false;
            }
            f = Math.abs(f) - 1;
         } while (f > f0);
         if (f == f0)
         {
            return true;
         }
         --i;
         return false;
      }

      /**
       * 
       * @return current header
       */
      public GribRecHeader currHd()
      {
         return i < mHds.length ? mHds[i] : null;
      }

      /**
       * 
       * @return current header as gribRecordLight
       */
      public GribRecordLight currLight()
      {
         GribRecHeader hd = currHd();
         if (hd == null)
         {
            return null;
         }
         return mLights[hd.getIx()];
      }
   }

   /**
    * 
    * @param aFileName
    */
   public GribSummary(String aFileName)
   {
      String path = "";
      File fileObj = new File(aFileName);
      String[] fileNames = null;
      if (fileObj.isDirectory())
      {
         path = fileObj.getAbsolutePath() + "\\";
         fileNames = fileObj.list(new FilenameFilter()
         {

			public boolean accept(File dir, String name)
            {	
				dir.exists();
				return name.matches(".*grb");
            }
         });
      }
      else
      {
         fileNames = new String[]{aFileName};
      }
      if (fileNames == null || fileNames.length == 0)
      {
         System.out.println("No grib files");
         return;
      }

      for (int fIx = 0; fIx < fileNames.length; fIx++)
      {
         String aFile = fileNames[fIx];
         System.out.println("\n\nGribfile: " + aFile);
         GribFile gf = null;
         try
         {
            gf = new GribFile(path + aFile);
         }
         catch (Exception e)
         {
            e.printStackTrace();
            continue;
         }
         int nrecs = gf.getRecordCount();
         GribRecordLight[] lights = gf.getLightRecords();
         System.out.println("Records: " + nrecs);
         _assert (nrecs == lights.length);
         scanRecs(new FldIter(lights));
      }
   }

   
   /**
    * @param cond
    */
   private static void _assert(boolean cond)
   {
      if (!cond) throw new IllegalStateException("");
   }
   
   /**
    * @param light
    */
   private static void printGDS(GribRecordLight light)
   {
      GribRecordGDS gds = light.getGDS();
      System.out.println("\nGrid:\n" + gds.toString());
      int mod = gds.getGridMode();
      int typ = gds.getGridType();
      int scan = gds.getGridScanmode();
      System.out.println("      mode(17):0x" + Integer.toHexString(mod));
      System.out.println("      type(6) :0x" + Integer.toHexString(typ));
      System.out.println("      scan(28):0x" + Integer.toHexString(scan));
      GribRecordPDS pds = light.getPDS();
      int cenId = pds.getCenterId();
      int subId = pds.getSubcenterId();
      int tabId = pds.getTableVersion();
      int proId = pds.getProcessId();
      GribPDSParamTable table = pds.getParamTable();
      //show gribtable mapping:
      int cen2 = table.getCenter_id();
      int sub2 = table.getSubcenter_id();
      int tab2 = table.getTable_number();
      String filn2 = table.getFilename();
      System.out.println("    PDS cent sub tab proc: "
            + cenId + " " + subId + " " + tabId + " " + proId);
      System.out.println("     -> cent sub tab file: "
            + cen2 + " " + sub2 + " " + tab2 + " " + filn2);
   }

   /**
    * 
    * @param light
    */
   private static void printPar(GribRecordLight light)
   {
      try
      {
         GribRecord rec = new GribRecord(light);
         float vmin = rec.getBDS().getMinValue();
         float vmax = rec.getBDS().getMaxValue();

         GribPDSParameter par = light.getPDS().getParameter();
         System.out.print(" Param: " + par.getNumber());
         System.out.print(" " + par.getName());
         System.out.print(" [" + par.getUnit() + "]");
         System.out.print(" " + par.getDescription());
         System.out.println(" [" + vmin + "  " + vmax + "]");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   /**
    * 
    * @param iter
    */
   private static void chkLevels(FldIter iter)
   {
      int N = 0;
      float z0 = 0;
      float z1 = 0;
      do
      {
         GribRecHeader hd = iter.currHd();
         float z = hd.getPDSLevZvalue();
         if (N == 0)
         {
            z0 = z1 = z;
         }
         else
         {
            if (z0 > z)
            {
               z0 = z;
            }
            else if (z1 < z)
            {
               z1 = z;
            }
         }
         N++;
         //hd.getParamUnit();
      } while (iter.next(4));
      System.out.println("# z:" + N);
   }

   /**
    * 
    * @author torc
    *
    */
   private static class CenterTabId
   {
	   /**
	    * Autogenerated doc
	    */      	   
      int cenId;
      
	   /**
	    * Autogenerated doc
	    */          
      int tabId;

      /**
       * 
       * @param rec
       */
      public CenterTabId(GribRecordLight rec)
      {
         GribRecordPDS pds = rec.getPDS();
         cenId = pds.getCenterId();
         tabId = pds.getTableVersion();
      }

      
      /**
       * @see java.lang.Object#toString()
       */
    public String toString()
      {
         return "    PDS cent,tab:  " + cenId + ", " + tabId;
      }

    
      /**
       * @see java.lang.Object#equals(java.lang.Object)
       */
    public boolean equals(Object o)
      {
         if (this == o)
         {
            return true;
         }
         if (!(o instanceof CenterTabId))
         {
            return false;
         }

         final CenterTabId centerTabId = (CenterTabId) o;

         if (cenId != centerTabId.cenId)
         {
            return false;
         }
         if (tabId != centerTabId.tabId)
         {
            return false;
         }

         return true;
      }

    
      /**
       * @see java.lang.Object#hashCode()
       */
    public int hashCode()
      {
         int result;
         result = cenId;
         result = 29 * result + tabId;
         return result;
      }
   }


   /**
    * 
    * @param iter
    */
   private static void scanRecs(FldIter iter)
   {
      if (iter.currLight() == null)
      {
         System.out.println("Null records");
         return;
      }
      do //F_GDS
      {
         GribRecordLight light = iter.currLight();
         printGDS(light);
         CenterTabId cid = new CenterTabId(light);
         DateInfo dateInfo0 = null;
         do //F_LEV_TYP
         {
            GribPDSLevel pdslev = iter.currHd().getPDSLev();
            System.out.println(" Z type(" + pdslev.getIndex() +
                  "): " + pdslev.getName());
            do //F_PAR
            {
               DateInfo dateInfo = new DateInfo();
               do //F_DATE
               {
                  if (false)
                  {
                     chkLevels(iter); //F_LEV_Z
                  }
                  dateInfo.add(iter.currHd().getDate());
               } while (iter.next(3));

               if (!dateInfo.equals(dateInfo0))
               {
                  System.out.println(dateInfo.toString());
                  dateInfo0 = dateInfo;
                  dateInfo = new DateInfo();
               }
               light = iter.currLight();
               CenterTabId cid2 = new CenterTabId(light);
               if (!cid.equals(cid2))
               {
                  System.out.println(cid2);
                  cid = cid2;
               }
               printPar(light);
            } while (iter.next(2));
         } while (iter.next(1));
      } while (iter.next(0));
   }


   /**
    * Autogenerated doc
    */
   private static void usage()
   {
      System.out.println("usage: prog <gribfile>.grb");
      System.out.println("      |prog <gribdir>");
      System.exit(0);
   }

   /**
    * 
    * @param args
    */
   public static void main(String... args)
   {
      if (args.length == 0)
      {
         usage();
      }
      new GribSummary(args[0]);
   }
}
