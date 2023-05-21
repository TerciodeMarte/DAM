/*1.- Obtén un listado con todas las variables de sistema de sesión.*/
show session variables;

/*2.- Obtén un listado con todas las variables de sistema globales.*/
show global variables;

/*3.- Modifica las variables de sistema que controlan el valor inicial de una columna 
autoincrement y el valor del incremento para que sean 5 y 10 respectivamente,*/
set @@auto_increment_offset=5;
set @@auto_increment_increment =10;


/*4.- Crea una tabla con dos columnas num y nombre donde num es PRIMARY KEY 
numérica y autoincrementada.*/
create database aa801;
use aa801;
create table aa801(
num int(4) unsigned auto_increment ,
nombre varchar(10),
primary key(num)
);

/*5.- Inserta tres nuevos registros en la tabla comprobando que se insertan de acuerdo a 
la configuración dada para el valor inicial y de incremento de autoincrement.*/
insert into aa801(nombre) values ('albano'),('daniel'),('ramiro');

/*6.- Obtén el valor de las variables de estado locales y globales.*/
show session status;
show global status;

/*7.- Obtén el número de consultas que han sido enviadas al servidor desde la sesión 
cliente.*/
show status like 'Questions';

/*8.- Obtén cuantos bytes han sido recibidos por el servidor y emitidos por el cliente desde 
la sesión cliente en que estás trabajando.*/
show status like 'Bytes_received';
show status like 'Bytes_sent';

/*9.- Realiza una consulta de todos los datos de una tabla de la BD que tengas abierta. 
Repite las tareas 7 y 8.*/
select * from aa801;
-- Se han incrementado el numero de las variables.

/*10.- Cierra la sesión cliente e inicia una nueva.*/
-- Cerrado

/*11.- Obtén cual es el valor de las variables de sistema de sesión que controlan el valor 
inicial y el incremento de una columna autoincrement y valora lo que ha ocurrido.*/
select @@auto_increment_offset,@@auto_increment_increment;

-- Han vuelto al valor de 1 porque he cerrado sesion.

/*12.- Repite las tareas 7 y 8 y valora lo que ha ocurrido.*/

-- Han vuelto al estado inicial porque al cambiar de sesion se reinicia

/*13.- Abre la base de datos concursomusica. Carga en dos variables de usuario el nombre 
y apellidos de un usuario cualquiera de la tabla usuarios (el que quieras). Carga en una 
variable de usuario el título de una canción. A partir de aquí y usando más variables, si 
así lo quieres para obtener por ejemplo el número de la canción, escribe las 
instrucciones necesarias para:
● Insertar el voto del usuario.
● Incrementar en uno los votos del usuario.
● Incrementar en uno los votos de la canción.*/

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

/*14.- Consulta el valor de las variables de estado que indican, para la sesión actual: 
● El número de instrucciones select ejecutadas. 
● El número de instrucciones insert ejecutadas. 
● El número de instrucciones update ejecutadas. 
● El número de instrucciones set ejecutadas. 
● El número de instrucciones create table ejecutadas. 
Y adjunta capturas de pantalla con los resultados.*/

-- ● El número de instrucciones select ejecutadas. 
show status like 'com_select';
-- ● El número de instrucciones insert ejecutadas. 
show status like 'com_insert';
-- ● El número de instrucciones update ejecutadas. 
show status like 'com_update';
-- ● El número de instrucciones set ejecutadas. 
show status like 'com_set_option';
-- ● El número de instrucciones create table ejecutadas. 
show status like 'com_create_table';