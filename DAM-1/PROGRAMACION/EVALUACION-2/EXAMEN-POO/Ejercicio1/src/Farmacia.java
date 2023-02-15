/**
 *
 * @author Albano Díez de Paulino
 */
public class Farmacia {
    /**
     * Variables privadas para uso de la clase
     */
    private String producto;
    private int cantidad;
    private double precio;

    /**
     * Constructor por defecto o sin parametros
     */
    public Farmacia() {
    }

    /**
     * Constructor con parametros
     * @param producto Nombre del producto
     * @param cantidad Cantidad de producto en tienda
     * @param precio Precio del producto
     */
    public Farmacia(String producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    /**
     * Constructor copia
     * @param f1 Objeto de la clase Farmacia
     */
    
    public Farmacia(Farmacia f1){
        this.producto=f1.producto;
        this.cantidad=f1.cantidad;
        this.precio=f1.precio;
    }
    /**
     * Metodo para obtener el dato de la propiedad Producto
     * @return Nombre del producto
     */

    public String getProducto() {
        return producto;
    }

     /**
     * Metodo para asignar un dato a la propiedad producto
     * @param producto Nombre del producto
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
     /**
     * Metodo para obtener el dato de la propiedad cantidad
     * @return Cantidad de producto en tienda
     */

    public int getCantidad() {
        return cantidad;
    }

     /**
     * Metodo para asignar un dato a la propiedad cantidad
     * @param cantidad Cantidad de producto en tienda
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Metodo para obtener el dato de la propiedad precio
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo para asignar un dato a la propiedad precio
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

     /**
     * Metodo Override de la clase la super clase object que devuelve los datos del objeto
     * @return Datos del Objeto
     */
    @Override
    public String toString() {
        return "producto=" + producto + ", cantidad=" + cantidad;
    }
    
    /**
     * Metodo heredado de la clase Producto
     * @return precio base con incremento del 10% si el precio final es inferior a 30 o del 18 si es superior a 30
     */
    public double calculaPrecio(){
        if((cantidad*precio)<30){
            return cantidad*precio*1.10;
        }else if((cantidad*precio)>=30){
             
            return cantidad*precio*1.18;
        }else{
            return -1.1;
        }
    }
    

}