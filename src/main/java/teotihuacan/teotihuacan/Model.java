package teotihuacan.teotihuacan;

public class Model {

    public int nbBatiment = 11;
    public int montePremierPlayer = 0;

    public int getNbBatiment() {
        return nbBatiment;
    }

    public void setNbBatiment(int nbBatiment) {
        this.nbBatiment = nbBatiment;
    }

    public void enleveBatiment(){
        this.nbBatiment--;
    }

    public int getMontePremierPlayer() {
        return montePremierPlayer;
    }

    public void setMontePremierPlayer() {
        this.montePremierPlayer = montePremierPlayer+10;
    }
}
