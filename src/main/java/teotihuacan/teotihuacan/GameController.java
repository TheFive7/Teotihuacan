package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static teotihuacan.teotihuacan.Main.*;
import static teotihuacan.teotihuacan.Player.*;

public class GameController {
    @FXML
    Label labelCacaoNumber;
    @FXML
    Label labelGoldNumber;
    @FXML
    Label labelWoodNumber;
    @FXML
    Label labelRockNumber;
    @FXML
    Label labelCurrentPlayer;
    @FXML
    Label numEtagePyramide;
    @FXML
    Label nbTours;
    @FXML
    GridPane grilleEtage;
    @FXML
    HBox listeBatiment;
    @FXML
    ImageView pionJaune;
    @FXML
    VBox pisteJaune;

    int num = 1;
    int numEtage = 4;
    Pyramide pyramide = new Pyramide(4);


    public void nextPlayer(){
        if (num == 4) {num = 1;} else {num ++;}
        currentPlayer = searchPlayerByNumber(num);
        afficherRessources();
        if (num == 1){
            int entier = Integer.parseInt(nbTours.getText());
            entier ++;
            nbTours.setText(String.valueOf(entier));
        }

    }

    public void actualiserFenetre(){
        if(listeBatiment != null){
            int nbBat = listeBatiment.getChildren().size() - model.getNbBatiment();
            if(nbBat == 1){
                listeBatiment.getChildren().remove(0);
            }
        }
        if(pionJaune != null){
            System.out.println("pas nul");
            pionJaune.setY(model.getPlayerJaune());
        }
        if(pisteJaune != null){
            System.out.println("piste jaune pas null");
        }
        afficherRessources();

    }

    public void prevPlayer(){
        if (num == 1) {num = 4;} else {num --;}
        currentPlayer = searchPlayerByNumber(num);
        afficherRessources();
    }

    public void afficherRessources(){

        labelCurrentPlayer.setText("Joueur " + num);
        labelCacaoNumber.setText("x " + currentPlayer.countRessource("cacao"));
        labelGoldNumber.setText("x " + currentPlayer.countRessource("or"));
        labelWoodNumber.setText("x " + currentPlayer.countRessource("bois"));
        labelRockNumber.setText("x " + currentPlayer.countRessource("pierre"));

    }

    public void pyramideView() {
        primaryStage.setScene(Main.pyramide);
    }

    //Affiche la carte 6
    public void carte6View() {
        primaryStage.setScene(carte6);
    }

    public void carte4View(){
        primaryStage.setScene(carte4);
    }

    public void carte5View(){
        primaryStage.setScene(carte5);
    }

    public void carte8View() { primaryStage.setScene(carte8); }

    public void carte1View(){
        primaryStage.setScene(carte1);
    }


    //Affiche la carte 3
    public void cartecacaoView() { primaryStage.setScene(cartecacao);}

    public void pisteDesMortsView() { primaryStage.setScene(pisteDesMorts);}


    //affiche l'étage suivant
    public void nextStage(){
        if (numEtage == 1) {numEtage = 4;} else {numEtage --;}
        afficherEtage();
    }

    //affiche l'étage précédent
    public void prevStage(){
        if (numEtage == 4) {numEtage = 1;} else {numEtage ++;}
        afficherEtage();
    }

    //rempli la grille représentant l'étage en fonction de l'étage choisis
    public void afficherEtage(){
        // Améliorer le rendu visuel en positionnant la pyramide au milieu
        grilleEtage.setAlignment(Pos.CENTER);
        grilleEtage.setHgap(10); grilleEtage.setVgap(10);

        if(grilleEtage != null) {
            grilleEtage.getChildren().clear(); //vide la grille avant d'afficher celle demandée pour ne pas avoir des éléments dupliqués
            numEtagePyramide.setText("Etage " + numEtage); //actualise le label indiquant le numéro de l'étage actuel
            Etage etage = pyramide.etages.get(numEtage-1); //récupère l'étage choisis dans la pyramide
            Tuile[][] tuilesEtage = etage.tuilesEtage; // récupère la liste de tuiles de l'étage
            for (int x=0; x<numEtage; x++){
                for (int y=0; y<numEtage; y++){
                    grilleEtage.add(tuilesEtage[x][y],x,y); //remplis la grille avec la liste de tuiles
                }
            }
        }
    }




    /**
     * permet de revenir au plateau principal
     */
    public void quitter(){
        primaryStage.setScene(Main.gameView);

    }

}