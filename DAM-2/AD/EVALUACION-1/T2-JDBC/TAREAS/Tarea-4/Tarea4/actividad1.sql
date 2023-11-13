create database if not exists actividad1;

use actividad1;

create table if not exists empleado(
 nif varchar(9) primary key,
 nombre varchar(40),
 fechanac date
);

create table if not exists departamento(
 coddpto int(10) primary key,
 nombre varchar(40),
 presupuesto double
);

create table if not exists trabaja(
 nif_empleado varchar(9),
 coddpto int(10),
 primary key(nif_empleado,coddpto),
 constraint fk_trabaja_empleado foreign key (nif_empleado) references empleado(nif),
 constraint fk_trabaja_departamento foreign key (coddpto) references departamento(coddpto)
);

insert into empleado values
('72204754A','Albano Díez',19970515),
('12345678Z','Daniel Espinosa',20001201),
('87654321W','Ramiro Gutierrez',19700131)
;

insert into departamento values
(1,'Informatica',12000),
(2,'Administracion',5000),
(3,'Fol',1000)
;

insert into trabaja values
('72204754A',1),
('12345678Z',2),
('87654321W',3)
;