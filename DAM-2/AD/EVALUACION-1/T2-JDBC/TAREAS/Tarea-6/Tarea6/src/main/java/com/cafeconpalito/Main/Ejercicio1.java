package com.cafeconpalito.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Ejercicio1 {

    public static void metodoLeer() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("configuracion.props")));

            System.out.println(properties.get("DB"));
            System.out.println(properties.get("SERVER"));
            System.out.println(properties.get("PORT"));
            System.out.println(properties.get("USER"));
            System.out.println(properties.get("PASSWORD"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
