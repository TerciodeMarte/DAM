
package minijuego1;

public class Manos {
    
    //DEFINIR ATRIBUTOS PRIVADOS A USAR
    private static int marcador1=0,marcador2=0;
    
    //METODOS PARA MOSTRAR LAS MANOS
    public static void Roca(){
         System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)\n"
                + "          _)\n"
                + "       ____)\n"
                + "      _____)\n"
                + "---._______)\n"
                + "");
        
    }
    public static void Tijeras(){
         System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)____\n"
                + "          ______)\n"
                + "       __________)\n"
                + "      (____)\n"
                + "---.__(___)\n"
                + "");
        
    }
    public static void Papel(){
        System.out.println("\n"
                + "    _______\n"
                + "---'   ____)____\n"
                + "          ______)\n"
                + "       __________)\n"
                + "      _________)\n"
                + "---._________)\n"
                + "");
        
    }
    public static void Lagarto(){
        System.out.println("\n"
               + "    _____________\n"
               + "---'   __________)\n"
               + "       __)\n"
               + "       __)\n"
               + "       __)___\n"
               + "---._________)\n"
               + "");
    
    }
    public static void Spock(){
           System.out.println("\n"
                + "    _______\n"
                + "---'   ____)____\n"
                + "          ______)\n"
                + "       __________)\n"
                + "      |_______\n"
                + "      ________)\n"
                + "---._________)\n"
                + "");
        
    }
    //METODO PARA SABER QUIEN A GANADO
    public static void Marcador(int x,int y){
        if (x==1&&(y==4||y==3)) {
            marcador1++;
            System.out.println("ME HAS GANADO");
        }else if(x==2&&(y==1||y==5)){
            System.out.println("ME HAS GANADO");
            marcador1++;
        }else if(x==3&&(y==2||y==4)){
            System.out.println("ME HAS GANADO");
            marcador1++;
        }else if(x==4&&(y==5||y==2)){
            System.out.println("ME HAS GANADO");
            marcador1++;
        }else if(x==5&&(y==3||y==1)){
            System.out.println("ME HAS GANADO");
            marcador1++;
        }else if(x==y){
            System.out.println("EMPATE");
        }else{
            System.out.println("TE HE GANADO");
            marcador2++;
        }
        System.out.println("VAMOS "+marcador1+" A "+marcador2);  
    }
    //METODO PARA DEFINIR EL GANADOR
    public static boolean Final(){
        if(marcador1>=3||marcador2>=3){
            return false;
        }else{
            return true;
        }
    }
    
}
