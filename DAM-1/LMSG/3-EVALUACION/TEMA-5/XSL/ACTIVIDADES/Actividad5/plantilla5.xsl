<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
  <html>
  <head>
  <title>Actividad5</title>
  <link rel="stylesheet" type="text/css" href="estilo5.css"></link>
  </head>
  <body>
  <h1>Lista del Título, número de páginas</h1>
  <ul>
  <xsl:for-each select="//libro">
  <li><xsl:value-of select="titulo"></xsl:value-of> - <xsl:value-of select="paginas"></xsl:value-of></li>
  </xsl:for-each>
  </ul>
  <h1>Titulo autores y editorial</h1>
  <table>
  <tr>
  <th>Titulo</th>
  <th>Autores</th>
  <th>Editorial</th>
  </tr>
  <xsl:for-each select="//libro">
  <tr>
  <td><xsl:value-of select="titulo"></xsl:value-of></td>
  <td><xsl:value-of select="autores/autor"></xsl:value-of></td>
  <td><xsl:value-of select="editorial"></xsl:value-of></td>
  </tr>
  </xsl:for-each>
  </table>
  </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
