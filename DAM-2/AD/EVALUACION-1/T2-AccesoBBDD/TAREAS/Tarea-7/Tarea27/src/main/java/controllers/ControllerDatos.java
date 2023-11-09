package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import views.Datos;
import views.Login;

/**
 *
 * @author Albano Díez de Paulino
 */
public class ControllerDatos implements MouseListener {

    private Datos view = new Datos();

    public void run() {

        view.setVisible(true);

        view.juegos.addMouseListener(this);
        view.jugadores.addMouseListener(this);
        view.ambos.addMouseListener(this);
        view.exit.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent().getName().equalsIgnoreCase("jugadores")) {

            JTableHeader tableHeader = view.jTable1.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_jugador");
            tableColumnModel.getColumn(1).setHeaderValue("alias");
            tableColumnModel.getColumn(2).setHeaderValue("nombre");
            tableHeader.repaint();

            DefaultTableModel modelo = (DefaultTableModel) view.jTable1.getModel();
            modelo.setRowCount(0);

        } else if (e.getComponent().getName().equalsIgnoreCase("juegos")) {

            JTableHeader tableHeader = view.jTable1.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_juego");
            tableColumnModel.getColumn(1).setHeaderValue("nombre");
            tableColumnModel.getColumn(2).setHeaderValue("tipo");
            tableHeader.repaint();

            DefaultTableModel modelo = (DefaultTableModel) view.jTable1.getModel();
            modelo.setRowCount(0);

        } else if (e.getComponent().getName().equalsIgnoreCase("ambos")) {
            JTableHeader tableHeader = view.jTable1.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("Nombre Jugador");
            tableColumnModel.getColumn(1).setHeaderValue("Nombre Juego");
            tableColumnModel.getColumn(2).setHeaderValue("Ultima Sesion");
            tableHeader.repaint();

            DefaultTableModel modelo = (DefaultTableModel) view.jTable1.getModel();
            modelo.setRowCount(0);

        } else if (e.getComponent().getName().equalsIgnoreCase("exit")) {

            System.exit(0);
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
