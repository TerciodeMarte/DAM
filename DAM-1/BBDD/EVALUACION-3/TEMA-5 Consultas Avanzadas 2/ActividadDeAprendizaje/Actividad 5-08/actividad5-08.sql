use concursomusica;

/*1.- Obtener los nombres y apellidos de los usuarios que han votado canciones del 
grupo Lori Meyers*/

select usuarios.nombre,apellidos from usuarios inner join votos on usuario=user inner join canciones on numCancion=cancion 
inner join grupos on grupo=codgrupo where grupos.nombre="Lori Meyers";

/*2.- Obtener el título de la canción que tiene más votos. Si hay varias canciones con el 
máximo de votos, deben salir todas ellas.
Una idea para realizarlo es obtener en una subconsulta el número de votos de cada 
canción ordenado por votos descendentemente y limitada a una fila.*/

-- sin subconsulta
select titulo,count(*) from canciones inner join votos on cancion=numCancion group by numCancion order by count(*) desc limit 1;

-- con subconsulta
select titulo from canciones inner join votos on cancion=numCancion group by cancion 
having count(*)=(select count(*) from votos group by cancion order by count(*) desc limit 1);

/*3.- A partir de la tabla votos, obtener el título de todas las canciones existentes junto 
con el número total de votos que han recibido ordenadas por título de canción. 
Tienes que unir dos consultas, una que obtiene los votos de las canciones votadas y 
una que obtiene las canciones no votadas junto con cero votos.
*/
-- con left join
select titulo,count(usuario) from canciones left join votos on cancion=numCancion group by numCancion order by titulo ;
-- con union
select titulo,count(*) from canciones inner join votos on cancion=numCancion group by numCancion union 
select titulo,count(usuario) from canciones left join votos on cancion=numCancion where cancion is null group by numCancion order by titulo;

/*4.- Obtener cuantas canciones han recibido votos.*/
select count(*) from (select count(*) from votos group by cancion) as subtable;
-- La de ramiro muy guapa
select count(distinct cancion) as votadas from votos;

/*5.- Obtener los nombres, apellidos y función de los componentes que forman el 
grupo al que pertenece Jorge Guirao.*/
select nombre,apellido,funcion from componentes where grupo=(select grupo from componentes where nombre='Jorge' and apellido='Guirao');

/*6.- Obtener el nombre y apellidos del usuario registrado más joven, su edad (al 
finalizar el año actual) y los títulos de las canciones que ha votado.*/

select nombre,apellidos,(curdate()-fechanac)/10000 as edad,titulo from usuarios inner join votos on user=usuario 
inner join canciones on numCancion=cancion where user=(select user from usuarios order by (curdate()-fechanac)/10000 limit 1); 

/*7.- Obtener el nombre de cada grupo y la duración menor de sus canciones.*/
select nombre,min(duracion) from grupos inner join canciones on grupo=codgrupo group by nombre;

/*8.- Obtener el nombre de cada grupo y el título de su canción de duración menor. Para 
hacer esto requieres usar una subconsulta que genera una tabla derivada (subconsulta 
en FROM).*/
select nombre,titulo,duracion from canciones inner join grupos on codgrupo = canciones.grupo inner join
(select grupo,min(duracion) as duracion2 from canciones group by grupo) as subtable on subtable.grupo = canciones.grupo and duracion2= duracion;
