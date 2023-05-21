package Numeros;

public class MetodosEstaticos {
    public static void opcionA(int a,int b){
        for (int i = a ; i >= b; i--) {
            System.out.println(i);
        }
    }
    
    public static void opcionB(int a,int b){
        for (int i = a ; i >= b; i--) {
            if(i%2==0){
               System.out.println(i);
            }
            
        }
    }
    public static void opcionC(int a,int b){
         for (int i = a ; i >= b; i--) {
            if(i%100==0){
               System.out.println(i);
            }
            
        }
    }
}
