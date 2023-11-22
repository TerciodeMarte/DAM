/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rebotepelotas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author joaqf
 */
//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {
        
    private LaminaPelota lamina;
    
    public MarcoRebote() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        
        ponerBoton(laminaBotones, "Dale!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        
        //Dibuja el botón de detener
        ponerBoton(laminaBotones, "Detener", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
               // detener();
            }
        });
        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

     
    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego() {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        
    }
 
}
