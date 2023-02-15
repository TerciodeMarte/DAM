create database IF NOT exists music_contest;

use music_contest;

create table if not exists grupos(
	codgrupo int(5) zerofill unsigned auto_increment,
    nombre varchar(15) not null,
    localidad varchar(30) not null,
    estilo varchar(15) not null,
    esgrupo boolean not null default true,
    annoGrab date,
    fechaEstreno date,
    compania varchar(15),
    primary key(codgrupo)
);
create table if not exists componentes(
	idComp int(5) zerofill unsigned auto_increment,
    nombre varchar(15) not null ,
    apellidos varchar(30) not null ,
    alias varchar(15),
    funcion set('batería', 'vocalista', 'voz' , 'guitarra'),
    grupo int(5) unsigned not null,
    primary key (idComp),
	constraint fk_componentes_grupos foreign key(grupo) references grupos(codgrupo)
);

create table if not exists canciones(
	numCancion int(5) zerofill unsigned auto_increment,
    grupo int(5) unsigned not null,
    duracion time not null,
    titulo varchar(15) not null,
    primary key (numCancion),
    constraint fk_canciones_grupos foreign key(grupo) references grupos(codgrupo)
);
create table if not exists usuarios(
	idUsuario int(5) zerofill unsigned auto_increment,
	usuario varchar(15) unique not null,
    contraseña varchar(20) not null,
    nombre varchar(15) not null,
    apellidos varchar(30) not null,
    fechanac date,
    primary key (idUsuario)
);
create table if not exists votos(
	numVoto int(5) zerofill unsigned auto_increment,
    usuario int(5) unsigned not null,
    fecha date not null,
    cancion int(5) unsigned not null,
    primary key (numVoto),
    constraint fk_votos_usuarios foreign key(usuario) references usuarios(idUsuario),
    constraint fk_votos_canciones foreign key(cancion) references canciones(numCancion)
);

