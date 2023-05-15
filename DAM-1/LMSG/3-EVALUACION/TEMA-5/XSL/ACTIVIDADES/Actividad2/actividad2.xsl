<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
  <html>
  <head>
  <title>Diccionario</title>
  <link rel="stylesheet" type="text/css" href="estilo2.css"/>
  </head>
  <body>
  <h1>DICCIONARIO SIMPLE</h1>
  <table>
  <tr>
  <td>IDIOMA</td>
  <td>SALUDO</td>
  <td>DESPEDIDA</td>
  </tr>
  <xsl:for-each select="Diccionario/*">
   <tr>
   <td><xsl:value-of select="name(.)"></xsl:value-of></td>
   <td><xsl:value-of select="saludo"></xsl:value-of></td>
   <td><xsl:value-of select="despedida"></xsl:value-of></td>
   </tr>
  </xsl:for-each>
  </table>
  </body>
  </html>
  
  </xsl:template>
</xsl:stylesheet>
