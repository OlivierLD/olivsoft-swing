package sailfax.chrono;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import sailfax.chrono.sort.ObjectToSort;
import sailfax.chrono.sort.QSortAlgorithm;

/**
 * Read SkedFile.txt
 */
public class DataParser
{
  private static String skedFileName = "SkedFile.txt";
  private static ObjectToSort[] faxes;
  private static ObjectToSort[] sitor;
  
  public static void readData()
  {
    try
    {
      System.out.println("Reading [" + skedFileName + "]");
      BufferedReader br = new BufferedReader(new FileReader(skedFileName));
      String line = "";
      long closestFax   = 0L;
      long closestSitor = 0L;
      String[] nextFaxData = null;
      String[] nextSitorData = null;
      List<FaxObject> fax4Sort = new ArrayList<FaxObject>(10);
      List<FaxObject> sitor4Sort = new ArrayList<FaxObject>(2);
      long smallestdifffax   = Long.MAX_VALUE;
      long smallestdiffsitor = Long.MAX_VALUE;
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
      DecimalFormat nf = new DecimalFormat("00");
      Calendar cal     = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
      int hours        = cal.get(Calendar.HOUR_OF_DAY);
      int minutes      = cal.get(Calendar.MINUTE);
      Date now         = sdf.parse(nf.format(hours) + ":" + nf.format(minutes));
      long longnow     = now.getTime();
      
//    System.out.println(">>> Now: " + hours + ":" + minutes + " GMT");
//    System.out.println(">>> " + now.toString());
      
      List<String[]> allTx = new ArrayList<String[]>(10);
      
      while ((line = br.readLine()) != null)
      {
        if (!line.startsWith(";"))
        {
          if (line.trim().length() > 0)
          {
//          System.out.println(line);
            String[] details = specialSplit(line);
            allTx.add(details);
            String begin = details[0];
            /*
             *  0 : start
             *  1 : stop
             *  2 : freq
             *  3 : type (fax/sitor)
             *  4 : size
             *  5 : station call sign
             *  6 : forecast
             *  7 : level
             *  8 : prog/man
             */
//          if (details[5].equals("sitor"))
//            System.out.println("Sitor");
            Date txDate = sdf.parse(begin);
            long longTxDate = txDate.getTime();
            if (longTxDate < longnow)
              longTxDate += (3600L * 24L * 1000L); // Plus one day
//          if (details[3].equals("fax"))
            {
              fax4Sort.add(new FaxObject(details, longTxDate));
              if ((longTxDate - longnow) < smallestdifffax)
              {
                smallestdifffax = (longTxDate - longnow);
                closestFax = longTxDate;
                nextFaxData = details;
              }
            }
//            else if (details[6].equals("sitor") || 
//                     details[3].equals("FEX") || 
//                     details[3].equals("FEC"))
//            {
//              sitor4Sort.add(new FaxObject(details, longTxDate));
//              if ((longTxDate - longnow) < smallestdiffsitor)
//              {
//                smallestdiffsitor = (longTxDate - longnow);
//                closestSitor = longTxDate;
//                nextSitorData = details;
//              }
//            }
//            else
//              System.out.println("Unknown line type");
//          System.out.println("==> Bulletin Time: " + txDate.toString());
          }
        }
        else
        {
//          String data = line.substring(1);
//          while (data.startsWith(" "))
//            data = data.substring(1);
//          if (data.length() > 0)
//          {
//            if (!Character.isDigit(data.charAt(0)))
//              System.out.println(data);
//          }
        }
      }
      System.out.println("There are :" + allTx.size() + " transmissions a day");
      System.out.println("Current Time     :" + sdf.format(now) + " GMT");
      if (closestFax > 0L)
      {
        System.out.println("Next Fax         :" + sdf.format(new Date(closestFax)) + " GMT");
        for (int i=0; i<nextFaxData.length; i++)
          System.out.print(nextFaxData[i] + " ");
        System.out.println();
      }
      if (closestSitor > 0L)
      {
        System.out.println("Next Sitor       :" + sdf.format(new Date(closestSitor)) + " GMT");
        for (int i=0; i<nextSitorData.length; i++)
          System.out.print(nextSitorData[i] + " ");
        System.out.println();
      }
      br.close();
      // 1 - Sort the Faxes
      QSortAlgorithm qsa = new QSortAlgorithm();
//    System.out.println("-- Faxes --");
      ObjectToSort[] ots = (ObjectToSort[])fax4Sort.toArray(new ObjectToSort[fax4Sort.size()]);      
      qsa.sort(ots);
      faxes = ots;
      for (int i=0; false && i<ots.length; i++)
      {
        String[] faxData = (String[])((FaxObject)ots[i]).getData();
        long v = ots[i].getValue();
        System.out.print(Long.toString(v) + " : ");
        for (int j=0; j<faxData.length; j++)
          System.out.print(faxData[j] + " ");
        System.out.println();         
      }
//    System.out.println("-- Sitor --");
      // 2 - Sort the Sitor
//    qsa = new QSortAlgorithm();
      ots = (ObjectToSort[])sitor4Sort.toArray(new ObjectToSort[sitor4Sort.size()]);
      qsa.sort(ots);
      sitor = ots;
      for (int i=0; false && i<ots.length; i++)
      {
        String[] sitorData = (String[])((FaxObject)ots[i]).getData();
        long v = ots[i].getValue();
        System.out.print(Long.toString(v) + " : ");
        for (int j=0; j<sitorData.length; j++)
          System.out.print(sitorData[j] + " ");
        System.out.println();         
      }
    }
    catch (FileNotFoundException fnfe)
    {
      System.out.println(fnfe.getMessage());
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }
  
  public static ObjectToSort[] getFaxes()
  { return faxes; }
  
  public static ObjectToSort[] getSITORs()
  { return sitor; }
  
  /**
   * Split a string at any number of blanks.
   * @param str
   * @return
   */
  private static String[] specialSplit(String str)
  {
    ArrayList<String> al = new ArrayList<String>(2);
    String theLine = str.trim();
    while (theLine.startsWith(" "))
      theLine = theLine.substring(1);
    int idx = 0;
    while ((idx = theLine.indexOf(" ")) > 0)
    {
      String chunk = theLine.substring(0, idx);
      theLine = theLine.substring(idx);
      al.add(chunk);
      while (theLine.startsWith(" "))
        theLine = theLine.substring(1);
    }
    if (theLine.length() > 0)
      al.add(theLine);
    al.trimToSize();
    return (String[])al.toArray(new String[al.size()]);
  }
  
  public static void main(String... args)
  {
    readData();
  }

  public static void setSkedFileName(String s)
  {
    skedFileName = s;
  }

  public static String getSkedFileName()
  {
    return skedFileName;
  }

  public static class FaxObject extends ObjectToSort
  {
    long theValue;
    Object data;
    
    public FaxObject(Object o, long val)
    {
      super(o, val);
      theValue = val;
      data = o;
    }
    public long getValue()
    {
      return theValue;
    }
    public Object getData()
    { return data; }
  }  
}
