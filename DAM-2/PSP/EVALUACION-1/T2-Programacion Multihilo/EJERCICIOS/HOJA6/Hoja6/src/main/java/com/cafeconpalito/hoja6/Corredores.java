package com.cafeconpalito.hoja6;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Corredores implements Runnable {

    private Pista p;
    private int id;

    public Corredores(Pista p, int id) {
        this.p = p;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Corredor " + id + " en su marca");
        p.marcas();
        System.out.println("Corredor " + id + " coge el Relevo");
        System.out.println("Corredor " + id + " corriendo");

        p.correr();

    }

}
