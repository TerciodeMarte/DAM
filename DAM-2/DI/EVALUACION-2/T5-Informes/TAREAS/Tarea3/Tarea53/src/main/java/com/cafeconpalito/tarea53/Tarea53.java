/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.tarea53;

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
 * @author carra
 */
public class Tarea53 {

    private static Connection con = ConexionBBDD.getInstance().getConnection();
    
    public static void main(String[] args) {
        Map hm = new HashMap();
        hm.put("FILTRO", 4);

        JasperPrint print;
        try {
            print = JasperFillManager.fillReport("Tarea53.jasper", hm, con);
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");
        } catch (JRException ex) {
            Logger.getLogger(Tarea53.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
