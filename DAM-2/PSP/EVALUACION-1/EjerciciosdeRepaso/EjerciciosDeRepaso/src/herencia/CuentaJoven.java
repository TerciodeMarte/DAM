/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author Albano Díez de Paulino
 */
public final class CuentaJoven extends Cuenta {

    public CuentaJoven(String numeroCuenta, double saldo, int contador) {
        super(numeroCuenta, saldo, contador);
        Cuenta.setContador(Cuenta.getContador()+1);
    }

    public CuentaJoven() {
         Cuenta.setContador(Cuenta.getContador()+1);
    }

    @Override
    public void pagarIntereses() {
       super.setSaldo(super.getSaldo()*1.05);
    }
    
}
