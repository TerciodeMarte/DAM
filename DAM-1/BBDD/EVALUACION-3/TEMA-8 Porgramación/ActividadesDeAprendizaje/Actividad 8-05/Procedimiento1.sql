/*1.- Realiza un procedimiento asigna_fecha_nac que modifica la fecha de nacimiento de 
una persona de la tabla personas con una fecha generada de forma aleatoria.
● El procedimiento recibe el número de persona a modificar y una fecha mínima 
y una fecha máxima entre las que se va a generar la fecha aleatoria.
● Una forma de obtener la fecha aleatoria es:
o Obtener la diferencia de días (D) entre la fecha máxima y la fecha 
mínima.
o Generar un número aleatorio N entre 0 y D.
o Obtener la fecha sumando a la fecha mínima N días. 
● Si la fecha máxima no es mayor que la mínima, el procedimiento no hace nada.*/

CREATE PROCEDURE `asigna_fecha_nac` (in numero int,in fechamin date,in fechamax date)
BEGIN
declare diff int;

END
