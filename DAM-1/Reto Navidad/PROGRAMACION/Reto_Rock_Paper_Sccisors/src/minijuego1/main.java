package minijuego1;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //DECLARACIÓN DE VARIABLES Y OBJETOS
        Scanner lecturaString = new Scanner(System.in);
        
        String palabra="";
        
        int numero=0;
        int numeropalabra=0;
        
        boolean condicion=false;
        
        //INICIO DEL JUEGO
        System.out.println("JUEGO DE PIEDRA/PAPEL/TIJERA/LAGARTO/SPOOK");
        do {
            System.out.println("Elige que quieres sacar");
        
            System.out.println("PIEDRA/PAPEL/TIJERA/LAGARTO/SPOOK");
        
            
            //DEFINIR JUGADA DEL ORDENADOR
            numero=(int)(Math.random()*5+1);
            
            //COMPROBAR LO QUE EL USUARIO A INTRODUCIDO
            do {
                palabra=lecturaString.nextLine();
                palabra=palabra.toUpperCase();
                switch (palabra) {
                   case "PIEDRA":
                       Manos.Roca();
                       condicion=false;
                       numeropalabra=1;
                       break;
                   case "PAPEL":
                       Manos.Papel();
                       condicion=false;
                       numeropalabra=2;
                       break;
                   case "TIJERA":
                       Manos.Tijeras();
                       condicion=false;
                       numeropalabra=3;
                       break;
                   case "LAGARTO":
                       Manos.Lagarto();
                       condicion=false;
                       numeropalabra=4;
                       break;
                   case "SPOOK":
                       Manos.Spock();
                       condicion=false;
                       numeropalabra=5;
                       break;
                   default:
                       System.out.println("Opcion no valida,vuelve a introducir");
                       System.out.println("Opciones");
                       System.out.println("PIEDRA/PAPEL/TIJERA/LAGARTO/SPOOK");
                       condicion=true;
               } 
            } while (condicion);
            
            //COMPROBAR JUGADA DEL ORDENADOR
            switch (numero) {
                    case 1:
                       System.out.println("SACO PIEDRA");
                       Manos.Roca();
                       break;
                   case 2:
                       System.out.println("SACO PAPEL");
                       Manos.Papel();
                       break;
                   case 3:
                       System.out.println("SACO TIJERAS");
                       Manos.Tijeras();
                       break;
                   case 4:
                       System.out.println("SACO LAGARTO");
                       Manos.Lagarto();
                       break;
                   case 5:
                       System.out.println("SACO SPOOK");
                       Manos.Spock();
                       break;
            }
            //METODO PARA COMPROBAR QUIEN HA GANADO PERSONA Y MAQUINA
            Manos.Marcador(numeropalabra, numero);
            
            
        } while (Manos.Final());
       
    }
    
}
