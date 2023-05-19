("Nombre de los jugadores nacidos antes del 90"),
for $jugador in doc("futbol")//jugador
where $jugador/año<1990
return data($jugador/nombre),

("Nombre de los equipos que hayan ganado algún mundial o algún europeo."),
for $equipos in doc("futbol")//equipo
where $equipos/c_europa>0 or $equipos/mundial>0
return data($equipos/nombre),

("Nombre de los jugadores que hayan nacido en España ordenados por año de nacimiento."),
for $jugador in doc("futbol")//jugador
where $jugador/pais="España"
order by $jugador/año
return data($jugador/nombre)