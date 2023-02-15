package hoja14;

public class Candidatos {
    private String nombre;
    private int edad;

    public Candidatos(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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
    
    public String imprimirInfo(){
        return "Canditado: "+nombre+ " Edad: "+edad;
    }

}
