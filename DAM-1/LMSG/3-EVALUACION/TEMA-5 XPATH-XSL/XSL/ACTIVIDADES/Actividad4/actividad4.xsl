<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
  <html>
  <head>
  <title>Actividad4</title>
  <link rel="stylesheet" type="text/css" href="estilo4.css"></link>
  </head>
  <body>
  <h1>Alumnos</h1>
  <ul>
  <xsl:for-each select="//alumno">
  <li><xsl:value-of select="concat(nombre,' ',apellidos)"></xsl:value-of></li>
  </xsl:for-each>
  </ul>
  </body>
  </html>
  
  </xsl:template>
</xsl:stylesheet>
