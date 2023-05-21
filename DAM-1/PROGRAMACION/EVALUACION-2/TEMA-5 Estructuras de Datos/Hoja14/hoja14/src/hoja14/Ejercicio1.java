
package hoja14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Ejercicio1 {

    public static void main(String[] args) {
        //Ejercicio 1 
        //Crear lista enlazada de los objetos Candidatos
        LinkedList <Candidatos> listado=new LinkedList();

        //Ejercicio 2
        //Crear Objetos de la clase Candidatos
        Candidatos c1=new Candidatos("ana", 53);
        Candidatos c2=new Candidatos("bea", 57);
        Candidatos c3=new Candidatos("oliver", 59);
        Candidatos c4=new Candidatos("leo", 63);
        Candidatos c5=new Candidatos("lia", 55);
        Candidatos c6=new Candidatos("anais", 51);
        
        
        //Ejercicio3
        //Añadir los 4 primeros objetos al listado del ejercicio 1
        listado.add(c1);
        listado.add(c2);
        listado.add(c3);
        listado.add(c4);
        
        //Ejercicio4
        //Añadir candidato en la posicion 2(1) desplanzando a los que ya habian
        listado.add(1,c5);
        
        //Ejercicio5
        //El candidato 1(c1) es sustituido por el 6(c6)
        listado.set(0,c6);
        
        //Ejercicio6
        //Elimina el candidato(c3) posicion (2)
        listado.remove(c3);
        
        //Ejercicio7
        listado.removeLast();
        
        //Ejercicio8
        //Mostrar la posicion de un objeto en la lista
        System.out.println(listado.indexOf(c5));
        
        //System.out.println(listado.get(0).imprimirInfo());
        
        //Ejercicio9
        
            //Bucle Tradicional
            for (int i = 0; i < listado.size(); i++) {
                System.out.println(listado.get(i).imprimirInfo());
            }
            System.out.println("");

            //Bucle foreach
            for (Candidatos i : listado) {
                System.out.println(i.imprimirInfo());
            }
            System.out.println();

            //Iterador
            Iterator <Candidatos> it = listado.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().imprimirInfo());
            }
            
        //Ejercicio10
        //Sublistado
        System.out.println("EJERCICIO 10");
        
        List <Candidatos> sublistado=listado.subList(1,listado.size());
        it=sublistado.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().imprimirInfo());
        }
       
        //Ejercicio11
        ArrayList <Candidatos> listado2 =new ArrayList();
        Candidatos T1=new Candidatos("tomas", 40);
        Candidatos T2=new Candidatos("teresa", 43);
        listado2.add(T1);
        listado2.add(T2);
        
        
        //Ejercicio12
        System.out.println("");
        it=listado2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().imprimirInfo());
        }
        
        //Ejercicio13
        listado.addAll(0, listado2);
        
        System.out.println("");
        //Ejercicio14
        for (Candidatos i : listado) {
            System.out.println(i.imprimirInfo());
            
        }
        
        /*COLAS Y PILAS*/
        Queue<String> cola= new LinkedList<>();
        cola.add("Juan");
        cola.add("Alberto");
        cola.add("Garcia");
        
        //Ejercicio 15
        System.out.println(cola.peek());
        
        //Ejercicio 16
        System.out.println(cola.poll());
        
        //Ejercicio 17
        System.out.println(cola.peek());
        
        //Ejercicio 18
        cola.add("Don Miguel");
        
        //Ejercicio 19
        for (String string : cola) {
            System.out.println(cola.peek());
        }
        
        Stack <String>pila=new Stack();
        
        pila.add("Manzana");
        pila.add("Pera");
        pila.add("Uva");
                
                
        //Ejercicio 20
        System.out.println(pila.firstElement());
        
        //Ejercicio 21
        
        System.out.println(pila.pop());
        
        //Ejercicio 22
        System.out.println(pila.firstElement());
        
        //Ejercicio 23
        pila.add("Melocoton");
        
        //Ejercicio 24
        for (String string : pila) {
            System.out.println(pila.pop());  
        }
        
    }
}
