/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.tarea55;

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
public class Tarea55 {

    private static Connection con = ConexionBBDD.getInstance().getConnection();
    
    public static void main(String[] args) {
        Map hm = new HashMap();
        hm.put("FILTRO", 4);

        JasperPrint print;
        try {
            print = JasperFillManager.fillReport("Tarea551.jasper", hm, con);
            JasperExportManager.exportReportToPdfFile(print, "informe1.pdf");
            print = JasperFillManager.fillReport("Tarea552.jasper", hm, con);
            JasperExportManager.exportReportToPdfFile(print, "informe2.pdf");
        } catch (JRException ex) {
            Logger.getLogger(Tarea55.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
