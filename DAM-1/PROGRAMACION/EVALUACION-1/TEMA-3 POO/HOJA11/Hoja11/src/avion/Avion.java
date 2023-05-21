
package avion;

public class Avion {
    private String modelo;
    private double peso,autonomia,altura,velocidad;
    private int pasajeros;
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    
    public String categoriaPeso(){
        if(peso>=1&&peso<=5){
             return "Ligero";
        }else if(peso>5&&peso<=10){
            return "Mediano";
        }else if(peso>10&&peso<=20){
            return "Pesado";
        }else if(peso>20){
            return "Superpesado";
        }else{
            return "Peso no valido";
        }
    }
    public boolean comprobarPasajeros(int numPasajeros){
        return numPasajeros<=pasajeros;
    }
    public int numeroRepostajes(int km){
        return (int)(km/autonomia)-1;
    }
    public boolean enTierra(){
        if(altura==0){
            return true;
        }else{
            return false;
        }
    }
    public double tiempo (int km){
        return km/velocidad;
    }
    
}
