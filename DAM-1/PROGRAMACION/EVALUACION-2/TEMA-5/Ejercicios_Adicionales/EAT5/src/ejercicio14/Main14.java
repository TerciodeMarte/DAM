package ejercicio14;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main14 {

    public static void main(String[] args) {
        boolean control=true;
        Scanner scs= new Scanner(System.in);
        Scanner sci= new Scanner(System.in);
        byte menu=-1;
        Agenda a1= new Agenda(5);
        
        do {
            System.out.println("1.Nuevo contacto\n"
                    + "2.Mostrar la agenda\n"
                    + "3.Buscar contacto\n"
                    + "4.Ver el numero de contactos de la agenda\n"
                    + "5.Modificar telefono de una agenda\n"
                    + "6.Salir");
            
            menu=sci.nextByte();
            switch (menu) {
                case 1:
                    a1.annadir();
                    break;
                case 2:
                    a1.mostrar();
                    break;
                case 3:
                    System.out.println("Dime a quien quieres buscar");
                    a1.buscar(scs.nextLine());
                    break;
                case 4:
                    System.out.println("Tienes "+ a1.getContactos()+ " contactos en la agenda");
                    break;
                case 5:
                    System.out.println("Dime a quien quieres modificar");
                    a1.modificar(scs.nextLine());
                    break;
                case 6:
                    System.out.println("Saliendo");
                    control=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            
            
        } while (control);
        
    }

}
