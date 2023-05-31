CREATE DEFINER=`root`@`localhost` FUNCTION `factorial`(num int) RETURNS int
    DETERMINISTIC
BEGIN
declare aux int;
declare i int;
set i = 1;
set aux = 1;

while i <= num do
set aux = aux * i;
set i = i + 1;
end while;

RETURN aux;
END