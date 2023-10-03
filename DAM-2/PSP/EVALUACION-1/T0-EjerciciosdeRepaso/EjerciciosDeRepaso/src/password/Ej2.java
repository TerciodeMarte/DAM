package password;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Ej2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una contrasena");
        String password = sc.nextLine();
        if (!comprobarLongitud(password)) {
            System.out.println("No tiene 8 caracteres o mas");
        } else if (!comprobarNumero(password) || !comprobarEspecial(password) || !comprobarMiniscula(password) || !comprobarMayuscula(password)) {
            System.out.println("La contrasena no cumple los requsitios especiales");
        } else {
            System.out.println("Contrasena correcta");
        }
    }

    public static boolean comprobarLongitud(String password) {
        if (password.matches(".{8,}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarMiniscula(String password) {
        if (password.matches(".*[a-z].*")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarMayuscula(String password) {
        if (password.matches(".*[A-Z].*")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarNumero(String password) {
        if (password.matches(".*\\d.*")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarEspecial(String password) {
        if (password.matches(".*[-].*||.*[_].*||.*[$].*")) {
            return true;
        } else {
            return false;
        }
    }
}
