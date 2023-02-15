//Algoritmo que permite introducir por teclado el número de kilómetros del trayecto 
//y devuelve el precio del billete. El importe será de 0.5 e por km recorrido. Si el 
//trayecto supera los 50 km se aplicará una reducción del 20%, y si supera los 100 km, 
//del 40%

Algoritmo ejercicio4
	//DECLARACIÓN DE VARIABLES A USAR
	Definir km Como Entero
	
	//LECTURA DE LOS KM DEL TRAYECTO
	Escribir "Dime el numero de KM del trayecto";
	Leer km
	
	//ESTRUCTURA PARA PODER APLICAR LOS DESCUENTOS
	Si km>100 Entonces
		Escribir "Pues te sale a " (km*0.5*0.6) "e"
		Escribir "Con un 40% de descuento"
	SiNo
		Si km>50 Entonces
			Escribir "Pues te sale a " (km*0.5*0.8) "e"
			Escribir "Con un 20% de descuento"
		SiNo
			Escribir "Pues te sale a " (km*0.5) "e"
		Fin Si
	Fin Si

FinAlgoritmo
