CREATE USER 'albano'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'albano'@'localhost';

use ventas;

select * from pedido inner join cliente on cliente.id=id_cliente inner join comercial on comercial.id=id_comercial;




start transaction;

insert into pedido(total,fecha,id_cliente,id_comercial) values(12.2,20231115,1,2);
select * from pedido;

rollback;