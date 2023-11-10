package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Model {

    public static ArrayList<String[]> juego() {

        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from juego";

        try {
            con = ConexionBBDD.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1), rs.getString(2), rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
        return lista;
    }

    public static ArrayList<String[]> jugador() {
        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from jugador";

        try {
            con = ConexionBBDD.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1), rs.getString(2), rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
        return lista;
    }

    public static ArrayList<String[]> jugadorSesionJuego() {
        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        /*
            JTableHeader tableHeader = view.jTable1.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_jugador");
            tableColumnModel.getColumn(1).setHeaderValue("alias");
            tableColumnModel.getColumn(2).setHeaderValue("nombre");
            tableHeader.repaint();
         */
        //ARREGLAR
        String select = "select alias,juego.nombre,fecha from jugador inner join sesion using (id_jugador) inner join juego using (id_juego)";

        try {
            con = ConexionBBDD.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1), rs.getString(2), rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
        return lista;
    }
}
