use world;

-- Ejercicio 2

select * from country;

-- Ejercicio 3

select * from city;
-- Countrycode tiene la clave forenea a country

-- Ejercicio 4

select CountryCode from city where id=163;
select * from country where code= (select CountryCode from city where id=163); 

-- Ejercicio 5

select Name,LocalName,Continent,SurfaceArea,Population,LifeExpectancy,GNP from country;

-- Ejercicio 6

select Name,LocalName,Continent,SurfaceArea,Population,LifeExpectancy,GNP from country order by name asc;
/* asc es por defecto asi que no hace falta ponerlo*/

-- Ejercicio 7

select Name,LocalName,Continent,SurfaceArea,Population,LifeExpectancy,GNP from country order by Population desc;

-- Ejercicio 8

select Name,Continent,Population from country order by Continent,Name asc;

-- Ejercicio 9

select Name,Continent,Population from country order by Continent asc ,Population desc;

-- Ejercicio 10

select Name,Population,SurfaceArea from country order by Population desc limit 5;

-- Ejercicio 11

select Name,Population,SurfaceArea,Population/SurfaceArea from country order by Population/SurfaceArea desc;

-- Ejercicio 12

select Name,LifeExpectancy from country order by LifeExpectancy desc limit 11,19;

-- Ejercicio 13

select GovernmentForm from country;

-- Ejercicio 14

select distinct GovernmentForm from country;

-- Ejercicio 15

select Name from city where CountryCode="ESP";

-- Ejercicio 17

select name,Population from city where Population>=500000;

-- Ejercicio 18

select name,Population from city where Population>=500000 && CountryCode="ESP" ;

-- Ejercicio 19

select name,Population from city where CountryCode="ESP" || CountryCode="FRA";

-- Ejercicio 20

select name,Population from city where Population>=500000 && (CountryCode="ESP" || CountryCode="FRA");

