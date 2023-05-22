CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_direcciones`(in min int,in max int)
BEGIN
declare aux int;
set aux=min;
while aux<=max do
call asigna_direccion(aux,@retorno);
set aux=aux+1;
end while;
END