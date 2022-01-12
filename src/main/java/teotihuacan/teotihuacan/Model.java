package teotihuacan.teotihuacan;

public class Model {

    public int nbBatiment = 11;
    public int playerJaune = 0;
    public int playerVert = 0;
    public int playerBleu = 0;
    public int playerRouge = 0;
    public int nbTour;
    public Boolean poserBatiment = true;
    public int nbOuvrierCase6 = 0;

    public int getNbBatiment() {
        return nbBatiment;
    }

    public void setNbBatiment(int nbBatiment) {
        this.nbBatiment = nbBatiment;
    }

    public void enleveBatiment(){
        this.nbBatiment--;
    }

    public int getPlayerJaune() {
        return playerJaune;
    }

    public void setPlayerJaune() {
        this.playerJaune -=25;
    }

    public int getPlayerVert() {
        return playerVert;
    }

    public void setPlayerVert() {
        this.playerVert -= 25;
    }

    public int getPlayerBleu() {
        return playerBleu;
    }

    public void setPlayerBleu() {
        this.playerBleu -= 25;
    }

    public int getPlayerRouge() {
        return playerRouge;
    }

    public void setPlayerRouge() {
        this.playerRouge -= 25;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public Boolean getPoserBatiment() {
        return poserBatiment;
    }

    public void setPoserBatiment(Boolean poserBatiment) {
        this.poserBatiment = poserBatiment;
    }

    public int getNbOuvrierCase6() {
        return nbOuvrierCase6;
    }

    public void addNbOuvrierCase6() {
        this.nbOuvrierCase6 += 1;
    }
}
