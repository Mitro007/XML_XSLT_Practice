<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="attachmentBytes" as="xs:base64Binary" xmlns:xs='http://www.w3.org/2001/XMLSchema' />
	
	<xsl:template match="/">
		<!-- <message><xsl:value-of select="/greeting" /></message> -->
		<out><xsl:value-of select="$attachmentBytes" /></out>
		<debug>
            <xsl:value-of select="system-property('xsl:vendor')"/>
        </debug>
	</xsl:template>

</xsl:stylesheet>