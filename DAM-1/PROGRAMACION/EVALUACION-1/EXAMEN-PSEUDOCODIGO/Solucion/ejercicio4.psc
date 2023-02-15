Algoritmo ejercicio4
	
	Definir precio Como Real
	Definir distancia Como Real
	
	Repetir
		Escribir "Introduce la distancia recorrida en el trayecto del viaje:"
		Leer distancia
	Hasta Que distancia>0
	
	
	si distancia <= 50 Entonces
		precio=0.5*distancia
	SiNo
		si distancia <= 100 Entonces
			precio=0.5*distancia*0.8
		FinSi
		si distancia > 100 Entonces
			precio=0.5*distancia*0.6
		FinSi
	FinSi
	
	Escribir "El precio del billete es " precio " euros"
	
FinAlgoritmo
