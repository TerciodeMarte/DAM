/*5.- Añade funcionalidad al trigger partidoEnJuego anterior para que actualice la 
clasificación cuando se modifica el resultado desde un resultado anterior no nulo.
Por ejemplo, cuando el resultado era 1-1 y pasa a ser 2-1, habría que hacer lo siguiente:
- El equipo local tiene un partido menos empatado.
- El equipo visitante tiene un partido menos empatado.
- El equipo local tiene un partido más ganado.
- El equipo visitante tiene un partido más perdido.
- Al equipo local se le suma un gol a favor y no se le suman goles en contra. Esto 
se debe hacer por las diferencias entre los nuevos goles y los anteriores goles.
- Al equipo visitante se le suma un gol en contra y no se le suman goles a favor. 
- Se obtienen y cargan los puntos de los equipos local y visitante (3*pg+pe).
En definitiva:
● Hay que saber cuál era el resultado del partido y, en función de ello descontar el 
número de partidos ganados, empatados o perdidos por los equipos.
● Hay que saber cuál es el nuevo resultado del partido y, en función de ello 
incrementar el número de partidos ganados, empatados o perdidos por los 
equipos.
● Hay que saber la diferencia entre los nuevos goles y los anteriores del local para 
sumárselos a favor al local y descontárselos al visitante en la clasificación. 
● Hay que saber la diferencia entre los nuevos goles y los anteriores del visitante 
para sumárselos a favor al visitante y descontárselos al local en la clasificación.*/
use ligatercera;

delimiter //
CREATE trigger partidoEnJuego before update on partidos for each row

BEGIN

declare difgolesloc int;
declare difgolesvis int;


if (select golesloc from partidos where eqloc = new.eqloc and eqvis = new.eqvis) is null then
set new.golesloc=0;
set new.golesvis=0;

update clasificacion set pj = pj+1 where codeq = new.eqloc or codeq = new.eqvis;
update clasificacion set pe = pe+1 where codeq = new.eqloc or codeq = new.eqvis;
update clasificacion set puntos = puntos+1 where codeq = new.eqloc or codeq = new.eqvis;

elseif (select golesloc from partidos where eqloc = new.eqloc and eqvis = new.eqvis) is not null then

	if	new.golesloc > new.golesvis then
        if old.golesloc < old.golesvis then
            update clasificacion set pg = pg + 1, pp = pp - 1, puntos = puntos + 3 where codeq = new.eqloc;
            update clasificacion set pg = pg - 1, pp = pp + 1, puntos = puntos -3 where codeq = new.eqvis;
        end if;
        if old.golesloc = old.golesvis then
            update clasificacion set pe = pe -1 , pg = pg + 1, puntos = puntos + 2 where codeq = new.eqloc;
            update clasificacion set pe = pe -1 , pp = pp + 1, puntos = puntos -1 where codeq = new.eqvis;
        end if; 
	end if;
	if	new.golesloc < new.golesvis then
        if old.golesloc > old.golesvis then
            update clasificacion set pg = pg -1, pp = pp + 1, puntos = puntos - 3 where codeq = new.eqloc;
            update clasificacion set pg = pg + 1, pp = pp - 1, puntos = puntos +3 where codeq = new.eqvis;
        end if;
        if old.golesloc = old.golesvis then
            update clasificacion set pe = pe -1 , pp = pp + 1, puntos = puntos - 1  where codeq = new.eqloc;
            update clasificacion set pe = pe -1 , pg = pg + 1, puntos = puntos + 2 where codeq = new.eqvis;
        end if;

	end if;
    if	new.golesloc = new.golesvis then
        if old.golesloc > old.golesvis then
            update clasificacion set pe = pe + 1, pg = pg - 1, puntos = puntos - 2 where codeq = new.eqloc;
            update clasificacion set pe = pe + 1, pp = pp - 1, puntos = puntos + 1 where codeq = new.eqvis;
        end if;
        if old.golesloc < old.golesvis then
            update clasificacion set pe = pe + 1, pp = pp - 1, puntos = puntos + 1 where codeq = new.eqloc;
            update clasificacion set pe = pe + 1, pg = pg - 1, puntos = puntos - 2 where codeq = new.eqvis;
        end if;
	end if;
set difgolesloc = new.golesloc - old.golesloc;
set difgolesvis = new.golesvis - old.golesvis;
update clasificacion set gf= gf + difgolesloc, gc= gc + difgolesvis where codeq = new.eqloc;
update clasificacion set gf= gf + difgolesvis, gc= gc + difgolesloc where codeq = new.eqvis;
end if;


END//
delimiter ;