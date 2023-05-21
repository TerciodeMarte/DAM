/*ACTIVIDAD 5-03
ALBANO DÍEZ DE PAULINO
19/02/2023*/
use nba;

/*1.- Obtén temporada, nombre, nombre de equipo y puntos por partido de todos los 
jugadores de la NBA de procedencia española.*/
select temporada,Nombre,Nombre_equipo,Puntos_por_partido from jugadores inner join estadisticas on codigo=jugador where Procedencia="Spain";

/*2.- Consigue todos los cruces posibles entre equipos de la división Pacífico (el equipo 
visitante y el local no pueden ser el mismo) usando producto cartesiano.*/
select l.Nombre as Local,v.Nombre as Visitante from equipos as l,equipos as v 
where l.Division="Pacific" and v.Division="Pacific"  and l.Nombre!=v.Nombre;

/*3.- Consigue los nombres, temporada y puntos por partido de los 5 jugadores de la 
división Pacífico que más puntos por partido han metido.*/
select jugadores.Nombre,temporada,Puntos_por_partido,Division from jugadores inner join estadisticas on codigo=jugador 
inner join equipos on Nombre_equipo=equipos.Nombre where Division="Pacific" order by Puntos_por_partido desc limit 5;

/*4.- Obtén el nombre, temporada, equipo y estadísticas de los jugadores de los Knicks 
de la temporada 07/08 ordenados por puntos por partido.*/
select jugadores.Nombre,temporada,Nombre_equipo,Puntos_por_partido,Asistencias_por_partido,Tapones_por_partido,Rebotes_por_partido
from jugadores inner join estadisticas on jugador=codigo where Nombre_equipo="Knicks" 
and temporada="07/08" order by Puntos_por_partido desc;

/*5.- ¿Quien es el jugador que más asistencias ha dado en un equipo de California? 
(Pista: Ciudades de California con equipo: Sacramento, Los Ángeles y Golden State)*/
select jugadores.Nombre,Asistencias_por_partido,Ciudad from jugadores inner join estadisticas on codigo=jugador 
inner join equipos on equipos.Nombre=Nombre_equipo where Ciudad in ("Sacramento","Los Angeles","Golden State") 
order by Asistencias_por_partido desc limit 1;

/*6.- Obtén el equipo local, el equipo visitante, puntos local, puntos visitante y 
temporada de los enfrentamientos entre equipos de la división Central.*/

select l.Nombre as Local, v.Nombre as Visitante, puntos_local,puntos_visitante,temporada,l.Division,v.Division from partidos inner join equipos as l 
on equipo_local=l.Nombre inner join equipos as v on equipo_visitante=v.Nombre where l.Division="Central" and v.Division="Central";

/*7.- ¿De qué ciudad es el equipo que más puntos ha anotado como local (hay muchos 
empatados)? ¿Y el que menos?*/
select Nombre,Ciudad,puntos_local,temporada from partidos inner join equipos on equipo_local=Nombre order by puntos_local desc,equipo_local asc limit 1;
select Nombre,Ciudad,puntos_local,temporada from partidos inner join equipos on equipo_local=Nombre order by puntos_local,equipo_local asc limit 1;

/*8.- Obtén el equipo y la ciudad del jugador con más rebotes de la conferencia este*/
select Nombre_equipo,Procedencia,Rebotes_por_partido,Conferencia from jugadores inner join estadisticas on jugador=codigo 
inner join equipos on equipos.Nombre=Nombre_equipo where Conferencia="East" order by Rebotes_por_partido desc limit 1;