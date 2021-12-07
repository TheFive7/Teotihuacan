package teotihuacan.teotihuacan;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import static teotihuacan.teotihuacan.Main.gameView;
import static teotihuacan.teotihuacan.Main.primaryStage;
import static teotihuacan.teotihuacan.Player.*;

public class MenuController {

    public void eclipse() {
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
    protected void play() {
        System.out.println("4 joueurs");
        nbPlayer = 4;

        createPlayer();
        attribuerRessourcesDepart();
        printPlayer();
        searchPlayerByNumber(1).enleverRessources("or",2);
        printPlayer();

        primaryStage.setScene(gameView);
    }
}