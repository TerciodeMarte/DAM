Algoritmo tarea1
	//Introducir 50 edades y calcular la media de los que son mayores de edad.

	Definir lectura,contador,div Como Entero
	Definir media Como Real

	Para contador=1 Hasta 50 Con Paso 1 Hacer
		
		Repetir
			Escribir "Dime la edad de la persona nº " contador " (Entre 1 y 120 años)";
			Leer lectura;
		Hasta Que lectura>1 Y lectura<120
		
		Si lectura>=18 Entonces
			media=media+lectura;
			div=div+1;
		Fin Si
	Fin Para
	
	Escribir "La media de todas las edades introducidas es: " media/div;
FinAlgoritmo
