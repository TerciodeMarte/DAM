package tarea5;
/**
 *
 * @author Albano Díez de Paulino
 */
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        
        Contacto c1 =new Contacto();
        Contacto c2 =new Contacto("Juan","Torombolo");
        Contacto c3 =new Contacto("Ramiro","Gutierrez");
        Contacto c4 =new Contacto("Daniel","Gutierrez");
        Contacto c5 =new Contacto("Pedro","Sanchez");
        
        LinkedList <Contacto>lista1=new LinkedList();
        lista1.add(c1);
        lista1.add(c2);
        lista1.add(c3);
        lista1.add(c4);
        lista1.add(c5);
        
        System.out.println("LinkedList 1");
        for (Contacto i: lista1) {
            i.muestraInformacion();
        }
        
        ArrayList <Contacto>lista2=new ArrayList();
        
        lista2.addAll(lista1);
        
        System.out.println("ArrayList");
        for (Contacto i : lista2) {
             i.muestraInformacion();
        }
        
        LinkedList <String>lista3=new LinkedList();
        lista3.add("Lunes");
        lista3.add("Martes");
        lista3.add("Miercoles");
        lista3.add("Jueves");
        lista3.add("Viernes");
        lista3.add("Sabado");
        lista3.add("Domingo");
        
        System.out.println("LinkedList 2");
        for (String i: lista3) {
            System.out.println(i);
        }
        
        int array[][]=new int[3][3];
        System.out.println("ARRAY BIDIMENSIONAL");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=(int)(Math.random()*(15-1)+1);
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
