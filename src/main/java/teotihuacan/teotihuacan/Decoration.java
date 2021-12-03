package teotihuacan.teotihuacan;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Decoration extends Pane {
    private Pane symbole1;
    private Pane symbole2;
    private Color color;

    public Decoration(Pane symbole1, Pane symbole2, Color color) {
        this.symbole1 = symbole1;
        this.symbole2 = symbole2;
        this.color = color;
    }

    // placer les tuiles  : fxml scene builder


}
