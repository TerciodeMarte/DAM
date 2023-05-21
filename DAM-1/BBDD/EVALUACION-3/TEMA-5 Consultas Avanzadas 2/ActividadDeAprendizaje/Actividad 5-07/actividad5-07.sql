use concursomusica;
/*1.- A partir del contenido de la tabla votos, obtén cuántos votos tiene cada canción que 
ha sido votada. Se deben mostrar los títulos de las canciones, los nombres de los grupos 
a los que pertenecen las canciones y el número de votos.
*/

select titulo,nombre,count(*) from votos inner join canciones on cancion=numCancion 
inner join grupos on grupo=codgrupo group by numCancion;

/*2.- A partir de la consulta anterior, obtén los títulos de las 8 canciones más votadas*/
select titulo,nombre,count(*) from votos inner join canciones on cancion=numCancion 
inner join grupos on grupo=codgrupo group by numCancion order by count(*) desc limit 8;

/*3.- Obtén el título de todas las canciones que han recibido más votos que la canción 
titulada No gires, el número de votos recibidos y el nombre del grupo al que 
pertenecen.*/

select titulo,nombre,count(*) from votos inner join canciones on cancion=numCancion 
inner join grupos on grupo=codgrupo group by numCancion 
having count(*)>(select count(*) from votos inner join canciones on cancion=numCancion 
where titulo='No gires');


/*4.- Obtén los títulos de las canciones que no han recibido aún votos (los de las 
canciones que no están en la tabla votos). Resuelve este ejercicio de dos formas: con 
LEFT JOIN y con subconsulta.*/

-- Con left join
select titulo from canciones left join votos on cancion=numCancion where cancion  is null;

-- Con subConsulta
SELECT titulo FROM canciones WHERE numcancion NOT IN (SELECT DISTINCT cancion FROM votos);

/*5.- Obtén los títulos de las canciones que no han recibido aún votos junto con el 
nombre del grupo al que pertenecen. Debe salir además una columna con valor cero 
para indicar el número de votos.*/

select titulo,nombre,'0' as num_votos from canciones left join votos on cancion=numCancion 
inner join grupos on codgrupo=grupo where cancion is null;

/*6.- Obtén cuantos votos tiene cada una de las canciones, el título y el nombre del grupo 
al que pertenecen. Deben salir todas las canciones, no sólo las votadas.*/
-- union
select titulo,nombre,count(*) from votos inner join canciones on cancion=numCancion 
inner join grupos on grupo=codgrupo group by numCancion union 
select titulo,nombre,'0' from canciones left join votos on cancion=numCancion 
inner join grupos on codgrupo=grupo where cancion is null; 

-- left join 
select titulo,grupos.nombre,count(usuario) from canciones left join votos on cancion=numCancion 
inner join grupos on grupo=codgrupo group by numCancion;

/*7.- Obtén los nombres de grupos que no hayan recibido votos, es decir, que todas sus 
canciones no hayan recibido votos.*/
select nombre from canciones left join votos on cancion=numCancion 
inner join grupos on codgrupo=grupo group by nombre having count(usuario)=0;

/*8.- Obtén los nombres y apellidos de los usuarios que han votado la canción titulada 
Canción de cuna.*/
-- con inner join
select nombre,apellidos from usuarios inner join votos on user=usuario 
inner join canciones on numCancion=cancion where titulo='Canción de cuna';

-- Con subselect
select nombre,apellidos from usuarios inner join votos 
on user=usuario where cancion=(select numCancion from canciones where titulo='Canción de cuna');
/*9.- Obtén los nombres y apellidos de todos los usuarios que han votado a alguno de los 
grupos votados por Elsa Frutos Núñez.*/

select nombre,apellidos from usuarios inner join votos on user=usuario 
inner join canciones on numCancion=cancion 
where grupo in (select grupo from usuarios inner join votos on user=usuario 
inner join canciones on numCancion=cancion 
where usuarios.nombre='Elsa' and apellidos='Frutos Núñez');


/*10.- Obtén las fechas de enero en que se han dado menos votos que los dados el día 2 
de enero de este 2018.*/

select fecha,count(*) from votos where fecha like '____-01-__' group by fecha 
having count(*)<(select count(*) from votos where fecha = date(20180102));

-- select inicial
select count(*) from votos where fecha = date(20180102);
-- consulta completa
select fecha,count(*) from votos where month(fecha) = 01 
group by fecha having count(*)<(select count(*) from votos where fecha = date(20180102));


