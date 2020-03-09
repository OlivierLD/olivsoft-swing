package sailfax;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import oracle.xml.parser.schema.XMLSchema;
import oracle.xml.parser.schema.XSDBuilder;
import oracle.xml.parser.v2.XMLParser;
import oracle.xml.parser.v2.DOMParser;

public class DataValidator 
{
  private final static String SCHEMA_LOCATION  = "fax-data-v2.xsd";
  private final static String VALID_DOCUMENT   = "pac-fax-data.xml";

  public DataValidator()
  {
    try
    {
//    URL validatorStream      = this.getClass().getResource(SCHEMA_LOCATION);
//    URL docToValidate        = this.getClass().getResource(VALID_DOCUMENT);
      URL validatorStream      = new File(SCHEMA_LOCATION).toURI().toURL();
      URL docToValidate        = new File(VALID_DOCUMENT).toURI().toURL();
    
      DOMParser parser = new DOMParser();
      parser.showWarnings(true);
      String version = DOMParser.getReleaseVersion();
      System.out.println("Using " + version);
      parser.setErrorStream(System.out);
      parser.setValidationMode(XMLParser.SCHEMA_VALIDATION);    
      parser.setPreserveWhitespace(true);
      XSDBuilder xsdBuilder = new XSDBuilder();
      InputStream is = validatorStream.openStream();
      XMLSchema xmlSchema = xsdBuilder.build(is, null);
      parser.setXMLSchema(xmlSchema);
      
      URL doc = docToValidate;
      
      parser.parse(doc);              
      /* XMLDocument valid = */ parser.getDocument();   
      System.out.println(VALID_DOCUMENT + " is valid");      
    }
    catch (Exception ex)
    {
      System.out.println("Invalid...");      
      ex.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new DataValidator();
  }
}