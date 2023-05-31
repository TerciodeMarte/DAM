CREATE DEFINER=`root`@`localhost` PROCEDURE `borrar_ultimos_contratos`(in num int)
BEGIN
declare max int;
declare i int default 0;
if (num<=(select max(numcontrato) from contratos)) then
set max=(select max(numcontrato) from contratos);
	while (i<num) do
		delete from contratos where numcontrato=max-i;
		set i=i+1;
	end while;
end if;
END