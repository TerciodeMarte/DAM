package Ejercicio2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        Reproduccion r1 = new Reproduccion();
        Reproduccion r2 = new Reproduccion();

        Cancion c1 = new Cancion("What is Love", "Haddaway");
        Cancion c2 = new Cancion("La Macarena", "Los del Rio");
        Cancion c3 = new Cancion("Libre", "Nino Bravo");
        Cancion c4 = new Cancion("Rivers of Babylon", "Boney M");
        Cancion c5 = new Cancion("Thriller", "Mickeal Jackson");

        Cancion c6 = new Cancion("Bamboleo", "Raya Real");
        Cancion c7 = new Cancion("Santander", "Rumba 5");
        Cancion c8 = new Cancion("Maria del Puerto", "Los carabelas");
        Cancion c9 = new Cancion("A dios le pido", "Juanes");
        Cancion c10 = new Cancion("La gozadera", "Gente de zona");

        r1.lista.add(c1);
        r1.lista.add(c2);
        r1.lista.add(c3);
        r1.lista.add(c4);
        r1.lista.add(c5);

        r2.lista.add(c6);
        r2.lista.add(c7);
        r2.lista.add(c8);
        r2.lista.add(c9);
        r2.lista.add(c10);

        HashMap<Integer, Reproduccion> CD = new HashMap<>();
        CD.put(1, r1);
        CD.put(2, r2);

        HashMap<Integer, Reproduccion> CD2 = new HashMap<>();
        CD2.put(1, r2);
        CD2.put(2, r1);
        
        Scanner sc = new Scanner(System.in);
        Scanner scint = new Scanner(System.in);
        String lectura="";
        int disco=0;
        
        System.out.println("Pulsa el boton ON para encender.(ON/OFF)");
        
        lectura=sc.nextLine();
        switch (lectura) {
            case "ON":
                System.out.println("Encendiendo");
                do {
                    System.out.println("1-Reproducir CD1");
                    System.out.println("2-Reproducir CD2");
                    System.out.println("3-Apagar");
                    switch (disco) {
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            System.out.println("Apagando");
                        default:
                            System.out.println("Opcion no valida");
                    }
                    
                    
                } while (disco!=3);
                break;
            case "OFF":
                System.out.println("Apagando");
                break;
            default:
                System.out.println("Opcion no valida");
        }  
    }
}
