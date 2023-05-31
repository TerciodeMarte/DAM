/*1.- Ahora vas a crear o editar un procedimiento desde Workbench, dentro de la base 
de datos datororigen, que:
● Crea, si es que no existe ya, una tabla de personas con las columnas num, 
nombre, apellido1, apellido 2, dni, fecha_nac, calle, localidad, sexo (H o M).
● Añade n filas a la tabla personas con un nombre obtenido aleatoriamente de la 
tabla de nombres de hombre o de la tabla de nombres de mujer.
● Devuelve el último número de persona que se ha generado al insertar las 
nuevas filas.
Para realizar los tres requerimientos anteriores deberás seguir los pasos que se indican 
a continuación:
*/
use datosorigen;

create table if not exists personas(
num int unsigned auto_increment, 
nombre varchar(30), 
apellido1 varchar(30), 
apellido2 varchar(30), 
dni varchar(9), 
fecha_nac date, 
calle varchar(60), 
localidad varchar(60), 
sexo enum('H','M'),
primary key(num)
);


/*3.- Ejecuta el procedimiento desde línea de comandos para que inserte 100 nombres 
de personas y devuelva el último número de persona introducida en una variable 
@numper:
*/
CALL generar_nombres(100,@numper);

/*Obtén el último número de persona introducida.*/
select @numper;

/*4.- Repite lo anterior para insertar 300 nuevos nombres de personas.*/
CALL generar_nombres(300,@numper);

/*5.- Al comprobar el contenido de la tabla personas observarás que se ha producido un 
error en los datos cargados. A todas las personas les hemos asignado el sexo `M`.
Modifica el procedimiento para que al cargar los nombres cargue correctamente el 
sexo (H si es un hombre y M si es una mujer).*/
-- Hecho

/*6.- Ahora vamos a crear un nuevo procedimiento para poner apellidos a todas las 
personas con números comprendidos entre el número mínimo y el máximo que se 
pasen como parámetros (no vamos a poner nada para comprobar posibles errores). No 
lo vamos a hacer en el editor de procedimientos sino con el cliente mysql o con el 
editor de instrucciones SQL en Workbench.*/
delimiter //
CREATE PROCEDURE carga_apellidos(IN inicio INT, IN fin INT)
BEGIN
	declare n int;
	declare n2 int;
	declare ape1 varchar(25);
	DECLARE ape2 VARCHAR(25);
	set n=inicio;
	while (n <=fin) do
		set n2=floor(rand()*65428);
		 set ape1=(select apellido from apellidos where n2>=desde AND n2<hasta);
		 set n2=floor(rand()*65428);
		 set ape2=(select apellido from apellidos where n2>=desde AND n2<hasta);
		 update personas set apellido1=ape1,apellido2=ape2 where num=n;
		 set n=n+1;
	end while;
END//

delimiter ;
/*7.- Envía al servidor el código del procedimiento.*/
-- Hecho

/*8.- Ejecuta el procedimiento para que se carguen los apellidos de las 100 primeras 
personas.*/
call carga_apellidos(1,100);

/*9.- Modifica el procedimiento para que los números aleatorios que se generan, lo 
hagan con respecto al valor máximo que hay en la columna hasta.*/
delimiter //
create PROCEDURE carga_apellidos(IN inicio INT, IN fin INT)
BEGIN
	declare n int;
	declare n2 int;
	declare ape1 varchar(25);
	DECLARE ape2 VARCHAR(25);
	set n=inicio;
	while (n <=fin) do
		set n2=floor(rand()*(select max(hasta) from apellidos));
		 set ape1=(select apellido from apellidos where n2>=desde AND n2<hasta);
		 set n2=floor(rand()*(select max(hasta) from apellidos));
		 set ape2=(select apellido from apellidos where n2>=desde AND n2<hasta);
		 update personas set apellido1=ape1,apellido2=ape2 where num=n;
		 set n=n+1;
	end while;
END//

delimiter ;

/*10.- Envía nuevamente el procedimiento al servidor y vuelve a ejecutar para que se 
generen apellidos para las personas con números entre 50 y 300*/
call carga_apellidos(50,300);