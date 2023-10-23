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

    private static ConexionBBDD conBD = new ConexionBBDD();
    private static Connection con = conBD.conectar();

    public static void main(String[] args) {

        ej1(con);
    }
    
    //1. Lista el nombre de todos los productos que hay en la tabla producto.
    private static void ej1(Connection con){
        PreparedStatement ps = null;
        ResultSet rs = null;

        // se prepara la sentencia para la BBDD como un String
        String selectLogUsuario = "select * from producto";

        try {

           
            //se crear el Statement Con la conexion a la BBDD y el String
            ps = con.prepareStatement(selectLogUsuario);
            //se añade al select el nombre del usuario
            //se ejecuta la sentencia y devuelve un resultado
            rs = ps.executeQuery();

            //Es necesario usar el Next Para pasar a la primera Linea de la busqueda
            //una vez en la primera linea podemos obtener la informacion;
            while (rs.next()) {
               System.out.println(rs.getInt(1) + rs.getString(2)+ rs.getDouble(3)+ rs.getInt(4)); 
            }
            

        } catch (SQLException e) {
            //System.err.println("ERROR AL LEER Login Usuario");

        }
    }
}
