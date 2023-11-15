package com.cafeconpalito.examenjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    private static Connection con = ConexionBBDD.getInstance().getConnection();

    public static void main(String[] args) {
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        do {
            System.out.println("1. Consultar datos de los clientes");
            System.out.println("2. Consultar datos de los comerciales");
            System.out.println("3. Consultar datos de los pedidos ordenados por la fecha de realización,\n mostrando en primer lugarlos pedidos más recientes");
            System.out.println("4. Devuelve un listado que muestre todos los clientes,con todos los pedidos que han realizado\n y con los datos de los comerciales asociados a cada pedido");
            System.out.println("5. Insertar pedido");
            System.out.println("6. Confirmar cambios");
            System.out.println("7. Salir");

            int seleccion = scInt.nextInt();

            switch (seleccion) {
                case 1:

                    caso1();
                    break;
                case 2:

                    caso2();
                    break;
                case 3:

                    caso3();
                    break;
                case 4:

                    caso4();
                    break;
                case 5:

                    caso5();
                    break;
                case 6:

                    caso6();
                    break;
                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("OPCION NO VALIDA");
            }

        } while (true);
    }

    private static void caso1() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from cliente";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    private static void caso2() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from comercial";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    private static void caso3() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from pedido order by fecha desc";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    private static void caso4() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from pedido inner join cliente on cliente.id=id_cliente inner join comercial on comercial.id=id_comercial;";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();
            System.out.println("PEDIDO \t \t \t \t \t \tCLIENTE \t \t \t \t \tCOMERCIAL");
            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5)
                        + "\t" + rs.getString(6)
                        + "\t" + rs.getString(7)
                        + "\t" + rs.getString(8)
                        + "\t" + rs.getString(9)
                        + "\t" + rs.getString(10)
                        + "\t" + rs.getString(11)
                        + "\t" + rs.getString(12)
                        + "\t" + rs.getString(13)
                        + "\t" + rs.getString(14)
                        + "\t" + rs.getString(15)
                        + "\t" + rs.getString(16));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    private static void caso5() {
       
        PreparedStatement psi = null;

   

        String insert = "insert into pedido(total,fecha,id_cliente,id_comercial) values(12.2,20231115,1,2);";
       

        try {

            con.setAutoCommit(false);

            System.out.println("Insertando pedido");
            psi = con.prepareStatement(insert);
            psi.executeUpdate();
            System.out.println("Falta confirmación");


        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {

            System.err.println("Error en el select");
        }

    }
      private static void caso6() {

        try {

            con.commit();
            System.out.println("CAMBIO REALIZADO");


        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {

            System.err.println("Error en el select");
        }

    }
}
