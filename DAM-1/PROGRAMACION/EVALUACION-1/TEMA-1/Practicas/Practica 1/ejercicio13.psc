Algoritmo ejercicio13
	Definir num Como Entero;
	Definir x Como Cadena;
	Repetir
		Escribir "Dame un numero entre -20 y 20";
		Leer num;
	Hasta Que num<20 O num>-20
	Si num<=0 Entonces
		x=ConvertirATexto(num)
		Para i=num+1 Hasta 0 Con Paso 1 Hacer
			x=Concatenar(Concatenar(x,","),ConvertirATexto(i))
		Fin Para
		Escribir "La cadena desde el numero que me has dicho es " x;
	SiNo
		x=ConvertirATexto(num)
		Para i=num-1 Hasta 0 Con Paso -1 Hacer
			x=Concatenar(Concatenar(x,","),ConvertirATexto(i))
		Fin Para
		Escribir "La cadena desde el numero que me has dicho es " x;
	Fin Si
	
	
FinAlgoritmo
