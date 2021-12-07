package teotihuacan.teotihuacan;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

import static teotihuacan.teotihuacan.Player.currentPlayer;

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

    int nbWood;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(Node children : dragElement.getChildren()){
            setupGestureSource((ImageView) children);
        }

        setupGestureTarget(drop1,5);
        setupGestureTarget(drop2,4);
        setupGestureTarget(drop3,3);

    }

    @Override
    public void quitter() {
        super.quitter();
    }

    int curseur = 0 ;
    ImageView iv;

    public void setupGestureSource(final ImageView source){

        source.setOnDragDetected(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

                /* put a image on dragboard */
                ClipboardContent content = new ClipboardContent();

                Image sourceImage = source.getImage();
                content.putImage(sourceImage);
                db.setContent(content);


                iv = source ;


                event.consume();
            }
        });

        source.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                source.setCursor(Cursor.HAND);
//                    System.out.println("e...: "+e.getSceneX());
                curseur = (int) e.getSceneX();
            }
        });
    }

    void setupGestureTarget(final HBox targetBox, int nbMaxImg){


        targetBox.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });

        targetBox.setOnDragDropped(new EventHandler <DragEvent>(){
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();
                nbWood = currentPlayer.countRessource("bois");
                if(db.hasImage() && targetBox.getChildren().size() < nbMaxImg && nbWood >= 2){


                    iv.setImage(db.getImage());

                    Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));

//                    System.out.println("event.getSceneX : "+event.getSceneX());
//                    System.out.println("localPoint.getX : "+localPoint.getX());
//                    System.out.println("********");

                    targetBox.getChildren().remove(iv);

                    iv.setX((int)(localPoint.getX() - iv.getBoundsInLocal().getWidth()  / 2)  );
                    iv.setY((int)(localPoint.getY() - iv.getBoundsInLocal().getHeight() / 2) );

                    targetBox.getChildren().add(iv);

                    actualiser();
               /* if(curseur < 400 && event.getSceneX() < 400){
                    nombreLeft = nombreLeft+0;
                }else if(curseur < 400 && event.getSceneX() > 400){
                    nombreLeft--;
                    nombreRight++;
                    actualiser();
                }else if(curseur > 400 && event.getSceneX() > 400){
                    nombreRight = nombreRight +0;
                }else if(curseur > 400 && event.getSceneX() < 400){
                    nombreLeft++;
                    nombreRight--;
                    actualiser();
                }*/
                    event.setDropCompleted(true);
                }else{
                    event.setDropCompleted(false);
                }

                event.consume();
            }
        });


    }

    public void actualiser(){
        System.out.println(" + 1 maison et - 2 bois");
        labelWoodNumber.setText(String.valueOf(nbWood));
    }

}
