#Creamos la base de datos
CREATE DATABASE IF NOT EXISTS CENTRO;

#Selecciones la base de datos
USE CENTRO;

CREATE TABLE IF NOT EXISTS grupos (
	id_grupo INT(10) not null auto_increment,
    nombre_etapa varchar(30) not null,
    nivel SET('1','2'),
    max_alumnos int(2),
    primary key(id_grupo)
);

CREATE TABLE IF NOT EXISTS alumnos (
	numAlumn INT(3) unsigned zerofill  not NULL auto_increment,
    nombre varchar(15) NOT NULL,
    apellido varchar(30) not null,
    direccion varchar(50),
    localidad varchar(10),
    dni varchar(9) not null unique,
    nie varchar(9),
    grupo int(10) not null,
    primary key(numAlumn),
    constraint fk_alumnos_grupos foreign key(grupo) references grupos(id_grupo)
);
CREATE TABLE IF NOT EXISTS modulos(
	codModulo varchar(6) not null,
    nombre varchar(15),
    horassemana int(2),
    transversal boolean default false,
    grupos int(10) not null,
    primary key (codModulo),
    constraint fk_modulos_grupos foreign key(grupos) references grupos(id_grupo)
);
create table if not exists horario(
	id_horario int(2) not null auto_increment,
    dia_semana enum('lunes','martes','miercoles','jueves','vierne`') not null,
    num_hora time not null,
    cod_modulo varchar(6) not null,
    primary key(id_horario),
    constraint fk_horario_modulos foreign key(cod_modulo) references modulos(codModulo)
);
create table if not exists cursadas(
	codModulo varchar(6) not null,
	numAlumn INT(3) unsigned not NULL,
    nota1 int(2) zerofill,
    nota2 int(2) zerofill,
    nota3 int(2) zerofill,
    notafinal1 int(2) zerofill,
    notafinal2 int(2) zerofill,
    primary key(codModulo,numAlumn),
    constraint fk_cursadas_modulos foreign key(CodModulo) references modulos(codModulo),
    constraint fk_cursadas_alumnos foreign key(numAlumn) references alumnos(numAlumn)
);
create table if not exists profesores(
	codProf int(4) unsigned not null auto_increment,
    nombre varchar(30),
    apellidos varchar(150),
    fechaAlta date,
    dni varchar(9) not null unique,
	direccion varchar(50),
    localidad varchar(10),
    primary key (codProf)
);
create table if not exists impartir(
	cod_profesor int(4) unsigned not null,
    cod_modulo varchar(6),
    titular boolean default false,
    primary key(cod_profesor,cod_modulo),
    constraint fk_impartir_modulos foreign key(cod_modulo) references modulos(codModulo),
	constraint fk_impartir_profesores foreign key(cod_profesor) references profesores(codProf)
);
create table if not exists titulaciones(
	cod_profesor int(4) unsigned not null auto_increment,
    num_tilt int(4) unsigned not null,
    tipo_tilt varchar(30) not null,
    nombre_tilt varchar(30) not null,
    primary key(cod_profesor,num_tilt),
    constraint fk_titulaciones_profesores foreign key(cod_profesor) references profesores(codProf)
);
create table if not exists horasapoyo(
	id_horaapoyo int(5) unsigned not null auto_increment,
	dia_semana enum('lunes','martes','miercoles','jueves','vierne`') not null,
    num_hora time not null,
    cod_prof int(4) unsigned,
    primary key (id_horaapoyo),
    constraint fk_horasapoyo_profesores foreign key(cod_prof) references profesores(codProf)
);
create table if not exists empresas(
	cif varchar(9) unique,
	nombre varchar(30),
    tipo varchar(30),
    direccion varchar(50),
    localidad varchar(10),
    primary key(cif)
);
create table if not exists contratos(
	id int(5) unsigned not null  auto_increment,
    cif varchar(9) not null,
    numAlumn INT(3) unsigned,
    fecha_ini date not null,
    fecha_fin date not null,
    hora_ini time not null,
    hora_fin time not null,
    primary key(id),
    constraint fk_contratos_empresas foreign key (cif) references empresas(cif),
    constraint fk_contratos_alumnos foreign key(numAlumn) references alumnos(numAlumn)
);

