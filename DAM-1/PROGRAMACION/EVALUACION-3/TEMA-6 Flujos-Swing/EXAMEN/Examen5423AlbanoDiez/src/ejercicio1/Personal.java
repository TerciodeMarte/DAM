package ejercicio1;

import java.io.Serializable;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Personal implements Serializable{

    private String dni;
    private int salario;

    public Personal() {
    }

    public Personal(String dni, int salario) {
        this.dni = dni;
        this.salario = salario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public static boolean validarDni(String DNI) {
        if (DNI.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarSalario(int salario) {
        if (salario <= 2000 && salario >= 1300) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Personal{" + "dni=" + dni + ", salario=" + salario + '}';
    }
    

}
