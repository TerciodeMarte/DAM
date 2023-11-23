/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.albanodiezpaulino_ex_ra2_e_20231123;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Diez de Paulino
 */
public class App {

    public static void main(String[] args) {
        
        System.out.println("Hola, el usuario Albano Díez de Paulino está haciendo la aplicación para el RA2!");
        System.out.println("Hace mucho tiempo en una galaxia muy muy lejana...");
        System.out.println("Se está librando una horrible batalla en el orbita de Endor entre las flotas rebeldes e imperiales");

        //Creo el elemento compartido
        
        DispositivosDrones dd = new DispositivosDrones(3, 0);
        
        
        //Creo los hilos de ejecucion
       
        Ingeniero i = new Ingeniero(dd, "Akbar", 600);
        Oficial o1 = new Oficial(dd, "Luke", 5000);
        Oficial o2 = new Oficial(dd, "Casian", 8000);

        //Ponga prioridad a los oficiales
        o1.setPriority(10);
        o2.setPriority(5);

        //Lanzo todos los hilos
        i.start();
        o1.start();
        o2.start();

        //Espero a que terminen todos los hilos
        try {
            i.join();
            o1.join();
            o2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Muestro los mensajes finales
        i.finalizar();
        o1.finalizar();
        o2.finalizar();

        System.out.println("La nave del emperador a caido");
        System.out.println("La Rebelion ha ganado pero el imperio aun no esta derrotado");

        System.out.println("El oficial " + o1.getNombre() + " ha disparado " + o1.getContador());
        System.out.println("El oficial " + o2.getNombre() + " ha disparado " + o2.getContador());

        System.out.println("FIN");

    }
}
