/* Ejercicio 1*/
CREATE DATABASE if not exists liga;

use liga;

/*Ejercicio 2*/
create table if not exists EQUIPO(
codeq int(3) unsigned, -- char(3)
nombre varchar(40) unique not null, -- no hace falta ni el unique ni el not null porque es clave secundaria
localidad varchar(15) not null,
estadio varchar(15),
escudo varchar(60),
fotoplantilla varchar(60),
primary key (codeq),
unique key(nombre)
);

/*Ejercicio 3*/
create table if not exists JUGADOR(
numjug int(3) unsigned auto_increment,
alias varchar(15) not null,
nombre varchar(15),
apellidos varchar(15),
fechanac date,
tarjamarillas int(3) unsigned default 0,
tarjrojas int(3) unsigned default 0,
equipo int(3) unsigned, -- char(3)
puesto enum('portero','defensa','centrocampista','delantero'),
primary key (numjug),
constraint fk_jugador_equipo foreign key(equipo) references EQUIPO(codeq) on update cascade on delete restrict
);

/*Ejercicio 4*/
create table if not exists CLASIFICACION(
codeq int(3) unsigned,
pj int(3) unsigned default 0,
pg int(3) unsigned default 0,
pe int(3) unsigned default 0,
gf int(3) unsigned default 0,
gc int(3) unsigned default 0,
puntos int(5) unsigned default 0,
primary key (codeq),
constraint fk_clasificacion_equipo foreign key(codeq) references EQUIPO(codeq) on update restrict on delete cascade
);
/*Ejercicio 5*/
create table if not exists PARTIDO(
numjornada int(2),
numpartido int(2),
eqloc int(3) unsigned, -- char(3)
eqvis int(3) unsigned,  -- char(3)
golesloc int(2) unsigned,
golesvis int(2) unsigned,
fecha date,
primary key (numjornada,numpartido),
constraint fk_partido_equipo_eqloc foreign key (eqloc) references EQUIPO(codeq) on update restrict on delete cascade,
constraint fk_partido_equipo_eqvis foreign key (eqvis) references EQUIPO(codeq) on update restrict on delete cascade
-- unique uk_local_visitante(equipoLOC,equipVsi),
);
/* No se como crear los rangos que me pides en las columnas numjornada y numpartido asi que he puesto 
el tipo de dato numero que mas se aproxima a ese rango.*/
/*Tampoco se crear dos claves foreneas con el mismo constraint asi que lo he divido en dos*/
/* Y no te dijo de hacerlo unico a los dos juntos*/

/*Ejercicio 6*/
alter table PARTIDO drop foreign key fk_partido_equipo_eqloc;
alter table PARTIDO drop foreign key fk_partido_equipo_eqvis;
alter table PARTIDO add constraint fk_partido_equipo_eqloc foreign key (eqloc) references EQUIPO(codeq) on update restrict on delete restrict;
alter table PARTIDO add constraint fk_partido_equipo_eqvis foreign key (eqvis) references EQUIPO(codeq) on update restrict on delete restrict;

/*Ejercicio 7*/
create table if not exists GOL(
	numfila int(5) unsigned,-- autoincremental
    jornada int(2),
    numpartido int(2),
    periodo ENUM('1','2'),
    minuto time,
    jugador int(3) unsigned,
    pp boolean default false,
    primary key (numfila),
    constraint fk_gol_partido foreign key(jornada,numpartido) references PARTIDO(numjornada,numpartido) on delete cascade
);
/*No se puede hacer el borrado a nulo del jugador porque la tabla gol no esta relacionada*/
/*En la clave forenea me crea el indice pero no me engancha con la tabla partido y no se porque*/

/*Ejercicio 8*/

alter table CLASIFICACION add column numppvisit int(3) unsigned;
alter table CLASIFICACION add column numpplocal int(3) unsigned;-- Sobra esta linea

/*Ejercicio 9*/

create index i_alias on JUGADOR(alias);