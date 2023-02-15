package tarea5;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Contacto {
    private String nombre,apellido;

    public Contacto() {
        nombre="Albano";
        apellido="Diez";
    }

    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void muestraInformacion(){
        System.out.print("Nombre: "+ nombre );
        System.out.println(" Apellido: " + apellido);
    }
    
    
}
