/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerosamigos;

/**
 *
 * @author Albano Díez de Paulino
 */
public class ej3 {

    public static void main(String[] args) {
        System.out.println(isAmigos(10 ,8));
    }

    public static boolean isAmigos(int x, int y) {
        int sumaA = 1;
        int sumaB = 1;

        for (int i = x - 1; i > 1; i--) {
            if (x % i == 0) {
                sumaA += i;
            }
        }
        if (sumaA != y) {
            return false;
        }

        for (int i = y - 1; i > 1; i--) {
            if (y % i == 0) {
                sumaB += i;
            }
        }

        if (sumaB != x) {
            return false;
        }
        
        return true;

    }
}
