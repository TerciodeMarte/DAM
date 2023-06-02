package examenra8;

/**
 *
 * @author Albano Diez de Paulino
 */
public class Colegio {
    private String nombre;
    private int edad,curso;

    public Colegio() {
    }

    public Colegio(String nombre, int edad, int curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void info() {
        System.out.println("Colegio{" + "nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + '}');
    }
    
    
}
