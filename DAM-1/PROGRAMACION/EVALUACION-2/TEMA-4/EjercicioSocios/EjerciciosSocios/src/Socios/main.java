package Socios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {

    static Scanner lectura = new Scanner(System.in);
    static Scanner lecturaS = new Scanner(System.in);
    static SocioIndividual individual = new SocioIndividual();
    static SocioFamiliar familiar = new SocioFamiliar();

    public static void main(String[] args) {
        //Comprabar IDS validas
        /*for (int i = 100000; i < 999999; i++) {
            if ((i % 19) % 5 == 0) {
                System.out.println(i);
            }
            }
        */
        boolean menu = true;
        byte opcion = 0;
        byte contador=0;
        boolean tipo=false;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    tipo=submenu();
                    contador++;
                    break;
                case 2:
                   
                    if (tipo) {
                        System.out.println(individual.toString());
                    }else{
                        System.out.println(familiar.toString());
                    }
                    contador++;
                    break;
                case 3:
                    if (tipo) {
                        System.out.println(individual.calcularPago());;
                    }else{
                        System.out.println(familiar.calcularPago());
                    }
                    contador++;
                    break;
                case 4:
                    System.out.println("Abandono de la aplicacion");
                    System.out.println("Operaciones Realizadas: "+ contador);
                    if (tipo) {
                        System.out.println("Hasta luego");
                        System.out.println(individual.getNombre());
                       menu=false;
                    }else{
                        System.out.println("Hasta luego");
                        System.out.println(familiar.getNombre());
                        menu=false;
                    }
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (menu);

    }


    public static byte menu() {
        System.out.println("1. Dar de alta al socio.");
        System.out.println("2. Mostrar los datos del socio.");
        System.out.println("3. Calcular cuota.");
        System.out.println("4. Salir.");
        return lectura.nextByte();
    }

    public static boolean submenu() {
        byte num = 0;
        System.out.println("1.Individual");
        System.out.println("2.Familiar");
        num = lectura.nextByte();
        switch (num) {
            case 1:
                System.out.println("Introduce un nombre");
                comprobacionNombre(lecturaS.nextLine(), num);
                System.out.println("Introduce un identificador valido");
                comprobacionIndentificador(lecturaS.nextLine(),num);
                System.out.println("Dime cuanta antiguedad tienes");
                individual.setAntiguedad(lectura.nextInt());
                return true;
                
            case 2:
                System.out.println("Introduce un nombre");
                comprobacionNombre(lecturaS.nextLine(), num);
                System.out.println("Introduce un identificador valido");
                comprobacionIndentificador(lecturaS.nextLine(),num);
                System.out.println("Dime cuantos hijos tienes");
                familiar.setNumhijos(lectura.nextInt());
                return false;
            default:
                System.out.println("Opcion no valida");
                return false;
        }
    }

    public static void comprobacionNombre(String nombre, int num) {
        while (nombre.length() < 6 || nombre.length() > 30) {
            System.out.println("Introduce un nombre entre 6 y 30 caracteres");
            nombre = lecturaS.nextLine();
        }
        if (num == 1) {
            individual.setNombre(nombre);
        } else {
            familiar.setNombre(nombre);
        }

    }

    public static void comprobacionIndentificador(String identificador, int num) {
        int aux = 0;
        boolean com = true;
        do {
            if (identificador.length() == 6) {
                aux = Integer.parseInt(identificador);
                if ((aux % 19) % 5 == 0) {
                    if (num == 1) {
                        individual.setNumSocio(aux);
                        com = false;
                        
                    } else {
                        familiar.setNumSocio(aux);
                        com = false;
                    } 
                }else{
                    System.out.println("Introduce un indentificador que el resto de dividir "
                            + "este numero \n" +
                            "entre 19 debe ser múltiplo de 5");
                    identificador = lecturaS.nextLine();
                }
            } else {
                System.out.println("Introduce un identificador de 6 digitos");
                identificador = lecturaS.nextLine();
            }

        } while (com);
    }
}
