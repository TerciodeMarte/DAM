package robot;

public class Movimiento {

    private Robot robot;

    public Movimiento(int posX, int posY, int angulo) {
        robot = new Robot(posX, posY, angulo);
    }

    /**
     * Método que hace que el robot avance en línea recta hasta que encuentre un
     * obstáculo delante.
     */
    public void avanzaRecto() {
        while (robot.avanza()) {
            robot.avanza();
            robot.pinta();
        }
    }

    /**
     * Método que hace que el robot avance en cuadrado avanzando diez pasos y
     * girando noventa grados.
     */
    public void avanzaCuadrado() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 10; j++) {
                if (robot.avanza()) {
                    robot.pinta();
                }
            }
            robot.gira90();
            robot.pinta();
        }

    }

    /**
     * Método que hace que el robot avance veinte veces en línea recta hasta
     * encontrar un obstáculo y que gire noventa grados.
     */
    public void avanzaEvitando() {
        byte contador = 0;

        while (contador < 20) {
            if (robot.avanza()) {
                robot.pinta();
            } else {
                robot.gira90();
                robot.pinta();
                contador++;
            }

        }

    }

    /**
     * Método que hace que el robot avance cien veces en línea recta hasta
     * encontrar un obstáculo y que luego gire un ángulo aleatorio de noventa,
     * ciento ochenta o doscientos setenta grados.
     */
    public void avanzaAleatorio() {
        byte contador = 0;
        byte random = 0;

        while (contador < 100) {
            if (robot.avanza()) {
                robot.pinta();
            } else {
                random = (byte) (Math.random() * 3);
                switch (random) {
                    case 0:
                        robot.gira90();
                        robot.pinta();
                        contador++;
                        break;
                    case 1:
                        robot.gira90();
                        robot.gira90();
                        robot.pinta();
                        contador++;
                        break;
                    case 2:
                        robot.gira90();
                        robot.gira90();
                        robot.gira90();
                        robot.pinta();
                        contador++;
                        break;
                    default:
                        throw new AssertionError();
                }

            }

        }
    }

    /**
     * Método que hace que el robot avance un número de pasos aleatorio entre
     * cero y diez y que gire un ángulo aleatorio de cero, noventa, ciento
     * ochenta o doscientos setenta grados y cuenta el número de pasos.
     */
    public void movimientoAleatorio() {
        byte numeropasos = 0;
        byte numerogiro = 0;
        while (robot.estaDentroLaberinto()) {
            numeropasos = (byte) (Math.random() * 11);
            numerogiro = (byte) (Math.random() * 4);
            for (int i = 0; i <= numeropasos; i++) {
                if (robot.avanza()) {
                    robot.pinta();
                } else {
                    switch (numerogiro) {
                        case 0:
                            robot.pinta();
                            break;
                        case 1:
                            robot.gira90();
                            robot.pinta();
                            break;
                        case 2:
                            robot.gira90();
                            robot.gira90();
                            robot.pinta();
                            break;
                        case 3:
                            robot.gira90();
                            robot.gira90();
                            robot.gira90();
                            robot.pinta();
                            break;
                        default:

                            throw new AssertionError();
                    }
                }
            }
        }
    }

    /**
     * Método que hace que el robot salga del laberinto manteniendo la mano
     * derecha pegada en todo momento a las paredes del laberinto y devuelve el
     * número de pasos.
     */
    public void salirDerecha() {
        while (robot.estaDentroLaberinto()) {
            if (robot.hayObstaculo(Robot.DCHA)) {
                robot.avanza();
                robot.pinta();
            }
        }
    }
}