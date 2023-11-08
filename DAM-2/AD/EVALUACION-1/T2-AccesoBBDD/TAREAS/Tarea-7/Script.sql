create database if not exists steam;
use steam;

-- Creación de usuarios
/*
CREATE USER 'user'@'localhost' IDENTIFIED BY '1234';
CREATE USER 'admin'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'localhost';
*/

create table juego (
id_juego int unsigned auto_increment,
nombre varchar(50),
tipo varchar(50),
primary key (id_juego)
);
 
-- drop table juego;
 
create table jugador (
id_jugador int unsigned auto_increment,
alias varchar(50),
nombre varchar(50),
primary key (id_jugador)
);
 
-- drop table jugador;
 
create table sesion (
id_jugador int unsigned,
id_juego int unsigned,
fecha TIMESTAMP default CURRENT_TIMESTAMP,
primary key(id_jugador,id_juego,fecha),
constraint fk_sesion_jugador foreign key (id_jugador) references jugador(id_jugador),
constraint fk_sesion_juego foreign key (id_juego) references juego(id_juego)
);

insert into juego (nombre, tipo) values 
('Super Mario Bros', 'Plataformas'), 
('Call of Duty', 'Shooter'), 
('Minecraft', 'Sandbox'), 
('The Legend of Zelda', 'Aventura'), 
('FIFA 23', 'Deportes'), 
('The Sims 4', 'Simulación'), 
('Grand Theft Auto V', 'Acción'), 
('Pokémon Espada y Escudo', 'Rol'), 
('Animal Crossing: new Horizons', 'Estrategia'), 
('Among Us', 'Social');

insert into jugador (alias, nombre) values 
('LaraCroft', 'Dolores García'), 
('MasterChief', 'Francisco López'), 
('Kratos', 'Rafael Sánchez'), 
('Link', 'David González'), 
('Mario', 'Carlos García'), 
('Sonic', 'Jorge Sánchez'), 
('Geralt', 'Daniel Martínez'), 
('NathanDrake', 'Pedro Díaz'), 
('Ellie', 'Sara Pérez'), 
('ArthurMorgan', 'Laura Rodríguez');

insert into sesion (id_jugador, id_juego) values 
(1, 1), 
(1, 2), 
(3, 5), 
(7, 3), 
(3, 10),
(5, 9),
(8, 2), 
(9, 3), 
(10, 6), 
(10, 9);