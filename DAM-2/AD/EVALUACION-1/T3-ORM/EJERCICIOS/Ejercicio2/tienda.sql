create database tienda;
use tienda;

create table cliente (
	pkcliente int auto_increment primary key,
	nombre varchar(20) not null,
	password varchar(20)not null	
);
create table categoria (
	pkcategoria int auto_increment primary key,
	nombre varchar(50)
);
create table producto (
	pkproducto int auto_increment primary key,
	nombre varchar(80) not null,
	fkcategoria int not null,	
	pvp decimal(8,2) not null,
	stock int,	
	FOREIGN key (fkcategoria) references categoria (pkcategoria)
);

create table carrito (
	pkcarrito int auto_increment primary key,
	fkcliente int not null,
	fecha date not null,
	FOREIGN key (fkcliente) references cliente (pkcliente)
);
create table lineacarrito (
	pklinea int auto_increment primary key,
	fkcarrito int not null,
	fkproducto int not null,
	unidades int not null,
	FOREIGN KEY (fkcarrito) references carrito (pkcarrito),
	FOREIGN KEY (fkproducto) references producto (pkproducto)	
);



