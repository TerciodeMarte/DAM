Algoritmo Ejercicio5
	Definir num1,contador,factorial Como Entero;
	factorial=1;
	Repetir
		Escribir "Dime un numero entero mayor que 0";
		Leer num1;
		contador=num1;
	Hasta Que num1>0
	
	Repetir
		factorial=factorial+contador;
		contador=contador-1;
	Hasta Que contador<=0
	Escribir "El suma de "  num1 " mas todos los anteriores es " factorial;
FinAlgoritmo
