package Tarea4;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner lecturaString=new Scanner (System.in);
        Scanner lecturaInt=new Scanner (System.in);
   
        Director daniel=new Director();
        
        Director jose=new Director("C/La piruleta",20,35,10.2,"Jose");
        
        System.out.println("Dime el nombre del primer Director");
        daniel.setNombre(lecturaString.nextLine());
        System.out.println("Dime donde vive");
        daniel.setDireccion(lecturaString.nextLine());
        System.out.println("Dime que edad tiene");
        daniel.setEdad(lecturaString.nextInt());
        System.out.println("Dime cuantas horas a trabajo");
        daniel.setHoras(lecturaString.nextInt());
        System.out.println("Dime cuanto cobra a la horas");
        daniel.setSalario(lecturaString.nextInt());
        
        System.out.println();
        System.out.println("LOS DATOS DEL PRIMER DIRECTOR SON");
        daniel.mostrarInformación();
        System.out.println("Salario mes: "+daniel.calculoSalario());
        System.out.println();
        System.out.println("LOS DATOS DEL SEGUNDO DIRECTOR SON");
        jose.mostrarInformación();
        System.out.println("Salario mes: "+jose.calculoSalario());
    }
    
}
