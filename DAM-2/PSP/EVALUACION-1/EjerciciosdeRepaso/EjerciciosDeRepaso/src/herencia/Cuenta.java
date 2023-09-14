package herencia;

/**
 *
 * @author Albano Diez Paulino
 */
public abstract class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private static int contador;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo, int contador) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.contador = contador;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cuenta.contador = contador;
    }
    
    
    
    public abstract void pagarIntereses();
    
}
