package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

    public static void main(String[] args) {

        Controller c = new Controller();
        c.run();
        //UserDAO.registerUsers();
        //UserDAO.listUser();

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
        form1.getNext().addMouseListener(this);
        form2.getNext().addMouseListener(this);
        form2.getBack().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("Login")) {
            if (UserDAO.searchEmail(login.getTFEmail().getText())) {
                login.getErrorE().setVisible(false);

                if (UserDAO.checkPassword(String.valueOf(login.getTFPass().getPassword()))) {

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
            add.setLocation(view.getX() + 200, view.getY());

            form1.setSize(700, 510);
            form1.setLocation(0, 0);

            add.getFormulario().removeAll();
            add.getFormulario().add(form1);
            add.getFormulario().revalidate();
            add.getFormulario().repaint();

            add.setVisible(true);

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
            System.out.println("Formulario3");
        } else if (e.getComponent().getName().equals("JBack2")) {
            add.getFormulario().removeAll();
            add.getFormulario().add(form1);
            add.getFormulario().revalidate();
            add.getFormulario().repaint();
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

}
