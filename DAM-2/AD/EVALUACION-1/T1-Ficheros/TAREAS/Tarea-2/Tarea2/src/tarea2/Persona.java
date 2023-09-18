package tarea2;

import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Persona implements Serializable  {
   
    private String nombre;
    private int telefono;

    public Persona(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Telefono: " + telefono;
    }
    
    
    
    
}
