public class TresEnRaya {

    public String[] tablero;
    private int turno;
    private int jugador;
    private boolean finalizado;

    //Constructor
    public TresEnRaya(){
        tablero = new String[10];
        for(int i=0; i<10; i++){
            tablero[i] = " ";
        }
        turno = 0;
        jugador = 1;
        finalizado = false;
    }

    //Método para mostrar el tablero
    public void mostrarTablero(){
        System.out.println("+---+---+---+");
        System.out.println("| "+tablero[1]+" | "+tablero[2]+" | "+tablero[3]+" |");
        System.out.println("+---+---+---+");
        System.out.println("| "+tablero[4]+" | "+tablero[5]+" | "+tablero[6]+" |");
        System.out.println("+---+---+---+");
        System.out.println("| "+tablero[7]+" | "+tablero[8]+" | "+tablero[9]+" |");
        System.out.println("+---+---+---+");
    }

    //Método para actualizar el tablero
    public void actualizarTablero(int posicion){
        if(jugador == 1){
            tablero[posicion] = "X";
            jugador = 2;
        } else {
            tablero[posicion] = "O";
            jugador = 1;
        }
        turno++;
    }

    //Método para comprobar si hay ganador
    public boolean comprobarGanador(){
        //Comprobamos filas
        if(tablero[1].equals(tablero[2]) && tablero[2].equals(tablero[3]) && !tablero[1].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        if(tablero[4].equals(tablero[5]) && tablero[5].equals(tablero[6]) && !tablero[4].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        if(tablero[7].equals(tablero[8]) && tablero[8].equals(tablero[9]) && !tablero[7].equals(" ")){
            finalizado = true;
            return finalizado;
        }

        //Comprobamos columnas
        if(tablero[1].equals(tablero[4]) && tablero[4].equals(tablero[7]) && !tablero[1].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        if(tablero[2].equals(tablero[5]) && tablero[5].equals(tablero[8]) && !tablero[2].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        if(tablero[3].equals(tablero[6]) && tablero[6].equals(tablero[9]) && !tablero[3].equals(" ")){
            finalizado = true;
            return finalizado;
        }

        //Comprobamos diagonales
        if(tablero[1].equals(tablero[5]) && tablero[5].equals(tablero[9]) && !tablero[1].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        if(tablero[3].equals(tablero[5]) && tablero[5].equals(tablero[7]) && !tablero[3].equals(" ")){
            finalizado = true;
            return finalizado;
        }
        return finalizado;
    }

    //Getters
    public int getTurno(){
        return turno;
    }

    public int getJugador(){
        return jugador;
    }
}
