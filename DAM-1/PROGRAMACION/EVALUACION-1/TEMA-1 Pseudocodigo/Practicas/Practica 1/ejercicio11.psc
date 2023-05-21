Algoritmo ejercicio11
	Definir num Como Entero;
	Definir x Como Cadena;
	num=-1;
	Mientras num>10 O num<0 Hacer
		Escribir "Dame un numero entre 0 y 10";
		Leer num;
	Fin Mientras
	x=ConvertirATexto(num)
	Para i=num+1 Hasta 20 Con Paso 1 Hacer
		x=Concatenar(Concatenar(x,","),ConvertirATexto(i))
	Fin Para
	Escribir "La cadena desde el numero que me has dicho es " x;
FinAlgoritmo
