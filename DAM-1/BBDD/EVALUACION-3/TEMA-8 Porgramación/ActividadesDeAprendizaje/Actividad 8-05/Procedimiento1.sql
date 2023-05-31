CREATE DEFINER=`root`@`localhost` PROCEDURE `asigna_fecha_nac`(in numero int,in fechamin date,in fechamax date)
BEGIN
declare diff int;
declare alea int;
set diff = datediff(fechamax,fechamin);

if diff>0 THEN
	set alea = round(rand()*diff);
	update personas set fecha_nac = date_add(fechaMin, interval alea day) where num = numero;
end if;
END