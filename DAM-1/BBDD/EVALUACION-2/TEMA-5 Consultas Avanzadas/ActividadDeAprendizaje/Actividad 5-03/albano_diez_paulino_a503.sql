/*ACTIVIDAD 5-03
ALBANO DÍEZ DE PAULINO
19/02/2023*/
use ligatercera;

/*1.- Obtén los nombres, apellidos y alias de los jugadores del equipo de nombre S.D.
TEXTIL ESCUDO realizando un producto cartesiano entre las tablas jugadores y 
equipos.
*/

select jugadores.nombre,apellidos,alias,equipos.nombre from equipos,jugadores where equipo=codeq and equipos.nombre="S.D. TEXTIL ESCUDO";

/*2.- Obtén el resultado del producto cartesiano completo entre la tabla equipos y la 
misma tabla equipos. Hay que hacer un renombrado en las dos tablas.*/

select * from equipos as Local , equipos as Visitante;

/*3.- Sobre la consulta anterior, establece que en el resultado salga una columna con el 
nombre de equipo local y otra con el nombre del equipo visitante y que en cada fila no 
se pueda repetir el equipo, es decir, que el nombre del equipo local no puede ser igual 
al nombre del equipo visitante.
¿Cómo se obtendría el mismo resultado usando INNER JOIN?
*/
select Local.nombre as Local,Visitante.nombre as Visitante from equipos as Local , equipos as Visitante 
where Local.nombre!=Visitante.nombre;

-- Con inner join

select Local.nombre as Local,Visitante.nombre as Visitante from equipos as Local inner join equipos as Visitante 
on Local.nombre!=Visitante.nombre;

/*4.- Obtén los datos de todos los porteros de la liga junto con el nombre de los equipos 
en los que juegan.*/

select numjug,alias,jugadores.nombre,apellidos,fechanac,goles,tarj_amarillas,tarj_rojas,puesto,equipos.nombre 
from jugadores inner join equipos 
on equipo=codeq where puesto="portero";

/*5.- Obtén los datos de la clasificación escribiendo el nombre de cada equipo y no su 
código. La clasificación debe salir ordenada descendentemente por puntos y, a 
igualdad de puntos, por diferencia de goles.
*/
select nombre,pj,pg,pe,gf,gc,puntos from clasificacion inner join equipos on clasificacion.codeq=equipos.codeq order by puntos,(gf-gc) desc;
-- Tabla clasificacion con datos a 0 no puedo comprobar el correcto funcionamiento del este select
-- He preguntado a mis compañeros si tenian el mismo problema que yo,para saber si estoy haciendo mal el importado de la base
-- Y tienen el mismo problema que yo, asi que el fallo no esta en mi. 

/*6.- Obtén los datos de la clasificación de los cuatro primeros clasificados en la liga, 
escribiendo el nombre de cada equipo y no su código.*/
select nombre,pj,pg,pe,gf,gc,puntos from clasificacion inner join equipos on clasificacion.codeq=equipos.codeq 
order by puntos,(gf-gc) desc limit 4;

-- Lo mismo que el 5

/*7.- Obtén los datos de la clasificación de los equipos de Torrelavega, Santander o 
Laredo, escribiendo el nombre de cada equipo y no su código*/
select nombre,pj,pg,pe,gf,gc,puntos from clasificacion inner join equipos on clasificacion.codeq=equipos.codeq 
where localidad="Torrelavega" or localidad="Santander" or localidad="Laredo" ;

/*8.- Obtén los resultados que ha obtenido el Club Deportivo Cayón jugando como local*/

select numjornada,numpartido,eqloc,eqvis,golesloc,golesvis,fecha from partidos inner join equipos on eqloc=codeq 
where nombre="Club Deportivo Cayón";
-- No necesito hacer un select con inner join si se el identificador del club "CAY"
select numjornada,numpartido,eqloc,eqvis,golesloc,golesvis,fecha from partidos where eqloc="CAY";

/*9.- De todos los jugadores que han metido algún gol, obtener el nombre del jugador, el 
nombre del equipo, la jornada y si lo ha metido o no en propia puerta.*/
select jugadores.nombre,apellidos,equipos.nombre,jornada,pp from goles inner join jugadores on Jugador=numjug 
inner join equipos on equipo=codeq;

/*10.- Obtén los resultados de los partidos jugados en agosto, escribiendo los nombres 
de los equipos y no sus códigos.*/

select numjornada, numpartido, x.nombre as Local, y.nombre as Visitante, golesloc, golesvis, fecha from partidos,equipos as x, equipos as y 
where x.codeq= eqloc and y.codeq=eqvis and fecha like '%-08-%';

