use alquileres;
-- Ejercicio 1
select * from automoviles;
-- Ejercicio 2
select alquilo,matricula,marca,modelo,color,precio from automoviles;
-- Ejercicio 3
select matricula,marca,modelo,precio,precio*1.1 from automoviles;
-- Ejercicio 4
select matricula,marca,modelo,precio from automoviles order by marca,modelo;
select matricula,marca,modelo,precio from automoviles order by precio desc;

-- Ejercicio 5
select distinct color from automoviles;
select count(distinct color) from automoviles;

-- Ejercicio 6
select matricula,marca,modelo from automoviles limit 5;

-- Ejercicio 7
select matricula,marca,modelo,precio from automoviles order by precio desc limit 1,5;
-- Ejercicio 8
select nombre,apellidos from clientes order by fnac desc limit 1;