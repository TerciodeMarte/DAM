Algoritmo Ejercicio6
	Definir dia,mes,ano,diaa,mesa,anoa,auxiliar Como Entero
	
	//Introduccion fecha actual
	
	Repetir
		Escribir "Dime el dia actual";
		Leer diaa;
	Hasta Que diaa>0 Y diaa<=31
	
	Repetir
		Escribir "Dime el mes actual";
		Leer mesa;
	Hasta Que mesa>0 Y mesa<=12
	
	Repetir
		Escribir "Dime el año actual";
		Leer anoa;
	Hasta Que anoa>1900 Y anoa<2100
	
	//Introducir fecha de nacimiento
	
	Repetir
		Escribir "Dime tu dia de nacimiento";
		Leer dia;
	Hasta Que dia>0 Y dia<=31
	
	Repetir
		Escribir "Dime tu mes de nacimiento";
		Leer mes;
	Hasta Que mes>0 Y mes<=12
	
	Repetir
		Escribir "Dime tu mes de nacimiento";
		Leer mes;
	Hasta Que ano>1900 Y ano>anoa
	
	auxiliar1=anoa-ano;
	Si mesa>mes Entonces
		Escribir "Tienes " auxiliar " años";
	SiNo
		Si mesa<mes Entonces
			Escribir "Tienes " auxiliar-1 " años";
		SiNo
			Si mesa=mes Y diaa>=dia Entonces
				Escribir "Tienes " auxiliar " años";
			SiNo
				Escribir "Tienes " auxiliar-1 " años";
			Fin Si
		Fin Si
	Fin Si
	
FinAlgoritmo
