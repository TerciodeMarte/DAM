package ejercicio11;

import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main11 {

    public static void main(String[] args) {
       int matriz1[][]={{101,102,103,104,105},{201,202,203,204,205},
       {301,302,303,304,305},{401,402,403,404,405},{501,502,503,504,505}}; 
       
       boolean control=true;
       Scanner sc=new Scanner(System.in);
       byte eleccion=0;
       
        do {
            System.out.println("1.-Elegir fila.");
            System.out.println("2.- Elegir columna.");
            System.out.println("3.- Mostrar los elementos de la diagonal.");
            System.out.println("4.- Mostrar los elementos de la diagonal inversa");
            System.out.println("5.- Mostrar los elementos de la diagonal hacia arriba.");
            System.out.println("6.- Salir.");
            eleccion=sc.nextByte();
            switch (eleccion) {
                case 1:
                    byte fila=-1;
                    do {
                        System.out.println("Dime que fila quieres ver(entre 0 y "+(matriz1.length-1)+")");
                        fila=sc.nextByte();
                        if (fila>0&&fila<(matriz1.length-1)) {
                            for (int i = 0; i < matriz1.length; i++) {
                                System.out.println(matriz1[fila][i]);
                            }
                        }else{
                             System.out.println("Fila no valida");
                        }
                    } while (fila<0||fila>(matriz1.length-1));
                    break;
                case 2:
                    byte columna=-1;
                    do {
                        System.out.println("Dime que columna quieres ver(entre 0 y "+(matriz1[0].length-1)+")");
                        columna=sc.nextByte();
                        if (columna>0&&columna<(matriz1[0].length-1)) {
                            for (int i = 0; i < matriz1[0].length; i++) {
                                System.out.println(matriz1[i][columna]);
                            }
                        }else{
                             System.out.println("Fila no valida");
                        }
                    } while (columna<0||columna>(matriz1.length-1));
                    break;
                case 3:
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = 0; j < matriz1[i].length; j++) {
                            if (i==j) {
                                System.out.println(matriz1[i][j]);
                            }
                        }
                    }
                    break;
                case 4:
                    int contador=matriz1.length-1;
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = 0; j < matriz1[i].length; j++){
                            if (j==contador) {
                                System.out.println(matriz1[i][j]);
                                contador--;
                            }
                        }
                    }
                    break;
                case 5:
                    int contador2=1;
                    for (int i = 0; i < matriz1.length; i++) {
                        for (int j = contador2; j < matriz1[i].length; j++){
                            System.out.print(matriz1[i][j] +" "); 
                        }
                        contador2++;
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo");
                    control=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (control);
    }

}
