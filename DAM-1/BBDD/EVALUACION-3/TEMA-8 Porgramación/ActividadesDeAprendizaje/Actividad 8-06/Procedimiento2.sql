CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_dnis`(in min int,in max int)
BEGIN
declare alea int;
declare numDNI varchar(8);
declare aux int;
declare letra varchar(23);
declare letra2 varchar(1);

set aux=min;

while aux<=max do
set numDNI=lpad(round(rand()*99999999),8,0);
set alea=round((rand()*22)+1);

set letra='TRWAGMYFPDXBNJZSQVHLCKE';
set letra2=substring(letra,alea,1);

update personas set dni=concat(numDNI,letra2) where num=aux;

set aux=aux+1;

end while;
END