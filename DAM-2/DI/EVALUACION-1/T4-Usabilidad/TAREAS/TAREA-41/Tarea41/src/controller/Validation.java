package controller;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Validation {

    public static boolean name(String name) {
        if (name.isBlank()) {
            return true;
        } else if (name.equalsIgnoreCase("Name")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean genre(String genre) {
        if (genre.isBlank()) {
            return true;
        } else if (genre.equalsIgnoreCase("Genre")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean company(int pos) {
        if (pos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean distribution(int pos) {
        if (pos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean date(String date) {
        if (date.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
}
