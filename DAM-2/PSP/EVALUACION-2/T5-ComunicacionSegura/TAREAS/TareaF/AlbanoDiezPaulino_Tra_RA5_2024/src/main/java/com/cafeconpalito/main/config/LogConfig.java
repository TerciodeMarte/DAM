package com.cafeconpalito.main.config;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Configuración para crear los ficheros de registro
 * @author Albano Díez de Paulino
 */
public class LogConfig {

    public static final Logger LOG_ERROR = Logger.getLogger("error_log");
    public static final Logger LOG_ALL = Logger.getLogger("all_log");
 
    private static FileHandler fileHandlerErrors = null;
    private static FileHandler fileHandlerUser = null;
 
    /**
     * Metodo para inicializar los logs y abrir los flujos.
     */
    public static void openLogs() {
 
        try {
 
            SimpleFormatter formatter = new SimpleFormatter();
 
            fileHandlerErrors = new FileHandler("error.log", true);
            LOG_ERROR.addHandler(fileHandlerErrors);
            fileHandlerErrors.setFormatter(formatter);
 
            fileHandlerUser = new FileHandler("all.log", true);
            LOG_ALL.addHandler(fileHandlerUser);
            fileHandlerUser.setFormatter(formatter);
 

            LOG_ERROR.setLevel(Level.SEVERE);


            LOG_ALL.setUseParentHandlers(false);

        } catch (IOException | SecurityException ex) {
            LOG_ERROR.log(Level.SEVERE, null, ex);
        }
 
    }
 
    /**
     * Metodo para cerrar los flujos.
     */
    public static void closeLogs() {
 
        fileHandlerErrors.close();
        fileHandlerUser.close();
 
    }

}
