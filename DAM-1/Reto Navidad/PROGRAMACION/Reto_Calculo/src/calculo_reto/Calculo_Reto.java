/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculo_reto;

import java.util.Scanner;

/**
 *
 * @author damt101
 */
public class Calculo_Reto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner lectura = new Scanner(System.in);

        int t, n, i;
        //Aquí defino  t como el total de la operación matematica
        int cf = 0;
        int ca = 0;

        //Aquí defino ca como el contador de aciertos y cf como el contador de fallos
        int contador = 0;
        System.out.println("Introduzca el numero de operaciones que euiera resolver");
        i = lectura.nextInt();
        long inicio = System.currentTimeMillis();
        Thread.sleep(2000);
        //Aquí creo el contador de tiempo 
        do {
            int b = (int) (Math.random() * 100 + 1);
            int a = (int) (Math.random() * 100 + 1);
            int elec = (int) (Math.random() * 4 + 1);
            //Aquí creo las tres variables aleatorias que van a ser numero1 el
            //numero 2 y la ultima que va servir para elegir la operacion matematica
            contador = contador + 1;

            switch (elec) {
                //Aquí creo 4 opciones del switch cada una para una operación matematicas
                case 1:
                    t = a + b;
                    System.out.println(a + "+" + b + "=");
                    n = lectura.nextInt();
                    if (n == t) {
                        //Aquí se comparara el resultado introducio con el total de la operación
                        System.out.println("HAS ACERTADO");
                        ca = ca + 1;
                        //Si el resultado introducido es correcto se sumara 1 al contador de aciertos
                    } else {
                        System.out.println("HAS FALLADO, la respuesta era:" + t);
                        cf = cf + 1;
                        //Si el resultado introducido es incorrecto se sumara 1 al contador de fallos
                    }
                    break;

                case 2:
                    t = a - b;
                    System.out.println(a + "-" + b + "=");
                    n = lectura.nextInt();
                    if (n == t) {
                        System.out.println("HAS ACERTADO");
                        ca = ca + 1;
                    } else {
                        System.out.println("HAS FALLADO, la respuesta era:" + t);
                        cf = cf + 1;
                    }
                    break;

                case 3:
                    t = a * b;
                    System.out.println(a + "*" + b + "=");
                    n = lectura.nextInt();
                    if (n == t) {
                        System.out.println("HAS ACERTADO");
                        ca = ca + 1;
                    } else {
                        System.out.println("HAS FALLADO, la respuesta era:" + t);
                        cf = cf + 1;
                    }
                    break;

                case 4:

                    do {
                        b = (int) (Math.random() * 100 + 1);
                        a = (int) (Math.random() * 100 + 1);
                    } while (a % b != 0);
                    //Primero genera valores aleatorios hasta que la dvivisión de a entre b sea entera
                    t = a / b;
                    System.out.println(a + "/" + b + "=");
                    n = lectura.nextInt();
                    if (n == t) {
                        System.out.println("HAS ACERTADO");
                        ca = ca + 1;
                    } else {
                        System.out.println("HAS FALLADO, la respuesta era:" + t);
                        cf = cf + 1;
                    }
                    break;
            }

        } while (contador < i);
        //Aquí se pide que finalize cuando el contador alcance el numero introducido por el usuario
        long fin = System.currentTimeMillis();
        //Aquí finalizara  el cronometro
        double tiempo = (double) ((fin - inicio) / 1000);
        //Aquí se calculara el tiempo en segundo
        System.out.println("El tiempo que has tardado es de:" + tiempo + " segundos");
        System.out.println("El numero de aciertos es:" + ca);
        System.out.println("El numero de fallos es:" + cf);
        //En estas 3 ultimas lineas se mostrara el contador de aciertos, el contador de fallos y el tiempo tardado

    }
}
