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
        }

        //Setting the padding
        setGridLinesVisible(true);

        setVgap(10);
        setHgap(10);

        //Setting the Grid alignment
        setAlignment(Pos.CENTER);
    }

    public void placerTuile(Pyramide pyramide, int x, int y, Player currentPlayer){
        Etage etageVerif = pyramide.etages.get(tuilesEtage.length-1);
        if(pyramide.etages.get(tuilesEtage.length-1).tuilesEtage.length !=4 ) etageVerif = pyramide.etages.get(tuilesEtage.length);
        if(tuilesEtage.length==4){
            tuilesEtage[x][y] = currentPlayer.getTuile();
            currentPlayer.setTuile(null);
        }
        else{
            System.out.println("looking at the stage -> " + etageVerif.tuilesEtage.length);
            if (verifPosition(etageVerif, x, y)) {
                tuilesEtage[x][y] = currentPlayer.getTuile();
                currentPlayer.setTuile(null);
            }
            else System.out.println("There are not 4 stones under this position. You can't place it here");
        }
    }

    public boolean verifPosition(Etage etage, int x, int y){
        Tuile tuile1 = etage.tuilesEtage[x][y];
        Tuile tuile2 = etage.tuilesEtage[x+1][y];
        Tuile tuile3 = etage.tuilesEtage[x][y+1];
        Tuile tuile4 = etage.tuilesEtage[x+1][y+1];
        return (tuile1!=null && tuile2!=null && tuile3!=null && tuile4!=null);
    }
}

/**
 * Une tuile est constituée de 4 symboles
 */
class Tuile extends GridPane {

    Symbole[][] symboles;
    boolean activated;

    public Tuile(boolean activated){

        this.activated = activated;

        ColumnConstraints column = new ColumnConstraints(40);
        getColumnConstraints().add(column);

        //Setting the Grid alignment
        setAlignment(Pos.CENTER);

        int tailleTuile = 2;
        symboles = new Symbole[tailleTuile][tailleTuile];

        // random utilisé pour la valeur d'un symbole
        Random rand = new Random();
        // une tuile fait forcément une taille de 2x2
        for (int x = 0; x < tailleTuile; x++) {
            for (int y = 0; y < tailleTuile; y++) {
                // Si la tuile contient bien des symboles
                if (activated){
                    int n = rand.nextInt(4);
                    symboles[x][y] = new Symbole(n);
                    // si la tuile ne contient pas de symboles
                } else {
                    symboles[x][y] = new Symbole(5);
                }
                add(symboles[x][y], x, y);
            }
        }
    }

    public boolean isActivated() {
        return activated;
    }
}