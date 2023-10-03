package password;

import java.util.Scanner;

/**
 *
 * @author Albano Diez de Paulino
 */

/*a. Realiza un programa que solicite a un usuario una cadena.
                compruebe: 
            i. - La cadena tiene 8 o más caracteres. 
            ii. - Contiene al menos una minúscula. 
            iii. - Contiene al menos una mayúscula. 
            iv. - Contiene al menos un número. 
            v. - Contiene al menos un carácter especial (-, _ o $) 
        c. Tras introducir la cadena mostrará un mensaje donde indicará si la 
        cadena es correcta, si tiene un número inferior a 8 caracteres o si no 
        cumple con los 4 últimos requisitos.*/
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una contrasena");
        String password = sc.nextLine();
        if (!comprobar_longitud(password)) {
            System.out.println("No tiene 8 caracteres o mas");
        }else if(!comprobar_numero(password)|| !comprobar_especial(password)|| !comprobar_miniscula(password) || !comprobar_mayuscula(password)){
            System.out.println("La contrasena no cumple los requsitios especiales");
        }else{
            System.out.println("Contrasena correcta");
        }
        
        

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
