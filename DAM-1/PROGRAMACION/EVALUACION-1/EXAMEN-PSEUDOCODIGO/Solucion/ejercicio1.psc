Algoritmo ejercicio1
	
	Definir n Como Entero
	Definir i Como Entero
	Definir contador Como Entero
	
	contador=0
	
	Repetir
		Escribir "Introduce un número entero mayor que 1 para comprobar si es primo y par o impar."
		Leer n
	Hasta Que n>1
	
	
	Para i=1 Hasta n Con Paso 1
		si n mod i == 0
			contador = contador+1
		FinSi
	FinPara
	
	si contador == 2
		Escribir "El número es primo."
	SiNo
		Escribir "El número introducido no es primo."
	FinSi
	
	si n mod 2 == 0
		Escribir "El número es par."
	SiNo
		Escribir "El número es impar."
	FinSi
	
FinAlgoritmo
