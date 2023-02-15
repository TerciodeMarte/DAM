
package ejercicio3;

public class Circunferencia {
    private double radio;

    public Circunferencia() {
        radio=1.0;
    }

    public Circunferencia(int radio) {
        this.radio = radio;
    }
    
    public double area(){
        //π r²
        return Math.PI*Math.pow(radio, 2);
    }
    public double perimetro(){
        //2.π x r
        return 2*Math.PI*2;
    }
    public void imprimir(){
        System.out.println("El radio es " + radio);
        System.out.println("El volumen es "+ area());
        System.out.println("La superficie es " + perimetro());
    }

    
}
