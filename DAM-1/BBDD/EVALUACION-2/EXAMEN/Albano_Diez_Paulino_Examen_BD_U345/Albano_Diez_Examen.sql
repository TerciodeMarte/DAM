/* Ejericio 1 */

-- Apartado b

select current_user();

-- Apartado c

show grants for 'AlbanoDiez'@'192.168.24.%';

-- Apartado d

create user 'ADP_EXAMEN'@'192.168.24.%' identified by '72204754';
create user 'ADP2_EXAMEN'@'192.168.24.%' identified by '72204754';

-- Apartado e

grant select on examen1.ejercicio1 to 'ADP_EXAMEN'@'192.168.24.%';
grant select on examen1.ejercicio1 to 'ADP2_EXAMEN'@'192.168.24.%';

-- Apartado f

drop user 'ADP2'@'192.168.24.%';

/*Ejercicio2*/
use ejercicio2;
-- Apartado C/A
select Nombre,Altura,Posicion,Nombre_equipo from jugadores where Posicion="G" order by Altura desc limit 5;

-- Apartado C/b

select equipo_local,equipo_visitante,puntos_local from partidos where equipo_local in ("Kings","Lakers","Clipers","Warriors") order by puntos_local desc limit 10;

-- Apartado C/c

select jugadores.Nombre,Nombre_equipo,Ciudad from jugadores inner join equipos on Nombre_equipo=equipos.Nombre where Ciudad in ("Miami","Orlando");

-- Apartado C/d

select jugadores.Nombre,temporada,Tapones_por_partido from estadisticas inner join jugadores on codigo=jugador 
inner join equipos on equipos.Nombre=Nombre_equipo where temporada="01/02" and Conferencia="East" order by Tapones_por_partido desc limit 10;

-- Aparatdo C/e
select l.Nombre as Local,v.Nombre as Visitante from equipos as l,equipos as v where l.Nombre!=v.Nombre and l.Division="Central" and v.Division="Central";

-- Apartado D

insert entrega.tabla3 values (1,"select Nombre,Altura,Posicion,Nombre_equipo from jugadores where Posicion='G' order by Altura desc limit 5;
select equipo_local,equipo_visitante,puntos_local from partidos where equipo_local in ('Kings','Lakers','Clipers','Warriors') order by puntos_local desc limit 10;
select jugadores.Nombre,Nombre_equipo,Ciudad from jugadores inner join equipos on Nombre_equipo=equipos.Nombre where Ciudad in ('Miami','Orlando');
select jugadores.Nombre,temporada,Tapones_por_partido from estadisticas inner join jugadores on codigo=jugador 
inner join equipos on equipos.Nombre=Nombre_equipo where temporada='01/02' and Conferencia='East' order by Tapones_por_partido desc limit 10;
select l.Nombre as Local,v.Nombre as Visitante from equipos as l,equipos as v where l.Nombre!=v.Nombre and l.Division='Central' and v.Division='Central';");

/*Ejercicio 3*/
use ejercicio3;

-- Apartado C/a
select nombre from grupos inner join canciones on codgrupo=grupo inner join votos on cancion=numCancion where usuario like '02%';

-- Apartado C/b
select apellidos,fechanac,titulo from usuarios inner join votos on usuario=user inner join canciones on numCancion=cancion where year(fechanac)>1995;

-- Apartado C/c

select componentes.nombre,titulo,usuario,duracion from componentes inner join grupos on codgrupo=componentes.grupo inner join canciones on canciones.grupo=codgrupo 
inner join votos on cancion=numCancion where duracion>000200;

-- Apartado C/d

select componentes.nombre,titulo,usuario,duracion from componentes inner join grupos on codgrupo=componentes.grupo inner join canciones on canciones.grupo=codgrupo 
inner join votos on cancion=numCancion where duracion>000200 and duracion<000400;

-- Apartado C/e

Select titulo,usuario,fecha,cancion from canciones left join votos on cancion=numCancion;

-- Apartado E
insert entrega.tabla3(solucion) values("
use ejercicio3;
select nombre from grupos inner join canciones on codgrupo=grupo inner join votos on cancion=numCancion where usuario like '02%';
select apellidos,fechanac,titulo from usuarios inner join votos on usuario=user inner join canciones on numCancion=cancion where year(fechanac)>1995;
select componentes.nombre,titulo,usuario,duracion from componentes inner join grupos on codgrupo=componentes.grupo inner join canciones on canciones.grupo=codgrupo 
inner join votos on cancion=numCancion where duracion>000200;
select componentes.nombre,titulo,usuario,duracion from componentes inner join grupos on codgrupo=componentes.grupo inner join canciones on canciones.grupo=codgrupo 
inner join votos on cancion=numCancion where duracion>000200 and duracion<000400;
Select titulo,usuario,fecha,cancion from canciones left join votos on cancion=numCancion;");



