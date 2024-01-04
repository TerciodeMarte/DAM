/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumacompartida;

/**
 *
 * @author joaqf
 */
public class Contador {
    
    private int numero;
    
    public Contador() {
        numero=0;
    }
    
    public synchronized void sumaContador(int valor) {
        numero=numero+valor;
    }
    
    
    public int getContador() {
        return numero;
    }
    
}
