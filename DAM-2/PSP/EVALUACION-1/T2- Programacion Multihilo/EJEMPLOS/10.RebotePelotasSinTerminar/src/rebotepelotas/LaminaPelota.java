/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rebotepelotas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author joaqf
 */
// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel {
    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
    //Añadimos pelota a la lámina
    public void add(Pelota b) {
        pelotas.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
        revalidate();
    }

}