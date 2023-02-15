Algoritmo ejercicio2
	
	Definir  n Como Real
	Definir positivos, negativos, ceros Como Entero
	
	Para i=1 Hasta 5 Con Paso 1 Hacer
		Escribir "Introduce un número"
		Leer n
		si n == 0 Entonces
			ceros = ceros + 1
		SiNo
			si n>0
				positivos = positivos + 1
			FinSi
			
			si n<0
				negativos = negativos +1
			FinSi
			
		FinSi
	FinPara
	
	Escribir "Hay " ceros " ceros," positivos " positivos" " y " negativos " negativos."
	
FinAlgoritmo
