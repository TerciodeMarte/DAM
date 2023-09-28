package examplecorrect.model;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Model {
    private int n1;
    private int n2;
    private int resultado=0;
    
    public Model(){}

    public Model(int n1, int n2) {
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
