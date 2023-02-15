Algoritmo Ejercicio4
	Definir num1,contador,factorial Como Entero;
	factorial=1;
	Repetir
		Escribir "Dime un numero entero mayor que 0";
		Leer num1;
		contador=num1;
	Hasta Que num1>0
	
	Mientras contador>0 Hacer
		factorial=factorial*contador;
		contador=contador-1;
	Fin Mientras
	Escribir "El factorial de "  num1 " es " factorial;
	
FinAlgoritmo
