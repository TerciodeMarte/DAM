CREATE DEFINER=`root`@`localhost` PROCEDURE `recaudacion`(in mes int,in anno int)
BEGIN
declare fechaaux date;

drop table if exists recaudacion;

create table if not exists recaudacion(
fecha date,
num_contratos_fin int,
importe double default 0.0
);

set fechaaux=concat(anno,mes,'01');

while fechaaux<=concat(anno,mes,'31') do
insert into recaudacion set fecha=fechaaux ,
num_contratos_fin=(select count(*) from contratos where ffin=fechaaux), 
importe=(select sum(precio) from automoviles inner join contratos using(matricula) where ffin=fechaaux);
set fechaaux=date_add(fechaaux,interval 1 day);
end while;

select * from recaudacion;
drop table if exists recaudacion;
END