/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carra
 */
public class Ejercicio1 {

    private static ConexionBBDD conBD = new ConexionBBDD();
    private static Connection con = conBD.conectar();
    

    public static void main(String[] args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        // se prepara la sentencia para la BBDD como un String
        String selectLogUsuario = "select nombre_usuario from usuario where id_usuario=?";

        try {

           
            //se crear el Statement Con la conexion a la BBDD y el String
            ps = con.prepareStatement(selectLogUsuario);
            //se añade al select el nombre del usuario
            ps.setInt(1, 2);
            //se ejecuta la sentencia y devuelve un resultado
            rs = ps.executeQuery();

            //Es necesario usar el Next Para pasar a la primera Linea de la busqueda
            //una vez en la primera linea podemos obtener la informacion;
            if (rs.next()) {
               System.out.println(rs.getString(1)); 
            }
            

        } catch (SQLException e) {
            //System.err.println("ERROR AL LEER Login Usuario");

        }
    }
}
