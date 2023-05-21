Algoritmo Ejercicio14
	Definir num1,num2,num3 Como Entero
	Escribir "Dame el primer numero";
	Leer num1;
	
	Escribir "Dame el segundo numero";
	Leer num2;
	
	Repetir
		Escribir "Opcion 1: Restar";
		Escribir "Opcion 2: Multiplicar";
		Escribir "Introduce 1 o 2 para elegir";
		
		Leer num3
	Hasta Que num3=1 O num3=2
	
	Segun num3 Hacer
		1:
			Escribir num1-num2;
		2:
			Escribir num1*num2;
	Fin Segun

FinAlgoritmo
