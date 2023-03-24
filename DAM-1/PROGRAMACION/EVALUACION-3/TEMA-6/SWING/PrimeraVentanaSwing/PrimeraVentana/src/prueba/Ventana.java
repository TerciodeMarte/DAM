/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prueba;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


/**
 *
 * @author Albano Díez de Paulino
 */
public class Ventana extends JFrame {

    public Ventana() {
        //Configuracion General
        JFrame.setDefaultLookAndFeelDecorated(true); //Aspecto de ventana por defecto de swing para todos los objetos de ventanas
        
        //Configuracion de ventana
        this.setVisible(true); //Hacer visible la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Mata el programa cuando cierras la pantalla
        this.setSize(400,400); //Define el tamaño de la pantalla al iniciar
        this.setTitle("Primera ventana"); //Pone el string al label de la pantalla
        this.setLocation(100, 100); //Pone la ventana en una posicion concreta
        
        //Configuracion de contenedores
        JPanel contenedor =(JPanel) this.getContentPane(); //Creamos un contenedor para meter elementos
        contenedor.setLayout(null); //Sin Layout
        //contenedor.setLayout(new FlowLayout()); //Con Layout
        contenedor.setBackground(new Color(255,0,0)); //Poner color de fondo al contenedor
        
        //Configuracion de Elementos
        JLabel etiqueta = new JLabel("Hola mundo"); //Creo el elemento etiqueta
        contenedor.add(etiqueta); //Añado la etiqueta
        etiqueta.setBounds(25, 25, 75, 20); //(Pixels desde Derecha,Pixels desde Arriba,Tamaño Horizontal,Tamaño Vertical)
        
        JButton boton = new JButton("Salir");
        contenedor.add(boton);
        boton.setBounds (25, 75, 100, 50);
        
        //Configuracion del evento
        boton.addActionListener((e) -> {
            System.out.println("Hola mundo");
            System.exit(0);
        });
        
    }
    
   
       
    
}
