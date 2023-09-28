package tarea3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tarea3.entity.Product;

/**
 *
 * @author Albano Díez de Paulino
 */
public class ProductModel {

    static ArrayList<Product> lista = new ArrayList();

    public void guardar(Product product) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        File fichero = null;
        try {
            fichero = new File("productos.dat");
            if (!fichero.exists()) {
                fos = new FileOutputStream(fichero);
                oos = new ObjectOutputStream(fos);

                lista.add(product);

                oos.writeObject(lista);
            } else {
                fis = new FileInputStream(fichero);
                ois = new ObjectInputStream(fis);
                while (fis.available() > 0) {
                    lista = (ArrayList) ois.readObject();
                }
                fos = new FileOutputStream(fichero);
                oos = new ObjectOutputStream(fos);

                lista.add(product);

                oos.writeObject(lista);
            }


        } catch (IOException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
                Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    //TODO: Metodo para leer la lista de productos
    public ArrayList<Product> leer() {
        ArrayList<Product> arraylectura = new ArrayList();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        File fichero = null;
        try {
            fichero = new File("productos.dat");
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                arraylectura = (ArrayList) ois.readObject();
            }

            return arraylectura;
        } catch (FileNotFoundException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    ois.close();
                    fis.close();
                }
            } catch (IOException e) {
                Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return null;
    }
}
