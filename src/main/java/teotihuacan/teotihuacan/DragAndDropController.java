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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import static teotihuacan.teotihuacan.Main.*;

import static teotihuacan.teotihuacan.Player.currentPlayer;
import static teotihuacan.teotihuacan.Player.printPlayer;

public class DragAndDropController extends GameController implements Initializable {

    @FXML
    private GridPane ouvriersJoueurs;
    @FXML
    private GridPane gridOuvrier;

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

        setupGestureTarget(5,null, drop1);
        if(drop2 != null) setupGestureTarget(4, null, drop2);
        if(drop3 != null)setupGestureTarget(3, null, drop3);



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

    void setupGestureTarget( int nbMaxImg, GridPane gridPane, HBox hbox){
        Node targetBox;
        if(gridPane != null && hbox == null){
            targetBox = gridPane;
        }
        else targetBox = hbox;

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
                System.out.println(" nb bois : " + nbWood + " placer batiment " + model.getPoserBatiment() + " size = " + ((Pane) targetBox).getChildren().size() + " < "+  nbMaxImg + " size grid ouvrier = " +gridOuvrier.getChildren().size() + "height = "+ ((Pane) targetBox).getHeight());
                if(db.hasImage() && ((Pane) targetBox).getChildren().size() < nbMaxImg ){
                    if(((Pane) targetBox).getHeight() == 38 && nbWood >=2 && model.getPoserBatiment() && gridOuvrier.getChildren().size()>=1 || ((Pane) targetBox).getHeight() == 105){
                        iv.setImage(db.getImage());

                        Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));

                        if(!targetBox.getId().equals("gridOuvrier")){
                            ((Pane) targetBox).getChildren().remove(iv);
                            System.out.println("pas grid ouvrier ça ");
                        }
                        

                        iv.setX((int)(localPoint.getX() - iv.getBoundsInLocal().getWidth()  / 2)  );
                        iv.setY((int)(localPoint.getY() - iv.getBoundsInLocal().getHeight() / 2) );

                        if(!targetBox.getId().equals("gridOuvrier")) ((Pane) targetBox).getChildren().add(iv);
                        else {
                            gridOuvrier.add(iv, model.getNbOuvrierCase6(),0);
                            model.addNbOuvrierCase6();
                        }

                        if(targetBox.getId().equals("drop1") || targetBox.getId().equals("drop2") || targetBox.getId().equals("drop3"))actualiser();
                        if(targetBox.getId().equals("drop1")) {
                            currentPlayer.ouvriers[0].augmenterForce();
                            gridOuvrier.getChildren().remove(model.getNbOuvrierCase6()-1);
                            ImageView img = new ImageView(new Image("file:src/main/resources/ouvriers/de_"+currentPlayer.getColor().toLowerCase() + "_"+currentPlayer.ouvriers[0].getForce() + ".png"));
                            img.setFitHeight(50);
                            img.setFitWidth(50);
                            System.out.println(model.getNbOuvrierCase6());
                            gridOuvrier.add(img, model.getNbOuvrierCase6()-1, 0);
                            //model.addNbOuvrierCase6();
                        }
                        event.setDropCompleted(true);
                    }

                }else{
                    event.setDropCompleted(false);
                }

                event.consume();
            }
        });


    }



    public void quitter(){
        super.quitter();

    }

    public void actualiser(){
        System.out.println(" + 1 maison et - 2 bois");
        currentPlayer.enleverRessources("bois", 2);
        model.enleveBatiment();
        switch (currentPlayer.getColor()) {
            case "YELLOW" -> model.setPlayerJaune();
            case "BLUE" -> model.setPlayerBleu();
            case "GREEN" -> model.setPlayerVert();
            case "RED" -> model.setPlayerRouge();
            default -> {
            }
        }
        model.setPoserBatiment(false);
    }

    public void actualiserOuvrier(){
        int col = 0, line = 0;
        for(int i=0; i< currentPlayer.ouvriers.length; i++){
            if(i==2){
                col = 0;
                line = 1;
            }
            String imgName = "de_"+currentPlayer.getColor().toLowerCase() + "_"+currentPlayer.ouvriers[i].getForce() + ".png";

            Image imgv1 = new Image("file:src/main/resources/ouvriers/"+imgName);

            ImageView img = new ImageView(imgv1);
            img.setFitHeight(50);
            img.setFitWidth(50);
            setupGestureSource(img);
            ouvriersJoueurs.add(img,col,line);

            col++;
        }

        setupGestureTarget(4, ouvriersJoueurs, null);
        setupGestureTarget(12, gridOuvrier, null);





    }

}
