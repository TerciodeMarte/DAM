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
       ej2();
       //ej3();
       //ej4();
       //ej5();
       //ej6();
       //ej7();
       //ej8();
       //ej9();
        //ej10();
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
     * 9. Lista los nombres y los precios de todos los productos de la tabla producto,
    *redondeando el valor del precio.
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
    * 10. Lista los nombres y los precios de todos los productos de la tabla producto,
    *truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
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
}
