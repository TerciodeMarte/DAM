use ligatercera;

/*1.- Obtén todas las localidades en las que hay equipos en la liga.*/

select localidad from equipos group by localidad;

/*2.- Obtén cuantos partidos se han jugado, es decir, cuantos partidos tienen resultado.*/

select count(golesloc) from partidos;

/*3.- Obtén en la tabla goles cuantos goles se han marcado en total y cuantos en propia 
puerta. Realizar dos consultas, una para cada caso.*/

select count(numfila) from goles;
select sum(pp) from goles;

/*4.- Obtén los alias y nombres de equipos de los jugadores que han marcado goles. No 
deben salir repetidos los jugadores.*/
select alias,equipos.nombre from jugadores inner join equipos on equipo=codeq inner join goles on Jugador=numjug group by alias,equipos.nombre;

/*5.- Obtén cuantos centrocampistas tiene el equipo de nombre S.D. Textil Escudo.*/

select count(*) from jugadores inner join equipos on codeq=equipo where puesto='centrocampista' and equipos.nombre='S.D. Textil Escudo';

/*6.- Obtén cuantos goles en total se han obtenido en cada partido de la jornada 1 y los 
nombres de equipos que los jugaron*/
select golesloc+golesvis as Goles,l.nombre,v.nombre from partidos inner join equipos as l on l.codeq=eqloc inner join equipos as v on v.codeq=eqvis 
where numjornada=1;

/*7.a.- Obtén cuantos goles en total se marcaron en la jornada número 2.*/
select count(*) from goles group by jornada having jornada='2';

/*7.b.- Obtén cuantos goles en total se han marcado en cada jornada. En cada fila debe 
salir el número de jornada y el número total de goles.*/
select jornada,count(*) from goles group by jornada;

/*8.a.- Obtén el jugador más joven, entre los que tienen registrada fecha de nacimiento, 
del equipo de nombre S.D. Laredo. Debe salir el nombre y apellidos, el alias, el puesto 
y la fecha de nacimiento.*/

select jugadores.nombre,apellidos,alias,puesto,fechanac from jugadores 
where fechanac = (select max(fechanac) from jugadores inner join equipos on equipo = codeq where equipos.nombre = 'S.D Laredo');

/*8.b.- Obtén el jugador más joven, entre los que tienen registrada fecha de nacimiento, 
de cada equipo. Debe salir el nombre del equipo, y el nombre y apellidos, el alias, el 
puesto y la fecha de nacimiento del jugador más joven.*/

select equipos.nombre,jugadores.nombre,apellidos,alias,puesto,fechanac from jugadores inner join equipos on equipo = codeq
where numjug in (select numjug from jugadores where fechanac in (select max(fechanac) from jugadores group by equipo having max(fechanac)));


/*9.- Obtén el nombre y apellidos del jugador más joven de la liga y el equipo al que 
pertenece.*/
select jugadores.nombre,apellidos,equipos.nombre from jugadores inner join equipos on equipo = codeq
where fechanac = (select max(fechanac) from jugadores);

/*10.- Obtener en cuantos partidos la diferencia de goles entre un equipo y el otro fue 
superior a dos goles.*/
select count(*) from partidos where golesloc-golesvis>2 or golesvis-golesloc>2;
