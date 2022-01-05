package teotihuacan.teotihuacan;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;


/**
 * La pyramide est composée de 4 étages
 */
public class Pyramide {
    ArrayList<Etage> etages = new ArrayList<>();

    public Pyramide(int nbEtage) {
        for (int noEtage=1; noEtage<nbEtage+1; noEtage++){
            etages.add(new Etage(noEtage));
        }
    }
//    public void choixConfiguration(int nbJoueurs){
//        switch (nbJoueurs){
//            case 2 :
//                System.out.println("plateau de 2 joueurs");
//                break;
//            case 3 :
//                System.out.println("plateau de 3 joueurs");
//                break;
//            case 4 :
//                System.out.println("plateau de 4 joueurs");
//                // configuration pour 4 joueurs
//                break;
//        }
//
//    }
}

class Etage extends GridPane {

    Tuile[][] tuilesEtage;
    public Etage(int noEtage){
        tuilesEtage = new Tuile[noEtage][noEtage];

        if (noEtage == 4) {
            tuilesEtage[0][1] = new Tuile(true);
            tuilesEtage[0][2] = new Tuile(true);
            tuilesEtage[1][0] = new Tuile(true);
            tuilesEtage[2][0] = new Tuile(true);
            tuilesEtage[1][3] = new Tuile(true);
            tuilesEtage[2][3] = new Tuile(true);
            tuilesEtage[3][1] = new Tuile(true);
            tuilesEtage[3][2] = new Tuile(true);

            for (int x=0; x<noEtage; x++){
                for (int y=0; y<noEtage; y++){
                    if(tuilesEtage[x][y] == null){
                        tuilesEtage[x][y] = new Tuile(false);
                        add(tuilesEtage[x][y],x,y);
                    }
                }
            }
        }
        else {
            for (int x=0; x<noEtage; x++){
                for (int y=0; y<noEtage; y++){
                    tuilesEtage[x][y] = new Tuile(false);
                    add(tuilesEtage[x][y],x,y);
                }
            }
        }

        //Setting the padding
        //setPadding(new Insets(20, 20, 20, 20));
        setGridLinesVisible(true);

        setVgap(10);
        setHgap(10);

        //Setting the Grid alignment
        setAlignment(Pos.CENTER);
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