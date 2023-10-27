Create table if not exists zoo(
    zooID SERIAL primary key,
    nombre varchar(100) not null,
    ciudad varchar(100) not null,
    tamano double precision not null,
    presupuestoAnual double precision not null
);

Create table if not exists especie (
    especieID SERIAL primary key,
    nombreComun varchar(100) not null,
    nombreCientifico varchar(200) not null,
    familiaAnimal varchar(200) not null,
    peligroExtincion boolean not null
);

Create table if not exists animal (
    animalID SERIAL primary key,
    zooID int not null,
    especieID int not null,
    anoNacimiento date not null,
    paisNacimiento varchar(200) not null,
    CONSTRAINT fk_animal_especie FOREIGN KEY (especieID) REFERENCES especie(especieID),
    CONSTRAINT fk_animal_zoo FOREIGN KEY (zooID) REFERENCES zoo(zooID)
);

insert into zoo(nombre,ciudad,tamano,presupuestoanual) values
('Cabarceno','Penagos',10000,200000),
('Zoo de Santillana','Santillana',15000,500000),
('Loro Park','Benidorm',16000,500000),
('Terra Natura','Benidorm',12000,500000),
('Aquarium','Finisterrae',17000,2000000),
('BioParc','Gijón',21000,2500000),
('Central Park','New York',2000,10000),
('Zoo 1','Paris',25000,200000),
('Zoo 2','Roma',17000,200000),
('Zoo 3','Londres',18600,200000);


insert into especie(nombrecomun,nombrecientifico,familiaanimal,peligroextincion) values
('Perro','Canis familiaris','Canidos',false),
('Gato','Felis silvestris catus','Felidae',false),
('Elefante africano','Loxodonta africana' , 'Elephantidae',true),
('León', 'Panthera leo', 'Felidae',true),
('Cebra',' Equus quagga','Equidae',true),
('Jirafa Giraffa','camelopardalis','Giraffidae',false),
('Tigre de Bengala','Panthera tigris tigris','Felidae',false),
('Oso polar','Ursus maritimus','Ursidae',false),
('Rinoceronte de Java','Rhinoceros sondaicus','Rhinocerotidae',true),
('Tigre de Sumatra','Panthera tigris sumatrae','Felidae',true),
('Oso polar','Ursus maritimus','Ursidae',true);

insert into animal(zooid,especieid,anonacimiento,paisnacimiento) values
(1,2,'2018-01-01','Canada'),
(5,3,'2019-01-01','Japon'),
(5,3,'2020-01-01','Japon'),
(6,5,'2021-01-01','Japon'),
(6,5,'2022-01-01','Japon'),
(7,1,'2018-01-01','Venezuela'),
(7,1,'2019-01-01','Venezuela'),
(2,2,'2020-01-01','Portugal'),
(10,1,'2021-01-01','Nigeria'),
(9,4,'2022-01-01','Puerto Rico');
