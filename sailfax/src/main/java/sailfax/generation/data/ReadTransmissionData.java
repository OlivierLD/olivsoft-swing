package sailfax.generation.data;

import java.io.File;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.NSResolver;
import oracle.xml.parser.v2.XMLDocument;

import oracle.xml.parser.v2.XMLElement;

import org.w3c.dom.NodeList;

import sailfax.main.SelectTransmissions;

public class ReadTransmissionData
{
  private static DOMParser parser = null;
  
  public static List readFaxSchedule() throws Exception
  {
    return readFaxSchedule(SelectTransmissions.xmlFileName);
  }
  public static List readFaxSchedule(String dataFileName) throws Exception
  {
    List<BulletinData> data = new ArrayList<BulletinData>(10);
    
    System.out.println("ReadTransmissionData: Parsing [" + dataFileName + "]");
    if (parser == null)
      parser = new DOMParser();
    try
    { parser.parse(new File(dataFileName).toURI().toURL()); }
    catch (Exception ex)
    {
      System.out.println("Parsing [" + dataFileName + "]");
      System.out.println(ex.toString());
    }
    XMLDocument doc = parser.getDocument();
    NSResolver resolver = new NSResolver()
      {
        public String resolveNamespacePrefix(String string)
        {
          return "http://www.fax-data.org";
        }
      };
    NodeList bulletinList = doc.selectNodes("/fax:fax-data/fax:bulletins", resolver);
//  System.out.println("Found " + stationList.getLength() + " bulletin(s)");
    // Get the stations
    for (int i=0; i<bulletinList.getLength(); i++)
    {
      XMLElement bulletin = (XMLElement)bulletinList.item(i);
      BulletinData bd = new BulletinData();
      data.add(bd);
      
      // Get the transmissions
      NodeList transmissionList = bulletin.selectNodes("./fax:bulletins-data/fax:transmissions/fax:transmission", resolver);
//    System.out.println("Found " + transmissionList.getLength() + " transmission(s)");
      // Get the frequencies
      NodeList stationList = bulletin.selectNodes("./fax:stations/fax:station", resolver);
//    System.out.println("Found " + frequenceList.getLength() + " frequency(ies)");
      // Get the maps
      NodeList mapList = bulletin.selectNodes("./fax:bulletins-data/fax:map-areas/fax:map-area", resolver);
//    System.out.println("Found " + mapList.getLength() + " map(s)");
      
      for (int j=0; j<stationList.getLength(); j++)
      {
        XMLElement station = (XMLElement)stationList.item(j);
        String stationCallSign = station.getAttribute("call-sign");
        //    System.out.println("Station Call Sign:" + stationCallSign);
        String stationName = station.selectNodes("./fax:name", resolver).item(0).getFirstChild().getNodeValue();
        //    System.out.println("Station:" + stationName);
        
        StationData stationData = new StationData();
        stationData.callsign = stationCallSign;
        stationData.stationName = stationName;
        bd.stations.add(stationData);
        
        NodeList freqList = station.selectNodes("./fax:frequencies/fax:frequency", resolver);
        for (int k=0; k<freqList.getLength(); k++)
        {
          FreqData fd = new FreqData();
          fd.freq = ((XMLElement)freqList.item(k)).getChildrenByTagName("freq").item(0).getFirstChild().getNodeValue();
          try { fd.times = ((XMLElement)freqList.item(k)).getChildrenByTagName("times").item(0).getFirstChild().getNodeValue(); } catch (NullPointerException ignore) {}
          try { fd.emission = ((XMLElement)freqList.item(k)).getChildrenByTagName("emission").item(0).getFirstChild().getNodeValue(); } catch (NullPointerException ignore) {}
          try { fd.power = ((XMLElement)freqList.item(k)).getChildrenByTagName("power").item(0).getFirstChild().getNodeValue(); } catch (NullPointerException ignore) {}       
          stationData.freqs.add(fd);      
        }
      }
      
      for (int j=0; j<mapList.getLength(); j++)
      {
        MapData md = new MapData();
        md.id = ((XMLElement)mapList.item(j)).getAttribute("id");
        md.top = ((XMLElement)mapList.item(j)).getChildrenByTagName("top").item(0).getFirstChild().getNodeValue();
        md.bottom = ((XMLElement)mapList.item(j)).getChildrenByTagName("bottom").item(0).getFirstChild().getNodeValue();
        md.left = ((XMLElement)mapList.item(j)).getChildrenByTagName("left").item(0).getFirstChild().getNodeValue();
        md.right = ((XMLElement)mapList.item(j)).getChildrenByTagName("right").item(0).getFirstChild().getNodeValue();
        bd.maps.add(md);
      }
      
      for (int j=0; j<transmissionList.getLength(); j++)
      {
        XMLElement trans = (XMLElement)transmissionList.item(j);
        TransmissionData td = new TransmissionData();
        td.starts = trans.getChildrenByTagName("starts").item(0).getFirstChild().getNodeValue();
        td.stops = trans.getChildrenByTagName("stops").item(0).getFirstChild().getNodeValue();
        td.mode = trans.getChildrenByTagName("mode").item(0).getFirstChild().getNodeValue();
        try { td.rpm = trans.getChildrenByTagName("rpm-ioc").item(0).getFirstChild().getNodeValue();  } catch (NullPointerException ignore) {}
        try { td.content = trans.getChildrenByTagName("content").item(0).getFirstChild().getNodeValue();  } catch (NullPointerException ignore) {}
        if (trans.getChildrenByTagName("map-zone").item(0) != null)
          td.map = trans.getChildrenByTagName("map-zone").item(0).getFirstChild().getNodeValue();
        bd.transmissions.add(td);
        
//        System.out.println("  " + trans.getChildrenByTagName("starts").item(0).getFirstChild().getNodeValue() +
//                           "  " + trans.getChildrenByTagName("stops").item(0).getFirstChild().getNodeValue() +
//                           "  " + freq +
//                           "  " + trans.getChildrenByTagName("mode").item(0).getFirstChild().getNodeValue() +
//                           " size=" + trans.getChildrenByTagName("rpm-ioc").item(0).getFirstChild().getNodeValue() +
//                           "  " + trans.getChildrenByTagName("content").item(0).getFirstChild().getNodeValue() +
//                           ((trans.getChildrenByTagName("map-zone").item(0) == null) ? " " :
//                            ", Map " + trans.getChildrenByTagName("map-zone").item(0).getFirstChild().getNodeValue()));
      }
    }
    return data;
  }
  
  public static class BulletinData
  {
    public List<MapData> maps                   = null;
    public List<TransmissionData> transmissions = null;
    public List<StationData> stations           = null;    
    
    public BulletinData()
    {
      maps          = new ArrayList<MapData>();
      transmissions = new ArrayList<TransmissionData>();
      stations      = new ArrayList<StationData>();
    }
  }
  
  public static class StationData
  {
    public String callsign    = "";
    public String stationName = "";
    public List<FreqData> freqs = null;
    
    public StationData()
    {
      freqs = new ArrayList<FreqData>(2);
    }
  }
  
  public static class FreqData
  {
    public String freq;
    public String times;
    public String emission;
    public String power;
  }
  
  public static class MapData
  {
    public String id;
    public String top;
    public String bottom;
    public String left;
    public String right;
  }
  
  public static class TransmissionData
  {
    public String starts;
    public String stops;
    public String mode;
    public String rpm;
    public String content;
    public String map;
  }

  public static void main(String[] args) throws Exception
  {
    List data = readFaxSchedule();

    System.out.println(" -- Main --");
    Iterator iterator = data.iterator();
    while (iterator.hasNext())
    {
      BulletinData bd = (BulletinData)iterator.next();
      List<StationData> stations = bd.stations;
      Iterator<StationData> stats = stations.iterator();
      while (stats.hasNext())
      {
        StationData sd = (StationData)stats.next();
        System.out.println("; " + sd.callsign + " " + sd.stationName);
        List<FreqData> fd = sd.freqs;
        Iterator<FreqData> freqs = fd.iterator();
        while (freqs.hasNext())
        {
          FreqData f = (FreqData)freqs.next();
          System.out.println("; " + f.freq + ", " + f.times + ", " + f.emission + ", " + f.power);
        }
      }
      List<MapData> md = bd.maps;
      Iterator<MapData> maps = md.iterator();
      while (maps.hasNext())
      {
        MapData m = (MapData)maps.next();
        System.out.println("; " + m.id + ":" + m.top + " " + m.bottom + " - " + m.left + " " + m.right);
      }
      
      List<TransmissionData> td = bd.transmissions;
      Iterator<TransmissionData> trans = td.iterator();
      while (trans.hasNext())
      {
        TransmissionData t = (TransmissionData)trans.next();
        System.out.println(" " + 
                           t.starts + " " +
                           t.stops + " " +
                           "freq" + " " + 
                           t.mode + " " +
                           "size=" + t.rpm + " " +
                           t.content + " " + 
                           ((t.map!=null)?"(Map " + t.map + ")":""));
      }
    }
  }  
}
