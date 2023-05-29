<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>EXAMEN XSL</title>
        <link rel="stylesheet" type="text/css" href="examen.css"/>
      </head>
      <body>
        <h1>Lista del título, número de páginas</h1>
        <ul>
          <xsl:for-each select="//libro">
            <li><xsl:value-of select="titulo"/> - <xsl:value-of select="paginas"/></li>
          </xsl:for-each>
        </ul>
        <h1>Titulo autores y editorial</h1>
        <div id="tabla">
          <table>
            <tr>
              <th>Titulo</th>
              <th>Autores</th>
              <th>Editorial</th>
            </tr>
            <xsl:for-each select="//libro">
              <tr>
                <td>
                  <xsl:value-of select="titulo"/>
                </td>
                <td>
                  <xsl:for-each select="autores/autor">
                    <xsl:value-of select="text()"/>
                  </xsl:for-each>
                </td>
                <td>
                  <xsl:value-of select="editorial"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
        </div>
        <h1>Lista del título, número de páginas Ejercicio 2</h1>
        <ul>
          <xsl:for-each select="//libro[paginas&gt;512]">
            <li><xsl:value-of select="titulo"/> - <xsl:value-of select="paginas"/></li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
