package fruteria;
/**
 *
 * @author Albano Díez de Paulino
 */
public abstract class Producto {
    /**
     * Variables Heredables
     */
    protected String codigo; //Cambio el tipo de entero a string para saber la longitud y validar el codigo
    protected double precioBase;
    
    /**
     * Metodo abstracto para las clases hijas
     * 
     */
    public abstract double calcularPrecio();

    /**
     * Constructor con parametros
     * @param codigo Codigo del producto con tres digitos
     * @param precioBase Precio del producto
     */
    public Producto(String codigo, double precioBase) {
        this.codigo = codigo;
        this.precioBase = precioBase;
    }
    
}
