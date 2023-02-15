Algoritmo tarea2
	//Introducir cuantas personas con edad aletoria quieres y calcular la media de los que son mayores de edad.
	Definir lectura,contador,div,random Como Entero
	Definir media Como Real
	
	Escribir "Voy a calcular la media de edad(aleatoria entre 1 y 120) del nº de personas que me digas";
	
	Repetir
		Escribir "Dime cuantas personas quieres";
		Leer lectura;
	Hasta Que lectura>1
		
	Para contador=1 Hasta lectura Con Paso 1 Hacer
		random=azar(120)+1;
		Escribir "La edad elegida para la persona nº " contador " es de " random " años ";
		Si random>=18 Entonces
			media=media+random;
			div=div+1;
		Fin Si
	Fin Para
	
	Escribir "La media de todas las edades aleatorias es: " media/div;
FinAlgoritmo
