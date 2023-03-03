package ejercicio1;
/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        Gestion g1=new Gestion();
        
        //Crear Objetos de la clase personal
        Personal p1=new Personal("72204754A",1200);
        Personal p2=new Personal("12345678B",900);
        Personal p3=new Personal("87654321C",2000);
        Personal p4=new Personal("13572468D",100);
        Personal p5=new Personal("24681357E",3000);
        
        //Añadir Empleados a la Linkedlist
        g1.inserta_empleado(p1.getDni(), p1.getSalario());
        g1.inserta_empleado(p2.getDni(), p2.getSalario());
        g1.inserta_empleado(p3.getDni(), p3.getSalario());
        g1.inserta_empleado(p4.getDni(), p4.getSalario());
        g1.inserta_empleado(p5.getDni(), p5.getSalario());
        
        //Borrar empleado 2
        g1.borra_empleado(p2.getDni());
        
        //Mostrar Empleados
        g1.lista_empleados();
        
        
        
    }

}
