<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- <xsl:template match="/">
		
	</xsl:template> -->
	
	<xsl:template match="@* | node()">
      <xsl:copy>
         <xsl:apply-templates select="@* | node()"/>
      </xsl:copy>
   </xsl:template>
   
   <!-- if last() is not there, then <Age> will be added after every <Item> tag. -->
   <xsl:template match="/Order/Item[last()]">
      <!-- <xsl:copy-of select="."/> -->
      <Age>34</Age>
   </xsl:template>

</xsl:stylesheet>