/*3.- Modifica el procedimiento anterior para que:
Si no existe el número de persona, escribirá un mensaje en pantalla indicando tal 
circunstancia.*/
CREATE PROCEDURE `asigna_direccion`(in numper INT)
BEGIN

declare auxdir varchar(100);
declare alea int;
declare max int;
declare municipio varchar(70);
declare provincia2 varchar(30);

if (select num from personas where num = numper) != false then
set alea = (select round((rand()*count(*))+1)  from calles);
set auxdir = (select concat(nomcalle, ", " ,round((rand()*60)+1)) from calles where idcalle = alea);

set max = (select max(hasta) from municipios);
set municipio = (select nommunicipio from municipios where hasta >= round(rand()*max) limit 1); 
set provincia2 = (select provincia from municipios where nommunicipio = municipio);

update personas set direccion = auxdir , localidad = municipio , provincia = provincia2  where num = numper;
else
select 'No he encontrado a la persona picha';
end if;
END