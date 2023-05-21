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

call asgina_direccion(3);