/*Ejercicio1*/
CREATE USER 'albano'@'localhost' IDENTIFIED BY '1234';

/*Ejercicio3*/
GRANT all on *.* TO 'albano'@'localhost';
flush privileges;

/*Ejercicio4*/
create database word;
create USER 'albano'@'192.168.24.%' identified by '1234';
grant select on word.* to 'albano'@'192.168.24.%';

/*Ejercicio 6*/
create user 'prueba'@'localhost' identified by '1234';
create user 'prueba'@'192.168.24.11' identified by '1234';

/* Ejercicio 8*/
GRANT insert, update, drop, select ON nba.* TO 'prueba'@'localhost';
GRANT insert, update, drop, select ON nba.* TO 'prueba'@'192.168.24.11';
flush privileges;

