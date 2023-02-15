package Ejercicio2;

import java.util.LinkedList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Reproduccion {

    LinkedList<Cancion> lista = new LinkedList();

    public String reproducceCancion(int pos) {
        return "Titulo de la cancion: " + lista.get(pos).getTítulo() + " Autor: " + lista.get(pos).getAutor();
    }

    public String avance(int pos) {
        if (pos >= lista.size()) {
            return "No hay cancion";
        } else {
           return "Titulo de la cancion: " + lista.get(pos + 1).getTítulo() + " Autor: " + lista.get(pos + 1).getAutor();
        }

    }

    public String retroceso(int pos) {
        if (pos <= 0) {
            return "No hay cancion";
        } else {
            return "Titulo de la cancion: " + lista.get(pos - 1).getTítulo() + " Autor: " + lista.get(pos - 1).getAutor();
        }
    }

    public String inicio() {
        return "Titulo de la cancion: " + lista.getFirst().getTítulo() + " Autor: " + lista.getFirst().getAutor();
    }
    public String fin(){
        return "Titulo de la cancion: " + lista.getLast().getTítulo() + " Autor: " + lista.getLast().getAutor();
    }
    public String aleatorio(){
        int random=(int)Math.random()*lista.size();
        return "Titulo de la cancion: " + lista.get(random).getTítulo() + " Autor: " + lista.get(random).getAutor();
    }
    
    public void reproduceCDenOrden(){
        for (Cancion cancion : lista) {
            System.out.println("Titulo: "+cancion.getTítulo()+"Autor: "+ cancion.getAutor());
        }
        
    }
    
}

