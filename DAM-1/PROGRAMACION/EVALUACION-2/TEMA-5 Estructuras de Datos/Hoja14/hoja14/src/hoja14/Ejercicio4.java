/*Escribe un programa que cargue dos colecciones distintas con datos de 
diferentes candidatos. Inserta datos, alguno en común en las dos colecciones. Realizar 
las siguientes operaciones:
Añade a la primera colección todos los candidatos que tiene la segunda
Borra de la primera todos los candidatos de la otra
Borra de la segunda colección todos los candidatos que estén en la otra
Borra todos los candidatos de la primera colección
 */
package hoja14;

import java.util.Iterator;
import java.util.LinkedList;

public class Ejercicio4 {

    public static void main(String[] args) {
        LinkedList<Candidatos> listado = new LinkedList();
        LinkedList<Candidatos> listado2 = new LinkedList();

        Candidatos c1 = new Candidatos("ana", 53);
        Candidatos c2 = new Candidatos("bea", 57);
        Candidatos c3 = new Candidatos("oliver", 59);
        Candidatos c4 = new Candidatos("leo", 63);
        Candidatos c5 = new Candidatos("lia", 55);
        Candidatos c6 = new Candidatos("anais", 51);

        //Parte 1
        listado.add(c1);
        listado.add(c2);
        listado.add(c3);

        listado2.add(c2);

        //Parte 2
        listado.addAll(listado2);

        //Parte 3
        listado.removeAll(listado2);

        //Parte 4
        
        listado.removeAll(listado);
        
    }
}
