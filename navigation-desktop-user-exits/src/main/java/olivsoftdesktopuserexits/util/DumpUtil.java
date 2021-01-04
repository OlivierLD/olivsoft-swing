package olivsoftdesktopuserexits.util;

public class DumpUtil
{
  private final static int LINE_LEN = 16;
  
  public static String[] dualDump(String str)
  {
    byte[] ba = str.getBytes();
    String[] result = null;
    int dim = ba.length / LINE_LEN;
    result = new String[dim + 1];
    for (int l=0; l<(dim + 1); l++)
    {
      String line = "";
      int start = l * LINE_LEN;
      for (int c=start; c<Math.min(start + LINE_LEN, ba.length); c++)
      {
        line += (lpad(Integer.toHexString(ba[c]).toUpperCase(), 2, "0") + " ");
      }
      line = rpad(line, 3 * LINE_LEN, " ");
      line += "    ";
      for (int c=start; c<Math.min(start + LINE_LEN, ba.length); c++)
      {
//        line += (Character.isLetter(str.charAt(c)) || 
//                 Character.isDigit(str.charAt(c)) ||
//                 Character.isSpaceChar(str.charAt(c)) ? str.charAt(c) : ".");
        line += (isAsciiPrintable(str.charAt(c)) ? str.charAt(c) : ".");
      }
      
      result[l] = line;
    }
    
    return result;
  }
  
  /**
   * Might not work with some encodings...
   * @param ch
   * @return
   */
  public static boolean isAsciiPrintable(char ch) 
  {
    return ch >= 32 && ch < 127;
  }
  
  private static String lpad(String s, int len, String with)
  {
    while (s.length() < len)
      s = with + s;
    return s;
  }
  
  private static String rpad(String s, int len, String with)
  {
    while (s.length() < len)
      s += with;
    return s;
  }
  
  public static void main(String... args)
  {
    String s = "ABCDEFGHIJKLMNO\r\r\n\000PQakeu\000coucou!$%&&*^#";
    
    String[] sa = dualDump(s);
    for (String str : sa)
      System.out.println(str);
    
    String mess = "+CMTI: \"ME\",75\r\n";
    System.out.println(mess.substring(mess.lastIndexOf(",") + 1, mess.lastIndexOf("\r\n")));
    
    String content = "+CMGR: \"REC READ\",\"+4153505547\",\"\",\"15/11/14,08:57:42-32\",145,4,0,0,\"+12063130057\",145,7\r\nRe-sent\r\n\r\nOK\r\n";
    olivsoftdesktopuserexits.fona.manager.FONAManager.ReceivedSMS m = new olivsoftdesktopuserexits.fona.manager.FONAManager.ReceivedSMS(content);
    System.out.println("From " + m.getFrom()+" :" + m.getContent());   
  }
}
