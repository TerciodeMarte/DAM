package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class UserDAO {

    private static User user;

    private static LinkedList<User> listuser = new LinkedList();

    public static User getUser() {
        return user;
    }

    public static boolean searchEmail(String email) {

        try (FileInputStream fis = new FileInputStream("users.dat"); ObjectInputStream ois = new ObjectInputStream(fis)){
            
          
            LinkedList<User> a = new LinkedList();
            
            while (fis.available() > 0) {
                 a = (LinkedList<User>) ois.readObject();

            }
            for (User b : a) {
                if (b.getEmail().equals(email)) {
                    user=b;
                    return true;
                }
            }
            return false;

        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf);
            return false;
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
            return false;
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
            return false;
        }

    }
    
      public static boolean checkPassword(String password) {

          if (user.getPassword().equals(password)) {
              return true;
          }else{
              return false;
          }

    }

    public static void registerUsers() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            //se le pasa la ruta del archivo
            fos = new FileOutputStream("users.dat");
            //se le pasa el fos como parametro
            oos = new ObjectOutputStream(fos);

            //creo 2 objetos de prueba para poder almacenarlos
            User objeto1 = new User("admin@valve.com", "1234", "Albano");
            User objeto2 = new User("user@valve.com", "1234", "Daniel");
            listuser.add(objeto1);
            listuser.add(objeto2);

            //utilizamos el metodo oos.writeObject para pasarle el objeto
            //podemos utilizar este metodo tantos objetos tengamos
            oos.writeObject(listuser);

            //si es el mismo Objeto como el array de alumnos de la tarea lo sobre escribe
        } catch (IOException e) {
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
            }

        }
    }
   
    public static void listUser(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("users.dat");
            ois = new ObjectInputStream(fis);
            LinkedList<User> a = new LinkedList();
            
            while (fis.available() > 0) {
                 a = (LinkedList<User>) ois.readObject();

            }
            for (User b : a) {
                System.out.println(b);
            }

        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf);
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }

    }

}
