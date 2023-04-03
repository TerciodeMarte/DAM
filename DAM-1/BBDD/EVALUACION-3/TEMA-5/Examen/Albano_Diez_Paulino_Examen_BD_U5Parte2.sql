use ejercicio1;
-- Ejercicio 1

/*1. Obtén los nombres y puntos_por_partido de los jugadores de los Lakers y de los 
Clippers de la temporada 06/07, ordenados por los puntos por partido de mayor a 
menor.*/

select Nombre,Puntos_por_partido from jugadores inner join estadisticas on codigo=jugador where temporada='06/07' 
and (Nombre_equipo='Clippers' or Nombre_equipo='Lakers') order by Puntos_por_partido desc ;

/*2. Obtén los nombres de equipos y el número de partidos en los que han metido más 
de 130 puntos como visitante contra los Magic ordenados de mayor a menor por 
dicho número de partidos.
*/
select equipo_visitante,count(*) from partidos where puntos_visitante>130 group by equipo_visitante order by count(*) desc;

/*3. Obtén la ciudad del equipo que más puntos totales ha metido como local. Debes 
poner también los puntos totales y llamar a la columna “total_puntos”. */

select Ciudad,max(puntos_local) as total_puntos from partidos inner join equipos on Nombre=equipo_local group by equipo_local;

/*4. Obtén el nombre, los puntos por partido, el nombre del equipo y la temporada de 
todos los jugadores que metieron más puntos por partido que Tracy McGrady en 
la temporada 03/04 en la conferencia West (con subconsulta).*/

select max(Puntos_por_partido) from estadisticas inner join jugadores on codigo=jugador inner join equipos on equipos.Nombre=Nombre_equipo where temporada='03/04' and Conferencia='west'; -- Puntos maximos de Tracy McGrady

select Nombre,Puntos_por_partido,Nombre_equipo,temporada from estadisticas inner join jugadores on codigo=jugador where Puntos_por_partido 
>(select max(Puntos_por_partido) from estadisticas inner join jugadores on codigo=jugador inner join equipos on equipos.Nombre=Nombre_equipo where temporada='03/04' and Conferencia='west');

/*5. Obtén los nombres, y la media de puntos como local de los equipos que metieron 
en la temporada 05/06 menos puntos como local de media que los Bulls (con 
subconsulta).*/
select avg(puntos_local) from partidos where equipo_local='Bulls'; -- Media de puntos de los bulls

select equipo_local,avg(puntos_local) from partidos where temporada='05/06' and puntos_local<(select avg(puntos_local) from partidos where equipo_local='Bulls') group by equipo_local;

use ejercicio2;
-- Ejercicio 2

/*6. Muestra los nombres y apellidos de todos los usuarios que han votado a alguno de 
los grupos votados por Elsa Frutos Núñez.*/
select grupo from votos inner join canciones on cancion=numCancion inner join usuarios on usuario=user where nombre='Elsa' and apellidos='Frutos Núñez'; -- grupos votados por Elsa

select nombre,apellidos from usuarios inner join votos on usuario=user inner join canciones on numCancion=cancion 
where grupo in (select grupo from votos inner join canciones on cancion=numCancion inner join usuarios on usuario=user where nombre='Elsa' and apellidos='Frutos Núñez');

/*7. Muestra el nombre de cada grupo, la duración y el título de su canción de duración 
mayor.*/
select titulo from canciones group by grupo having max(duracion); -- Volver


/*8. Muestra en una columna el nombre seguido de los apellidos de los usuarios que han 
votado canciones en domingo.*/
select concat(nombre,' ',apellidos) as NombreApellidos from usuarios inner join votos on usuario=user where dayofweek(fecha)=1;

/*9. Muestra nombre, apellidos y fecha de nacimiento de los usuarios que cumplirán 
años el próximo mes y cuantos días han pasado desde que emitieron su último voto.*/
select nombre,apellidos,fechanac,datediff(curdate(),fecha) as Dias from usuarios inner join votos on user=usuario where month(fechanac)=month(curdate());

/*10. Muestra los nombres y apellidos separados mediante un guion medio y la fecha de 
nacimiento de los usuarios que cumplen años dentro de 3 días.*/
select concat(nombre,'-',apellidos) as Nombre_Apellidos,fechanac from usuarios where day(fechanac)=day(adddate(curdate(),interval 3 day));

/*11. Muestra los nombres de los componentes en mayúsculas, los títulos de sus 
canciones votadas con duración superior a 2 minutos y cuya longitud de caracteres 
sea inferior a 9, el nombre del usuario que las ha votado y una columna con 
anotación “larga” o “corta” en función de si la duración es menor o igual que 4 
minutos (“corta”) o si es superior (“larga”).*/
select ucase(componentes.nombre),titulo,if(duracion<=000400,'corta','larga'),usuarios.nombre,apellidos from componentes inner join grupos on grupos.codgrupo=componentes.grupo 
inner join canciones on canciones.grupo=grupos.codgrupo inner join votos on cancion=numCancion inner join usuarios on usuario=user where duracion>000200 and length(titulo)<9 ;

/*12. Muestra los datos de una canción cuyo número de canción sea igual a un único 
número obtenido aleatoriamente inferior o igual al número total de canciones.*/
set @aleatorio= round(rand()*(select count(*) from canciones));
select @aleatorio;
select * from canciones where numCancion=@aleatorio;

/*13. Muestra el título y el número de votos de la canción que más votos ha recibido. No 
se puede usar LIMIT ni ORDER BY.*/
select cancion,count(*) as voto from votos group by cancion; -- Volver despues

/*14. Muestra cuantos usuarios han emitido votos, cuantas canciones hay en la tabla 
canciones, cuantas de ellas hay de duración superior a 2 minutos y medio y cuantas 
de duración inferior o igual a 2 minutos y medio.*/
select count(distinct usuario) as usuarios from votos; -- Usuarios que han emitido votos
select count(numCancion)  as Total_Canciones from canciones; -- Canciones que hay
select count(numCancion) as Canciones_Superior from canciones where duracion>000230; -- canciones superiores a 2:30
select count(numCancion) as Canciones_Inferior from canciones where duracion<=000230; -- canciones inferiores a 2:30

select usuarios,Total_Canciones,Canciones_Superior,Canciones_Inferior from (select count(distinct usuario) as usuarios from votos) as a1,
(select count(numCancion)  as Total_Canciones from canciones)as a2,
(select count(numCancion) as Canciones_Superior from canciones where duracion>000230)as a3,
(select count(numCancion) as Canciones_Inferior from canciones where duracion<=000230) as a4;

/*15. Muestra el nombre, contraseña cifrada con MD5 de los usuarios y el número de 
votos que han emitido en total a grupos de Barcelona, Madrid o Sevilla. Se deben 
reflejar las ciudades mediante identificadores (BCN, MAD, SV respectivamente). Hay 
que usar funciones de control de flujo. No se puede usar LIMIT ni ORDER BY*/

select usuarios.nombre,md5(contraseña),count(*) as Votos from usuarios inner join votos on user=usuario inner join canciones on numCancion=cancion 
inner join grupos on codgrupo=grupo where localidad in ('Barcelona','Madrid','Sevilla') group by user ;

