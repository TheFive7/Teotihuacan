package teotihuacan.teotihuacan;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;

public class DraggableNode {

    private double mouseAnchorX;
    private double mouseAnchorY;
    int curseur = 0 ;
    ImageView iv;

    public void setupGestureSource(final ImageView source){

        source.setOnDragDetected(new EventHandler <MouseEvent>() {

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

                if(db.hasImage() && targetBox.getChildren().size() < nbMaxImg){

                    iv.setImage(db.getImage());

                    Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));

//                    System.out.println("event.getSceneX : "+event.getSceneX());
//                    System.out.println("localPoint.getX : "+localPoint.getX());
//                    System.out.println("********");

                    targetBox.getChildren().remove(iv);

                    iv.setX((int)(localPoint.getX() - iv.getBoundsInLocal().getWidth()  / 2)  );
                    iv.setY((int)(localPoint.getY() - iv.getBoundsInLocal().getHeight() / 2) );

                    targetBox.getChildren().add(iv);

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

/*    public void actualiser(){

        text1.setText("Ballon a gauche : "+ nombreLeft);
        text2.setText("Ballon a droite : "+ nombreRight);
        System.out.println(nombreLeft+ " " + nombreRight);
        System.out.println(text1.getText()+ " " + text2.getText());
        root.getChildren().remove(text1);
        root.getChildren().remove(text2);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
    }*/

  
}
