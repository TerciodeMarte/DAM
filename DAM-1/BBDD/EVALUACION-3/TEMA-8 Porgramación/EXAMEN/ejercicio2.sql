CREATE DEFINER=`root`@`localhost` FUNCTION `frec_aleatoria`() RETURNS varchar(100) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
declare rand int;
declare aux int;
declare frec int;
declare auxstring varchar(25);
declare salida varchar(100);
set rand=round(rand());

if rand=0 then
	set aux=round((rand()*(select max(idnombre) from nombreshombre)));
	set auxstring=(select nombre from nombreshombre where idnombre=aux);
else
	set aux=round((rand()*(select max(idnombre) from nombresmujer)));
	set auxstring=(select nombre from nombresmujer where idnombre=aux);
end if;
call frecuencia_nombres(auxstring,frec);

RETURN concat('Nombre: ',auxstring,' Frecuencia: ',frec);
END