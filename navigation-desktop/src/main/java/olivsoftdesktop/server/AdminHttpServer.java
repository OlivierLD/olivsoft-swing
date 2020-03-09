package olivsoftdesktop.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;

import java.net.SocketException;
import java.net.URLDecoder;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import nmea.server.ctx.NMEAContext;

import nmea.server.ctx.NMEADataCache;
import nmea.server.utils.Utils;

import ocss.nmea.parser.Angle180EW;

import olivsoftdesktop.ctx.DesktopContext;
import olivsoftdesktop.ctx.DesktopEventListener;

import org.json.JSONObject;


/**
 * Dedicated HTTP Server.
 * This is NOT J2EE Compliant, not even CGI.
 *
 * Runs the communication between an HTTP client and the
 * features of the Data server to be displayed remotely.
 */
public class AdminHttpServer 
{
  public AdminHttpServer() {}

  private boolean verbose = "true".equals(System.getProperty("verbose", "false"));
  private int _port = 0;
  
  private final static String TURN_HTTP_ON     = "/put/http/on";
  private final static String TURN_HTTP_OFF    = "/put/http/off";
  private final static String TURN_TCP_ON      = "/put/tcp/on";
  private final static String TURN_TCP_OFF     = "/put/tcp/off";
  private final static String TURN_UDP_ON      = "/put/udp/on";
  private final static String TURN_UDP_OFF     = "/put/udp/off";
  private final static String TURN_LOGFILE_ON  = "/put/log/on";
  private final static String TURN_LOGFILE_OFF = "/put/log/off";
  
  private final static String TURN_VERBOSE_ON  = "/put/verbose/on";
  private final static String TURN_VERBOSE_OFF = "/put/verbose/off";
  
  // Statuses
  private final static String HTTP_STATUS      = "/get/http";
  private final static String TCP_STATUS       = "/get/tcp";
  private final static String UDP_STATUS       = "/get/udp";
  private final static String LOG_STATUS       = "/get/log";
  private final static String VERBOSE_STATUS   = "/get/verbose";
  
  private final static String REC_NO           = "/get/recno";

  private final static String ALL_STATUS       = "/get/all";
  private final static String RESET_CONSOLE    = "/update/console";

  private final static String LOGFILE_NAME     = "logfile";

  private final static String NB_TCP_CLIENTS   = "/get/tcp/clients";
  
  public AdminHttpServer(int port)
  {
    InetAddress localaddr = getCurrentIp();
    String localName = localaddr != null ? localaddr.getHostAddress() : "localhost";
    System.out.println(String.format(">>> Starting Admin HTTP server on %s, port %d", localName, port));
    System.out.println(">>> Try http://" + localName + ":" + port + "/console from a browser.");
    System.out.println(">>> Try http://" + localName + ":" + port + "/html5/admin.html for Admin prms.");
    this._port = port;
    
    // Infinite loop, waiting for requests
    Thread httpListenerThread = new Thread("AdminListener")
    {
      public void run()
      {
        boolean go = true;
        try
        {
          Map<String, String> header = new HashMap<String, String>();
          ServerSocket ss = new ServerSocket(_port);
          boolean help = false;
          boolean console = false;
          boolean fetchPrms = false;
          while (go)
          {
            Socket client = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter   out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            
            String command = "";
            String commandReply = "";
            Map<String, String> prmMap = new HashMap<String, String>();
            String line;
            String fileToFetch = "";
            command = "";
            commandReply = "Good";
            help = false;
            console = false;
            fetchPrms = false;
            while (go && (line = in.readLine()) != null)
            {
              if (verbose) System.out.println(">>> HTTP Request:" + line);
          //  command = "";
          //  commandReply = "Good";
              try 
              {
                command = line.substring(line.indexOf("/"));
                command = command.substring(0, command.indexOf(" ")).trim();
                if (command.indexOf("?") > -1)
                {
                  String prms = command.substring(command.indexOf("?") + 1);
                  command = command.substring(0, command.indexOf("?"));
                  String[] pa = prms.split("&");
                  for (String p : pa)
                  {
                    String[] nv = p.split("=");
                    prmMap.put(nv[0], nv[1]);
                  }
                }
                if (verbose) System.out.println(">>> Command: [" + command + "]");
              }
              catch (Exception ex)
              {                
              }
              if (line.length() == 0)
                break;
              else if (line.startsWith("POST /exit") || line.startsWith("GET /exit"))
              {
//             System.out.println("Received an exit signal");
                go = false;
              }
              else if (line.startsWith("POST /help") || line.startsWith("GET /help"))
              {
//              System.out.println("Received an help request");
                help = true;
              }
              else if (line.startsWith("POST /console") || line.startsWith("GET /console"))
              {
//              System.out.println("Received an help request");
                console = true;
              }
              else if (line.startsWith("GET /fetch-prms"))
              {
//              System.out.println("Fetching parameters...");
                fetchPrms = true;
              }
              else if (line.startsWith("GET /update-prms"))
              {
//              System.out.println("Updating parameters...");
                updateCalParams(line);
              }
              else if (command.trim().length() > 0)
              {
                if (verbose) System.out.println("Managing Admin command [" + command + "]");
                // Manage it here
                if (TURN_HTTP_ON.equals(command))
                {
//                System.out.println("Enabling HTTP");
                  if (DesktopContext.getInstance().isHttpRebroadcastAvailable())
                  {
                    DesktopContext.getInstance().setHttpRebroadcastEnable(true);
                    NMEAContext.getInstance().fireEnableHTTPserver(true);
                  }
                  else
                    commandReply = "HTTP re-broadcasting NOT available";
                }
                else if (TURN_HTTP_OFF.equals(command))
                {
//                System.out.println("Disabling HTTP");
                  if (DesktopContext.getInstance().isHttpRebroadcastAvailable())
                  {
                    DesktopContext.getInstance().setHttpRebroadcastEnable(false);
                    NMEAContext.getInstance().fireEnableHTTPserver(false);
                  }
                  else
                    commandReply = "HTTP re-broadcasting NOT available";

                }
                else if (TURN_TCP_ON.equals(command))
                {
//                System.out.println("Enabling TCP");
                  if (DesktopContext.getInstance().isTcpRebroadcastAvailable())
                    DesktopContext.getInstance().setTcpRebroadcastEnable(true);
                  else
                    commandReply = "TCP re-broadcasting NOT available";
                }
                else if (TURN_TCP_OFF.equals(command))
                {
//                System.out.println("Disabling TCP");
                  if (DesktopContext.getInstance().isTcpRebroadcastAvailable())
                    DesktopContext.getInstance().setTcpRebroadcastEnable(false);
                  else
                    commandReply = "TCP re-broadcasting NOT available";
                }
                else if (TURN_UDP_ON.equals(command))
                {
//                System.out.println("Enabling UDP");
                  if (DesktopContext.getInstance().isUdpRebroadcastAvailable())
                    DesktopContext.getInstance().setUdpRebroadcastEnable(true);
                  else
                    commandReply = "UDP re-broadcasting NOT available";
                }
                else if (TURN_UDP_OFF.equals(command))
                {
//                System.out.println("Disabling UDP");
                  if (DesktopContext.getInstance().isUdpRebroadcastAvailable())
                    DesktopContext.getInstance().setUdpRebroadcastEnable(false);
                  else
                    commandReply = "UDP re-broadcasting NOT available";
                }
                else if (TURN_LOGFILE_ON.equals(command))
                {
//                System.out.println("Enabling Logging");                  
                  if (DesktopContext.getInstance().isFileRebroadcastAvailable())
                  {
//                    String fileName = "logged-data/data.nmea";
//                    try
//                    {
//                      String fName = prmMap.get(LOGFILE_NAME);
//                      if (fName != null && fName.trim().length() > 0)
//                        fileName = fName;
//                      System.out.println(">>> LogFile name: [" + fileName + "]");
//                    }
//                    catch (Exception ex) {}
                    DesktopContext.getInstance().setFileRebroadcastEnable(true); // TODO A file name
                  }
                  else
                    commandReply = "FILE (log) re-broadcasting NOT available";
                }
                else if (TURN_LOGFILE_OFF.equals(command))
                {
//                System.out.println("Disabling Logging");                  
                  if (DesktopContext.getInstance().isFileRebroadcastAvailable())
                    DesktopContext.getInstance().setFileRebroadcastEnable(false);
                  else
                    commandReply = "FILE (log) re-broadcasting NOT available";
                } 
                else if (TURN_VERBOSE_ON.equals(command))
                {
//                System.out.println("Enabling verbose");                  
                  DesktopContext.getInstance().setDesktopVerbose(true);
                } 
                else if (TURN_VERBOSE_OFF.equals(command))
                {
//                System.out.println("Disabling verbose");                  
                  DesktopContext.getInstance().setDesktopVerbose(false);
                } 
                else if (RESET_CONSOLE.equals(command))
                {
                  DesktopContext.getInstance().fireResetConsole();
                }
                else if (HTTP_STATUS.equals(command))
                {
//                System.out.println("HTTP_STATUS");        
                  if (DesktopContext.getInstance().isHttpRebroadcastAvailable())
                    commandReply = DesktopContext.getInstance().isHttpRebroadcastEnable() ? "on" : "off";
                  else 
                    commandReply = "HTTP re-broadcast not available";
                }
                else if (TCP_STATUS.equals(command))
                {
//                System.out.println("TCP_STATUS");                  
                  if (DesktopContext.getInstance().isTcpRebroadcastAvailable())
                    commandReply = DesktopContext.getInstance().isTcpRebroadcastEnable() ? "on" : "off";
                  else 
                    commandReply = "TCP re-broadcast not available";
                }  
                else if (UDP_STATUS.equals(command))
                {
//                System.out.println("UDP_STATUS");                  
                  if (DesktopContext.getInstance().isUdpRebroadcastAvailable())
                    commandReply = DesktopContext.getInstance().isUdpRebroadcastEnable() ? "on" : "off";
                  else 
                    commandReply = "UDP re-broadcast not available";
                }  
                else if (LOG_STATUS.equals(command))
                {
//                System.out.println("LOG_STATUS");                  
                  if (DesktopContext.getInstance().isFileRebroadcastAvailable())
                    commandReply = DesktopContext.getInstance().isFileRebroadcastEnable() ? "on" : "off";
                  else 
                    commandReply = "File re-broadcast not available";
                }     
                else if (VERBOSE_STATUS.equals(command))
                {
//                System.out.println("VERBOSE_STATUS");                  
                  commandReply = DesktopContext.getInstance().isDesktopVerbose() ? "on" : "off";
                }  
                else if (REC_NO.equals(command))
                {
                  commandReply = "Reading record # " + Long.toString(getReplayFileRecnum());
                }  
                else if (NB_TCP_CLIENTS.equals(command))
                {
                  if (DesktopContext.getInstance().isTcpRebroadcastAvailable())
                  {
                    if (DesktopContext.getInstance().isTcpRebroadcastEnable())
                    {
                      final Thread currentThread = Thread.currentThread();
                      DesktopEventListener del = new DesktopEventListener()
                      {
                        public void setNbClients(int connectionType, int nb) 
                        {
                          if (connectionType == DesktopEventListener.TCP_TYPE)
                          {
    //                      System.out.println(">>> Got NB client response:" + Integer.toString(nb));
                            setStr("Nb TCP clients:" + Integer.toString(nb));
                            synchronized (currentThread)
                            {
                              currentThread.notify();
    //                        System.out.println("Thread notification completed.");
                            }
                          }
                        } 
                      };
                      DesktopContext.getInstance().addApplicationListener(del);
                      Thread sendRequest = new Thread("Admin Sender")
                        {
                          public void run()
                          {
                            setStr("No clients");
                            DesktopContext.getInstance().fireGetNbClients(DesktopEventListener.TCP_TYPE);
    //                      System.out.println(">>> request completed.");
                          }
                        };
                      sendRequest.start();
                      synchronized (currentThread)
                      {
    //                  System.out.println(">>> Waiting for the response, nb TCP client.");
                        currentThread.wait(500L);
                        commandReply = str;
    //                  System.out.println(">>> Got the response, done waiting. [" + str + "]");
                        DesktopContext.getInstance().removeApplicationListener(del);
                      }
                    }
                    else
                      commandReply = "TCP Rebroadcast is disabled";
                  }
                  else
                    commandReply = "No TCP Rebroadcast available";
                }
                else if (ALL_STATUS.equals(command))
                {
                  if (DesktopContext.getInstance().isHttpRebroadcastAvailable())
                    commandReply = "HTTP re-broadcast is " + (DesktopContext.getInstance().isHttpRebroadcastEnable() ? "on" : "off") + ", on port " + Integer.toString(DesktopContext.getInstance().getHttpRebroadcastPort());
                  else 
                    commandReply = "HTTP re-broadcast not available";
                  commandReply += "\n";
                  if (DesktopContext.getInstance().isTcpRebroadcastAvailable())
                    commandReply += "TCP re-broadcast is " + (DesktopContext.getInstance().isTcpRebroadcastEnable() ? "on" : "off") + ", on port " + Integer.toString(DesktopContext.getInstance().getTcpRebroadcastPort());
                  else 
                    commandReply += "TCP re-broadcast not available";
                  commandReply += "\n";                  
                  if (DesktopContext.getInstance().isUdpRebroadcastAvailable())
                    commandReply += "UDP re-broadcast is " + (DesktopContext.getInstance().isUdpRebroadcastEnable() ? "on" : "off") + ", on port " + Integer.toString(DesktopContext.getInstance().getUdpRebroadcastPort());
                  else 
                    commandReply += "UDP re-broadcast not available";
                  commandReply += "\n";
                  if (DesktopContext.getInstance().isFileRebroadcastAvailable())
                    commandReply += "Logging is " + (DesktopContext.getInstance().isFileRebroadcastEnable() ? "on" : "off") + ", in " + DesktopContext.getInstance().getFileRebroadcastName();
                  else 
                    commandReply += "Logging not available";
                  commandReply += "\n";
                  commandReply += "Verbose is " + (DesktopContext.getInstance().isDesktopVerbose() ? "on" : "off");
                }
                else
                {
               // commandReply = "Unknown query";
//                System.out.println("Unmanaged: [" + line + "]");
                }
              }
              else if (line.startsWith("GET /")) // display a file
              {
                fileToFetch = line.substring("GET /".length());
                fileToFetch = fileToFetch.substring(0, fileToFetch.indexOf(" "));
                System.out.println("********** File to fetch:[" + fileToFetch + "] *************");
              }
//            System.out.println("Read:[" + line + "]");
              if (line.indexOf(":") > -1) // Header?
              {
                String headerKey = line.substring(0, line.indexOf(":"));
                String headerValue = line.substring(line.indexOf(":") + 1);
                header.put(headerKey, headerValue);
              }
            }
            String contentType = "text/plain";

            String content = commandReply;
            if (help)          
            {
              content = (generateHelpContent());
              contentType = "text/html";
            }
            else if (console)          
            {
              content = (generateConsoleContent());
              contentType = "text/html";
            }
            else if (fetchPrms)
            {
              content = generatePrms();
              contentType = "application/json";
            }
            else if (fileToFetch.trim().length() > 0)
            {
              content = "";
              File f = new File(fileToFetch);
              if (!f.exists())
                out.println(fileToFetch + " not found from " + System.getProperty("user.dir"));
              else
              {
                if (fileToFetch.toUpperCase().endsWith(".HTML") ||
                    fileToFetch.toUpperCase().endsWith(".XHTML"))
                  contentType = "text/html";
                else if (fileToFetch.toUpperCase().endsWith(".XML") ||
                         fileToFetch.toUpperCase().endsWith(".XSD"))
                  contentType = "text/xml";
                else if (fileToFetch.toUpperCase().endsWith(".XSL"))
                  contentType = "text/xsl";
                else if (fileToFetch.toUpperCase().endsWith(".TXT"))
                  contentType = "text/plain";
                else if (fileToFetch.toUpperCase().endsWith(".JS"))
                  contentType = "text/javascript";
                else if (fileToFetch.toUpperCase().endsWith(".CSS"))
                  contentType = "text/css";
                else
                  System.out.println("File extension not managed for " + fileToFetch); // We don't read binaries. See below.
//              System.out.println("............... Reading " + f.getAbsolutePath());
                BufferedReader br = new BufferedReader(new FileReader(f));
                String data = "";

                out.print("HTTP/1.1 200 \r\n"); 
                out.print("Content-Type: " + contentType + "\r\n");
//              out.print("Content-Length: " + content.length() + "\r\n");
//              out.print("Access-Control-Allow-Origin: *\r\n"); 
                out.print("\r\n"); // End Of Header
                //
                boolean ok = true;
                while (ok)
                {
                  data = br.readLine();
                  if (data == null)
                    ok = false;
                  else
                    out.println(data);
                }
                br.close();
              }
            }
            
            if (content.length() > 0)
            {
              // Headers?
              out.print("HTTP/1.1 200 \r\n"); 
              out.print("Content-Type: " + contentType + "\r\n");
              out.print("Content-Length: " + content.length() + "\r\n");
              out.print("Access-Control-Allow-Origin: *\r\n"); 
              out.print("\r\n"); // End Of Header
              //
              out.println(content);
            }
            out.flush();
            out.close();
            in.close();
            client.close();
          }
          ss.close();
          System.out.println("Exiting.");
        }
        catch (Exception e)
        {
          System.err.println("AdminHttpServer:" + e.toString());
          e.printStackTrace();
        }
        System.out.println("HTTP Admin Server done.");
      }
    };
    httpListenerThread.start();
  }

  public static InetAddress getCurrentIp()
  {
    try
    {
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      while (networkInterfaces.hasMoreElements())
      {
        NetworkInterface ni = networkInterfaces.nextElement();
        Enumeration<InetAddress> nias = ni.getInetAddresses();
        while (nias.hasMoreElements())
        {
          InetAddress ia = nias.nextElement();
          if (!ia.isLinkLocalAddress() &&
              !ia.isLoopbackAddress() &&
               ia instanceof Inet4Address)
          {
            return ia;
          }
        }
      }
    }
    catch (SocketException e)
    {
      System.err.println("unable to get current IP " + e.getMessage());
    }
    return null;
  }

  private String str = "";
  private void setStr(String str)
  {
    this.str = str;
  }
  
  private long getReplayFileRecnum()
  {
    long recNo = 0L;
    recNo = NMEAContext.getInstance().getReplayFileRecNum();
    return recNo;
  }
  
  private String generatePrms()
  {
    NMEADataCache cache = NMEAContext.getInstance().getCache();
    double bspFactor   = ((Double)cache.get(NMEADataCache.BSP_FACTOR)).doubleValue();
    double awsFactor   = ((Double)cache.get(NMEADataCache.AWS_FACTOR)).doubleValue();
    double awaOffset   = ((Double)cache.get(NMEADataCache.AWA_OFFSET)).doubleValue();
    double hdgOffset   = ((Double)cache.get(NMEADataCache.HDG_OFFSET)).doubleValue();
    double maxLeeway   = ((Double)cache.get(NMEADataCache.MAX_LEEWAY)).doubleValue();
    
    String devFile     = ((String)cache.get(NMEADataCache.DEVIATION_FILE)).toString();
    double defaultDecl = ((Angle180EW)cache.get(NMEADataCache.DEFAULT_DECLINATION)).getDoubleValue();
    int damping        = ((Integer)cache.get(NMEADataCache.DAMPING)).intValue();
    
    String polarFile   = ((String)cache.get(NMEADataCache.POLAR_FILE_NAME)).toString();
    double polarFactor = ((Double)cache.get(NMEADataCache.POLAR_FACTOR)).doubleValue();
    
    boolean displayWebWT = true,
            displayWebAT = true,
            displayWebGDP = false,
            displayPRMSL = false,
            displayWebHUM = false,
            displayWebVOLT = false;
    try { displayWebWT = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_WT)).booleanValue(); } catch (Exception ex) {}
    try { displayWebAT = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_AT)).booleanValue(); } catch (Exception ex) {}
    try { displayWebGDP = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_GDT)).booleanValue(); } catch (Exception ex) {}
    try { displayPRMSL = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_PRMSL)).booleanValue(); } catch (Exception ex) {}
    try { displayWebHUM = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_HUM)).booleanValue(); } catch (Exception ex) {}
    try { displayWebVOLT = ((Boolean)cache.get(NMEADataCache.DISPLAY_WEB_VOLT)).booleanValue(); } catch (Exception ex) {}

    String doc = "{}";
    try
    {
      JSONObject json = new JSONObject();
      json.put("bspFactor", bspFactor);
      json.put("awsFactor", awsFactor);
      json.put("awaOffset", awaOffset);
      json.put("hdgOffset", hdgOffset);
      json.put("maxLeeway", maxLeeway);
      json.put("devFile", devFile);
      json.put("defaultDecl", defaultDecl);
      json.put("damping", damping);
      json.put("polarFile", polarFile);
      json.put("polarSpeedFactor", polarFactor);
      
      json.put("displayWT", displayWebWT);
      json.put("displayAT", displayWebAT);
      json.put("displayGDT", displayWebGDP);
      json.put("displayPRMSL", displayPRMSL);
      json.put("displayHUM", displayWebHUM);
      json.put("displayVOLT", displayWebVOLT);
  
      doc = json.toString();
    }
    catch (Exception ex) 
    {
      ex.printStackTrace();
    }
    
    return doc;
  }

  private enum CacheToQSMatch
  {
    BSP_FACTOR("bsp", NMEADataCache.BSP_FACTOR),
    AWS_FACTOR("aws", NMEADataCache.AWS_FACTOR),
    AWA_OFFSET("awa", NMEADataCache.AWA_OFFSET),
    HDG_OFFSET("hdg", NMEADataCache.HDG_OFFSET),
    MAX_LEEWAY("lwy", NMEADataCache.MAX_LEEWAY),
    DEVIATION_FILE("dev", NMEADataCache.DEVIATION_FILE),
    DEFAULT_DECLINATION("dec", NMEADataCache.DEFAULT_DECLINATION),
    DAMPING("dpg", NMEADataCache.DAMPING),
    POLAR_FILE("pol", NMEADataCache.POLAR_FILE_NAME),
    POLAR_FACTOR("fac", NMEADataCache.POLAR_FACTOR),
    
    DISPLAY_WEB_WT("dwt", NMEADataCache.DISPLAY_WEB_WT),
    DISPLAY_WEB_AT("dat", NMEADataCache.DISPLAY_WEB_AT),
    DISPLAY_WEB_GDT("dgdt", NMEADataCache.DISPLAY_WEB_GDT),
    DISPLAY_WEB_PRMSL("dprmsl", NMEADataCache.DISPLAY_WEB_PRMSL),
    DISPLAY_WEB_HUM("dhum", NMEADataCache.DISPLAY_WEB_HUM),
    DISPLAY_WEB_VOLT("dvolt", NMEADataCache.DISPLAY_WEB_VOLT);
    
     // &dwt=true&dat=true&dgdt=true&dprmsl=true&dhum=true&dvolt=true
    private final String name;
    private final String key;

    CacheToQSMatch(String name, String key)
    {
      this.name = name;
      this.key = key;
    }
    
    public String prmname() { return this.name; }
    public String key() { return this.key; }
  }
  
  private void updateCalParams(String line)
  {
    try
    {
      int from = line.indexOf(" ") + 1;
      String request = line.substring(from, line.indexOf(" ", from + 1));
  //    System.out.println("[" + request + "]");
      String qString = request.substring(request.indexOf("?") + 1);
      String[] prms = qString.split("&");
      for (String nvPair : prms)
      {
        String[] nv = nvPair.split("=");
        for (CacheToQSMatch match : CacheToQSMatch.values())
        {
          if (match.prmname().equals(nv[0]))
          {
            Object cachedData = NMEAContext.getInstance().getCache().get(match.key());
            System.out.println("In updateCalParams, " + match.key());
            if (cachedData instanceof String)
            {
              String str = URLDecoder.decode(nv[1], "ISO-8859-1");
              NMEAContext.getInstance().getCache().put(match.key, str);              
            }
            else if (cachedData instanceof Double)
            {
              String str = URLDecoder.decode(nv[1], "ISO-8859-1");
              NMEAContext.getInstance().getCache().put(match.key, new Double(str));
            }
            else if (cachedData instanceof Integer)
            {
              String str = URLDecoder.decode(nv[1], "ISO-8859-1");
              NMEAContext.getInstance().getCache().put(match.key, new Integer(str));
            }
            else if (cachedData instanceof Boolean)
            {
              String str = URLDecoder.decode(nv[1], "ISO-8859-1");
              NMEAContext.getInstance().getCache().put(match.key, Boolean.valueOf(str));
            }
            else if (cachedData instanceof Angle180EW)
            {
              String str = URLDecoder.decode(nv[1], "ISO-8859-1");
              NMEAContext.getInstance().getCache().put(match.key, new Angle180EW(Double.parseDouble(str)));
            }
            else
            {
              if (cachedData != null)
                System.out.println("Un-managed type:" + cachedData.getClass().getName());
              else
              {
                if (match.key().equals(NMEADataCache.DISPLAY_WEB_WT) || 
                    match.key().equals(NMEADataCache.DISPLAY_WEB_AT) || 
                    match.key().equals(NMEADataCache.DISPLAY_WEB_GDT) || 
                    match.key().equals(NMEADataCache.DISPLAY_WEB_PRMSL) ||  
                    match.key().equals(NMEADataCache.DISPLAY_WEB_HUM) || 
                    match.key().equals(NMEADataCache.DISPLAY_WEB_VOLT))
                {
                  String str = URLDecoder.decode(nv[1], "ISO-8859-1");
                  System.out.println("Setting [" + match.key + "] to " + str);
                  NMEAContext.getInstance().getCache().put(match.key, Boolean.valueOf(str));
                }
                else
                  System.out.println("Null data for " + match.key());
              }
            }
            break;
          }
        }
      }      
      NMEAContext.getInstance().fireDampingHasChanged(((Integer)NMEAContext.getInstance().getCache().get(NMEADataCache.DAMPING)).intValue());
      NMEAContext.getInstance().fireDeviationCurveChanged(Utils.loadDeviationHashtable((String)NMEAContext.getInstance().getCache().get(NMEADataCache.DEVIATION_FILE)));
      
      // Write properties file
      Utils.writeNMEAParameters();

      System.out.println("Prms Updated.");
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }  
  
  private String generateHelpContent()
  {
    String str = ""; // "Content-Type: text/html\r\n\r\n";
    str += "<html><head><title>Admin server help</title></head><body><pre>\n";
    str += ("Server System Date is:" + new Date().toString() + "\n\n");
    str += "------------------------------------\n";
    str += "Available commands (base-paths) are:";
    str += "<ul>";
    str += "<li>/console</li>";
    str += "<li>/help</li>";
    str += "<li>/exit</li>";
    str += "<li>/put/http/on</li>";
    str += "<li>/put/http/off</li>";
    str += "<li>/put/tcp/on</li>";
    str += "<li>/put/tcp/off</li>";
    str += "<li>/put/udp/on</li>";
    str += "<li>/put/udp/off</li>";
    str += "<li>/put/log/on</li>"; // ?logfile=[file.name]</li>";
    str += "<li>/put/log/off</li>";
    str += "<li>/put/verbose/on</li>";
    str += "<li>/put/verbose/off</li>";
    str += "<li>/get/http</li>";
    str += "<li>/get/tcp</li>";
    str += "<li>/get/udp</li>";
    str += "<li>/get/log</li>";
    str += "<li>/get/verbose</li>";
    str += "<li>/get/all</li>";
    str += "<li>/update/console</li>";
    str += "<li>/get/recno</li>";
    str += "<li>/get/tcp/clients</li>";
    str += "</ul>";
    str += "------------------------------------\n";
    str += "</pre></body></html>\n";    
    return str;
  }
    
  private String generateConsoleContent()
  {
    String css = "<style type='text/css'>\n" + 
    "      body { background : #ffffff; color : #000000; font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      h1 { color: white; font-style: italic; font-size: 14pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular; background-color: black; padding-left: 5pt } \n" + 
    "      h2 { font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      h3 { font-style: italic; font-weight: bold; font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular; font-weight: bold  } \n" + 
    "      li { font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      p { font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      td { font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      small { font-size: 10pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      blockquote{ font-style: italic; font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular }--> \n" + 
    "      em { font-size: 12pt; font-style: italic; font-weight: bold; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      pre { font-size: 11pt; font-family: Courier New, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      address { font-size: 12pt; font-family: Arial, Helvetica, Geneva, Swiss, SunSans-Regular } \n" + 
    "      a:link { color : #000000}  \n" + 
    "      a:active { color: #000000}  \n" + 
    "      a:visited { color : #000000}\n" + 
    "    </style>  \n";
    String str = "";
    str += "<html><head><title>Admin Server Console</title>" + css + "</head><body>\n";
    str += "<h1>Admin Console</h1>\n";
    str += "<ul>";
    str += "<li><a href='/console'>Console</a></li>";
    str += "<li><a href='/help'>Help</a></li>";
    str += "<li><a href='/exit'>Stop</a> admin server (Warning: cannot be restarted from here)</li>";
    str += "<li>Turn HTTP <a href='/put/http/on'>ON</a>, or <a href='/put/http/off'>OFF</a></li>";
    str += "<li>Turn TCP <a href='/put/tcp/on'>ON</a>, or <a href='/put/tcp/off'>OFF</a></li>";
    str += "<li>Turn UDP <a href='/put/udp/on'>ON</a>, or <a href='/put/udp/off'>OFF</a></li>";
    str += "<li>Turn Logging <a href='/put/log/on'>ON</a>, or <a href='/put/log/off'>OFF</a></li>"; // ?logfile=[file.name]</li>";
    str += "<li>Turn Verbose <a href='/put/verbose/on'>ON</a>, or <a href='/put/verbose/off'>OFF</a></li>";
    str += "<li><a href='/get/all'><b>All Status</b></a></li>";
    str += "<li><a href='/get/http'>HTTP Status</a></li>";
    str += "<li><a href='/get/tcp'>TCP Status</a></li>";
    str += "<li><a href='/get/udp'>UDP Status</a></li>";
    str += "<li><a href='/get/log'>Logging Status</a></li>";
    str += "<li><a href='/get/verbose'>Verbose Status</a></li>";
    str += "<li><a href='/update/console'>Reset Char Console</a></li>";
    str += "<li><a href='/get/recno'>Current record (replay)</a></li>";
    str += "<li><a href='/get/tcp/clients'>Nb TCP Clients</a></li>";
    str += "</ul>";
    str += "<hr>";
    str += "<small>After using the links above, use the <i>back</i> button to come back here.</small>";
    str += "<hr>";
    str += "<address>&copy; OlivSoft</address>";
    str += "</body></html>\n";    
    return str;
  }
    
  //  For dev tests
  public static void main(String[] args) throws Exception
  {
//  System.setProperty("admin.http.port", "7070");
    int port = 8080;
    new AdminHttpServer(port);

    Thread t = new Thread("For Dev Tests")
      {
        public void run()
        {
          synchronized(this)
          {
            try {  this.wait(); } catch (Exception ex) {}
          }
        }
      };
    t.start();
  }
}