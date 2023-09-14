package password;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Ej2 {

    public static void main(String[] args) {
        
    }
    
    public static boolean comprobar_longitud(String password) {
        if (password.length() >= 8) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean comprobar_miniscula(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }

        }
        return false;
    }

    public static boolean comprobar_mayuscula(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }

        }
        return false;
    }

    public static boolean comprobar_numero(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }

        }
        return false;
    }

    public static boolean comprobar_especial(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == '-' || password.charAt(i) == '_' || password.charAt(i) == '$') {
                return true;
            }

        }
        return false;
    }

}
