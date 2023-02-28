package ejercicio10;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Alumno {
    String nombre;
    int notas[];
    
    Scanner sc= new Scanner(System.in);

    public Alumno(String nombre) {
        this.nombre=nombre;
        notas=new int[5];
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Dime la nota" +(i+1));
            notas[i]=sc.nextInt();
        }
    }
    
     public int menor(){
        Arrays.sort(notas);
        return notas[0];
    }
    
    public int mayor(){
        Arrays.sort(notas);
        return notas[notas.length-1];
    }
    
      public String mostrar(){
        int suma=0;
        for (int i = 0; i <notas.length ; i++) {
            suma=suma+notas[i];
        }
        return "El nombre del alumno es:"+ nombre+"La nota media es: "+suma/notas.length;
    }
    
}
