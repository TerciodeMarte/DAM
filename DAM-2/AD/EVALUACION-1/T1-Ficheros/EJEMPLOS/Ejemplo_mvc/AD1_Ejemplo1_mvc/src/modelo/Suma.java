/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author msola
 */
public class Suma {
    private int n1;
    private int n2;
    private int resultado=0;
    
    public Suma(){}

    public Suma(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    
    /**
     * Método que suma los dos números 
     * @return resultado de la suma
     */
    public int sumar(){
        this.resultado = n1 + n2;
        
        return this.resultado;
    }
    
   
}
