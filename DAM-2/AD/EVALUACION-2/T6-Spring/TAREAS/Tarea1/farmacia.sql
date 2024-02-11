create database if not exists farmacia;
use farmacia;
create table if not exists laboratorio (
	pklaboratorio int primary key,
	nombre varchar(50)		
);
create table if not exists medicamento (
	pkmedicamento int primary key,
	aklaboratorio int not null,
	formato varchar(25),
	stock int,
	pvp float,
	foreign key (aklaboratorio) references laboratorio (pklaboratorio)
);
create table if not exists persona (
	pkpersona int primary key,
	nombre varchar(50),	
	fechanacimiento date not null		
);

create table if not exists tratamiento (
	pktratamiento int primary key,
	akpersona int not null,
	akmedicina int not null,
	fecha date not null,
	foreign key (akpersona) references persona (pkpersona),
	foreign key (akmedicina) references medicamento (pkmedicamento)
);

insert into laboratorio values (100, 'Laboratorio 100');
insert into laboratorio values (200, 'Laboratorio 200');
insert into laboratorio values (300, 'Laboratorio 300');
insert into laboratorio values (400, 'Laboratorio 400');


insert into medicamento values (10, 100, 'jarabe', 10000, 2.25);
insert into medicamento values (20, 200, 'pomada', 10000, 10.20);
insert into medicamento values (30, 300, 'pastilla', 10000, 15.00);

insert into persona values (1, 'persona 1', '1975-01-01');
insert into persona values (2, 'persona 2', '1976-03-03');
insert into persona values (3, 'persona 3', '1980-04-11');
insert into persona values (4, 'persona 4', '1982-01-01');
insert into persona values (5, 'persona 5', '1983-03-03');
insert into persona values (6, 'persona 6', '1984-04-11');
insert into persona values (7, 'persona 7', '1985-01-01');
insert into persona values (8, 'persona 8', '1986-03-03');
insert into persona values (9, 'persona 9', '1987-04-11');

insert into tratamiento values (1, 1, 10, '2022-12-28');
insert into tratamiento values (2, 2, 20, '2023-01-02');
insert into tratamiento values (3, 3, 30, '2023-02-02');
insert into tratamiento values (4, 1, 10, '2023-01-18');
insert into tratamiento values (5, 2, 20, '2023-01-22');
insert into tratamiento values (6, 3, 30, '2023-02-12');