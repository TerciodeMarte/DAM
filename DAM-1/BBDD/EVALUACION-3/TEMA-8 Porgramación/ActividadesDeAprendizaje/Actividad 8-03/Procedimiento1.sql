CREATE DEFINER=`root`@`localhost` PROCEDURE `votar`(IN nombre varchar(15),IN apellidos varchar(30),IN titulo varchar(40))
BEGIN
set @u=(select user from usuarios where usuarios.nombre=nombre and usuarios.apellidos=apellidos);
insert into votos(usuario,fecha,cancion) values(@u,curdate(),(select numCancion from canciones where canciones.titulo=titulo));
SET SQL_SAFE_UPDATES = 0;
update usuarios set totalvotos=totalvotos+1 where user=@u;
update canciones set total_votos=total_votos+1 where canciones.titulo=titulo;
SET SQL_SAFE_UPDATES = 1;

-- Apartado 4 Modificacion
select numCancion,grupo,duracion,titulo,total_votos from canciones where canciones.titulo=titulo;
END