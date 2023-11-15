     package com.cafeconpalito.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Tarea5 {

    private static Connection con = ConexionBBDD.getInstance().getConnection();

    public static void main(String[] args) {

        // ej1();
        //ej2();
        //ej3();
        //ej4();
        //ej5();
        //ej6();
        //ej7();
        //ej8();
        //ej9();
        //ej10();
        //ej11();
        //ej12();
        //ej13();
        //ej14();
        //ej15();
        //ej16();
        //ej17();
        //ej18();
        //ej19();
        ej20();

    }

    /**
     * 1. Lista el nombre de todos los productos que hay en la tabla producto.
     */
    public static void ej1() {

        System.out.println("\nListando Todos los nombres de productos ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 2. Lista los nombres y los precios de todos los productos de la tabla
     * producto.
     */
    public static void ej2() {

        System.out.println("\nListando Nombre y Precio de Productos");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre,precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 3. Lista todas las columnas de la tabla producto.
     */
    public static void ej3() {

        System.out.println("\nListando Todo de productos (Select *)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 4. Lista el nombre de los productos, el precio en euros y el precio en
     * dólares estadounidenses (USD)
     */
    public static void ej4() {

        System.out.println("\nLista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre ,precio ,precio*0.9451 from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 5. Lista el nombre de los productos, el precio en euros y el precio en
     * dólares estadounidenses (USD). Utiliza los siguientes alias para las
     * columnas: nombre de producto, euros, dólares
     */
    public static void ej5() {

        System.out.println("\nLista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre as 'Nombre de Producto' ,precio as 'Euros' ,precio*0.9451 as 'Dolares' from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 6. Lista los nombres y los precios de todos los productos de la tabla
     * producto, convirtiendo los nombres a mayúscula
     */
    public static void ej6() {

        System.out.println("\nLista el nombre de los productos en Mayusculas, el precio");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select UPPER(nombre),precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 7. Lista los nombres y los precios de todos los productos de la tabla
     * producto, convirtiendo los nombres a minúscula
     */
    public static void ej7() {

        System.out.println("\nLista el nombre de los productos en Minuscula, el precio");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select LOWER(nombre),precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 8. Lista el nombre de todos los fabricantes en una columna, y en otra
     * columna obtenga en mayúsculas los dos primeros caracteres del nombre del
     * fabricante
     */
    public static void ej8() {

        System.out.println("\nLista el nombre de los fabricantes, y los dos primeros caracteres del nombre en mayus");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, upper(substring(nombre,1,2)) from fabricante";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 9. Lista los nombres y los precios de todos los productos de la tabla
     * producto, redondeando el valor del precio.
     */
    public static void ej9() {

        System.out.println("\nLista el nombre de los productos , el precio redondeado");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, round(precio,0) from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 10. Lista los nombres y los precios de todos los productos de la tabla
     * producto, truncando el valor del precio para mostrarlo sin ninguna cifra
     * decimal.
     */
    public static void ej10() {

        System.out.println("\nLista el nombre de los productos , el precio sin decimal");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, format(precio,0) from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 11. Lista el identificador de los fabricantes que tienen productos en la
     * tabla producto
     */
    public static void ej11() {

        System.out.println("\nLista el identificador de los fabricantes que tienen productos en la tabla producto");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select id_fabricante from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 12. Lista el identificador de los fabricantes que tienen productos en la
     * tabla producto, eliminando los identificadores que aparecen repetidos.
     */
    public static void ej12() {

        System.out.println("\nLista el identificador de los fabricantes que tienen productos en la\n"
                + "     * tabla producto, eliminando los identificadores que aparecen repetidos.");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select distinct id_fabricante from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 13. Lista los nombres de los fabricantes ordenados de forma ascendente.
     */
    public static void ej13() {

        System.out.println("\nLista los nombres de los fabricantes ordenados de forma ascendente.");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre from fabricante order by nombre";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 14. Lista los nombres de los fabricantes ordenados de forma descendente.
     */
    public static void ej14() {

        System.out.println("\nLista los nombres de los fabricantes ordenados de forma descendente.");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre from fabricante order by nombre desc";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 15. Lista los nombres de los productos ordenados en primer lugar por el
     * nombre de forma ascendente y en segundo lugar por el precio de forma
     * descendente.
     */
    public static void ej15() {

        System.out.println("\nLista los nombres de los productos ordenados en primer lugar por el \n"
                + "nombre de forma ascendente y en segundo lugar por el precio de forma \n"
                + "descendente.");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre,precio from producto order by nombre asc,precio desc";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 16. Inserta tres nuevos productos a tu elección. Muestra la nueva tabla
     * por pantalla.
     */
    public static void ej16() {

        System.out.println("\nInserta tres nuevos productos a tu elección. Muestra la nueva tabla\n"
                + "     * por pantalla.");
        PreparedStatement psi = null;

        PreparedStatement pss = null;
        ResultSet rss = null;

        String insert = "insert into producto(nombre,precio,id_fabricante) values ('RTX 2060',1000,2),('RTX 3060',1200,2),('RTX 4060',1400,2)";
        String select = "select * from producto";

        try {

            con.setAutoCommit(false);

            psi = con.prepareStatement(insert);
            psi.executeUpdate();
            pss = con.prepareStatement(select);
            rss = pss.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rss.next()) {

                System.out.println(rss.getString(1) + rss.getString(2) + rss.getString(3) + rss.getString(4));
            }

            con.rollback();

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {

            System.err.println("Error en el select");
        }

    }

    /**
     * 17. Inserta a dos fabricantes nuevos: Apple y Nvidia
     */
    public static void ej17() {

        System.out.println("\nInserta a dos fabricantes nuevos: Apple y Nvidia"
                + "     * por pantalla.");
        PreparedStatement psi = null;

        PreparedStatement pss = null;
        ResultSet rss = null;

        String insert = "insert into fabricante(nombre) values ('Nvidia'),('Apple')";
        String select = "select * from fabricante";

        try {

            con.setAutoCommit(false);

            psi = con.prepareStatement(insert);
            psi.executeUpdate();
            pss = con.prepareStatement(select);
            rss = pss.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rss.next()) {

                System.out.println(rss.getString(1) + rss.getString(2));
            }

            con.rollback();

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {

            System.err.println("Error en el select");
        }

    }

    /**
     * 18. Modifica los productos de Seagate para que sean ahora de Lenovo.
     */
    public static void ej18() {

        System.out.println("\nModifica los productos de Seagate para que sean ahora de Lenovo");
        PreparedStatement psi = null;

        PreparedStatement pss = null;
        ResultSet rss = null;

        String insert = "update producto set id_fabricante = (select id from fabricante where nombre = 'Lenovo') where id_fabricante = (select id from fabricante where nombre = 'Seagate');";
        String select = "select * from producto";

        try {

            con.setAutoCommit(false);

            psi = con.prepareStatement(insert);
            psi.executeUpdate();
            pss = con.prepareStatement(select);
            rss = pss.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rss.next()) {

                System.out.println(rss.getString(1) + " " + rss.getString(2) + " " + rss.getString(3) + " " + rss.getString(4));
            }

            con.rollback();

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {

            System.err.println("Error en el select");
        }

    }

    /**
     * 19. Borra los fabricantes que empiezan por a.
     */
    public static void ej19() {

        System.out.println("\nBorra los fabricantes que empiezan por a");
        PreparedStatement psi = null;

        PreparedStatement pss = null;
        ResultSet rss = null;

        String delete = "delete from fabricante where nombre like('a%');";
        String select = "select * from fabricante";

        try {

            con.setAutoCommit(false);

            con.createStatement().execute("SET FOREIGN_KEY_CHECKS=0");

            psi = con.prepareStatement(delete);
            psi.executeUpdate();
            pss = con.prepareStatement(select);
            rss = pss.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rss.next()) {

                System.out.println(rss.getString(1) + " " + rss.getString(2));
            }

            con.createStatement().execute("SET FOREIGN_KEY_CHECKS=1");

            con.rollback();

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
    /**
     * 20. Muestra las dos tablas diferenciándolas de alguna manera en la salida por Netbeans
     */
    public static void ej20() {

        System.out.println("\nMuestra las dos tablas diferenciándolas de alguna manera en la salida por Netbeans");

        ej3();
       
        ej13();
        

    }
}
