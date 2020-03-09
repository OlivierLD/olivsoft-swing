package olivsoftdesktopuserexits.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nmea.server.utils.CustomNMEAParser;

import ocss.nmea.parser.StringParsers;

public class CustomRNDParser
  implements CustomNMEAParser
{
  private static String PATTERN = "^\\$(\\w{2})(RND),.*";
  private static Pattern pattern = Pattern.compile(PATTERN);
  
  public CustomRNDParser()
  {
    super();
  }

  @Override
  public Object customParse(String string)
  {
    Object obj = null;
    Matcher matcher = pattern.matcher(string);
    if (matcher.find())
    {
      String type  = matcher.group(2);
      if ("RND".equals(type))
      {
        if (StringParsers.validCheckSum(string))
        {
          String[] sa = string.substring(0, string.indexOf("*")).split(",");
          obj = sa[1];
          System.out.println(">>> Custom Sentence Management: " + obj.toString());
        }
        else
          System.out.println("Invalid NMEA Sentence [" + string + "]");
      }
    }
    return obj;
  }

  @Override
  public String getCacheID(String string)
  {
    String id = null;
    Matcher matcher = pattern.matcher(string);
    if (matcher.find())
    {
      String type  = matcher.group(2);
      if ("RND".equals(type))
        id = "Random Number";
    }
    return id;
  }
}
