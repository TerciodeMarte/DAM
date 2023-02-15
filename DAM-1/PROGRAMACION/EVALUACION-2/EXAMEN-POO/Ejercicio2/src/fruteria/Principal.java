package fruteria;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Principal {

    /**
     * Metodo que tiene la logica del menu no repetitivo
     * @param args 
     */
    public static void main(String[] args) {
        Fruta array[]=new Fruta[5];
        array[0] = new Fruta(true, "Manzana", "303", 2.0);
        array[1] = new Fruta(false, "Pera", "12", 1.0);
        array[2] = new Fruta(true, "Platano", "999", 3.0);
        array[3]= new Fruta(true, "Banana", "1000", 4.0);
        array[4] = new Fruta(false, "Mango", "500", 5.0);

        Scanner sc = new Scanner(System.in);
        byte num = 0;
        System.out.println("1- Muestra la informacion de todos los objetos.");
        System.out.println("2- Validar codigo");
        System.out.println("3- Recogida para fábrica");
        System.out.println("4- Salir");
        System.out.println("Dime una opcion");
        num=sc.nextByte();

        switch (num) {
            case 1:
                for (Fruta i : array) {
                    System.out.println(i.toString());
                }
                break;
            case 2:
                for (Fruta i : array) {
                    System.out.println(i.validadCodigo());
                }
                break;
            case 3:
                for (Fruta i : array) {
                    if(i.isEstadoOptimo()){
                        System.out.println(i.toString());
                    }
                }
                break;
            case 4:
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

}
