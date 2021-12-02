package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static teotihuacan.teotihuacan.Player.*;

public class GameController {
    @FXML
    Label labelCacaoNumber;
    @FXML
    Label labelGoldNumber;
    @FXML
    Label labelWoodNumber;
    @FXML
    Label labelRockNumber;
    @FXML
    Label labelCurrentPlayer;

    int num = 1;

    public void nextPlayer(){
        if (num == 4) {num = 1;} else {num ++;}
        currentPlayer = searchPlayerByNumber(num);
        afficherRessources();
    }

    public void prevPlayer(){
        if (num == 1) {num = 4;} else {num --;}
        currentPlayer = searchPlayerByNumber(num);
        afficherRessources();
    }

    public void afficherRessources(){
        labelCurrentPlayer.setText("Joueur " + num);
        labelCacaoNumber.setText("x " + currentPlayer.countRessource("cacao"));
        labelGoldNumber.setText("x " + currentPlayer.countRessource("or"));
        labelWoodNumber.setText("x " + currentPlayer.countRessource("bois"));
        labelRockNumber.setText("x " + currentPlayer.countRessource("pierre"));
    }
}
