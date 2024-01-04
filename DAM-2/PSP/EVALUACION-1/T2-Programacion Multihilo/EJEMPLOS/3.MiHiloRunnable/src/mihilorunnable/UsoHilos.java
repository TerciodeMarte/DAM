/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mihilorunnable;

/**
 *
 * @author joaqf
 */
public class UsoHilos {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        
        //PRIMERA FORMA (IMPLEMENTANDO LA INTERFAZ RUNNABLE EN UNA CLASE A PARTE)

        //Primero, construye un objeto MiHilo.
        MiHiloRunnable mh=new MiHiloRunnable("#1");

        //Luego, construye un hilo de ese objeto.
        Thread nuevoh=new Thread(mh);

        //Finalmente, comienza la ejecución del hilo.
        nuevoh.start();
        
        
        //SEGUNDA FORMA (CLASE ANÓNIMA)
    
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Código del hilo desde clase anónima");
        }
        
    }).start();
    
    
    //TERCERA FORMA (EXPRESIÓN LAMBDA)
    new Thread(() -> System.out.println("Código del hilo desde Lambda")).start();
        
    }

}
