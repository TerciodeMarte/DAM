CREATE PROCEDURE `dia_semana` (IN dia int,OUT nombre varchar(15))
BEGIN
case dia
when 1 then set nombre='Lunes';
when 2 then set nombre='Martes';
when 3 then set nombre='Miercoles';
when 4 then set nombre='Jueves';
when 5 then set nombre='Viernes';
when 6 then set nombre='Sabado';
when 7 then set nombre='Domingo';
END case;
END
