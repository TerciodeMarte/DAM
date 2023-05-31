CREATE DEFINER=`root`@`localhost` PROCEDURE `frecuencia_nombres`(in nom varchar(25),out frec int)
BEGIN
declare id int;

if (select idnombre from nombresmujer where nombre=nom) is not null then
	set id=(select idnombre from nombresmujer where nombre=nom);
	set frec=(select frecnombre from nombresmujer where idnombre=id);
	
elseif (select idnombre from nombreshombre where nombre=nom) is not null then
	set id=(select idnombre from nombreshombre where nombre=nom);
	set frec=(select frecnombre from nombreshombre where idnombre=id);
end if;
END