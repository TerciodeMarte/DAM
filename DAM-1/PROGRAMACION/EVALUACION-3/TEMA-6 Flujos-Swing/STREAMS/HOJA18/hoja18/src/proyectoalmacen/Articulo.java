
package proyectoalmacen;

import java.io.Serializable;

public class Articulo implements Serializable{
    
    private String codigo;
    private String descripcion;
    private int existencias;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public Articulo(String codigo, String descripcion, int existencias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.existencias = existencias;
    }
    
    

    public static boolean validarCodigo(String codigo){
        return (codigo.matches("[A-Z]{2}[.][0-9]{1,3}[A-Za-z]+"));
    }
    
    public static boolean validarExistencias(int existencias){
        return (existencias>=0 && existencias<1000);
    }
    
    
    public static boolean validarDescripcion (String descripcion){
        return (descripcion.length()>=3 && descripcion.length()<=10);
    }

    @Override
    public String toString() {
        return "Articulo:" + "codigo=" + codigo + ", descripcion=" + descripcion + ", existencias=" + existencias;
    }
   
    
    
    
    
}
