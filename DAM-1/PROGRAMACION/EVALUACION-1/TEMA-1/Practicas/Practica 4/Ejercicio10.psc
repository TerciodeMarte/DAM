Algoritmo Ejercicio10
	Definir num,suma Como entero;

	
	Escribir "Sumo todos los numeros que me des";
	Escribir "Si quieres que pare escribe un 0";
	
	Repetir
		Escribir "Introduce numero";
		Leer num
		Si num <> 0 Entonces
			suma=suma+num;
		Fin Si
	Hasta Que num=0;
	Escribir "La suma de todos los numeros es: " suma;
	
FinAlgoritmo
