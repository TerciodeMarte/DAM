//Algoritmo que permite introducir un número por teclado un número natural mayor 
//que 1 y deberá devolver un mensaje diciendo sin el número es primo. Además, 
//deberá devolver si el número introducido es par o impar. Se debe asegurar que el 
//número introducido sea siempre natural y mayor que 1. (Un número primo es todo 
//aquel que tenga como únicos divisores él mismo y el número 1).

Algoritmo ejercicio1
	
	Definir num Como Entero;
	Definir aux Como Logico;
	
	aux=Falso;
	
	Repetir
		
		Escribir "Dime un numero en numero entero mayor que 1"
		Leer num
		
		Si num MOD 2 == 0  Entonces
			Escribir "El numero introducido  es par";
		SiNo
			Escribir "El numero introducido es impar";
		Fin Si
		
	Hasta Que num>1
	
	Para i=2 Hasta num-1 Con Paso 1 Hacer
		Si num MOD i ==0 Entonces
			aux=Verdadero;
		Fin Si
	Fin Para
	Si aux==Falso Entonces
		Escribir "Ademas es primo";
	SiNo
		Escribir "Ademas no es primo";
	Fin Si
FinAlgoritmo
