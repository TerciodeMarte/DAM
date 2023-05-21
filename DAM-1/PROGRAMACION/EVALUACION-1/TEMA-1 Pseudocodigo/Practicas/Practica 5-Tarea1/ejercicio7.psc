Algoritmo prueba
	// Después de leer el nº de un día del mes, decir qué día de la semana es, 
	// suponiendo que el uno es lunes.
	// Declaración e inicialización de variables
	Definir num,num2 Como Entero
	num = 1
	// Declaración de array
	Definir dia Como Caracter
	Dimension dia[31]
	// Algoritmo de inicialización del array
	Repetir
		Para contador=num Hasta 31 Con Paso 7 Hacer
			Segun num  Hacer
				1:
					dia[contador] = 'Lunes'
				2:
					dia[contador] = 'Martes'
				3:
					dia[contador] = 'Miercoles'
				4:
					dia[contador] = 'Jueves'
				5:
					dia[contador] = 'Viernes'
				6:
					dia[contador] = 'Sabado'
				7:
					dia[contador] = 'Domingo'
			FinSegun
		FinPara
		num = num+1
	Hasta Que num>7
	// Comprobación del dia(Introducción por teclado)
	Escribir 'Dime un numero de mes y te digo que dia de la semana es'
	Leer num2
	Escribir 'El dia es ' dia[num2]
FinAlgoritmo
