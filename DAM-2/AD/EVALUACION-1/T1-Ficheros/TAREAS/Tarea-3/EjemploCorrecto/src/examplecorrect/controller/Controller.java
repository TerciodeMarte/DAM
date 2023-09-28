package examplecorrect.controller;

import examplecorrect.model.Model;
import examplecorrect.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Controller implements ActionListener {

    private static View view = new View();
    private Model model = new Model();

    public static void main(String[] args) {

        Controller c = new Controller();
        c.run();

    }

    public void run() {

        view.setTitle("Calculator");
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        this.view.suma.addActionListener(this);
        this.view.limpiar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("sumar")) {
            try {

                model.setN1(Integer.parseInt(view.TF1.getText()));
                model.setN2(Integer.parseInt(view.TF2.getText()));

                view.TFR.setText(String.valueOf(model.sumar()));
            } catch (NumberFormatException ex) {

                view.TF1.setText("");
                view.TF2.setText("");
                view.TFR.setText("Debes escribir dos números enteros.");
            }

        } else if (e.getActionCommand().equalsIgnoreCase("limpiar")) {
            view.TF1.setText("");
            view.TF2.setText("");
            view.TFR.setText("");
        }
    }

}
