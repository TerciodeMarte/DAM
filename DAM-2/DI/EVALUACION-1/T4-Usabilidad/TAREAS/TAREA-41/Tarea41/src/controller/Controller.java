package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Game;
import models.GameDAO;
import models.UserDAO;
import view.Add;
import view.Form1;
import view.Form2;
import view.Games;
import view.Login;
import view.Main;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Controller implements ActionListener, MouseListener, FocusListener {

    private static Main view = new Main();
    private static Login login = new Login();
    private static Games games = new Games();
    private static Add add = new Add(view, true);
    private static Form1 form1 = new Form1();
    private static Form2 form2 = new Form2();

    private static String ruta = "";
    private static int contador = 0;

    public static void main(String[] args) {

        Controller c = new Controller();
        c.run();

        //UserDAO.registerUsers();
        //UserDAO.listUser();
        //String nombre+, String genre+, String date+, String company+, String distribution+, String pegi+, String descripcion, String image, String version, double precio
        //GameDAO.almacenarGame(new Game("Minecraft", "SandBox", "2012-12-01", "Microsoft", "Europa", "+3", "Juego de cubos", "src/resources/logo-steam", "Basic", 12));
        //GameDAO.almacenarGame(new Game("TF2", "Shooter", "2023-01-31", "Valve", "America", "+17", "Red vs Blue", "src/resources/logo-steam", "Free", 0));
        //GameDAO.leerGames();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        login.setSize(700, 750);
        login.setLocation(0, 0);
        login.getErrorE().setVisible(false);
        login.getErrorP().setVisible(false);

        games.setSize(700, 750);
        games.setLocation(0, 0);

        view.getFondo().removeAll();
        view.getFondo().add(login);
        view.getFondo().revalidate();
        view.getFondo().repaint();

        view.setLocationRelativeTo(null);
        view.setVisible(true);

        login.getLogin().addActionListener(this);
        login.getExit().addActionListener(this);
        login.getTFEmail().addMouseListener(this);
        login.getTFPass().addMouseListener(this);
        login.getTFEmail().addFocusListener(this);
        login.getTFPass().addFocusListener(this);

        games.getJLExit().addMouseListener(this);
        games.getAdd().addActionListener(this);
        games.getFilterb().addMouseListener(this);

        form1.getNext().addMouseListener(this);
        form2.getNext().addMouseListener(this);
        form2.getBack().addMouseListener(this);
        form2.getLoad().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("Login")) {
            if (UserDAO.searchEmail(login.getTFEmail().getText())) {
                login.getErrorE().setVisible(false);

                if (UserDAO.checkPassword(String.valueOf(login.getTFPass().getPassword()))) {

                    cargarTabla(games.getTFFName().getText(), games.getTFFGenre().getText(), games.getTFFCompany().getText());
                    games.getJLName().setText("Welcome " + UserDAO.getUser().getName());
                    view.getFondo().removeAll();
                    view.getFondo().add(games);
                    view.getFondo().revalidate();
                    view.getFondo().repaint();

                } else {
                    login.getErrorP().setVisible(true);

                }
            } else {
                login.getErrorE().setVisible(true);
                login.getErrorP().setVisible(false);
            }
        } else if (e.getActionCommand().equalsIgnoreCase("AddGame")) {
            if (contador == 0) {
                add.setLocation(view.getX() + 200, view.getY());

                limpiarFormularios();
                form1.setSize(700, 510);
                form1.setLocation(0, 0);

                add.getFormulario().removeAll();
                add.getFormulario().add(form1);
                add.getFormulario().revalidate();
                add.getFormulario().repaint();

                add.setVisible(true);
                contador = 1;
            } else {
                contador = 0;
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent().getName().equals("JLExit")) {
            this.login.getTFEmail().setText("email@steam.com");
            this.login.getTFPass().setText("password");
            login.getTFPass().setForeground(Color.gray);
            login.getTFEmail().setForeground(Color.gray);

            view.getFondo().removeAll();
            view.getFondo().add(login);
            view.getFondo().revalidate();
            view.getFondo().repaint();
        } else if (e.getComponent().getName().equals("JNext1")) {

            if (form1.getjDateChooser1().getDate() == null) {
                JOptionPane jop = new JOptionPane("One field contains an error", JOptionPane.ERROR_MESSAGE);
                JDialog jd = jop.createDialog("ERROR");
                jd.setLocationRelativeTo(null);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);
            } else {
                if (Validation.name(form1.getTFFName().getText())
                        || Validation.genre(form1.getTFGenre().getText())
                        || Validation.date(form1.getjDateChooser1().getDate().toString())
                        || Validation.distribution(form1.getComboDistribution().getSelectedIndex())
                        || Validation.company(form1.getComboCompany().getSelectedIndex())) {

                    JOptionPane jop = new JOptionPane("One field contains an error", JOptionPane.ERROR_MESSAGE);
                    JDialog jd = jop.createDialog("ERROR");
                    jd.setLocationRelativeTo(null);
                    jd.setVisible(true);
                    jd.setAlwaysOnTop(true);

                } else {

                    form2.setSize(700, 510);
                    form2.setLocation(0, 0);

                    add.getFormulario().removeAll();
                    add.getFormulario().add(form2);
                    add.getFormulario().revalidate();
                    add.getFormulario().repaint();
                }
            }

        } else if (e.getComponent().getName().equals("JNext2")) {
            if (Validation.description(form2.getTADes().getText())
                    || Validation.ruta(form2.getTFRuta().getText())
                    || Validation.version(form2.getTFVersion1().getText())
                    || Validation.price(form2.getPrecio().getValue().toString())) {

                JOptionPane jop = new JOptionPane("One field contains an error", JOptionPane.ERROR_MESSAGE);
                JDialog jd = jop.createDialog("ERROR");
                jd.setLocationRelativeTo(null);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);

            } else {
                GameDAO.almacenarGame(new Game(form1.getTFFName().getText(),
                        form1.getTFGenre().getText(),
                        form1.getjDateChooser1().getDate().toString(),
                        form1.getComboCompany().getSelectedItem().toString(),
                        form1.getComboDistribution().getSelectedItem().toString(),
                        form1.getjSpinner1().getValue().toString(),
                        form2.getTADes().getText(),
                        ruta,
                        form2.getTFVersion1().getText(),
                        Double.parseDouble(form2.getPrecio().getValue().toString())));

                add.dispose();

                JOptionPane jop = new JOptionPane("Game successfully inserted ", JOptionPane.INFORMATION_MESSAGE);
                JDialog jd = jop.createDialog("INFO");
                jd.setLocationRelativeTo(null);
                jd.setVisible(true);
                jd.setAlwaysOnTop(true);

                cargarTabla(games.getTFFName().getText(), games.getTFFGenre().getText(), games.getTFFCompany().getText());
                limpiarFormularios();
            }

        } else if (e.getComponent().getName().equals("JBack2")) {
            add.getFormulario().removeAll();
            add.getFormulario().add(form1);
            add.getFormulario().revalidate();
            add.getFormulario().repaint();
        } else if (e.getComponent().getName().equals("LoadImage")) {
            //Creamos el objeto JFileChooser
            JFileChooser fc = new JFileChooser();

            //Indicamos lo que podemos seleccionar
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            //Creamos el filtro
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.png", "png");

            //Le indicamos el filtro
            fc.setFileFilter(filtro);

            //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
            int seleccion = fc.showOpenDialog(add);

            //Si el usuario, pincha en aceptar
            if (seleccion == JFileChooser.APPROVE_OPTION) {

                //Seleccionamos el fichero
                File fichero = fc.getSelectedFile();
                ruta = fichero.getAbsolutePath();

                Path origenPath = FileSystems.getDefault().getPath(ruta);
                Path destinoPath = FileSystems.getDefault().getPath("images/" + fichero.getName());

                try {
                    Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);

                    ruta = "images/" + fichero.getName();
                    //Ecribe la ruta del fichero seleccionado en el campo de texto
                    form2.getTFRuta().setText(fichero.getAbsolutePath());

                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else if (e.getComponent().getName().equals("Filter")) {
            System.out.println("Entre");
            cargarTabla(games.getTFFName().getText(), games.getTFFGenre().getText(), games.getTFFCompany().getText());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            if (e.getComponent().getName().equals("TFEmail")) {
                if (login.getTFEmail().getText().equals("email@steam.com")) {
                    login.getTFEmail().setText("");
                    login.getTFEmail().setForeground(Color.white);
                }
                if (String.valueOf(login.getTFPass().getPassword()).isEmpty()) {
                    login.getTFPass().setText("password");
                    login.getTFPass().setForeground(Color.gray);
                }
            } else if (e.getComponent().getName().equals("TFPass")) {
                if (String.valueOf(login.getTFPass().getPassword()).equals("password")) {
                    login.getTFPass().setText("");
                    login.getTFPass().setForeground(Color.white);
                }
                if (login.getTFEmail().getText().isEmpty()) {
                    login.getTFEmail().setText("email@steam.com");
                    login.getTFEmail().setForeground(Color.gray);
                }
            }
        } catch (NullPointerException ex) {

        }

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

    @Override
    public void focusGained(FocusEvent e) {
        try {
            if (e.getCause().toString().equals("ACTIVATION")) {
                if (login.getTFEmail().getText().equals("email@steam.com")) {
                    login.getTFEmail().setText("");
                    login.getTFEmail().setForeground(Color.white);
                }
                if (String.valueOf(login.getTFPass().getPassword()).isEmpty()) {
                    login.getTFPass().setText("password");
                    login.getTFPass().setForeground(Color.gray);
                }
            } else if (e.getOppositeComponent() == null) {
                if (login.getTFEmail().getText().equals("email@steam.com")) {
                    login.getTFEmail().setText("");
                    login.getTFEmail().setForeground(Color.white);
                }
                if (String.valueOf(login.getTFPass().getPassword()).isEmpty()) {
                    login.getTFPass().setText("password");
                    login.getTFPass().setForeground(Color.gray);
                }
            } else if (e.getOppositeComponent().getName().equalsIgnoreCase("TFEmail")) {

                if (String.valueOf(login.getTFPass().getPassword()).equals("password")) {
                    login.getTFPass().setText("");
                    login.getTFPass().setForeground(Color.white);
                }
                if (login.getTFEmail().getText().isEmpty()) {
                    login.getTFEmail().setText("email@steam.com");
                    login.getTFEmail().setForeground(Color.gray);
                }

            } else if (e.getOppositeComponent().getName().equalsIgnoreCase("TFPass")) {

                if (login.getTFEmail().getText().equals("email@steam.com")) {
                    login.getTFEmail().setText("");
                    login.getTFEmail().setForeground(Color.white);
                }
                if (String.valueOf(login.getTFPass().getPassword()).isEmpty()) {
                    login.getTFPass().setText("password");
                    login.getTFPass().setForeground(Color.gray);
                }
            }
        } catch (NullPointerException ex) {
        }

        //System.out.println(e.getOppositeComponent().getName());
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    private static void cargarTabla(String nombre, String genero, String company) {

        GameDAO.leerGames();
        LinkedList<Game> lista = GameDAO.getListgame();
        DefaultTableModel modelo = (DefaultTableModel) games.getTBGames().getModel();
        modelo.setRowCount(0);

        if ((nombre.equalsIgnoreCase("Name") || nombre.isBlank())
                && (genero.equalsIgnoreCase("Genre") || genero.isBlank())
                && (company.equalsIgnoreCase("Company") || company.isBlank())) {
            for (Game game : lista) {
                String[] row = {game.getNombre(), game.getGenre(), game.getDate(), game.getCompany(), game.getDistribution(), game.getPegi()};
                modelo.addRow(row);
            }
        } else {

            Iterator<Game> it = lista.iterator();
            while (it.hasNext()) {
                Game game = it.next();

                if (game.getNombre().contains(nombre)) {
                    continue;
                }
                if (game.getCompany().contains(company)) {
                    continue;
                }
                if (game.getGenre().contains(genero)) {
                    continue;
                }
                it.remove();
            }
            for (Game game : lista) {
                String[] row = {game.getNombre(), game.getGenre(), game.getDate(), game.getCompany(), game.getDistribution(), game.getPegi()};
                modelo.addRow(row);
            }

        }

    }

    private static void limpiarFormularios() {

        //Limpiar formulario 1
        form1.getTFFName().setText("Name");
        form1.getTFFName().setForeground(Color.GRAY);
        form1.getTFGenre().setText("Genre");
        form1.getTFGenre().setForeground(Color.GRAY);
        form1.getComboCompany().setSelectedIndex(0);
        form1.getComboCompany().setForeground(Color.GRAY);
        form1.getComboDistribution().setSelectedIndex(0);
        form1.getComboDistribution().setForeground(Color.GRAY);
        Date limpieza = null;
        form1.getjDateChooser1().setDate(limpieza);
        form1.getjSpinner1().setValue("+3");

        //Limpiar formulario 2
        form2.getTADes().setText("");
        form2.getTFRuta().setText("");
        form2.getTFVersion1().setText("");
        form2.getPrecio().setValue(0);

    }
}
