<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>
  <xsl:template match="/">
    <html> 
      <header>
        <link rel="stylesheet" href="print.css" type="text/css"/>
        <title>Fax Schedule</title>
      </header>
      <script type="text/javascript">
      <![CDATA[
function getTimeZone()
{
  var visitortime = new Date();
  document.write('<input type="hidden" name="x-VisitorTimeZoneOffset" ');
  if (visitortime) 
  {
    document.write('value="' + visitortime.getTimezoneOffset()/60 + '">');
  }
  else 
  {
    document.write('value="JavaScript not Date() enabled">');
  }   
}  
var offset = 0;

function displayTimeZone()
{
  var visitortime = new Date();
  if (visitortime) 
  {
    var loc = document.location.toString();
    var i = loc.indexOf("?offset=");
    var userOffset = false;
    if (i > -1)
      userOffset = true;

    offset = visitortime.getTimezoneOffset()/60;
    document.write('Computer Time Zone: UTC' + (offset>0?'-':'+') + Math.abs(offset));
	
	if (userOffset)
	{
	  offset =  loc.substr(8 + i); // 8=len("?offset=")
	}
  }
}
function calculateLocalTime(gmtTime)
{
  hours = gmtTime.substring(0, gmtTime.indexOf(':'));
  minutes = gmtTime.substring(gmtTime.indexOf(':') + 1);
  h = parseInt(hours);
  newH = h - offset;
//alert("Hour:" + h + " + ", becomes " + newH);
  while (newH > 24) newH -= 24;
  while (newH < 0) newH += 24;
//alert("-- Hour:" + h + " + ", becomes " + newH);
  document.write(newH + ':' + minutes);
}
function setOffsetTo(val)
{
//alert('Offset set to ' + (-val));
  offset = -val;
  this.location = "schedule.html?offset=" + offset;
}      
      ]]>
      </script>
      <body>
        <h1>Fax Schedule</h1>
        <script type="text/javascript">
        displayTimeZone();
        </script>
        <br/>
        All times are UTC, unless specified otherwise.
        <p style="background-color : #8caae6;">
          <small>
            The <b>Starts</b> element is the actual start of the transmission.
            <br/>
            The Fax program will search for start tone, beginning two minutes 
            <b>before</b> the listed start time, if not found by the stop time then 
            fax is aborted.
            <br/>
            In other words, the stop is not the end of the transmission.
            <br/>
            <i>Example:</i>
            <br/>
            If you have :
            <pre>
              Starts 10:00
              Stops  10:03
            </pre>
            the fax program will be searching for the start signal at 09:58.
            If the start signal is found before 10:03, the fax will be received 
            completely, finished with a stop signal.
            If no start signal has been received by 10:03, then the fax is 
            aborted.  
          </small>
        </p>
        <table width="100%" border="0">
	     <tr>
		   <th></th>
		   <th></th>
           <th>
		     <select name="utc-offset" onChange="javascript:setOffsetTo(this.value);">
			   <script type="text/javascript">
                           <![CDATA[
			     for (i=-12; i<=12; i++)
                             {
			       var label = "" + i;
			       if (i >= 0)
			         label = "UTC+" + i;
                               else
			         label = "UTC" + i;
			       document.write('<option value="' + i + '"' + (i==(-offset)?' selected="y"':'') + '>' + label + '</option>\n');
                             }
                           ]]>
			   </script>
			 </select>
		   </th>
		   <th></th>
		   <th></th>
		   <th></th>
	      </tr>
          <tr>
            <th></th>
            <th>Starts</th>
            <th><i><script type="text/javascript">document.write('UTC' + (offset>0?'-':'+') + Math.abs(offset));</script></i></th>
            <th>Stops</th>
            <th>Freq</th>
            <th align="left">Content</th>
          </tr>
          <xsl:for-each select="//bulletin">
            <xsl:sort select="./@starts" data-type="string" order="ascending"/>            
            <tr>
              <xsl:choose>
                <xsl:when test="position() mod 2 = 1">
                  <xsl:attribute name="style">background-color : #c0c0c0;</xsl:attribute>
                </xsl:when>
                <xsl:otherwise>
                </xsl:otherwise>
              </xsl:choose>
              <td align="center"><xsl:value-of select="position()"/></td>
              <td align="center"><xsl:value-of select="@starts"/></td>
              <td align="center"><script type="text/javascript">calculateLocalTime('<xsl:value-of select="@starts"/>');</script></td>
              <td align="center"><xsl:value-of select="@stops"/></td>
              <td align="center"><xsl:value-of select="@freq"/></td>
              <td align="left"><xsl:value-of select="@content"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
      <hr/>
      <address>&#169; 2007, Oliv Cool Stuff Soft</address>
    </html>
  </xsl:template>
</xsl:stylesheet>
