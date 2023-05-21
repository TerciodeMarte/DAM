("Nombre de las flores cuya temporada sea el verano "),
for $flor in doc("Floristeria")//flor
where $flor/temporada="Verano"
return data($flor/nombre),

("Nombre de las flores de españa cuyo nº lote sea menor de 200"),
for $flor in doc("Floristeria")//flor
where $flor/origen="España" and $flor/origen/@nLote<200
return data($flor/nombre),

("Precio de las flores cuya temporada sea la primavera o de origen Italiano"),

for $flor in doc("Floristeria")//flor
where $flor/temporada="Primavera" or $flor/origen="Italia"
return data($flor/precio)