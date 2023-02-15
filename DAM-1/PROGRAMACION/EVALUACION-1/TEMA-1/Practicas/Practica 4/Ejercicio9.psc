Algoritmo Ejercicio9
	
	Definir letra Como Caracter;
	Definir contador Como Entero;
	
	Escribir "Escribe una A y yo cuento cuantas veces lo has echo";
	Escribir "Si quieres que pare escribe un *";
	
	Repetir
		Escribir "Introduce letra";
		Leer letra
		Si letra="A" Entonces
			contador=contador+1;
		Fin Si
	Hasta Que letra="*"
	Escribir "He contado " contador " letras A";
FinAlgoritmo
