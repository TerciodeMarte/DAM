use municipiosu6;

/*1.- Con una sola instrucción, añade los datos de todas las localidades del municipio de id 20:
La Cueva. 740 hab 
Pomaluengo. 972 hab.
Socobio. 259 hab.
Villabáñez. 681 hab 
Comprueba ahora con SELECT cuales son las localidades del municipio de nombre Castañeda*/

insert into localidades(municipio,numero,nombre_loc,habitantes) values
(20,1,'La Cueva',740),
(20,2,'Pomaluengo',972),
(20,3,'Socobio', 259),
(20,4,'Villabáñez', 681);

select nombre,numero,nombre_Loc,habitantes from localidades inner join municipios on municipio=id where nombre='Castañeda';

/*2.- Descarga el archivo de volcado de datos personas.csv que contiene información sobre 
varias personas que hay que insertar en la tabla personas.
Carga en la tabla personas los datos de las personas almacenadas en el archivo. Para ello usa 
la instrucción:
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/personas.csv' INTO 
TABLE personas CHARACTER SET utf8mb4;
Deberás modificar la ubicación del archivo.*/

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/personas.csv' INTO 
TABLE personas CHARACTER SET utf8mb4;
-- Mirar la ruta para cargar archivos de fomra segura
SHOW VARIABLES LIKE "secure_file_priv";

/*3.- Añade ahora filas en la tabla concejales para indicar que las personas con id comprendido 
entre 33 y 37, ambos incluidos, son concejales en el municipio número 20 por el partido AMC.*/

insert into concejales(idpers,partido,municipio) select idpers,'AMC',20 from personas where idpers between 33 and 37;

/*4.- Añade ahora una fila en la tabla rige para indicar que la alcaldesa del municipio número 20 
es la persona de id 35 desde el 27 de junio de 2015.*/
insert into rige set alcalde=35,municipio=20,fini='20150627',partido=(select partido from concejales where idpers=35);

/*5.- Establece que la anterior alcaldesa ha dejado de serlo hoy mismo.*/
update rige set ffin=current_date() where alcalde=35;

/*6.- El resto de instrucciones debes realizarlas dentro de una transacción que anularás al final 
de la actividad.
Incrementa en el 12% los habitantes de todas las localidades del municipio número 20.*/
start transaction;
update localidades set habitantes=habitantes*1.12 where municipio=20;

/*7.- Establece para la alcaldesa que inicio su mandato en el municipio número 12 en el año 
2011, que la fecha de inicio y fecha de finalización del mandato fueron una semana más tarde 
del día que tienen registrado actualmente.*/
update rige set fini=date_add(fini,interval 1 week),ffin=date_add(ffin,interval 1 week) where municipio=12 and year(fini)=2011;

/*8.- Elimina todas las localidades con población cero.*/
SET SQL_SAFE_UPDATES = 0;
delete from localidades where habitantes=0;


/*9.- Elimina en la tabla personas todas las personas que tengan menos de 18 años 
actualmente.*/
delete from personas where year(current_date()-a_nac)<18;


/*10.- Elimina en la tabla personas todas las personas nacidas en 1962, 1982, 1992 o 1993.
Explica lo que ocurre.
Establece que se eliminen las personas que no producen error de eliminación*/

delete from personas where a_nac in (1962,1982,1992,1993); -- Con esta linea no puedo borrar las personas porque hay claves foreneas que apuntan a algunas personas
delete ignore from personas where a_nac in (1962,1982,1992,1993); -- Con esta linea ignora a las personas que tengan clave forenea y elimina las que no la tienen
SET SQL_SAFE_UPDATES = 1;
rollback;
