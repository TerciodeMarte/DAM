/*
) Hacer un programa que pida al usuario un número del 1 al 3. Utilizando 
la estructura de control “switch”, el programa hará lo siguiente:
• Si el usuario introduce un 1 deberá aparecer por pantalla el mensaje: 
“Eres el primero”.
• Si el usuario introduce un 2 deberá aparecer por pantalla el mensaje: 
“Eres el segundo”.
• Si el usuario introduce un 3 deberá aparecer por pantalla el mensaje: 
“Eres el segundo”.
• Si el usuario introduce otro número el mensaje será: “Estás fuera del 
podio”.

*/
package ejercicios;

import java.util.Scanner;

public class ejercicio6 {

    public static void main(String[] args) {
        //Variables y objetos a usar
        int num;
        Scanner lectura=new Scanner(System.in);
        //Introduccion del numero por consola,siempre mayor que 1
        //sino se repite la peticion.
        do {
            System.out.println("Introduce un numero(positivo)");
            num=lectura.nextInt();
        } while (num<1);
        
        //Switch para mostrar el texto pedido por consola
        switch (num) {
            case 1:
                System.out.println("Eres el primero");
                break;
            case 2:
                System.out.println("Eres el segundo");
                break;
            case 3:
                System.out.println("Eres el tercero");
                break;
            default:
                System.out.println("Esta fuera del podio");   
        }
        
    }
    
}
