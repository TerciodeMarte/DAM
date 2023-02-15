
package ejercicio1;

import java.util.Scanner;

public class Punto {
    private int x,y,z;
    
    public Punto() {
        x=0;
        y=0;
        z=0;
    }
    public Punto(int c){
        x=y=z=c;
    }

    public Punto(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void imprimir(){
        System.out.println("("+x+","+y+","+z+")");
    }
    
    public void pedirCoordenadas(){
        System.out.println("Dime el valor de x");
        Scanner lectura=new Scanner(System.in);
        x=lectura.nextInt();
        System.out.println("Dime el valor de y");
        y=lectura.nextInt();
        System.out.println("Dime el valor de z");
        z=lectura.nextInt();
    }
    
}
