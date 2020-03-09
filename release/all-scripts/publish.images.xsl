<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xsl:stylesheet [
 <!ENTITY copy    "&#169;">
 <!ENTITY deg     "&#176;">
 <!ENTITY plusmn  "&#177;">
 <!ENTITY Delta   "&#916;">
 <!ENTITY delta   "&#948;">
 <!ENTITY epsilon "&#949;">
 <!ENTITY psi     "&#968;">
 <!ENTITY micro   "&#181;">
 <!ENTITY pi      "&#960;">
 <!ENTITY Pi      "&#928;">
 <!ENTITY frac12  "&#189;">
 <!ENTITY Agrave  "&#192;">
 <!ENTITY Aacute  "&#193;">
 <!ENTITY Acirc   "&#194;">
 <!ENTITY Atilde  "&#195;">
 <!ENTITY Auml    "&#196;">
 <!ENTITY Aring   "&#197;">
 <!ENTITY AElig   "&#198;">
 <!ENTITY Ccedil  "&#199;">
 <!ENTITY Egrave  "&#200;">
 <!ENTITY Eacute  "&#201;">
 <!ENTITY Ecirc   "&#202;">
 <!ENTITY Euml    "&#203;">
 <!ENTITY Igrave  "&#204;">
 <!ENTITY Iacute  "&#205;">
 <!ENTITY Icirc   "&#206;">
 <!ENTITY Iuml    "&#207;">
 <!ENTITY ETH     "&#208;">
 <!ENTITY Ntilde  "&#209;">
 <!ENTITY Ograve  "&#210;">
 <!ENTITY Oacute  "&#211;">
 <!ENTITY Ocirc   "&#212;">
 <!ENTITY Otilde  "&#213;">
 <!ENTITY Ouml    "&#214;">
 <!ENTITY times   "&#215;">
 <!ENTITY Oslash  "&#216;">
 <!ENTITY Ugrave  "&#217;">
 <!ENTITY Uacute  "&#218;">
 <!ENTITY Ucirc   "&#219;">
 <!ENTITY Uuml    "&#220;">
 <!ENTITY Yacute  "&#221;">
 <!ENTITY THORN   "&#222;">
 <!ENTITY szlig   "&#223;">
 <!ENTITY agrave  "&#224;">
 <!ENTITY aacute  "&#225;">
 <!ENTITY acirc   "&#226;">
 <!ENTITY atilde  "&#227;">
 <!ENTITY auml    "&#228;">
 <!ENTITY aring   "&#229;">
 <!ENTITY aelig   "&#230;">
 <!ENTITY ccedil  "&#231;">
 <!ENTITY egrave  "&#232;">
 <!ENTITY eacute  "&#233;">
 <!ENTITY ecirc   "&#234;">
 <!ENTITY euml    "&#235;">
 <!ENTITY igrave  "&#236;">
 <!ENTITY iacute  "&#237;">
 <!ENTITY icirc   "&#238;">
 <!ENTITY iuml    "&#239;">
 <!ENTITY eth     "&#240;">
 <!ENTITY ntilde  "&#241;">
 <!ENTITY ograve  "&#242;">
 <!ENTITY oacute  "&#243;">
 <!ENTITY ocirc   "&#244;">
 <!ENTITY otilde  "&#245;">
 <!ENTITY ouml    "&#246;">
 <!ENTITY divide  "&#247;">
 <!ENTITY oslash  "&#248;">
 <!ENTITY ugrave  "&#249;">
 <!ENTITY uacute  "&#250;">
 <!ENTITY ucirc   "&#251;">
 <!ENTITY uuml    "&#252;">
 <!ENTITY yacute  "&#253;">  
]>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                version="2.0">
  <xsl:output method="xml" indent="yes"/>
  <xsl:param name="doc-title">Composites Archive</xsl:param>
  <xsl:template match="/">
    <fo:root>
      <fo:layout-master-set>
        <fo:simple-page-master master-name="portrait-page" page-width="8.5in"
                               page-height="11in">
          <!-- Portrait -->
          <fo:region-body margin="0in"/>
          <fo:region-after region-name="footer" extent="10mm"/>
        </fo:simple-page-master>
        <fo:simple-page-master master-name="landscape-page" page-height="8.5in"
                               page-width="11in">
          <!-- Portrait -->
          <fo:region-body margin="0in"/>
          <fo:region-after region-name="footer" extent="10mm"/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="portrait-page">
        <!-- landscape-page or portrait-page -->
        <fo:static-content flow-name="footer">
          <!--fo:block text-align="center">Page <fo:page-number/> of <fo:page-number-citation ref-id="last-page"/></fo:block-->
          <fo:block text-align="center" font-size="8pt">
            Page
            <fo:page-number/>
            of
            <fo:page-number-citation ref-id="last-page"/>
          </fo:block>
        </fo:static-content>
        <fo:flow flow-name="xsl-region-body">
          <fo:block break-after="page">
            <!-- background-image="url('bg.jpg')"-->
            <!-- First Page -->
            <fo:block text-align="center" font-family="Book Antiqua" margin-top="1.5in"           
                      font-size="30pt" font-weight="bold" margin="0.5in">Composites</fo:block>
            <fo:block text-align="center" font-family="Book Antiqua"            
                      font-size="40pt" font-weight="bold" margin="0.5in"><xsl:value-of select="$doc-title"/></fo:block>
            <fo:block text-align="left" font-family="Book Antiqua" margin-bottom="1.5in"                              
                      font-size="10pt" font-weight="bold" margin="0.5in">by Oliv Soft</fo:block>
          </fo:block>
          <!-- Data go here -->
          <fo:block margin="0.01in">
            <xsl:for-each select="//file">
              <xsl:apply-templates select="."/>
            </xsl:for-each>
          </fo:block>
          <fo:block id="last-page"/>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  
  <xsl:template match="file">
    <fo:block text-align="center" font-family="Courier" font-size="8pt"
              break-after="page" margin="0.1in">
      <fo:block text-align="left" font-family="Book Antiqua" font-size="8pt"
                font-weight="normal" margin="0.1in">
        <xsl:value-of select="./@date"/>, <xsl:value-of select="./@comment"/>
      </fo:block>
      <fo:block text-align="center">
        <fo:external-graphic keep-together.within-page="2">
          <!--  src="url('sextant.gif')"/> -->
          <xsl:variable name="url" select="./@path"/>
          <xsl:attribute name="src">
            <xsl:value-of select="concat('url(', $url, ')')" disable-output-escaping="yes"/>
          </xsl:attribute>
        </fo:external-graphic>
      </fo:block>
    </fo:block>
  </xsl:template>
  
</xsl:stylesheet>
