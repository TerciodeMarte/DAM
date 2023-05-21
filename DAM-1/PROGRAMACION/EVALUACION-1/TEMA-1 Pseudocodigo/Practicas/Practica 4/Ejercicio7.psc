Algoritmo Ejercicio7
	Definir num1,num2,num3 Como Entero
	Escribir "Dame el primer numero";
	Leer num1;
	
	Escribir "Dame el segundo numero";
	Leer num2;
	
	Repetir
		Escribir "Opcion 1: Sumar";
		Escribir "Opcion 2: Restar";
		Escribir "Opcion 3: Multiplicar";
		Escribir "Opcion 3: Dividir";
		Escribir "Introduce 1,2,3 o 4 para elegir";
		Leer num3
	Hasta Que num3>=1 Y num3<=4
	
	Segun num3 Hacer
		1:
			Escribir num1+num2;
		2:
			Escribir num1-num2;
		3:
			Escribir num1*num2;
		4:
			Escribir num1/num2;
	Fin Segun
FinAlgoritmo
