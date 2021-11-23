package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static teotihuacan.teotihuacan.Main.*;
import static teotihuacan.teotihuacan.Player.*;

public class MenuController {

    @FXML
    protected void on2PlayersClick() {
        System.out.println("2 joueurs");
        nbPlayer = 2;
        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        primaryStage.setScene(pyramide2J);
    }

    @FXML
    protected void on3PlayersClick() {
        System.out.println("3 joueurs");
        nbPlayer = 3;
        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        primaryStage.setScene(pyramide3J);
    }

    @FXML
    protected void on4PlayersClick() {
        System.out.println("4 joueurs");
        nbPlayer = 4;
        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        primaryStage.setScene(pyramide4J);
    }
}