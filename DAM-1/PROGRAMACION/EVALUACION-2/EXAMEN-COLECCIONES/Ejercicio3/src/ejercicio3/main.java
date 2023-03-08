package ejercicio3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Albano Díez de Paulino
 */
public class main {

    public static void main(String[] args) {
        //Muy interesante este ejercicio
        int array[]=new int[30];
        int contador=0;
        
        HashMap<Integer,Integer> map= new HashMap<>();
        
        for (int i = 0; i < array.length; i++) {
            array[i]=(int) (Math.random()*10);
        }
        System.out.println("El array generado es :");
        System.out.println(Arrays.toString(array));
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j]==i) {
                    contador++;
                }
            }
            if (contador!=0) {
                map.put(i, contador);
                contador=0;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("De numeros "+entry.getKey() + " hay "+entry.getValue()); 
        }
        
    }

}
