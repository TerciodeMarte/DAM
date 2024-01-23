/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea55;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 * Clase para rgestionar la conexion a la BBDDD
 *
 * @author CafeConPalito
 */
public class ConexionBBDD {

    //Datos necesarios para configurar la conexión a la base de datos
    private static ConexionBBDD instance = null;
    private Connection con = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // esto por lo que entiendo utiliza el driver que bajamos (el jar)
    static final String USER = "root";
    static final String PASS = "1234";
    static final String BD = "fabrica"; // nombre de la base de datos
    //la direccion para conectar a la bbdd se le pasa como parametro "BD"

    //IP PARA TRABAJAR EN EL SERVER
    //static final String IP = "192.168.24.16";
    //IP PARA TRABAJAR EN LOCAL
    //static final String IP = "127.0.0.1";
    static final String IP = "localhost";

    //Todos los parametros para conectar a la BBDD
    static final String DB_URL = "jdbc:mysql://" + IP + ":3306/" + BD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private ConexionBBDD() {
     
        try {
            Class.forName(JDBC_DRIVER);
            this.con = DriverManager.getConnection(DB_URL, USER,PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public static ConexionBBDD getInstance() {
        if (instance == null) {
            instance = new ConexionBBDD();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    /**
     * Metodo para desconectar la BBDD
     */
    public void desconectar() {

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
