package ejercicio13;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Figura {

    char[][] matriz;
    char letra;

    public Figura(char letra, int dimension) {
        matriz = new char[dimension][dimension];
        this.letra = letra;
    }

    public char[][] cuadrado() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = letra;
            }
        }
        return matriz;
    }

    public char[][] cuadrado_vacio() {
        for (int i = 0; i < matriz.length; i++) {
            matriz[0][i] = '-';
            matriz[matriz[i].length - 1][i] = '-';
        }
        for (int i = 0; i < matriz[i].length; i++) {
            matriz[i][0] = '|';
            matriz[i][matriz.length - 1] = '|';
        }
        return matriz;
    }

    public char[][] aspa() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    matriz[i][j] = '\\';
                }
            }
        }
        int contador = matriz.length - 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == contador) {
                    matriz[i][j] = '/';
                    contador--;
                }
            }
        }
        return matriz;
    }
    

}
