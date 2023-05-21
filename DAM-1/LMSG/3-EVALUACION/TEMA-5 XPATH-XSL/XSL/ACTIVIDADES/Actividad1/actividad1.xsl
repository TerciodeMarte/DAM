<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>Balomano</title>
        <link rel="stylesheet" type="text/css" href="estilo1.css"/>
      </head>
      <body>
        <h1>Actividad 1</h1>
        <h2>Equipos</h2>
        <xsl:for-each select="//equipo">
          <h3>Seleccion: <xsl:value-of select="nombre"/></h3>
          <h3>Entrenador: <xsl:value-of select="entrenador"/></h3>
          <table>
            <tr>
              <th>Jugador</th>
              <th>Posición</th>
            </tr>
            <xsl:for-each select="jugadores/jugador">
              <tr>
                <td>
                  <xsl:value-of select="node()"/>
                </td>
                <td>
                  <xsl:value-of select="@posicion"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
