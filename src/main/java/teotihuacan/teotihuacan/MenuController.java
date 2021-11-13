package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static teotihuacan.teotihuacan.Player.createPlayer;
import static teotihuacan.teotihuacan.Player.nbPlayer;

public class MenuController {

    @FXML
    protected void on2PlayersClick() {
        System.out.println("2 joueurs");
        nbPlayer = 2;
        createPlayer();
    }

    @FXML
    protected void on3PlayersClick() {
        System.out.println("3 joueurs");
        nbPlayer = 3;
        createPlayer();
    }

    @FXML
    protected void on4PlayersClick() {
        System.out.println("4 joueurs");
        nbPlayer = 4;
        createPlayer();
    }
}