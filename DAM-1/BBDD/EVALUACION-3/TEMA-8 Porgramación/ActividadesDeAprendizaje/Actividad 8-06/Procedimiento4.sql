CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_personas`(in numper int)
BEGIN

declare ultimo int;
declare primero int;
declare i int;

set primero=(select max(num) from personas);
set i=primero;

call generar_nombres(numper,ultimo);
call carga_apellidos(primero,ultimo);
call cargar_dnis(primero,ultimo);
call cargar_sexos(primero,ultimo);
call cargar_direcciones(primero,ultimo);
while i<=ultimo do
	call asigna_fecha_nac(i,19550101,curdate());
	set i=i+1;
end while;
END