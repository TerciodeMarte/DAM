
package electrodomesticos;

public class Electrodomestico {
    // Atributos
    private String numSerie;
    private String marca;
    private double precio;

    // Métodos set y get
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    // Método constructor por defecto
    public Electrodomestico() {
        this.numSerie = "pendiente de asignar";
        this.marca = "LG";
        this.precio = 120.99;
    }

    // Método constructor con argumentos
    public Electrodomestico(String numSerie, String marca, double precio) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.precio = precio;
    }

    // Método para aplicar el IVA
    public void aplicarIva() {
        precio = 1.21*precio;
    }

    // Método para rebajar el precio
    public void rebajarPrecio(double porcentaje) {
        precio =precio * (1 - porcentaje / 100);

        if (precio < 10) {
            precio = 10;
        }
    }
}

