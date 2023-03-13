use ligatercera;

/*1.- Obtén los nombres de los equipos que tienen menos de 11 jugadores registrados.*/

select equipos.nombre from equipos inner join jugadores on equipo=codeq group by equipo having count(*)<11 ;

/*2.- Obtén los nombres de los equipos que tienen registrados 2 porteros.*/

select equipos.nombre from equipos inner join jugadores on equipo=codeq where puesto='portero' group by equipo having count(*)=2 ;

/*3.- Obtén, a partir de la tabla goles, cuantos goles se han marcado en cada jornada.*/

select jornada,count(*) from goles group by jornada;

/*4.- Obtén, a partir de la tabla goles, las jornadas en las que se han marcado más de 25 
goles.*/
select jornada,count(*) from goles group by jornada having count(*)>25;

/*5.- Obtén, a partir de la tabla partidos, cuantos goles ha marcado cada equipo jugando 
como local. Debe salir el nombre del equipo junto con el total de goles sólo si el total 
de goles es mayor que 4.*/
select nombre,sum(golesloc) from partidos inner join equipos on eqloc=codeq group by eqloc having sum(golesloc)>4;

/*6.a.- Obtén los nombres de los equipos contra los que ha jugado el S.D. Barreda 
jugando como local. No deben salir datos de partidos no jugados (golesloc a null).*/
select v.nombre from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where l.nombre='S.D. Barreda BP.' and golesloc is not null;

/*6.b.- Obtén los nombres de los equipos contra los que ha jugado el S.D. Barreda 
jugando como visitante. No deben salir datos de partidos no jugados*/
select l.nombre from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where v.nombre='S.D. Barreda BP.' and golesloc is not null;

/*7.a.- Obtén los nombres de los equipos contra los que ha jugado el S.D. Barreda. Para 
realizarlo debes utilizar las instrucciones de los ejercicios 6.a y 6.b.*/
select v.nombre from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where l.nombre='S.D. Barreda BP.' and golesloc is not null union 
select l.nombre from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where v.nombre='S.D. Barreda BP.' and golesloc is not null;

/*7.b.- Obtén los nombres de los equipos contra los que ha jugado el S.D. Barreda, el 
número de jornada del partido, los goles que metió, los que recibió y si jugó como local 
o como visitante. El resultado debe salir ordenado por número de jornada.*/

-- fumada
select numjornada,v.nombre as Visitante,l.nombre as Local ,golesloc as Goles_Barreda, golesvis as Goles_Visitante from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where l.nombre='S.D. Barreda BP.' and golesloc is not null union 
select numjornada,v.nombre,l.nombre,golesvis,golesloc from partidos inner join equipos as v on v.codeq=eqvis 
inner join equipos as l on eqloc=l.codeq where v.nombre='S.D. Barreda BP.' and golesloc is not null order by numjornada;

-- Sencilla
select numjornada,v.nombre as Visitante,l.nombre as Local ,golesloc as Goles_Barreda, golesvis as Goles_Visitante from partidos inner join equipos as l on l.codeq=eqloc
inner join equipos as v on v.codeq=eqvis where (l.nombre='S.D. Barreda BP.' or v.nombre='S.D. Barreda BP.') and golesloc is not null;

/*8.- Obtén el número total de goles que ha marcado el Club Deportivo Cayón jugando 
como local y el número total de goles que ha marcado jugando como visitante.*/
select sum(golesloc),sum(golesvis) from partidos inner join equipos as l on l.codeq=eqloc
inner join equipos as v on v.codeq=eqvis where (l.nombre='Club Deportivo Cayón' or v.nombre='Club Deportivo Cayón');

/*9.- Obtén el número total de goles que ha marcado cada equipo jugando como local y 
el número total de goles que ha marcado cada equipo jugando como visitante. El 
resultado debe estar ordenado alfabéticamente por nombre de equipo.*/

select eqloc,sum(golesloc) from partidos group by eqloc;
select eqvis,sum(golesvis) from partidos group by eqvis;


/*10.- Obtén cuantos jugadores de cada equipo no han marcado goles. Recuerda que 
una forma de obtener los jugadores que no han marcado goles es realizar un LEFT JOIN 
entre la tabla JUGADORES y la tabla GOLES. */

select equipos.nombre,count(*) from jugadores left join goles on numjug=Jugador inner join equipos on codeq=equipo where Jugador is null group by equipos.nombre;