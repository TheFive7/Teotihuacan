package teotihuacan.teotihuacan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import static teotihuacan.teotihuacan.Player.*;

public class MenuController {

    public void Eclipse(Stage stage) {

        Stage stage1 = new Stage();
        int jEclipse = 12;
        Pane PEclipse = new Pane();
        PEclipse.setPrefSize(400, 400);
        PEclipse.getChildren().addAll();
        Scene Eclipse = new Scene(PEclipse);
        TextArea textField = new TextArea("Nombre de jour avant l'éclipse : " + jEclipse);
        textField.setMinWidth(180);
        PEclipse.getChildren().addAll(textField);
        stage1.setTitle("Eclipse");
        stage1.setScene(Eclipse);
        stage1.show();

    }



    @FXML
    protected void on2PlayersClick() {


        System.out.println("2 joueurs");
        nbPlayer = 2;
        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        Stage stage2 = new Stage();
        Eclipse(stage2);


    }

    @FXML
    protected void on3PlayersClick() {
        System.out.println("3 joueurs");
        nbPlayer = 3;

        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        Stage stage2 = new Stage();
        Eclipse(stage2);

    }

    @FXML
    protected void on4PlayersClick() {
        System.out.println("4 joueurs");
        nbPlayer = 4;

        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        Stage stage2 = new Stage();
        Eclipse(stage2);

    }
}