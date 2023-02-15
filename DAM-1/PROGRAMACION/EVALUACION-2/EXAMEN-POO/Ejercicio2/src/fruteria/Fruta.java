package fruteria;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Fruta extends Producto {

    private boolean estadoOptimo;
    private String tipo;

    //Constructor por defecto con parametros debido a que me has pedido en la clase super declarar un contructor
    //Para poder llamarlo con la palabra reservada super en el contructor con parametros de esta clase
    //PARA USAR SUPER EN EL CONSTRUCTOR CON PARAMETROS TENGO QUE DECLARAR UN CONTRUCTOR DE LA QUE HEREDO
    public Fruta(String codigo, double precioBase) {
        super(codigo, precioBase);
    }

    /**
     * Constructor con parametros
     * @param estadoOptimo Estado del producto
     * @param tipo Tipo de fruta
     * @param codigo Codigo del producto con tres digitos
     * @param precioBase Precio del producto
     */
    public Fruta(boolean estadoOptimo, String tipo, String codigo, double precioBase) {
        super(codigo, precioBase);
        this.estadoOptimo = estadoOptimo;
        this.tipo = tipo;
    }
    /**
     * Metodo heredado de la clase Producto
     * @return precio base con incremento del 4%
     */

    @Override
    public double calcularPrecio() {
        return precioBase*1.04;
    }
    /**
     * Metodo Override de la clase la super clase object que devuelve los datos del objeto
     * @return Datos del Objeto
     */

    @Override
    public String toString() {
        return "Codigo=" + codigo + ", tipo=" + tipo+", estadoOptimo=" + estadoOptimo + ", preciofinal=" + precioBase;
    }
    /**
     * Metodo que valida el codigo del producto si tiene 3 cifras
     * @return Devuelve true si tiene 3 cifras
     */
    public boolean validadCodigo(){
        
        if (codigo.length()==3) {
            return true;
        }else{
            return false;
        }
    }
    /**
     * Devuelve el estado del producto(True,false)
     * @return estadoOptimo
     */

    public boolean isEstadoOptimo() {
        return estadoOptimo;
    }
    
    
    
    

}
