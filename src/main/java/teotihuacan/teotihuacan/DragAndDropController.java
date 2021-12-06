package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DragAndDropController extends GameController implements Initializable {
    @FXML
    private ImageView home1;

    @FXML
    private ImageView home10;

    @FXML
    private ImageView home11;

    @FXML
    private ImageView home2;

    @FXML
    private ImageView home3;

    @FXML
    private ImageView home4;

    @FXML
    private ImageView home5;

    @FXML
    private ImageView home6;

    @FXML
    private ImageView home7;

    @FXML
    private ImageView home8;

    @FXML
    private ImageView home9;

    @FXML
    private HBox dragElement;

    @FXML
    private HBox drop1;

    @FXML
    private HBox drop2;

    @FXML
    private HBox drop3;


    DraggableNode draggableNode = new DraggableNode();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(Node children : dragElement.getChildren()){
            draggableNode.setupGestureSource((ImageView) children);
        }

        draggableNode.setupGestureTarget(drop1,5);
        draggableNode.setupGestureTarget(drop2,4);
        draggableNode.setupGestureTarget(drop3,3);

    }
}
