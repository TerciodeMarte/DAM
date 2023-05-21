CREATE DEFINER=`root`@`localhost` PROCEDURE `mes`(in mes int,out nombre varchar(15))
BEGIN
case mes
when 1 then set nombre='Enero';
when 2 then set nombre='Febrero';
when 3 then set nombre='Marzo';
when 4 then set nombre='Abril';
when 5 then set nombre='Mayo';
when 6 then set nombre='Junio';
when 7 then set nombre='Julio';
when 8 then set nombre='Agosto';
when 9 then set nombre='Septiembre';
when 10 then set nombre='Octubre';
when 11 then set nombre='Noviembre';
when 12 then set nombre='Diciembre';
END case;
END