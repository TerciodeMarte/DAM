Algoritmo ejercicio3
	Definir lado,altura,profundidad,volumen Como Real
	
	Mientras lado<=0 Hacer
		Escribir "Dime el lado del ortoedro";
		Leer lado;
	Fin Mientras
	
	Mientras profundidad<=0 Hacer
		Escribir "Dime la profundidad del ortoedro";
		Leer profundidad;
	Fin Mientras
	
	Mientras altura<=0 Hacer
		Escribir "Dime la altura del ortoedro";
		Leer altura;
	Fin Mientras
	
	volumen=lado*altura*profundidad;
	
	Escribir "El volumen del ortoedro es: " volumen;
	
FinAlgoritmo
