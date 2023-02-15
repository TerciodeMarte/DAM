Algoritmo Ejercicio5
	Definir num1,contador,factorial Como Entero;
	factorial=1;
	Repetir
		Escribir "Dime un numero entero mayor que 0";
		Leer num1;
	Hasta Que num1>0
	
	Para contador=num1 Hasta 1 Con Paso -1 Hacer
		factorial=factorial+contador;
	Fin Para
	Escribir "El suma de "  num1 " mas todos los anteriores es " factorial;
FinAlgoritmo
