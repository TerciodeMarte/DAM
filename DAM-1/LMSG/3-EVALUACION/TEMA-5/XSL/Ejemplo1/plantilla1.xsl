<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
  <title>Libros</title>
  <link rel="stylesheet" type="text/css" href="estilos1.css"/>
  </head>
  <body>
  <h1>Librerias Gil(Catalogos)</h1>
  <ul>
    <xsl:for-each select="/catalogo/libro">
    <li>Título: <xsl:value-of select="titulo"/> - Editorial: <xsl:value-of select="editorial"/> </li>
    </xsl:for-each>
  </ul>
  <table>
  <tr>
  <td>Titulo</td>
  <td>Autores</td>
  <td>Editorial</td>
  </tr>
  <xsl:for-each select="//libro">
  <tr><td><xsl:value-of select="titulo"/></td><td><xsl:value-of select="autores/autor"/></td><td><xsl:value-of select="editorial"/></td></tr>
  </xsl:for-each>
  </table>
  
  </body>
  </html>
 
  </xsl:template>
</xsl:stylesheet>
