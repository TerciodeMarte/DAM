package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.UserDAO;
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

        this.login.getLogin().addActionListener(this);
        this.login.getExit().addActionListener(this);
        this.login.getTFEmail().addMouseListener(this);
        this.login.getTFPass().addMouseListener(this);
        this.login.getTFEmail().addFocusListener(this);
        this.login.getTFPass().addFocusListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("Login")) {
            if (UserDAO.searchEmail(this.login.getTFEmail().getText())) {
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
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
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
        if (e.getCause().toString().equals("ACTIVATION")) {
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

        //System.out.println(e.getOppositeComponent().getName());
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
