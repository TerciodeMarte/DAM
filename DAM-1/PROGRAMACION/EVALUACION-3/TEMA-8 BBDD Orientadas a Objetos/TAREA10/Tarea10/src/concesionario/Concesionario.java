package concesionario;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Concesionario {
    private String marca, modelo;
    private int precio,kilometros;

    public Concesionario(String marca, String modelo, int precio, int kilómetros) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.kilometros = kilómetros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilómetros) {
        this.kilometros = kilómetros;
    }

    public void info() {
        System.out.println("\t"+"Marca=" + marca + ", Modelo=" + modelo + ", Precio=" + precio + ", kilometros=" + kilometros); 
    }
    
    
}
