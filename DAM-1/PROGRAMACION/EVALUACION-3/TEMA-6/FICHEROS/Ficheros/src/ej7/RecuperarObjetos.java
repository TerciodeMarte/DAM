package ej7;

import java.io.*;

public class RecuperarObjetos {

    public static void main(String[] args) {
        //Lee el archivo en formato byte amigos.dat

        File fichero;
        FileInputStream fis = null;
        ObjectInputStream flujoentradaobjetos = null;

        try {

            fichero = new File("amigos.txt");//Debe de ser amigos.dat

            if (fichero.exists()) {

                fis = new FileInputStream(fichero);
                flujoentradaobjetos = new ObjectInputStream(fis);

                while (true) {//Bucle Infinito
                    Amigo a = (Amigo) flujoentradaobjetos.readObject();
                    System.out.println(a.toString());
                }

            }
        } catch (EOFException eof) {//No se que hace esta excepcion
            System.err.println("---------------------------------------");
        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf);
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
            System.out.println(ioe.getStackTrace());//No se que hace este metodo
        } catch (Throwable e) {//No se que hace este catch
            System.err.println("Error de programa: " + e);
        } finally {
            try {
                if (flujoentradaobjetos != null) {//cerrar por fis
                    flujoentradaobjetos.close();
                    fis.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }

    }
}
