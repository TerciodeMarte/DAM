package avion;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Avion avion1=new Avion();
        Avion avion2=new Avion();
        Scanner lectura=new Scanner(System.in);
        Scanner lectura2=new Scanner(System.in);
        
        System.out.println("Dime el modelo del avion 1");
        avion1.setModelo(lectura.nextLine());
        
        System.out.println("Dime el peso del avion 1(en Toneladas)");
        avion1.setPeso(lectura2.nextInt());
        
        System.out.println("Dime los pasajeros del avion 1");
        avion1.setPasajeros(lectura2.nextInt());
        
        System.out.println("Dime la autonomia del avion 1");
        avion1.setAutonomia(lectura2.nextDouble());
        
        System.out.println("Dime la velocidad que va el avión 1");
        avion1.setVelocidad(lectura2.nextDouble());
        
        System.out.println("LA CATEGORIA DEL AVION 1 ES:");
        System.out.println(avion1.categoriaPeso());
        
        System.out.println("En el avion 1 entran 200 pasajeros");
        System.out.println(avion1.comprobarPasajeros(200));
        
        System.out.println("Para viajar 5837km con autonomia: "+ avion1.getAutonomia()+" tiene que parar "+ avion1.numeroRepostajes(5837)+" veces");
        
        
        
        System.out.println("Dime el modelo del avion 2");
        avion2.setModelo(lectura.nextLine());
        
        System.out.println("Dime la velocidad que va el avión 2");
        avion2.setVelocidad(lectura2.nextDouble());
        
        if(avion1.getVelocidad()>avion2.getVelocidad()){
            System.out.println("El avion 1 va mas rapido");
        }else if (avion2.getVelocidad()>avion1.getVelocidad()){
            System.out.println("El avion 2 va mas rapido");
        }else{
            System.out.println("Los dos van a la misma velocidad");
        }
        
        System.out.println("El avion 1 tarda " + avion1.tiempo(5837)+ "horas en llegar desde Paris a Nueva York");
        System.out.println("El avion 2 tarda " + avion2.tiempo(5837)+ "horas en llegar desde Paris a Nueva York");
    }
    
}
