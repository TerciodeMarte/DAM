package com.cafeconpalito.hoja5;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Garaje {

    private int cuenta;
    private int lleno;
    
    public synchronized int entrar(){
        return cuenta;
    }
    
    public synchronized int salir(){
        return cuenta;
    }
    
    
}
