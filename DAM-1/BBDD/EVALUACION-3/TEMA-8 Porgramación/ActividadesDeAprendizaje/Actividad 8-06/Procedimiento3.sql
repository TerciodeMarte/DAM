CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_sexos`(in min int,in max int)
BEGIN
declare nom varchar(100);
declare aux int;

set aux=min;

while aux<=max do
if (select personas.nombre from personas inner join nombresmujer using(nombre) where num=aux) = false then
	update personas set sexo='M' where num=aux;
else

	update personas set sexo='H' where num=aux;
end if;
set aux=aux+1;

end while;
END