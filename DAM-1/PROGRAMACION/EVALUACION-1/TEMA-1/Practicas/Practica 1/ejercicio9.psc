Algoritmo ejercicio9
	Definir num1,num2,num3 Como Entero
	
	Escribir "Dime el primer numero";
	Leer num1
	
	Repetir
		Escribir "Dime el segundo numero";
		Leer num2
	Hasta Que num2<>num1
	
	Repetir
		Escribir "Dime el tercer numero";
		Leer num3
	Hasta Que num3<>num1 Y num3<>num2
	
	
	Si num1>num2 Y num1>num3 Entonces
		Escribir "El mayor es el primer numero";
	SiNo
		Si num1<num2 Y num3<num2 Entonces
			Escribir "El mayor es el segundo numero";
		SiNo
			Escribir "El mayor es el tercer numero";
		Fin Si
	Fin Si
	
FinAlgoritmo
