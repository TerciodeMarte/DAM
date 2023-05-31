use datosorigen;

/*1.- En la base de datos datosorigen, realiza un procedimiento cargar_direcciones para 
generar aleatoriamente la dirección, localidad y provincia de todas las personas (TABLA 
PERSONAS) con números comprendidos entre el número mínimo y el máximo que se 
pasen como parámetros. 
La dirección se obtiene aleatoriamente de la tabla CALLES añadiendo una coma, un 
espacio y un número aleatorio entre 1 y 60.
La localidad y la provincia se obtiene aleatoriamente de la tabla MUNICIPIOS.*/

call cargar_direcciones(1,10);

/*2.- En la base de datos datosorigen, realiza un procedimiento cargar_dnis para generar 
aleatoriamente los DNI de todas las personas con números comprendidos entre el 
número mínimo y el máximo que se pasen como parámetros. 
Para generar aleatoriamente números de DNI de cada persona debes:
● Obtener un número aleatorio entre 0 y 99999999. Si sale un número de menos 
de 8 cifras hay que rellenarlo con ceros (en un CHAR). Usar la función lpad. 
Asignar el resultado a una variable usada para almacenar el DNI.
● Obtener una letra aleatoria entre las letras de ‘TRWAGMYFPDXBNJZSQVHLCKE’. 
Generar un número aleatorio entre 1 y 23 y extraer la letra que está en esa 
posición (Usar substring). Concatenar el contenido de la variable que contiene el 
DNI con la letra que se ha extraído anteriormente.*/

call cargar_dnis(1,10);

/*3.- En la base de datos datosorigen, realiza un procedimiento cargar_sexos para 
establecer en la columna SEXO de la tabla PERSONAS el sexo correcto de las personas 
con números comprendidos entre el número mínimo y el máximo que se pasen como 
parámetros. 
CFGS DAM
Bases de Datos. Curso 22-23
En sexo se cargará H si es un hombre y M si es una mujer. Dado que la tabla personas 
tiene una columna NOMBRE con nombres extraídos de las tablas NOMBRES_MUJER y 
NOMBRES_HOMBRE, se puede saber si un nombre corresponde a una mujer si ese 
nombre está en la tabla NOMBRES_MUJER.
*/
call cargar_sexos(1,10);

/*4.- En la base de datos datosorigen, realiza un procedimiento cargar_personas que 
recibe el número de personas que se quieren añadir y permite añadir a la tabla 
PERSONAS ese número de personas con todos los datos aleatorios (excepto la columna 
autoincrementada y la columna SEXO que se establece de acuerdo con que el nombre 
sea de un hombre o de una mujer).
Deberás utilizar los procedimientos que se han usado para generar todos esos datos de 
forma aleatoria.*/
call cargar_personas(100);