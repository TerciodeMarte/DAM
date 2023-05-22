use datosorigen;

/*Todos los procedimientos se realizarán sobre la base de datos datosorigen. En la tabla 
personas debes añadir una columna provincia VARCHAR(30).*/
alter table personas add column provincia varchar(30);

/*1.- Realiza un procedimiento asigna_fecha_nac que modifica la fecha de nacimiento de 
una persona de la tabla personas con una fecha generada de forma aleatoria.
● El procedimiento recibe el número de persona a modificar y una fecha mínima 
y una fecha máxima entre las que se va a generar la fecha aleatoria.
● Una forma de obtener la fecha aleatoria es:
o Obtener la diferencia de días (D) entre la fecha máxima y la fecha 
mínima.
o Generar un número aleatorio N entre 0 y D.
o Obtener la fecha sumando a la fecha mínima N días. 
● Si la fecha máxima no es mayor que la mínima, el procedimiento no hace nada.
*/

call asigna_fecha_nac(3,19970515,curdate());

/*2.- Realiza un procedimiento asigna_direccion que modifica la dirección y localidad 
una persona de la tabla personas con una dirección y localidad generadas 
aleatoriamente.
● El procedimiento recibe el número de persona a modificar.
● En la dirección carga un texto formado por una calle obtenida aleatoriamente 
de la tabla calles, una coma y un espacio, y un número entero comprendido 
entre 1 y 60.
● En la localidad carga un nombre de municipio obtenido aleatoriamente a partir 
de un número generado aleatoriamente entre 0 y el valor máximo que hay en 
la columna hasta de la tabla de municipios.
● En la columna provincia carga el nombre de la provincia del municipio obtenido 
anteriormente*/

call asigna_direccion(3);

/*3.- Modifica el procedimiento anterior para que:
Si no existe el número de persona, escribirá un mensaje en pantalla indicando tal 
circunstancia.*/
call asigna_direccion(1000);

/*4.- Modifica el procedimiento anterior para que no escriba el mensaje de error en 
pantalla, sino que devuelva en una variable booleana si se pudo realizar la 
modificación por existir el número de persona o si no se realizó por no existir.*/
set @persona=false;
call asigna_direccion(1000,@persona);
select @persona;

/*5.- Crea una cuenta de usuario para acceder al servidor MySQL con el identificador 
invitado desde otro equipo de la red (si trabajas con máquina virtual, desde la real).
Establece que con esa cuenta de usuario se puedan realizar consultas (privilegio 
SELECT) y ejecutar procedimientos (privilegio EXECUTE) sobre la base de datos 
datosorigen.
Actualiza privilegios:
FLUSH PRIVILEGES;*/

CREATE USER 'invitado'@'%' IDENTIFIED BY '1234' PASSWORD EXPIRE INTERVAL 1 DAY;
grant select on datosorigen.* to 'invitado'@'%';
grant execute on datosorigen.* to 'invitado'@'%';

/*6.- Comprueba si el usuario creado puede acceder desde el equipo para el que has 
creado la cuenta, si puede hacer SELECT sobre las tablas de datosorigen y si puede 
ejecutar los procedimientos que se han creado en esta actividad.*/