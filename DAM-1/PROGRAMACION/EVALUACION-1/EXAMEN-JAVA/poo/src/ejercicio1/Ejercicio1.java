/*
 Crea un proyecto con dos clases. Una de ellas será la clase Persona, 
cuyos atributos serán el nombre, primer apellido, segundo apellido, ciudad, número 
de portal y piso (enteros) y letra del piso (carácter). Los métodos para implementar
serán los siguientes:
• muestraDatos(): deberá mostrar por pantalla todos los atributos, 
especificando qué es cada uno.
• muestraDistancia(int distancia). Deberá devolver la distancia, introducida 
como parámetro, que camina la persona a la semana.
En la otra clase (la clase principal) se deberá crear un objeto y llamar a los dos 
métodos anteriores. Para el método muestraDistancia, deberá mostrarse por 
pantalla la distancia.
Los atributos tendrán que declararse con el tipo de variable que corresponda y se 
deberá guardar un dato en cada uno de ellos.

*/
package ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {
        //Crear objeto humana de la clase persona
        Persona humana=new Persona();
        
        //Llamadas a metodos de la clase
        humana.muestraDatos();
        System.out.println("Distancia recorrida: "+ humana.muestraDistancia(100)+ " m");
    }
    
}
