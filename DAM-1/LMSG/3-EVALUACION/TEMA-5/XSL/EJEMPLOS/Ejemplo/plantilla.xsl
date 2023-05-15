<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="UTF-8" indent="yes"/> 
<xsl:template match="/">
    <html> 
        <head>
        <title>Floristeria</title>
        <link rel="stylesheet" type="text/css" href="estilos.css"/>
        </head>
        <body>
            <div>
                <h1>Nombres</h1>
               <ul>
               <!-- Bucle for each-->
               <!--Viajo al elemento padre del XML y me recorre todos los hijos-->
              <xsl:for-each select="floristeria/flor">
              <!-- Recoje el valor de todos los elementos hijos-->
                  <li><xsl:value-of select="nombre"/></li>
              </xsl:for-each>
              </ul>
            </div>
        </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
