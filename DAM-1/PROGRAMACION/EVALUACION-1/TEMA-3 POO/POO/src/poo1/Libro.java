
package poo1;

public class Libro {
    
    private String titulo,autor;
    private int NumeroEjemplares,NumeroPrestados;

    public Libro() {

    }

    public Libro(String titulo, String autor, int NumeroEjemplares, int NumeroPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.NumeroEjemplares = NumeroEjemplares;
        this.NumeroPrestados = NumeroPrestados;
    }    
 
}
