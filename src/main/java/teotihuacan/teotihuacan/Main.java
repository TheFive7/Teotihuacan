package teotihuacan.teotihuacan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Stage primaryStage;
    static Scene gameView;
    static Scene pyramide2J;
    static Scene pyramide3J;
    static Scene pyramide4J;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene menu = new Scene(fxmlLoader.load(), 800, 800);

        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("gameView.fxml"));
        gameView = new Scene(fxmlLoader1.load(), 1200, 800);

        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("pyramide2J.fxml"));
        pyramide2J = new Scene(fxmlLoader2.load(), 800, 800);

        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("pyramide3J.fxml"));
        pyramide3J = new Scene(fxmlLoader3.load(), 800, 800);

        FXMLLoader fxmlLoader4 = new FXMLLoader(Main.class.getResource("pyramide4J.fxml"));
        pyramide4J = new Scene(fxmlLoader4.load(), 800, 800);

        stage.setTitle("Teotihuacan");
        stage.setScene(menu);
        stage.show();

        // Tests
        Deck deck = new Deck(20);
        deck.print();
        deck.shuffle();
        deck.print();
        System.out.println();
    }

    public static void main(String[] args) {
        launch();
    }
}