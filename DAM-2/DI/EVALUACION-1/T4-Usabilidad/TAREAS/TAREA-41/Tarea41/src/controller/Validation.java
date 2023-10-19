package controller;

import models.GameDAO;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Validation {

    public static boolean name(String name) {
        if (GameDAO.searchOneGame(name)) {
            return true;
        } else if (name.isBlank()) {
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

    public static boolean description(String description) {
        if (description.isBlank()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean version(String version) {
        if (version.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean price(String price){
        if (price.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
     public static boolean ruta(String ruta){
        if (ruta.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
}
