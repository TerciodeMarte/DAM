
package Ejercicio2;


public class Automovil extends Vehiculo{
    private double litros=0;
    private double precGas=0;

    public Automovil(double litros,double precGas,double kms,int tiempo) {
        this.litros=litros;
        this.precGas=precGas;
        this.kms=kms;
        this.tiempo=tiempo;
    }

    public Automovil() {
    }
    

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getPrecGas() {
        return precGas;
    }

    public void setPrecGas(double precGas) {
        this.precGas = precGas;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    @Override
    public double CalcularVelocidad(){
       return kms/tiempo; 
    }
    public double consumoMedio(){
        return litros/kms*100;
    }
    public double consumoEuros(){
        return consumoMedio()*precGas;
    }
}
