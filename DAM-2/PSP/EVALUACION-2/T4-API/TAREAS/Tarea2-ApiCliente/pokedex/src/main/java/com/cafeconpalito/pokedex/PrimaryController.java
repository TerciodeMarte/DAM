package com.cafeconpalito.pokedex;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class PrimaryController implements Initializable {

    @FXML
    private ImageView ImageView;
    @FXML
    private ImageView next;
    @FXML
    private ImageView back;
    @FXML
    private Label pokename;
    @FXML
    private HBox tipos;
    @FXML
    private ProgressBar hpbar;
    @FXML
    private Label hplabel;
    @FXML
    private Label atcklabel;
    @FXML
    private Label defenselabel;
    @FXML
    private Label especialatklabel;
    @FXML
    private Label especialdeflabel;
    @FXML
    private Label speedlabel;
    @FXML
    private ProgressBar atckbar;
    @FXML
    private ProgressBar defensebar;
    @FXML
    private ProgressBar especialatkbar;
    @FXML
    private ProgressBar especialdefbar;
    @FXML
    private ProgressBar speedbar;
    @FXML
    private Label type1;
    @FXML
    private Label type2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateInfo();
    }

    @FXML
    private void nextButton(MouseEvent event) {
        if (EntryPoint.getContador() < 1025) {
            EntryPoint.setContador(EntryPoint.getContador() + 1);
            updateInfo();
        }

    }

    @FXML
    private void backButton(MouseEvent event) {
        if (EntryPoint.getContador() > 1) {
            EntryPoint.setContador(EntryPoint.getContador() - 1);
            updateInfo();

        }
    }

    private void updateInfo() {
        //Actualizo el json
        ConsultasAPI.consulta(EntryPoint.getContador());

        //Obtengo la foto
        ImageView.setImage(ConsultasAPI.getSprite());

        //Obtengo el nombre
        pokename.setText("#" + EntryPoint.getContador() + " " + ConsultasAPI.getName().toUpperCase());

        //Obtengo las estaticas
        Integer stats[] = ConsultasAPI.getStats();

        //Poner estadisticas en labels
        hplabel.setText(stats[0].toString());
        atcklabel.setText(stats[1].toString());
        defenselabel.setText(stats[2].toString());
        especialatklabel.setText(stats[3].toString());
        especialdeflabel.setText(stats[4].toString());
        speedlabel.setText(stats[5].toString());

        //Actualizo las progressBar para mostrar stats
        updateProgressBar(stats);

        //Obtengo los tipos
        String types[] = ConsultasAPI.getTypes();

        //Actualizo los tipos
        updateTypes(types);

    }

    private void updateProgressBar(Integer[] stats) {
        String color[] = new String[stats.length];
        //Determino los colores de cada stat
        for (int i = 0; i < stats.length; i++) {
            if (stats[i] < 50) {
                color[i] = "red";
            } else if (stats[i] >= 50 && stats[i] < 80) {
                color[i] = "orange";
            } else if (stats[i] >= 80 && stats[i] < 100) {
                color[i] = "yellow";
            } else if (stats[i] >= 100 && stats[i] < 120) {
                color[i] = "green";
            } else {
                color[i] = "lime";
            }
        }
        //Pongo los valores
        hpbar.setProgress(stats[0] / 255.0);
        atckbar.setProgress(stats[1] / 255.0);
        defensebar.setProgress(stats[2] / 255.0);
        especialatkbar.setProgress(stats[3] / 255.0);
        especialdefbar.setProgress(stats[4] / 255.0);
        speedbar.setProgress(stats[5] / 255.0);

        //Pongo el color
        hpbar.setStyle("-fx-accent:" + color[0]);
        atckbar.setStyle("-fx-accent:" + color[1]);
        defensebar.setStyle("-fx-accent:" + color[2]);
        especialatkbar.setStyle("-fx-accent:" + color[3]);
        especialdefbar.setStyle("-fx-accent:" + color[4]);
        speedbar.setStyle("-fx-accent:" + color[5]);
    }

    private void updateTypes(String[] types) {
        String color[] = new String[2];

        //Determino los colores de cada tipo
        for (int i = 0; i < types.length; i++) {
            switch (types[i]) {
                case "bug": //ECHO
                    color[i] = "#007310";
                    break;
                case "dark"://echo
                    color[i] = "#393939";
                    break;
                case "dragon": //ECHO
                    color[i] = "#6100D6";
                    break;
                case "electric"://echo
                    color[i] = "#E0DD0C";
                    break;
                case "fairy": //echo
                    color[i] = "#FF83F6";
                    break;
                case "fighting": //echo
                    color[i] = "#F54A00";
                    break;
                case "fire": //echo
                    color[i] = "#CF0000";
                    break;
                case "flying":
                    color[i] = "#006DAB";
                    break;
                case "ghost": //echo
                    color[i] = "#260053";
                    break;
                case "grass": //ECHO
                    color[i] = "#00FF23";
                    break;
                case "ground": //echo
                    color[i] = "#844004";
                    break;
                case "ice": //echo
                    color[i] = "#00CFCF";
                    break;
                case "normal"://echo
                    color[i] = "#DFDEDE";
                    break;
                case "poison"://echo
                    color[i] = "#AA00FF";
                    break;
                case "psychic": //echo
                    color[i] = "#FF0061";
                    break;
                case "rock"://echo
                    color[i] = "#876546";
                    break;
                case "steel": //ECHO
                    color[i] = "#D6D6D6";
                    break;
                case "water": //ECHO
                    color[i] = "#006DAB";
                    break;
            }
        }
        //Pongo los textos y colores en los labels
        if (types.length == 2) {
            type1.setText(types[0].toUpperCase());
            type1.setStyle("-fx-background-color: " + color[0]);
            type2.setStyle("-fx-background-color: " + color[1]);
            type2.setText(types[1].toUpperCase());
            type2.setDisable(false);
        } else {
           
            type1.setText(types[0].toUpperCase());
            type1.setStyle("-fx-background-color: " +color[0]);
            type2.setText("Type 2");
            type2.setStyle("-fx-background-color: transparent" );
            type2.setDisable(true);
            
        }

    }

}
