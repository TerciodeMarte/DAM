<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="utf-8" indent="yes"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>Actividad4b</title>
        <link rel="stylesheet" type="text/css" href="estilo4b.css"/>
      </head>
      <body>
        <h1>Alumnos</h1>
        <h2>Convocatoria: <xsl:value-of select="//alumno[@convocatoria='Junio']/@convocatoria"/> </h2>
        <table>
          <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Nota final</th>
            <th>Calificacion</th>
          </tr>
          <xsl:for-each select="//alumno[@convocatoria='Junio']">
            <tr>
              <td>
                <xsl:value-of select="nombre"/>
              </td>
              <td>
                <xsl:value-of select="apellidos"/>
              </td>
              <td>
                <xsl:value-of select="final"/>
              </td>
              <xsl:if test=" final &gt; 9 ">
                <td>Sobresaliente</td>
              </xsl:if>
              <xsl:if test=" final &gt; 7 and final &lt; 9 ">
                <td>Notable</td>
              </xsl:if>
              <xsl:if test=" final &gt; 6 and final &lt; 7 ">
                <td>Bien</td>
              </xsl:if>
              <xsl:if test=" final &gt; 5 and final &lt; 6 ">
                <td>Aprobado</td>
              </xsl:if>
              <xsl:if test="final &lt; 5 ">
                <td>Suspendido</td>
              </xsl:if>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
