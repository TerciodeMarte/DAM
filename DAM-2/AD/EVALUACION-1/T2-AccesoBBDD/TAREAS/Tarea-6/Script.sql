create database if not exists bugisoft;

use bugisoft;

create table if not exists users(
id int(2) unsigned auto_increment ,
name varchar(10)not null,
password varchar(50)not null,
PRIMARY KEY (id)
);

INSERT INTO users(name,password) VALUES
('albano','1234'),
('daniel','4321'),
('ramiro','5678');