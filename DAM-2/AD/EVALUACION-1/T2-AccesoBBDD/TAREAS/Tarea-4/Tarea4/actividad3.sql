create database if not exists actividad3;

use actividad3;

create table if not exists paciente(
 numhistorial int(10) primary key
);

create table if not exists medico(
codidentificacion int(10) primary key
);

create table if not exists ingreso(
 numingreso varchar(9),
 numhistorial int(10),
 codidentificacion int(10),
 primary key(numingreso),
 constraint fk_ingreso_paciente foreign key (numhistorial) references paciente(numhistorial),
 constraint fk_ingreso_medico foreign key (codidentificacion) references medico(codidentificacion)
);

insert into paciente values
(1),
(2),
(3)
;

insert into medico values
(1),
(2),
(3)
;

insert into ingreso values
(1,1,3),
(2,3,2),
(3,2,1)
;