Algoritmo Ejercicio12
	Definir anno Como Entero;
	
	Escribir "Ingresa un año";
	leer anno;
	si ano mod 4 == 0 Entonces
		si año mod 100 == 0 Entonces
			si año mod 400 == 0 Entonces
				Escribir "El año ",anno," es bisiesto";
			sino
				Escribir "El año ",anno," no es bisiesto";
			FinSi
		SiNo
			Escribir "El año ",anno," es bisiesto";
		FinSi
	SiNo
		Escribir "El año ",anno," no es bisiesto";
	FinSi
FinAlgoritmo
