package com.cafeconpalito.pruebamongo;

/**
 *
 * @author carra
 */
public class PruebaMongo {

    public static void main(String[] args) {
        Connection c = new Connection("adiezd07", "1234");
        c.createConecction();
        c.startConecction();
    }
}
