Algoritmo Ejercicio11
	
	Definir num,sumapar,sumaimpar Como Entero
	
	Para num=1 Hasta 100 Con Paso 1 Hacer
		Si num MOD 2 = 0 Entonces
			sumapar=sumapar+num;
		SiNo
			sumaimpar=sumaimpar+num;
		Fin Si
	Fin Para
	
	Escribir "La suma de los pares es: " sumapar;
	Escribir "La suma de los impares es: " sumaimpar;
	
FinAlgoritmo
