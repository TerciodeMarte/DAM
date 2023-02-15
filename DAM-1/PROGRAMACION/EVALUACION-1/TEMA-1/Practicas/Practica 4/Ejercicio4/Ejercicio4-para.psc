Algoritmo Ejercicio4
	
	Definir num1,contador,factorial Como Entero;
	factorial=1;
	Repetir
		Escribir "Dime un numero entero mayor que 0";
		Leer num1;
	Hasta Que num1>0
	
	Para contador=num1 Hasta 1 Con Paso -1 Hacer
		factorial=factorial*contador;
	Fin Para
	Escribir "El factorial de "  num1 " es " factorial;
	
FinAlgoritmo
