/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplothreadlock;

/**
 *
 * @author joaqf
 */
public class EjemploThreadLock {

  
    public static void main(String[] args) {
        final String recurso1 = "recurso 1";
        final String recurso2 = "recurso 2";
        // t1 intenta bloquear el recurso 1 y después acceder al recurso 2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (recurso1) {
                    System.out.println("Thread 1: bloquea el recurso 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (recurso2) {
                        System.out.println("Thread 1: bloquea el recurso 2");
                    }
                }
            }
        };

        // t2 intenta bloquear el recurso 2 y después el acceder al recurso 1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (recurso2) {
                    System.out.println("Thread 2: bloquea el recurso 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (recurso1) {
                        System.out.println("Thread 2: bloquea el recurso 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }

}
