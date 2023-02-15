
package Socios;


public abstract class Socio {
    protected String nombre="Default";
    protected int numSocio=0;

    public abstract String getNombre();

    public abstract void setNombre(String nombre) ;

    public abstract int getNumSocio();

    public abstract void setNumSocio(int numSocio);
    
    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\n"+"Numero de Socio: "+getNumSocio(); 
    }
    
    public abstract double calcularPago();
}
