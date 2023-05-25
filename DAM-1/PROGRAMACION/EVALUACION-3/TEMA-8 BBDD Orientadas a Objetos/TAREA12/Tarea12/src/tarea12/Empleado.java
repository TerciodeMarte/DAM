package tarea12;

/**
 *
 * @author Albano Diez de Paulino
 */
public class Empleado {
    private String nombre, estudios;
    private int edad,antiguedad;

    public Empleado() {
    }

    public Empleado(String nombre, String estudios, int edad, int antiguedad) {
        this.nombre = nombre;
        this.estudios = estudios;
        this.edad = edad;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void info() {
        System.out.println("Empleado{" + "nombre=" + nombre + ", estudios=" + estudios + ", edad=" + edad + ", antiguedad=" + antiguedad + '}');
    }
    
    
}
