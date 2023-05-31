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
anteriormente
*/
CREATE PROCEDURE `asigna_direccion`(in numper INT)
BEGIN

declare auxdir varchar(100);
declare alea int;
declare max int;
declare municipio varchar(70);
declare provincia2 varchar(30);

set alea = (select round((rand()*count(*))+1)  from calles);
set auxdir = (select concat(nomcalle, ", " ,round((rand()*60)+1)) from calles where idcalle = alea);

set max = (select max(hasta) from municipios);
set municipio = (select nommunicipio from municipios where hasta >= round(rand()*max) limit 1); 
set provincia2 = (select provincia from municipios where nommunicipio = municipio);

update personas set direccion = auxdir , localidad = municipio , provincia = provincia2  where num = numper;

END