package tarea3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tarea3.entity.Product;
import tarea3.model.ProductModel;
import tarea3.view.Input;
import tarea3.view.View;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Controller implements ActionListener {

    private static View view = new View();
    private static Input input = new Input(view, true);
    private ProductModel model = new ProductModel();

    public static void main(String[] args) {

        Controller c = new Controller();
        c.run();

    }

    public void run() {

        view.setTitle("Inventario");
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        this.view.nuevo.addActionListener(this);
        this.view.update.addActionListener(this);

        this.input.guardar.addActionListener(this);
        this.input.cancelar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("nuevo")) {
            input.setTitle("Nuevo Producto");
            input.setLocationRelativeTo(null);
            input.setVisible(true);
        } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
            input.dispose();
        } else if (e.getActionCommand().equalsIgnoreCase("guardar")) {
            if (input.getTF1().getText().isBlank() || input.getTF2().getText().isBlank()) {
                JOptionPane jop = new JOptionPane("Introduce un nombre y/o un precio", JOptionPane.ERROR_MESSAGE);
                javax.swing.JDialog jd = jop.createDialog("ERROR");
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);
            } else if (input.getTF2().getText().contains(",")) {
                JOptionPane jop = new JOptionPane("Dato numerico con coma", JOptionPane.ERROR_MESSAGE);
                javax.swing.JDialog jd = jop.createDialog("ERROR");
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);
            } else {
                model.guardar(new Product(input.getTF1().getText(), Double.parseDouble(input.getTF2().getText())));

                JOptionPane jop = new JOptionPane("Producto guardado con exito", JOptionPane.INFORMATION_MESSAGE);
                javax.swing.JDialog jd = jop.createDialog("INFO");
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);

                input.dispose();
            }

        } else if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
            ArrayList<Product> lista = new ArrayList();
            DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
            lista = model.leer();
            for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

            for (Product i : lista) {
                String[] row = new String[2];
                row[0] = i.getNombre();
                row[1] = String.valueOf(i.getPrecio());
                modelo.addRow(row);
            }
        }
    }
}
