<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:fox="http://xml.apache.org/fop/extensions" 
                version="1.0">
  <xsl:template match="/">
    <fo:root>
      <fo:layout-master-set>
        <fo:simple-page-master master-name="my-page"
                               page-width="8.5in"
                               page-height="11in">
          <fo:region-body margin="0in"/>
          <fo:region-after region-name="footer" extent="20mm"/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="my-page">
        <!--fo:static-content flow-name="footer">
          <fo:block text-align="center">Page <fo:page-number/> of <fo:page-number-citation ref-id="last-page"/></fo:block>
        </fo:static-content-->
        <fo:flow flow-name="xsl-region-body">
          <fo:block break-after="page"> <!-- background-image="url('bg.jpg')"-->
            <fo:block text-align="center" font-family="Book Antiqua" font-size="60pt" font-weight="bold" margin="1in">
              Fax Schedule
            </fo:block>
            <fo:block text-align="center">
              <!--fo:external-graphic src="url('./WeatherFax.jpg')"/-->
              <fo:external-graphic src="url('./clipper.jpg')"/>
            </fo:block>
            <fo:block text-align="left" font-family="Times" font-size="11pt" font-style="italic" margin="1in">
              &#169; Oliv Cool Stuff Soft  
            </fo:block>
          </fo:block>
          <fo:block margin="1in">
            <xsl:for-each select="/schedule-root">
              <xsl:apply-templates select="."/>
            </xsl:for-each>
          </fo:block>
          <!--fo:block id="last-page"/-->
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  
  <xsl:template match="schedule-root">
    <fo:block text-align="center" font-family="Courier" font-size="6pt" break-after="page">
      <fo:table border="0.5pt solid black">
        <fo:table-column column-width="0.5in"/>
        <fo:table-column column-width="0.7in"/>
        <fo:table-column column-width="0.7in"/>
        <fo:table-column column-width="0.7in"/>
        <fo:table-column column-width="4in"/>
        <fo:table-header>
          <fo:table-row>
            <fo:table-cell number-columns-spanned="1" padding="medium" border="0.5pt solid black"><fo:block text-align="center" font-weight="bold" font-family="Times" font-size="7pt"></fo:block></fo:table-cell>
            <fo:table-cell number-columns-spanned="1" padding="medium" border="0.5pt solid black"><fo:block text-align="center" font-weight="bold" font-family="Times" font-size="7pt">Starts</fo:block></fo:table-cell>
            <fo:table-cell number-columns-spanned="1" padding="medium" border="0.5pt solid black"><fo:block text-align="center" font-weight="bold" font-family="Times" font-size="7pt">Stop</fo:block></fo:table-cell>
            <fo:table-cell number-columns-spanned="1" padding="medium" border="0.5pt solid black"><fo:block text-align="center" font-weight="bold" font-family="Times" font-size="7pt">Freq</fo:block></fo:table-cell>
            <fo:table-cell number-columns-spanned="1" padding="medium" border="0.5pt solid black"><fo:block text-align="left" font-weight="bold" font-family="Times" font-size="7pt">Content</fo:block></fo:table-cell>
          </fo:table-row>
        </fo:table-header>
        <fo:table-body>
          <xsl:for-each select="./bulletin">
            <xsl:sort select="./@starts" data-type="string" order="ascending"/>
            <!--xsl:apply-templates select="."/-->
				    <fo:table-row>
				      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="position()"/></fo:block></fo:table-cell>
				      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@starts"/></fo:block></fo:table-cell>
				      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@stops"/></fo:block></fo:table-cell>
				      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@freq"/></fo:block></fo:table-cell>
				      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="left"><xsl:value-of select="./@content"/></fo:block></fo:table-cell>
				    </fo:table-row>
          </xsl:for-each>
        </fo:table-body>
        <!--fo:table-footer>
          That's it
        </fo:table-footer-->
      </fo:table>
    </fo:block>
  </xsl:template>

  <xsl:template match="bulletin">
    <fo:table-row>
      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="position()"/></fo:block></fo:table-cell>
      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@starts"/></fo:block></fo:table-cell>
      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@stops"/></fo:block></fo:table-cell>
      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="center"><xsl:value-of select="./@freq"/></fo:block></fo:table-cell>
      <fo:table-cell padding="medium" border="0.5pt solid black"><fo:block text-align="left"><xsl:value-of select="./@content"/></fo:block></fo:table-cell>
    </fo:table-row>
  </xsl:template>
  
</xsl:stylesheet>
