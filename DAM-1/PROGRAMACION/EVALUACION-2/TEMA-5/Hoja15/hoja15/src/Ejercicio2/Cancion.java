package Ejercicio2;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Cancion {
    private String título,autor;

    public Cancion(String título, String autor) {
        this.título = título;
        this.autor = autor;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
