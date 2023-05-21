use centro;
/*Ejercicio 1*/
alter table alumnos MODIFY COLUMN localidad varchar(20);

/*Ejercicio 2*/
create index k_loc_alumnos ON alumnos (localidad);

/*Ejercicio 3*/
create index k_ape_alumnos on alumnos(apellido);

/*Ejercicio 4*/
ALTER TABLE alumnos DROP COLUMN nie ;
alter table alumnos add nie int after dni;

/*Ejercicio 5*/
alter table alumnos modify column nie int unique;
create index uk_NIE_alumnos ON alumnos (nie);

/*Ejercicio 6*/
alter table alumnos modify column nie char(6) unique;

/*Ejercicio 7*/
create table if not exists horario(
	id_horario int(2) not null auto_increment,
    dia_semana enum('lunes','martes','miercoles','jueves','viernes') not null,
    num_hora time not null,
    cod_modulo varchar(6) not null,
    primary key(id_horario),
    constraint fk_horario_modulos foreign key(cod_modulo) references modulos(codModulo)
    
);

/*Ejercicio 8*/
ALTER TABLE horasapoyo DROP CONSTRAINT fk_horasapoyo_profesores;
alter table horasapoyo drop column cod_prof;
alter table horasapoyo add column profesor int (4) unsigned;
alter table horasapoyo add column modulo varchar(6);
alter table horasapoyo add constraint fk_horasapoyo_impartir_profesor foreign key(profesor) references impartir(cod_profesor);
alter table horasapoyo add constraint fk_horasapoyo_impartir_modulo foreign key(modulo) references impartir(cod_modulo);

