package ejercicio10;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main10 {

    public static void main(String[] args) {
        Alumno a1=new Alumno("Albano");
        System.out.println("El alumno introducido es: "+a1.mostrar());
        
        System.out.println("La nota mayor es: "+a1.mayor());
        System.out.println("la nota menor es: "+a1.menor());
        
    }

}
