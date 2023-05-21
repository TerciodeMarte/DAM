use alquileres;

select numcontrato,automoviles.matricula,marca,modelo from contratos inner join automoviles 
on contratos.matricula=automoviles.matricula where ffin is null;

select numcontrato,nombre,apellidos from clientes inner join contratos on dnicliente=dni where ffin is null;

select numcontrato,automoviles.matricula,marca,modelo,nombre,apellidos,kfin-kini from 
(contratos inner join automoviles on contratos.matricula=automoviles.matricula)inner join clientes 
on dnicliente=dni where ffin is not null;

select distinct nombre,apellidos from (contratos inner join automoviles on contratos.matricula=automoviles.matricula) 
inner join clientes on dnicliente=dni where marca="seat";

select * from automoviles,contratos,contratos2,clientes;

use nba;

select a.nombre as local,b.nombre as visitante from equipos as a inner join equipos as b 
on a.nombre != b.nombre where a.division ="central" and b.division="central";