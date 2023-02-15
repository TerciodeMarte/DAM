Algoritmo ejercicio8
	Definir num,random Como Entero;
	random=azar(20)+1;
	
	Mientras random<>num Hacer
		Escribir "Dime el numero haber si aciertas(Rango 0 a 20)";
		Leer num;
		Si random<num Entonces
			Escribir "El numero oculto es menor";
		SiNo
			Si random>num Entonces
				Escribir "El numero oculto es mayor";
			Fin Si
		Fin Si
	Fin Mientras
	Escribir "Advinastes el numero";
	Escribir "El numero era " random;
	
FinAlgoritmo
