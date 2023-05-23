CREATE DEFINER=`root`@`localhost` PROCEDURE `factorial`(in num int,out factorial int)
BEGIN

declare aux int;
declare i int;
set i = 1;
set aux = 1;

while i <= num do 
set aux = aux * i;
set i = i + 1;
end while;

set factorial=aux;
END