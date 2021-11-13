package teotihuacan.teotihuacan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static teotihuacan.teotihuacan.Player.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Teotihuacan");
        stage.setScene(scene);
        stage.show();

        // Tests
        Deck deck = new Deck(20);
        deck.print();
        deck.shuffle();
        deck.print();

        nbPlayer = 4;
        createPlayer();
        attribuerRessourcesDepart();
        System.out.println(players.get(0).getRessources().size());
        System.out.println(players.get(1).getRessources().size());
        System.out.println(players.get(2).getRessources().size());
        System.out.println(players.get(3).getRessources().size());
        printPlayer();
    }

    public static void main(String[] args) {
        launch();
    }
}