package ejercicio1;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Personal {
    
    private String dni;
    
    private int salario;

    public Personal() {
    }

    public Personal(String dni, int salario) {
        this.dni = dni;
        this.salario = salario;
    }
    

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
