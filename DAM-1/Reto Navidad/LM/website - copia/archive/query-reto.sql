#Se crea la base de datos
create database	if not exists museo;

#Se usa la base de datos creada
use museo;

#Se crean todas las entidades segun el esquema relacional previamente creado
create table if not exists EMPRESA(
	id_empresa int(5) unsigned not null ,
    nombre varchar(50) not null,
    nacionalidad varchar(15),
    primary key(id_empresa)
);

create table if not exists REVISTA(
	id_revista int(5) unsigned not null ,
    id_empresa int(5) unsigned not null,
	editorial varchar(50) not null,
    primary key(id_revista),
    constraint fk_revista_empresa foreign key(id_empresa) references EMPRESA(id_empresa)
);

create table if not exists DISEÑADOR(
	id_diseñador int(5) unsigned not null ,
    id_empresa int(5) unsigned not null,
    primary key(id_diseñador),
    constraint fk_diseñador_empresa foreign key(id_empresa) references EMPRESA(id_empresa)
);
create table if not exists FABRICANTE(
	id_fabricante int(5) unsigned not null ,
    id_empresa int(5) unsigned not null,
    primary key(id_fabricante),
    constraint fk_fabricante_empresa foreign key(id_empresa) references EMPRESA(id_empresa)
);
create table if not exists SOFTWARE(
	id_software int(5) unsigned not null ,
    id_diseñador int(5) unsigned not null,
    nombre varchar(50) not null,
    año int(4),
    propietario boolean default true,
    gratuito boolean default false,
    primary key(id_software),
    constraint fk_software_diseñador foreign key(id_diseñador) references DISEÑADOR(id_diseñador)
);
create table if not exists APLICACION(
	id_aplicacion int(5) unsigned not null ,
    id_software int(5) unsigned not null,
    version varchar(5) not null,
	so varchar(50) not null,
    primary key(id_aplicacion),
    constraint fk_aplicacion_software foreign key(id_software) references SOFTWARE(id_software)
);
create table if not exists VIDEOJUEGO(
	id_videojuego int(5) unsigned not null ,
    id_software int(5) unsigned not null,
	genero varchar(50) not null,
    primary key(id_videojuego),
    constraint fk_videojuego_software foreign key(id_software) references SOFTWARE(id_software)
);
create table if not exists MAQUINA(
	id_maquina int(5) unsigned not null ,
    id_fabricante int(5) unsigned not null,
	año int(4) not null,
    modelo varchar(50) not null,
    portatil boolean,
    primary key(id_maquina),
    constraint fk_maquina_fabricante foreign key(id_fabricante) references FABRICANTE(id_fabricante)
);
create table if not exists PERIFERICOS(
	id_periferico int(5) unsigned not null ,
    id_maquina int(5) unsigned not null,
    nombre varchar(50) not null,
    entrada boolean,
    salida boolean,
    primary key(id_periferico),
    constraint fk_periferico_maquina foreign key(id_maquina) references MAQUINA(id_maquina)
);

#Introducción de datos
INSERT INTO EMPRESA(id_empresa,nombre,nacionalidad)
VALUES 
(1, 'Nintendo','Japon'),
(2, 'Micromania','Espana'),
(3, 'Ediciones Plesa','Espana'),
(4, 'Computer Hoy','Espana'),
(5, 'La revolucion informatica','Espana'),
(6, 'Sony','Japon'),
(7, 'Microsoft','EEUU'),
(8, 'Delphi Developer','EEUU'),
(9, 'Commodore','EEUU'),
(10, 'Psygnosis','GB'),
(11, 'FunLabs','Rumania'),
(12, 'Generico','China');

INSERT INTO REVISTA (id_revista,id_empresa,editorial)
VALUES 
(1, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Micromania'),'Micromania'),
(2, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Ediciones Plesa'),'Computadoras'),
(3, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Computer Hoy'),'Computer Hoy'),
(4, (SELECT id_empresa FROM EMPRESA WHERE nombre ='La revolucion informatica'),'La revolucion Informatica');

INSERT INTO DISEÑADOR (id_diseñador,id_empresa)
VALUES 
(1, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Microsoft')),
(2, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Delphi Developer')),
(3, (SELECT id_empresa FROM EMPRESA WHERE nombre ='Psygnosis')),
(4, (SELECT id_empresa FROM EMPRESA WHERE nombre ='FunLabs'));

INSERT INTO SOFTWARE(id_software,id_diseñador,nombre,año,propietario,gratuito)
VALUES 
(1,1,'Visual Basic','1995',true,true),
(2,1,'Visual C++','1999',true,true),
(3,2,'Dolphin Developer','1996',false,true),
(4,1,'Microsoft Covol','1991',true,true),
(5,3,'F1-05','2005',true,false),
(6,4,'Dangerous Adventures','2003',true,false);

INSERT INTO APLICACION(id_aplicacion,id_software, version,so)
VALUES 
(1, 1,'4.0','Windows'),
(2, 2,'6.0','Windows'),
(3,3,'V2','Windows'),
(4,4,'V4.5','Windows');

INSERT INTO VIDEOJUEGO(id_videojuego,id_software,genero)
VALUES 
(1, 5,'Carreras'),
(2, 6,'Shooter');

INSERT INTO FABRICANTE(id_fabricante,id_empresa)
VALUES
(1,(SELECT id_empresa FROM EMPRESA WHERE nombre ='Nintendo')),
(2,(SELECT id_empresa FROM EMPRESA WHERE nombre ='Commodore')),
(3,(SELECT id_empresa FROM EMPRESA WHERE nombre ='Sony')),
(4,(SELECT id_empresa FROM EMPRESA WHERE nombre ='Generico'));

INSERT INTO MAQUINA(id_maquina,id_fabricante,año,modelo,portatil)
VALUES
(1,1,1996,'Gameboy',true),
(2,2,1982,'Commodore 64',false),
(3,2,2000,'PS2',false),
(4,1,2000,'Donkey Kong JR Tabletop',true);

INSERT INTO PERIFERICOS(id_periferico,id_maquina,nombre,entrada,salida)
VALUES
(1,3,'MandoPS2',True,false);
