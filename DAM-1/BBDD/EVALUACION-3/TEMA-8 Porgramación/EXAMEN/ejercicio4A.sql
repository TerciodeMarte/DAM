/*1.- Realiza un trigger insertarEquipo que provoca que, al insertar un nuevo equipo en la 
tabla equipos, lo inserta automáticamente en la tabla clasificación.*/
use ligatercera;
delimiter //

create trigger insertarEquipo after insert on equipos 
for each row
begin
insert into clasificacion(codeq) values(NEW.codeq);
end//

delimiter ;