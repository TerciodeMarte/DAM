/*Prueba Trigger 1*/

start transaction;
insert into equipos values ('esp','españa','santona',null,null,null);
rollback;

/*Prueba Trigger 2*/

start transaction;
insert into partidos values(27,11,'ALB','BAR',5,5,curdate());
rollback;

/* Prueba Trigger 3*/

drop trigger insertarPartido;

start transaction;
insert into partidos values(27,11,'ALB','BAR',5,5,curdate());
rollback;

/*Prueba Trigger 4*/
start transaction;
update partidos set golesloc=2, golesvis=2 where numjornada=26 and numpartido=10;
rollback;

/*Prueba Trigger 5*/
drop trigger partidoEnJuego;
start transaction;
alter table clasificacion add column pp int default 0 after pe;
update partidos set golesloc = 0, golesvis = 0 where numjornada = 26 and numpartido = 10;
update partidos set golesloc = 1, golesvis = 0 where numjornada = 26 and numpartido = 10;
update partidos set golesloc = 1, golesvis = 1 where numjornada = 26 and numpartido = 10;
update partidos set golesloc = 2, golesvis = 1 where numjornada = 26 and numpartido = 10;
rollback;

