<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="utf-8" indent="yes"/>
  <!-- Lista con el nombre y la raza de los perros cuyo id igual a P02 o igual a P04.-->
  <!--Tabla con el nombre raza y peso de los perros con un peso superior a 10 kg..-->
  <xsl:template match="/">
    <html>
      <head>
        <title>Protectora</title>
        <link rel="stylesheet" type="text/css" href="estilos2.css"/>
      </head>
      <body>
        <h1>Protectora</h1>
        <ul>
          <xsl:for-each select="//perro[@id='P02' or @id='P04']">
            <li>Nombre: <xsl:value-of select="nombre"/> - Raza: <xsl:value-of select="raza"/> </li>
          </xsl:for-each>
        </ul>
        <table>
          <tr>
            <td>Nombre</td>
            <td>Raza</td>
            <td>Peso</td>
          </tr>
          <xsl:for-each select="//perro[peso&gt;10]">
            <tr>
              <td>
                <xsl:value-of select="nombre"/>
              </td>
              <td>
                <xsl:value-of select="raza"/>
              </td>
              <td>
                <xsl:value-of select="peso"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
