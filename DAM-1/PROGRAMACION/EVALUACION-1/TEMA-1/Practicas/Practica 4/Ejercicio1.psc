Algoritmo Ejercicio1
	Definir num1,num2 Como Entero;
	
	Repetir
		Escribir "Dime un numero entero mayor que 0";
		Leer num1;
	Hasta Que num1>=0
	Repetir
		Escribir "Dime un otro numero entero mayor que 0";
		Leer num2;
	Hasta Que num2>=0
	
	Si num1%num2 = 0 Entonces
		Escribir "Los dos numeros son multiplos";
	SiNo
		Escribir "Los dos numeros no son multiplos entre si";
	Fin Si
FinAlgoritmo
