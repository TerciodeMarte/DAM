
Algoritmo ejercicio1
	Definir base,altura,perimetro,area Como Real;
	
	Mientras base<=0 Hacer
		Escribir "Dime la base del rectangulo";
		Leer base;
	Fin Mientras
	Mientras altura<=0 Hacer
		Escribir "Dime la altura del rectangulo";
		Leer altura;
	Fin Mientras
	
	perimetro=base*2+altura*2;
	area=base*altura;
	
	Escribir "El perimetro es: " perimetro;
	Escribir "El area es: " area;

FinAlgoritmo
