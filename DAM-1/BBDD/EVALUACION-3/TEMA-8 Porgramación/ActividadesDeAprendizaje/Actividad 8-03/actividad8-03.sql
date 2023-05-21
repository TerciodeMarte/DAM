/*2.- Comprueba la ejecución del procedimiento anterior. Antes de ejecutarlo, comprueba 
los votos que tiene la canción que se va a votar y los del usuario que va a dar el voto.
*/
set @nombre='Pedro';
set @apellidos='Pancorvo Hidalgo';
set @titulo='No gires';

select totalvotos,nombre,apellidos from usuarios where nombre=@nombre and apellidos=@apellidos;
select titulo,total_votos from canciones where titulo=@titulo;

call votar(@nombre,@apellidos,@titulo);

/*3.- Comprueba la ejecución del procedimiento anterior cuando un usuario que no existe 
vota la misma canción que la que has usado en el ejercicio 2. Interpreta lo que ha 
ocurrido.*/
set @nombre='Albano';
set @apellidos='Diez de Paulino';
set @titulo='No gires';

call votar(@nombre,@apellidos,@titulo);

-- 16:01:42	call votar(@nombre,@apellidos,@titulo)	Error Code: 1048. Column 'usuario' cannot be null	0.000 sec

/*Al no existir el usuario Albano, no encuentro su clave primaria y no puedo hacer la insercion del voto en la tabla votos
Y se para el procedimiento*/

/*4.- Modifica el procedimiento para que al final escriba los datos de la canción votada. 
Para poder modificarlo, antes tienes que eliminarlo.*/

-- Hecho

/*5.- Realiza un procedimiento contarVotos en la base de datos concursomusica que:
● Pone los votos de todos los usuarios a cero.
● Pone los votos de todas las canciones a cero.
● Actualiza el total de votos de las canciones con el número de votos de cada 
canción registrados en la tabla votos.
● Actualiza el total de votos de los usuarios con el número de votos dados por cada 
usuario en la tabla votos.
*/

/*6.- Comprueba la ejecución del procedimiento.*/
call contarVotos();