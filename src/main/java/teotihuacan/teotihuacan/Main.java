package teotihuacan.teotihuacan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Stage primaryStage;
    static Scene gameView;
    static Scene pyramide;
    static Scene carte6;


    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene menu = new Scene(fxmlLoader.load(), 800, 800);

        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("gameView.fxml"));
        gameView = new Scene(fxmlLoader1.load(), 1200, 800);

        FXMLLoader fxmlLoader2 = new FXMLLoader(Main.class.getResource("pyramide.fxml"));
        pyramide = new Scene(fxmlLoader2.load(), 1200, 800);

        FXMLLoader fxmlLoader3 = new FXMLLoader(Main.class.getResource("carte6.fxml"));
        carte6 = new Scene(fxmlLoader3.load(), 800, 400);

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