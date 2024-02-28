/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.main.simetrico;

import com.cafeconpalito.main.config.LogConfig;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La contraseña introducida por el usuario será analizada por el programa para
 * comprobar que es segura, y en caso contrario informarle de que no es segura y
 * qué condiciones reúne una contraseña segura.
 *
 * @author Albano Díez de Paulino
 */
public class PasswordValidator {
    private static final String PASSWORD_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    /**
     * Metodo para validar si una pwd tiene 8 caracteres, contiene un numero, una letra mayuscula y un caracter especial
     * @param password
     * @return True Si la contraseña tiene un parametro correcto
     */
    public static boolean validate(final String password) {
        Matcher matcher = pattern.matcher(password);
         LogConfig.LOG_ALL.log(Level.INFO, "The format of a password has been validated");
        return matcher.matches();
    }
}
