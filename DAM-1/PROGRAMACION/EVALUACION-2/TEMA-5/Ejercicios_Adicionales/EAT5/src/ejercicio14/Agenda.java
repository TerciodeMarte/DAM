package ejercicio14;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Agenda {
    private int contador;
    private Persona p1[];
    
    
    public Agenda(int dimension) {
        contador=0;
        p1=new Persona[dimension];
    }
    
    public void annadir(){
        if (contador<p1.length) {
            String nombre="";
            int numero=0;
            Scanner scs= new Scanner(System.in);
            Scanner sci= new Scanner(System.in);
            System.out.println("Dime el nombre de la persona");
            nombre=scs.nextLine();
            System.out.println("Dime su numero");
            numero=sci.nextInt();
            p1[contador]=new Persona(nombre,numero);
            contador++;
        }else{
            System.out.println("No se pueden añadir mas personas a la agenda");
        }
    }
    public void mostrar(){
        for (int i = 0; i < contador; i++) {
            System.out.println("Contacto "+ i+ " Nombre: "+ p1[i].getNombre()+" Numero: "+p1[i].getNumero());
        }
    }
    
    public void buscar(String nombre){
        for (int i = 0; i < contador; i++) {
            if (p1[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto "+ i+ "Nombre: "+ p1[i].getNombre()+"Numero: "+p1[i].getNumero());
            }
        }
    }
    
    public void modificar(String nombre){
        Scanner sc= new Scanner(System.in);
        for (int i = 0; i < contador; i++) {
            if (p1[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto "+ i+" Numero: "+p1[i].getNumero());
                System.out.println("Dime el numero numero nuevo");
                p1[i].setNumero(sc.nextInt());
                System.out.println("Numero guardado");
            }
        } 
    }

    public int getContactos() {
        return contador;
    }
    
    

}
