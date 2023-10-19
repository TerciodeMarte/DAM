package models;

import java.io.File;
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
public class GameDAO {

    private static Game game;
    private static LinkedList<Game> listgame = new LinkedList();

    public static Game getGame() {
        return game;
    }

    public static LinkedList<Game> getListgame() {
        return listgame;
    }

    
    public static void almacenarGame(Game game) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/games.dat"))) {

            listgame.add(game);

            oos.writeObject(listgame);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void leerGames() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/games.dat"))) {

            listgame = (LinkedList<Game>) ois.readObject();

        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf);
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
        }

    }
    
    public static boolean searchOneGame(String name){
        for (Game game1 : listgame) {
            if (game1.getNombre().equalsIgnoreCase(name)) {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
}
