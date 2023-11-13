/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.tarea32;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Albano Díez de Paulino
 */
public class JTextFieldPersonalizado extends JTextField implements Serializable, KeyListener {

    /**
     * Color para cuando la longitud no se cumpla
     */
    private Color A_ColorError;
    
    /**
     * Color para cuando la longitud se cumpla
     */
    private Color A_ColorOk;
    /**
     * Longitud para comprobar
     */
    private int A_longitud;

    public JTextFieldPersonalizado() {
        this.setText("12345678Z");
        this.setSize(190, 35);
        
        this.addKeyListener(this);
        
        this.A_ColorError = Color.RED;
        this.A_ColorOk = Color.GREEN;
        this.A_longitud = 9;

    }

    public Color getA_ColorError() {
        return A_ColorError;
    }

    public void setA_ColorError(Color ColorError) {
        this.A_ColorError = ColorError;
    }

    public Color getA_ColorOk() {
        return A_ColorOk;
    }

    public void setA_ColorOk(Color ColorOk) {
        this.A_ColorOk = ColorOk;
    }

    public int getA_Longitud() {
        return A_longitud;
    }

    public void setA_Longitud(int longitud) {
        this.A_longitud = longitud;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.getText().length() != A_longitud) {
            this.setBackground(A_ColorError);
        } else {
            this.setBackground(A_ColorOk);
        }
    }

}
