
package ejercicio1;

public class ejercicio1 {

    public static void main(String[] args) {
   
       Punto punto1 = new Punto();
       Punto punto2 = new Punto(2);
       Punto punto3 = new Punto(1,2,3);
       
       Punto punto4 = new Punto();
       punto4.pedirCoordenadas();
       
       punto1.imprimir();
       punto2.imprimir();
       punto3.imprimir();
       punto4.imprimir();
       
       
    }
    
}

