
package ejercicioscomics;

public class NovelaGrafica extends Comic {

    private int numpag;

    public NovelaGrafica(String titulo, String guionista, String dibujante, int numero,int numpag) {
        super(titulo, guionista, dibujante, numero);
        this.numpag = numpag;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); 
        System.out.println("Numero de paginas: "+numpag);
    }
    
    
}
