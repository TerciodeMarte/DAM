
package ejercicio1;


public class Libro {
    private String libro,autor;
    private int ejlibro,prelibro;

    public Libro() {
    }

    public Libro(String libro, String autor, int ejlibro, int prelibro) {
        this.libro = libro;
        this.autor = autor;
        this.ejlibro = ejlibro;
        this.prelibro = prelibro;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjlibro() {
        return ejlibro;
    }

    public void setEjlibro(int ejlibro) {
        this.ejlibro = ejlibro;
    }

    public int getPrelibro() {
        return prelibro;
    }

    public void setPrelibro(int prelibro) {
        this.prelibro = prelibro;
    }
    
    public boolean prestamo(){ 
        if(prelibro>=ejlibro){
            return false;
        }else{
            prelibro++;
            return true;
        }
    }
    public boolean devolucion(){ 
      if(prelibro<=0&&prelibro<=ejlibro){
          return false;
      }else{
          prelibro--;
          return false;
      }
    }

    @Override
    public String toString() {
        return "Libro{" + "libro=" + libro + ", autor=" + autor + ", ejlibro=" + ejlibro + ", prelibro=" + prelibro + '}';
    }
    
   
    
    
    
    
}
