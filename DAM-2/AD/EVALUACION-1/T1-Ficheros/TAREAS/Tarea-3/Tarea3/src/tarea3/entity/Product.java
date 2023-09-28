package tarea3.entity;

import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Product implements Serializable {

    private String nombre;
    private double precio;

    public Product() {
    }

    public Product(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }

}
