/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sumacompartida;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaqf
 */
public class SumaCompartida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
            Contador c= new Contador();
                       
            HiloSuma h1= new HiloSuma(1, c);
            HiloSuma h2= new HiloSuma(2, c);
            HiloSuma h3= new HiloSuma(3, c);
            HiloSuma h4= new HiloSuma(4, c);
            
            h1.start();
            h2.start();
            h3.start();
            h4.start();
            
            
        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SumaCompartida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("La suma al final vale: "+ c.getContador());
    } 
        
        
    
    
}
