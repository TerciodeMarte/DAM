create database if not exists vacunas;
use vacunas;
create table if not exists laboratorio (
	pklaboratorio int primary key,
	nombre varchar(50),	
	pvpdosis float	
);
create table if not exists vacuna (
	pkvacuna int primary key,
	aklaboratorio int not null,
	stock	int,
	foreign key (aklaboratorio) references laboratorio (pklaboratorio)
);
create table if not exists persona (
	pkpersona int primary key,
	nombre varchar(50),	
	fechanacimiento date not null,
	ndosis int	
);
create table if not exists vacunapersona (
	pkvacunapersona int primary key,
	akpersona int not null,
	akvacuna int not null,
	fecha date not null,
	foreign key (akpersona) references persona (pkpersona),
	foreign key (akvacuna) references vacuna (pkvacuna)
);

insert into laboratorio values (100, 'Pfizer', 17);
insert into laboratorio values (200, 'Moderna', 21);
insert into laboratorio values (300, 'AstraZeneca', 3);
insert into laboratorio values (400, 'Janssen', 8);


insert into vacuna values (10, 100, 10000);
insert into vacuna values (20, 200, 10000);
insert into vacuna values (30, 300, 10000);

insert into persona values (1, 'persona 1', '1975-01-01', 2);
insert into persona values (2, 'persona 2', '1976-03-03', 2);
insert into persona values (3, 'persona 3', '1980-04-11', 2);
insert into persona values (4, 'persona 4', '1982-01-01', 0);
insert into persona values (5, 'persona 5', '1983-03-03', 0);
insert into persona values (6, 'persona 6', '1984-04-11', 0);
insert into persona values (7, 'persona 7', '1985-01-01', 0);
insert into persona values (8, 'persona 8', '1986-03-03', 0);
insert into persona values (9, 'persona 9', '1987-04-11', 0);

insert into vacunapersona values (1, 1, 10, '2020-12-28');
insert into vacunapersona values (2, 2, 20, '2021-01-02');
insert into vacunapersona values (3, 3, 30, '2021-02-02');
insert into vacunapersona values (4, 1, 10, '2021-01-18');
insert into vacunapersona values (5, 2, 20, '2021-01-22');
insert into vacunapersona values (6, 3, 30, '2021-02-22');