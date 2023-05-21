<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
    <!--> Tabla con el título del libro,autores y editorial de los libros del autor Miguel Angel.<-->
    <!--> Lista con el título de los libros y su año de publicación, de los libros publicados en el 2018 
o años posteriores.<-->
    <html>
      <head>
        <title>Libreria</title>
        <link rel="stylesheet" type="text/css" href="estilos1b.css"/>
      </head>
      <body>
        <h1>Libreria Melendez</h1>
        <ul>
          <xsl:for-each select="//libro[año&gt;2018]">
            <li>Titulo: <xsl:value-of select="titulo"/> - Año de Publicacion: <xsl:value-of select="año"/></li>
          </xsl:for-each>
        </ul>
        <table>
        <tr><td>Titulo</td><td>Autor</td><td>editorial</td></tr>
        <xsl:for-each select="//libro[autores/autor='Miguel Angel']">
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
