use world;

-- Ejercicio 1

select Code from country where Name="Spain";

-- Ejercicio 2

select name,Population from city where CountryCode= (select Code from country where Name="Spain");

-- Ejercicio 3

select name,Population from city where CountryCode= (select Code from country where Name="Spain") && Population>250000 order by Population desc ;

-- Ejercicio 4

select Language,Percentage from countrylanguage where CountryCode=(select Code from country where Name="Spain");

-- Ejercicio 5

select name from country where Continent="Europe";
select name from country where Continent=2;

-- Ejercicio 6

select distinct District from city where CountryCode="RUS";

-- Ejercicio 7

select Name,Population,GNP,GNP/Population as Renta from country where Continent in ("Africa","Asia");

-- Ejercicio 8a

select Name,Continent,Population,GNP,(1000000*GNP/Population) as Renta from country where Continent!="Europe" order by Renta desc;

-- Ejercicio 8b

select Name,Continent,Population,GNP,(1000000*GNP/Population) as Renta from country where Continent!="Europe" order by Continent, Renta desc;

-- Ejercicio 9a

select CountryCode,Language from countrylanguage where Percentage>90 order by Language;

-- Ejercicio 9b

select distinct Language from countrylanguage where Percentage>90 order by Language;

-- Ejercicio 10

select Name,LifeExpectancy from country where Continent="Africa" && LifeExpectancy between 55 and 65;
