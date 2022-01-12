package teotihuacan.teotihuacan;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

/**
 * 1 symbole permet de constituer une tuile ou une décoration
 */
public class Symbole extends Pane {
    private int value;
    private String color;

    public Symbole(int value){
        this.value = value;
        color = choixCouleur();
        setImageFond(value);
    }

    private String choixCouleur() {
        String couleur = "BLACK";
        // 30% de chance d'avoir un symbole de couleur, le reste est en noir
        int tmp = new Random().nextInt(10);
        switch (tmp){
            case 0 :
                couleur = "RED";
                break;
            case 1 :
                couleur = "GREEN";
                break;
            case 2 :
                couleur = "BLUE";
                break;
        }
        return couleur;
    }

    public void setImageFond(int value) {
        int tailleImages = 50;
        ImageView imageView = new ImageView();
        imageView.setFitHeight(tailleImages);
        imageView.setFitWidth(tailleImages);
        Image image;
        switch (value) {
            case 0:
                image =  new Image("file:src/main/resources/pyramide/masque.png");
                break;
            case 1:
                image =  new Image("file:src/main/resources/pyramide/masqueDragon.png");
                break;
            case 2:
                image =  new Image("file:src/main/resources/pyramide/statuette.png");
                break;
            case 3 :
                image =  new Image("file:src/main/resources/pyramide/petitSymbole.png");
                break;
            default :
                image = new Image("file:src/main/resources/pyramide/empty.png");
        }
        imageView.setImage(image);
        getChildren().add(imageView);
    }

    public String getColor() {return color;}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}