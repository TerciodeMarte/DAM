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

public class Persona {
    //Propiedades de la clase
    String nombre="Albano";
    String primerapellido="Diez";
    String segundoapellido="de Paulino";
    String ciudad="Santona";
    int numero=19;
    int piso=1;
    char letra='A';
    
    //Metodos de la clase
    public void muestraDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Primer Apellido: "+primerapellido);
        System.out.println("Segundo Apellido: "+segundoapellido);
        System.out.println("Ciudad:"+ ciudad);
        System.out.println("Numero: "+numero);
        System.out.println("Piso: "+piso);
        System.out.println("Letra: "+letra);
    }
    
    public int muestraDistancia(int distancia){
        return distancia;
    }
}
