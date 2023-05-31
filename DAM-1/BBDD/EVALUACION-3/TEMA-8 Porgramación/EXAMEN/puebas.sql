use datosorigen;

/*Prueba Ejercicio1*/
set @frec=0;
call frecuencia_nombres('Maria',@frec);
select @frec;

/*Prueba Ejercicio2*/
select frec_aleatoria();

/*Prueba Ejercicio3*/
use alquileres;
start transaction;
call borrar_ultimos_contratos(6);
select * from contratos;
rollback;

/*Prueba Ejercicio4*/
-- Parte A
use ligatercera;
start transaction;
insert into equipos values ('esp','españa','santona',null,null,null);
rollback;

-- Parte b

start transaction;
insert into partidos values(27,11,'ALB','BAR',5,5,curdate());
rollback;

-- Parte c

drop trigger insertarPartido;

start transaction;
insert into partidos values(27,11,'ALB','BAR',5,5,curdate());
rollback;