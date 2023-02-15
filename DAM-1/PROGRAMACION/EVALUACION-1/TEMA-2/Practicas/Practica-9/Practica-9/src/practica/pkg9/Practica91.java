/*Diseña un programa donde crees un array de Strings, otro de booleanos 
y otro de caracteres, todos ellos de 4 elementos cualquiera y muéstralos 
por pantalla*/

package practica.pkg9;

import java.util.Arrays;


public class Practica91 {

  
    public static void main(String[] args) {
        
        String arrayString[]={"H","o","l","a"};
  
        boolean arrayBoolean[]={true,false,true,false};
        
        char arrayChar[]={'A','d','i','o'};
        
        System.out.println(Arrays.toString(arrayString));
        System.out.println(Arrays.toString(arrayBoolean));
        System.out.println(Arrays.toString(arrayChar));
        
    }
    
}
