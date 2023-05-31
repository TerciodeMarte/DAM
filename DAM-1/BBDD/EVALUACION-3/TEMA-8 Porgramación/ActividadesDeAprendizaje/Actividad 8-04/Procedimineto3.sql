CREATE DEFINER=`root`@`localhost` PROCEDURE `fecha_formato_sp`(in fecha date,out nuevo_formato varchar(30))
BEGIN
declare aux date;
declare dia varchar(15);
declare mes varchar(15);

case dayofweek(fecha)
when 2 then set dia='Lunes';
when 3 then set dia='Martes';
when 4 then set dia='Miercoles';
when 5 then set dia='Jueves';
when 6 then set dia='Viernes';
when 7 then set dia='Sabado';
when 1 then set dia='Domingo';
END case;

case month(fecha)
when 1 then set mes='Enero';
when 2 then set mes='Febrero';
when 3 then set mes='Marzo';
when 4 then set mes='Abril';
when 5 then set mes='Mayo';
when 6 then set mes='Junio';
when 7 then set mes='Julio';
when 8 then set mes='Agosto';
when 9 then set mes='Septiembre';
when 10 then set mes='Octubre';
when 11 then set mes='Noviembre';
when 12 then set mes='Diciembre';
END case;

set nuevo_formato=concat(dia,',',day(fecha),' de ',mes,' de ', year(fecha));
END