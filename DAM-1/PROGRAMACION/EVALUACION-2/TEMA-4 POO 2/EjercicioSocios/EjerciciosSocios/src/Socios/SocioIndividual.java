
package Socios;


public class SocioIndividual extends Socio {
    private int antiguedad=0;

    public SocioIndividual() {
    }
    
    public SocioIndividual(String nombre,int numSocio,int antiguedad){
        this.nombre=nombre;
        this.numSocio=numSocio;
        this.antiguedad=antiguedad;
    }
    
    public SocioIndividual(SocioIndividual object){
        this.nombre=object.nombre;
        this.numSocio=object.numSocio;
        this.antiguedad=object.antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
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
        return "Nombre: "+getNombre()+"\n"+"Numero de Socio: "+getNumSocio()+"\n"+"Antiguedad: " +getAntiguedad(); 
    }
    
    
    @Override
    public double calcularPago(){
        double pago=55;
        for (int i = 0; i < antiguedad; i++) {
            pago=pago*0.98;
        }
        return pago;
    }
    
}
