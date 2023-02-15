package minijuego2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //DECLARACIÓN DE VARIABLES Y OBJETOS A USAR
        Scanner lecturaString = new Scanner(System.in);
        String aux;
        char letra;
        byte llamada = 0;
        
        //ELECCION DE PALABRA (5 DIFERENTES,FORMA ALEATORIA)
        Script.eleccion((int)(Math.random()*5));
        
        //INICIO JUEGO
        System.out.println ("EL JUEGO DEL AHORCADO");
        do {
            System.out.println("------------------------------------");
            Script.mostrarPalabra();
            do {
                System.out.println("Dime una letra(MAYUSCULA)");
                aux = lecturaString.nextLine();
            } while (aux.length() > 1);
            letra = aux.charAt(0);

            llamada = Script.comprobacionLetras(letra);

            switch (llamada) {
                case 1:
                    Ahorcado.fase1();
                    break;
                case 2:
                    Ahorcado.fase2();
                    break;
                case 3:
                    Ahorcado.fase3();
                    break;
                case 4:
                    Ahorcado.fase4();
                    break;
                case 5:
                    Ahorcado.fase5();
                    break;
                case 6:
                    Ahorcado.fase6();
                    break;
                case 7:
                    Ahorcado.fase7();
                    break;
                case 8:
                    Ahorcado.fase8();
                    break;
                case 9:
                    Ahorcado.fase9();
                    break;
                case 10:
                    Ahorcado.fase10();
                    break;
                case 11:
                    Ahorcado.fase11();
                    System.out.println("D.E.P");
                    break;
            }
            Script.Final();
        }while (llamada<11); 
    }
}
