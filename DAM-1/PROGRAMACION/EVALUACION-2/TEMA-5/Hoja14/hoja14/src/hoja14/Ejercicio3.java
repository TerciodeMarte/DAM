/*Ejercicio 3: Vamos a guardar cadenas en una colección con el fin de borrar 
posteriormente la que empiecen por b
“hola”
“buenos días”
“buenas tardes”
“hasta luego”
*/
package hoja14;

import java.util.LinkedList;

/**
 *
 * @author Albano Diez
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        LinkedList<String>nombres=new LinkedList();
        
        nombres.add("hola");
        nombres.add("Buenos Dias");
        nombres.add("Buenas Tardes");
        nombres.add("Hasta Luego");
        
        System.out.println("Listado con todos los STRINGs");
        for (String nombre : nombres) {
            System.out.println(nombre);
            
        }
        nombres.removeIf(n->(n.toLowerCase().startsWith("b")));
        System.out.println("Listado con los STRING");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        
    }
}
