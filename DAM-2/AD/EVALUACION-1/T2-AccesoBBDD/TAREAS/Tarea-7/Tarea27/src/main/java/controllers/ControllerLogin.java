package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import models.ConexionBBDD;
import views.Login;

/**
 *
 * @author Albano Díez de Paulino
 */
public class ControllerLogin implements MouseListener {

    private Login view = new Login();
    private Connection con;
    private ControllerDatos controller = new ControllerDatos();
    

    public void run() {

        view.setVisible(true);

        view.login.addMouseListener(this);
        view.cancel.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent().getName().equalsIgnoreCase("Cancelar")) {
            view.TFPass.setText("");
            view.TFUser.setText("");
            view.TFMensage.setText("");
        } else if (e.getComponent().getName().equalsIgnoreCase("Login")) {
            try {

                ConexionBBDD.setUSER(view.TFUser.getText());
                ConexionBBDD.setPASS(view.TFPass.getText());

                con = ConexionBBDD.getInstance().getConnection();
               
                view.TFMensage.setText("");
                view.TFMensage.setForeground(Color.black);
                view.dispose();
                
                controller.run();
                
                

            } catch (SQLException ex) {

                view.TFMensage.setText("Usuario o contraseña incorrecto");
                view.TFMensage.setForeground(Color.red);
                view.TFPass.setText("");
                view.TFUser.setText("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
