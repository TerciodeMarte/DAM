CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_nombres`(IN n INT,OUT ultimo INT)
BEGIN
	DECLARE i INT;
	DECLARE nmaxhombre FLOAT;
	DECLARE nmaxmujer FLOAT;
	DECLARE aleat1 FLOAT;
	DECLARE aleat2 INT;
	DECLARE nomaleat VARCHAR(25);
    
	CREATE TABLE IF NOT EXISTS personas (
    num INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(25),
    apellido1 VARCHAR(25),
    apellido2 VARCHAR(25),
    dni CHAR(9),
    fecha_nac DATE,
    direccion VARCHAR(50),
    localidad VARCHAR(70),
    sexo CHAR(1)
	);
	SELECT MAX(hasta) INTO nmaxhombre FROM nombreshombre;
	SELECT MAX(hasta) INTO nmaxmujer FROM nombresmujer;
    
	SET i=0;
    
	WHILE i<n DO
		SET aleat1=rand();
		IF aleat1<0.5 THEN
			SET aleat2=floor(rand()*nmaxmujer);
			SELECT nombre INTO nomaleat FROM nombresmujer WHERE aleat2 >= desde AND aleat2 < hasta;
			INSERT INTO personas(nombre, sexo) VALUES (nomaleat,'M');
		ELSE
			SET aleat2=floor(rand()*nmaxhombre);
			SELECT nombre INTO nomaleat FROM nombreshombre WHERE aleat2 >= desde AND aleat2 < hasta;
			INSERT INTO personas(nombre, sexo) VALUES (nomaleat,'H');
		END IF;
		SET i=i+1;
	END WHILE;
	SET ultimo=(SELECT max(num) FROM personas);

END