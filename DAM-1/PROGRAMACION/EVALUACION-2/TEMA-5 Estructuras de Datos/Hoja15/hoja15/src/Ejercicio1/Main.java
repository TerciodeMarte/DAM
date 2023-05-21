package Ejercicio1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Albano Díez de Paulino
 */
/*1. Elige 10 series de televisión que hayan comenzado a emitirse en años diferentes. Crea 
una HashMap donde almacenes el título de cada serie (su clave será el año de emisión). 
Recorre el HashMap usando un iterador y un bucle for-each e imprime por pantalla el 
título y el año de emisión de cada serie en ambos casos.
*/
public class Main {

    public static void main(String[] args) {
        HashMap<Integer,String> series=new HashMap<>();
       
        
        series.put(1963, "Doctor Who");
        series.put(2023, "The Last of Us");
        series.put(2018, "The Rookie");
        series.put(1997, "Stargate SG-1");
        series.put(2004, "Stargate Atlantis");
        series.put(2022, "Andor");
        series.put(2021, "Bobba Fett");
        series.put(1089, "Dragon Ball Z");
        series.put(1999, "One Piece");
        series.put(2010, "The Wlaking Dead");
        
        Iterator<Integer> it= series.keySet().iterator();
        System.out.println("RECORRER EL MAPA CON UN ITERADOR DE CLAVES");
        while (it.hasNext()) {
            int aux=it.next();
            System.out.println("Anno de estreno: "+aux+" Titulo de la serie: "+ series.get(aux));
        }
        System.out.println("RECORRER EL MAPA CON EL FOR EACH");
        for (Map.Entry i : series.entrySet() ) {
            System.out.println("Anno de estreno: "+i.getKey()+" Titulo de la serie: "+ i.getValue());
        }
        
        
        
    }

}
