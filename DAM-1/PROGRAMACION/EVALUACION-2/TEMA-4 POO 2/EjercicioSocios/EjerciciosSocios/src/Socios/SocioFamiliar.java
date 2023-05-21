
package Socios;


public class SocioFamiliar extends Socio {
    private int numhijos=0;

    public SocioFamiliar() {
    }
    
    
    public SocioFamiliar(String nombre,int numSocio,int numhijos){
        this.nombre=nombre;
        this.numSocio=numSocio;
        this.numhijos=numhijos;
    }
    public SocioFamiliar(SocioFamiliar object){
        this.nombre=object.nombre;
        this.numSocio=object.numSocio;
        this.numhijos=object.numhijos;
    }

    public int getNumhijos() {
        return numhijos;
    }

    public void setNumhijos(int numhijos) {
        this.numhijos = numhijos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getNumSocio() {
        return numSocio;
    }

    @Override
    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\n"+"Numero de Socio: "+getNumSocio()+"\n"+"Numero de Hijos: " +getNumhijos(); 
    }
    @Override
    public double calcularPago(){
        return 55;
    }
    
    
    
}
