CREATE DEFINER=`root`@`localhost` PROCEDURE `contarVotos`()
BEGIN
SET SQL_SAFE_UPDATES = 0;
update usuarios set totalvotos=0;
update canciones set total_votos=0;

-- Comproabr que los ha puesto a cero
select * from usuarios;
select * from canciones;

update usuarios inner join (select count(*) as cuenta, usuario from votos group by usuario) as subtable on subtable.usuario=user set totalvotos=subtable.cuenta;
update canciones inner join (select count(*) as cuenta,cancion from votos group by cancion) as subtable on subtable.cancion=numCancion set total_votos=subtable.cuenta;

-- Comproabr que los ha actualizado
select * from usuarios;
select * from canciones;
SET SQL_SAFE_UPDATES = 1;
END