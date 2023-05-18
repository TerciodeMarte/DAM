create database if not exists aa804;

use aa804;


/*Ejercicio1*/

set @dia='';
call dia_semana(2,@dia);
select @dia;

/*Ejercicio2*/

set @mes='';
call mes(month(curdate()),@mes);
select @mes;

/*Ejercicio3*/

set @formato='';
call fecha_formato_sp(curdate(),@formato);
select @formato;