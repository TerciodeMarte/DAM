package tarea11;
/**
 *
 * @author Albano Diez de Paulino
 */
public class Producto {
    private String nombre, categoria;
    private int precio, stock ;

    public Producto() {
    }

    public Producto(String nombre, String categoria, int precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoría) {
        this.categoria = categoría;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void info() {
        System.out.println("nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", stock=" + stock + '}');
    }
    
    
    
}
