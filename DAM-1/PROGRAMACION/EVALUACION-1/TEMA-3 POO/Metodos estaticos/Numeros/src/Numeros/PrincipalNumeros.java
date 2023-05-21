package Numeros;

import java.util.Scanner;

public class PrincipalNumeros {

    public static void main(String[] args) {
        int a,b;
        String aux;
        //char x=' ';
        
        Scanner lectura= new Scanner(System.in);
        System.out.println("Dime el primero numero Entero");
        a=lectura.nextInt();
        
        do {
            System.out.println("Dime el segundo numero Entero");
            b=lectura.nextInt();
        } while (b>a);
        lectura.nextLine();
        do {
            Scanner lectura2=new Scanner(System.in);
            
            System.out.println("POSIBILIDADES CON LOS NUMEROS DADOS");
            System.out.println("a- Mostrar todos los numeros entre a y b");
            System.out.println("b- Mostrar todos los numeros pares entre a y b");
            System.out.println("c- Mostrar los multiplos de 100 que hay entre a y b");
            System.out.println("d- Salir");
            
            
            System.out.println("Dime que deseas hacer");
            aux=lectura.nextLine();
           
            //x=aux.charAt(0);
            switch (aux) {
                case "a":
                    MetodosEstaticos.opcionA(a, b);
                    break;
                case "b":
                    MetodosEstaticos.opcionB(a, b);
                    break;
                case "c":
                    MetodosEstaticos.opcionC(a, b);
                    break;
                case "d":
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!aux.equals("d")); 
    } 
}


