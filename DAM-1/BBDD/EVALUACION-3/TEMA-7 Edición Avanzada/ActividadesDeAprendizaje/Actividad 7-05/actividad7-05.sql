use concursomusica;

/*Preparativos para el apartado 2.2*/
alter table usuarios add column totalvotos int default 0;
update usuarios inner join (select count(*) as cuenta, usuario from votos group by usuario) as subtable on subtable.usuario=user set totalvotos=subtable.cuenta;
update canciones inner join (select count(*) as cuenta,cancion from votos group by cancion) as subtable on subtable.cancion=numCancion set total_votos=subtable.cuenta;
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
update usuarios set totalvotos=totalvotos+1 where user='02Ana';
/*2.3.- Suma un voto a la canción Cientos y Cientos. Comprueba cuántos votos tiene la 
canción.*/
SET SQL_SAFE_UPDATES = 0;
update canciones set total_votos=total_votos+1 where titulo='Cientos y cientos';
SET SQL_SAFE_UPDATES = 1;
select total_votos from canciones where titulo='Cientos y cientos';

/*2.4.- Aunque el proceso realizado sea correcto, anula la transacción para realizar el 
proceso de otra forma (es un supuesto de que se ha producido algún fallo o algún 
error en el proceso).*/
rollback;



/*3.- Ten en cuenta que al haber finalizado una transacción anteriormente, por estar en 
modo transaccional, ya estás trabajando dentro de una nueva transacción, no tienes 
que iniciar una nueva. Ahora vas a almacenar previamente los datos del voto en dos 
variables: @u para almacenar el identificador de usuario y @t para almacenar el título.*/

set @u='02Ana';
set @t='Cientos y cientos';

/*3.1.- Añade el voto realizado a la tabla votos.*/
insert into votos(usuario,fecha,cancion) values(@u,curdate(),(select numCancion from canciones where titulo=@t));
/*3.2.- Suma un voto al total de votos que ha dado la usuaria.*/
update usuarios set totalvotos=totalvotos+1 where user=@u;
/*3.3.- Suma un voto a la canción votada.*/
SET SQL_SAFE_UPDATES = 0;
update canciones set total_votos=total_votos+1 where titulo=@t;
SET SQL_SAFE_UPDATES = 1;
/*3.4.- Confirma la transacción.*/
commit;

/*4.- Realiza en una transacción todas las operaciones que se deben efectuar cuando se 
elimine un voto. Se va a eliminar el voto dado por 02Ana en la fecha actual. Las 
operaciones que se realizan son:
● Eliminar el voto dado por 02Ana en la fecha actual.
● Decrementar en uno el número de votos de la usuaria 02Ana.
● Decrementar en uno el número de votos dados a la canción votada en el voto.
Es importante realizar esto en un orden adecuado. Dado que estás trabajando en 
modo transaccional, no es necesario que realices el inicio de la transacción (la 
transacción se habrá iniciado cuando terminó la correspondiente a lo desarrollado en 
el ejercicio 3).*/

set @u='02Ana';
set @t='Cientos y cientos';

-- ● Eliminar el voto dado por 02Ana en la fecha actual.
delete from votos where usuario=@u and fecha=curdate();

-- ● Decrementar en uno el número de votos de la usuaria 02Ana.
update usuarios set totalvotos=totalvotos-1 where user=@u;

-- ● Decrementar en uno el número de votos dados a la canción votada en el voto.
SET SQL_SAFE_UPDATES = 0;
update canciones set total_votos=total_votos-1 where titulo=@t;
SET SQL_SAFE_UPDATES = 1;

/*5.- Establece en la sesión de trabajo el modo no transaccional. Repite lo realizado en 
los ejercicios 2, 3 y 4 en este modo no transaccional.*/
set autocommit=1;

/*6.- Inicia una nueva transacción.
● Elimina el voto dado por 02Ana en la fecha actual.
● Decrementa en uno el número de votos de la usuaria 02Ana.*/

start transaction;

set @u='02Ana';
set @t='Cientos y cientos';
-- ● Eliminar el voto dado por 02Ana en la fecha actual.
delete from votos where usuario=@u and fecha=curdate();

-- ● Decrementar en uno el número de votos de la usuaria 02Ana.
update usuarios set totalvotos=totalvotos-1 where user=@u;

/*7.- Sin confirmar ni anular la transacción, cierra la sesión cliente MySQL. Inicia una 
nueva sesión y:
Comprueba si quedaron realizados los cambios hechos en el ejercicio 6*/

/*Se quedan guardados todos los cambios ya que estoy en el modo no transacional y al cerrar sesion se hace un autocommit*/