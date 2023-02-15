
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        int posicion = 0;
        //Creo el scanner
        while(!tresEnRaya.comprobarGanador() && tresEnRaya.getTurno() < 9){
            System.out.println("Turno del jugador "+tresEnRaya.getJugador());
            tresEnRaya.mostrarTablero();
            // Pedimos la posición
            
            System.out.println("Introduzca la posición: ");
            posicion = sc.nextInt();
            // Comprobamos que la pos1ición está vacía
            if(tresEnRaya.tablero[posicion].equals(" ")){
                tresEnRaya.actualizarTablero(posicion);
            } else {
                System.out.println("Posición no válida.");
            }
        }
        

        if(tresEnRaya.comprobarGanador()){
            System.out.println("El ganador es el jugador "+tresEnRaya.getJugador());
        } else {
            System.out.println("Empate!");
        }
    }
}