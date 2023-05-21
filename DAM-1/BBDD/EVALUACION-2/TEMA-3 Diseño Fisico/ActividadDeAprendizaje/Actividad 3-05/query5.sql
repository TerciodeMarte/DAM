/*Creacion de base de datos*/
create database if not exists agencia;

use agencia;

/*Ejercicio 1 creacion de tablas*/

create table if not exists EMPLEADOS(
	idEmp int(3) unsigned auto_increment,
    nombre varchar(15) not null,
    apellidos varchar(30) not null,
    primary key(idEmp)
);
create table if not exists ADMINS(
		idEmp int(3) unsigned auto_increment,
        fecha date not null,
        estudios varchar(15),
        primary key(idEmp),
        constraint fk_admins_empleados foreign key(idEmp) references EMPLEADOS(idEmp)
	);
create table if not exists MEDIADORES(
		idEmp int(3) unsigned auto_increment,
        nivel int(3) unsigned not null default 0,
        primary key(idEmp),
        constraint fk_mediadores_empleados foreign key(idEmp) references EMPLEADOS(idEmp)
	);
create table if not exists HOMBRES(
		idHombre int(3) unsigned auto_increment,
		nombre varchar(15) not null,
		apellidos varchar(30) not null,
        primary key(idHombre)
	);
create table if not exists MUJERES(
		idMujer int(3) unsigned auto_increment,
		nombre varchar(15) not null,
		apellidos varchar(30) not null,
        primary key(idMujer)
	);
create table if not exists CITAS(
		Mediador int(3) unsigned,
		idMujer int(3) unsigned ,
		idHombre int(3) unsigned,
        fechaCita date not null,
        primary key(idHombre,idMujer),
        constraint fk_citas_mediadores foreign key(Mediador) references MEDIADORES(idEmp),
        constraint fk_citas_hombres foreign key(idHombre) references HOMBRES(idHombre),
        constraint fk_citas_mujeres foreign key(idMujer) references MUJERES(idMujer)
	);
create table if not exists MATRIS(
		idMat int(3) unsigned auto_increment, 
		fecha date,
        idMujer int(3) unsigned ,
		idHombre int(3) unsigned,
        primary key(idMat),
        constraint fk_matris_citas foreign key(idMujer,idHombre) references CITAS(idMujer,idHombre)
        );

    