package teotihuacan.teotihuacan;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Random;


/**
 * La pyramide est composée de 4 étages
 */
public class Pyramide extends Pane {
    Etage[] etagesPyramide = new Etage[3];

    public Pyramide(int nbEtage) {
        for (int noEtage=0; noEtage<nbEtage; noEtage++){
            getChildren().add(new Etage(noEtage));
        }
    }
    public void choixConfiguration(int nbJoueurs){
        switch (nbJoueurs){
            case 2 :
                System.out.println("plateau de 2 joueurs");
                break;
            case 3 :
                System.out.println("plateau de 3 joueurs");
                break;
            case 4 :
                System.out.println("plateau de 4 joueurs");
                // configuration pour 4 joueurs
                break;
        }

    }
}

class Etage extends GridPane {

    public Etage(int noEtage){
        Tuile[][] tuilesEtage = new Tuile[noEtage][noEtage];
        for (int x=0; x<noEtage; x++){
            for (int y=0; y<noEtage; y++){
                tuilesEtage[x][y] = new Tuile(false);
                add(tuilesEtage[x][y],x,y);
            }
        }

        configJoueurs(4);

        //Setting the padding
        //setPadding(new Insets(20, 20, 20, 20));
        setGridLinesVisible(true);

        setVgap(10);
        setHgap(10);

        //Setting the Grid alignment
        setAlignment(Pos.CENTER);
    }

    private void configJoueurs(int nbJoueurs) {
        switch (nbJoueurs){
            case 2 :
                System.out.println("configuration de 2 joueurs");
                break;
            case 3 :
                System.out.println("configuration de 3 joueurs");
                break;
            case 4 :
                add(new Tuile(true),0,1);
                add(new Tuile(true),0,2);
                add(new Tuile(true),1,0);
                add(new Tuile(true),2,0);
                add(new Tuile(true),1,3);
                add(new Tuile(true),2,3);
                add(new Tuile(true),3,1);
                add(new Tuile(true),3,2);
        }
    }
}


/**
 * Une tuile est constituée de 4 symboles
 */
class Tuile extends GridPane {

    public Tuile(boolean activated){

        ColumnConstraints column = new ColumnConstraints(40);
        getColumnConstraints().add(column);


        //Setting the Grid alignment
        setAlignment(Pos.CENTER);

        int tailleTuile = 2;
        Symbole[][] tuile = new Symbole[tailleTuile][tailleTuile];


        // random utilisé pour la valeur d'un symbole
        Random rand = new Random();
        // une tuile fait forcément une taille de 2x2
        for (int x = 0; x < tailleTuile; x++) {
            for (int y = 0; y < tailleTuile; y++) {
                // Si la tuile contient bien des symboles
                if (activated){
                    int n = rand.nextInt(4);
                    tuile[x][y] = new Symbole(n);
                // si la tuile ne contient pas de symboles
                } else {
                    tuile[x][y] = new Symbole(5);
                }
                add(tuile[x][y], x, y);
            }
        }
    }
}
