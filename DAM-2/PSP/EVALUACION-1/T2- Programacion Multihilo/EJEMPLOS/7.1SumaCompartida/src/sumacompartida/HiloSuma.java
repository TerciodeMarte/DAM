/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumacompartida;

/**
 *
 * @author joaqf
 */
public class HiloSuma extends Thread{
    
    int id;
    private Contador c;
    
    public HiloSuma(int id, Contador c) {
        this.id=id;
        this.c=c;
    }
    
    @Override
    public void run() {
        
        System.out.println("Entra el hilo "+id);
        for (int i=0; i<10000; i++) {
            c.sumaContador(1);
        }
        
        System.out.println("El hilo "+id+ " contador: "+c.getContador());
        
    }
    
}
