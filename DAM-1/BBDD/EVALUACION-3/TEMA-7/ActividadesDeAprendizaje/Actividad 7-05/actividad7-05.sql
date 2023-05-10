use concursomusica;

/*1.- Establece en la sesión de trabajo el modo transaccional para realizar las 
transacciones correspondientes a los ejercicios 2, 3 y 4.*/

set autocommit=0;

/*2.- En esta primera tarea, vas a simular la realización de todas las operaciones que se 
deben hacer cuando un usuario ha dado un voto. La usuaria 02Ana ha dado ahora 
mismo un voto a la canción titulada Cientos y cientos.*/


/*2.1.- Añade el voto realizado a la tabla votos. Comprueba los datos del voto insertado.*/
insert into votos(usuario,fecha,cancion) values('02Ana',curdate(),(select numCancion from canciones where titulo='Cientos y cientos'));
select usuario,fecha,cancion from votos where usuario='02Ana' and cancion=(select numCancion from canciones where titulo='Cientos y cientos');

/*2.2.- Suma un voto al total de votos que ha dado la usuaria 02Ana.*/
-- No tiene sentido esto,porque la base de datos no esta guardando el total de votos de los usuarios,solo guarda el total de votos de las canciones.
-- El siguiente update suma un voto a la cancion que ha votado 02Ana.
set @votos=(select total_votos from canciones where titulo='Cientos y cientos')+1;
SET SQL_SAFE_UPDATES = 0;
update canciones set total_votos=(@votos) where titulo='Cientos y cientos';
SET SQL_SAFE_UPDATES = 1;
/*2.3.- Suma un voto a la canción Cientos y Cientos. Comprueba cuántos votos tiene la 
canción.*/
-- Lo hice arriba
select total_votos from canciones where titulo='Cientos y cientos';

/*2.4.- Aunque el proceso realizado sea correcto, anula la transacción para realizar el 
proceso de otra forma (es un supuesto de que se ha producido algún fallo o algún 
error en el proceso).*/
rollback;