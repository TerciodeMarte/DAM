CREATE DEFINER=`root`@`localhost` FUNCTION `DiasSinVotos`() RETURNS int
    DETERMINISTIC
BEGIN
declare fecha date;
declare i int;

set fecha=concat(year(curdate()),'01','01');
set i=0;
while fecha<=curdate() do
if (select count(*) from votos where votos.fecha=fecha)=0 then
set i=i+1;
end if;
set fecha=date_add(fecha,interval 1 day);
end while;
return i;
END