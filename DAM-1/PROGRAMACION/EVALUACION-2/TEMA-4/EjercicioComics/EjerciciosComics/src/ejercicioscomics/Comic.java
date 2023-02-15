package ejercicioscomics;

public class Comic {
    protected String titulo,guionista,dibujante;
    protected int numero;

    public Comic(String titulo, String guionista, String dibujante, int numero) {
        this.titulo = titulo;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.numero = numero;
    }

    public Comic() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getDibujante() {
        return dibujante;
    }

    public void setDibujante(String dibujante) {
        this.dibujante = dibujante;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void mostrarInformacion(){
        System.out.println("Titulo: " +getTitulo());
        System.out.println("Guionista: "+ getGuionista());
        System.out.println("Dibujante: "+ getDibujante());
        System.out.println("Numero: "+ getNumero());
    }
    
    
    
    
}
