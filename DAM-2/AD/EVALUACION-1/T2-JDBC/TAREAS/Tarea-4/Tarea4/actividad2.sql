create database if not exists actividad2;

use actividad2;

create table if not exists cliente(
 codcliente int(4) primary key
);

create table if not exists articulo(
 codarticulo int(4) primary key
);

create table if not exists compra(
 codcliente int(4),
 codarticulo int(4),
 fecha date,
 unidades int(4),
 primary key(codcliente,codarticulo),
 constraint fk_compra_cliente foreign key (codcliente) references cliente(codcliente),
 constraint fk_compra_articulo foreign key (codarticulo) references articulo(codarticulo)
);

insert into cliente values
(1),
(2),
(3)
;

insert into articulo values
(1),
(2),
(3)
;

insert into compra values
(1,1,20230901,100),
(2,2,20201231,5),
(1,3,20220101,20)
;