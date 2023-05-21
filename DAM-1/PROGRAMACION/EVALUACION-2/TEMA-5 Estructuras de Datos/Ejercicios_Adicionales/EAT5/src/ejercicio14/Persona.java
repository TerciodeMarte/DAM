package ejercicio14;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Persona {
    private String Nombre;
    private int numero;

    public Persona(String Nombre, int numero) {
        this.Nombre = Nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    

}
