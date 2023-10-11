package examen3;

import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Juego implements Serializable{
    
    private int id ;
    private String titulo,pegi;

    public Juego() {
    }

    public Juego(int id, String titulo, String pegi) {
        this.id = id;
        this.titulo = titulo;
        this.pegi = pegi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", titulo=" + titulo + ", pegi=" + pegi + '}';
    }
    
    

}
