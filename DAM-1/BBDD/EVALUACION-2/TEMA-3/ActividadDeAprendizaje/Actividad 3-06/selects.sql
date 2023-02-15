create database if not exists nba;
use nba;

/*Primer Select*/
Create view jugadores_Hawks as SELECT nombre, procedencia, altura, posicion, archivofoto
FROM jugadores where nombre_equipo='Hawks';

/*Segundo Select*/
SELECT nombre FROM jugadores_Hawks;
/*Tercer Select*/
SELECT nombre FROM jugadores_hawks WHERE posicion='F';
SELECT * FROM jugadores_hawks WHERE locate('F', posicion)>0;

UPDATE jugadores_hawks SET nombre='John Smith' WHERE nombre='Josh Smith';  

INSERT INTO jugadores_hawks (nombre, procedencia, altura, posicion) VALUES ('Sergio Llull','Mahon','6-1','G');  

create view segunda as SELECT nombre, puntos_por_partido, asistencias_por_partido, rebotes_por_partido, tapones_por_partido 
FROM jugadores INNER JOIN estadisticas on jugador=codigo WHERE nombre_equipo='Hawks' AND temporada='05/06'; 

SELECT nombre, puntos_por_partido FROM segunda ORDER BY 
puntos_por_partido DESC;

drop view segunda;


