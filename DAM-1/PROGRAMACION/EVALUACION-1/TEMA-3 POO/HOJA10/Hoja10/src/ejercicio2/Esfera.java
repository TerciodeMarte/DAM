
package ejercicio2;

public class Esfera {
    private double radio;

    public Esfera() {
        radio=1.0;
    }

    public Esfera(double radio) {
        this.radio = radio;
    }
    
    public double volumen(){
        //V = 4/3 πr³
        return 4/3 *Math.PI*Math.pow(radio, 3);
    }
    public double superficie(){
        //4 π r 2
        return 4*Math.PI*Math.pow(radio,2);
    }
    public void imprimir(){
        System.out.println("El radio es " + radio);
        System.out.println("El volumen es "+ volumen());
        System.out.println("La superficie es " + superficie());
    }

}
