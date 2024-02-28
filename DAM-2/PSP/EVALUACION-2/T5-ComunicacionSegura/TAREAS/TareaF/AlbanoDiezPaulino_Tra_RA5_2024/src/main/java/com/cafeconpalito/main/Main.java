/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.main;

import com.cafeconpalito.main.config.LogConfig;
import com.cafeconpalito.main.view.Banner;
import com.cafeconpalito.main.view.UserInterface;

/**
 * Punto de entrada a la aplicación
 *
 * @author Albano Díez de Paulino
 */
public class Main {

    public static void main(String[] args) {
        LogConfig.openLogs();
        System.out.println(Banner.BANNERIN);
        UserInterface.sw(args);
        System.out.println("");
        System.out.println(Banner.BANNEROUT);
        LogConfig.closeLogs();
    }
}
