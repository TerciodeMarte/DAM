package componentesemaforo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Albano Díez de Paulino
 */
public class MiBotonColores extends JButton implements Serializable,MouseListener {

    private Color ColorTexto;

    public MiBotonColores() {
        ColorTexto = Color.BLACK;
        this.setBackground(Color.RED);
        this.addMouseListener(this);
    }

    public Color getColorTexto() {
        return ColorTexto;
    }

    public void setColorTexto(Color ColorTexto) {
        this.ColorTexto = ColorTexto;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }


}
