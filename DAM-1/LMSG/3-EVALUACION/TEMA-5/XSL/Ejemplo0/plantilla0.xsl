<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
<xsl:output method="html" encoding="UTF-8" indent="yes"/>
<xsl:template match="/">
<html>
<head>
<title>Catalogo</title>
<link rel="stylesheet" type="text/css" href="Ej0.css"/>
</head>
<body>
<div>
<br></br>
<h1>Lista Cantantes</h1>
<ul>
<xsl:for-each select="catalogo/disco">
<li><xsl:value-of select="cantante"/></li>
</xsl:for-each>
</ul>
<h1>Tabla con el título, nombre del cantante y año de publicación</h1>
<table>
<tr><td>Título</td><td>Nombre</td><td>Año</td></tr>
<xsl:for-each select="catalogo/disco">
<tr><td><xsl:value-of select="titulo"/></td><td><xsl:value-of select="cantante"/></td><td><xsl:value-of select="año"/></td></tr>
</xsl:for-each>
</table>
<br></br>
</div>
</body>
</html>
</xsl:template>
</xsl:stylesheet>