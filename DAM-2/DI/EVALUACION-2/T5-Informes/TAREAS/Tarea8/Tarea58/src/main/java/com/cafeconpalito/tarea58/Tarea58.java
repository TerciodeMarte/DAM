/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.tarea58;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Albano Diez de Paulino
 */
public class Tarea58 {

    private static Connection con = ConexionBBDD.getInstance().getConnection();

    public static void main(String[] args) {
        Map hm = new HashMap();
        hm.put("FILTRO", 1);

        JasperPrint print;
        try {
            print = JasperFillManager.fillReport("Tarea58.jasper", hm, con);
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");
        } catch (JRException ex) {
            Logger.getLogger(Tarea58.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
