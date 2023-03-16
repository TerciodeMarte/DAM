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
