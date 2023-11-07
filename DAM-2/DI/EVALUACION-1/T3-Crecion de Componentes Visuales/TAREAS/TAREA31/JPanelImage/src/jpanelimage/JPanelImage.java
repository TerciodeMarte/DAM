package jpanelimage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Albano Díez de Paulino
 */
public class JPanelImage extends JPanel implements Serializable {

    private File rutaImage;

    public JPanelImage() {
        
    }

    public String getRutaImage() {
        return rutaImage;
    }

    public void setRutaImage(String rutaImage) {
        this.rutaImage = rutaImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
      
    }
    
    
    
    /*//SIN DISTORCIONAR CODIGO REDUCIDO
        //ES NECESARIO LLEVARSE EL ESCALADOR DE IMAGEN y MODIFICAR EL LABEL QUE SE QUIERE AJUSTAR
        ImageIcon image = new ImageIcon("logo-negative.png");
        Dimension escalaCorrecta = getScaledDimension(  new Dimension(image.getIconWidth(), image.getIconHeight()), 
                                                        new Dimension(jLabelSinDeformar.getWidth(), jLabelSinDeformar.getHeight()));
        Image imgEscalada = image.getImage().getScaledInstance(escalaCorrecta.width, escalaCorrecta.height, WIDTH);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        jLabelSinDeformar.setIcon(imgFinal);*/

//ESCALADOR ;)
    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

}
