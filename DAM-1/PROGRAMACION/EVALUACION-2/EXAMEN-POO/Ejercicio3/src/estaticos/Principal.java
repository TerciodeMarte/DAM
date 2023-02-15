package estaticos;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Principal {

    /**
     * Metodo Principal que tiene la logica del menu repetitivo
     * 
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Scanner lecturaD= new Scanner (System.in);
        byte num=0;
        do {
            System.out.println("1-Calcular numero mayor entre 3 numeros");
            System.out.println("2-Calcular descuento");
            System.out.println("3-Numero Romano");
            System.out.println("4-Volumen de una esfera");
            System.out.println("5-Salir");
            num=lectura.nextByte();
            switch (num) {
            case 1:
                byte x,y,z;
                System.out.println("Dime el primer numero");
                x=lectura.nextByte();
                System.out.println("Dime el segundo numero");
                y=lectura.nextByte();
                System.out.println("Dime el tercer numero");
                z=lectura.nextByte();
                System.out.println("El mayor es: "+ Metodos.numeroMayor(x, y, z) );
                break;
            case 2:
                double a,b;
                System.out.println("Dime el precio con descuento");
                a=lecturaD.nextDouble();
                System.out.println("Dime el precio original");
                b=lecturaD.nextDouble();
                System.out.println("El descuento es :"+ Metodos.porcentajeDescuento(b,a));
                break;
            case 3:
                byte numero;
                System.out.println("Dime que numero romano quieres saber");
                numero=lectura.nextByte();
                System.out.println("El numero en romano es: "+ Metodos.numerosRomanos(numero));
                break;
            case 4:
                double radio;
                System.out.println("Dime el radio de la esfera");
                radio=lectura.nextDouble();
                System.out.println("El volumen es: "+ Metodos.volumenEsfera(radio));
                break;
            case 5:
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Opcion no valida");
        }
            
        } while (num!=5);
    }

}
