package Ejercicio2;

import java.util.Scanner;

public class Main {
    
    static Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) {
        int menu = 6;
        
        Automovil coche1 = new Automovil();

        do {
            System.out.println("INFORMACION DEL TRAYECTO");
            System.out.println("1-Consultar datos del trayecto del vehículo");
            System.out.println("2-Consultar la velocidad media");
            System.out.println("3-Consultar consumo medio, en litros a los 100Km");
            System.out.println("4-Consultar consumo medio, en Euros a los 100Km");
            System.out.println("5-Salir");

            menu = lectura.nextInt();

            switch (menu) {
                case 1:
                    coche1=setDatos();
                    System.out.println("KMS: " + Math.round(coche1.getKms() * 100.0) / 100.0);
                    System.out.println("Litros: " + Math.round(coche1.getLitros() * 100.0) / 100.0);
                    System.out.println("Tiempo: " + coche1.getTiempo());
                    break;
                case 2:
                    coche1=setDatos();
                    System.out.println(coche1.CalcularVelocidad());
                    break;
                case 3:
                    coche1=setDatos();
                    System.out.println(coche1.consumoMedio());
                    break;
                case 4:
                    coche1=setDatos();
                    System.out.println(coche1.consumoEuros());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        } while (menu != 5);
    }

    public static Automovil setDatos() {

        Automovil coche = new Automovil();
        
        System.out.println("Dime los KMS que has echo");
        coche.setKms(lectura.nextDouble());
        System.out.println("Dime cuanto has tardado");
        coche.setTiempo(lectura.nextInt());
        System.out.println("Dime los litros que consume tu coche");
        coche.setLitros(lectura.nextDouble());
        System.out.println("Dime el precio de la gasolina");
        coche.setPrecGas(lectura.nextDouble());
        
        return coche;

    }

}
