package teotihuacan.teotihuacan;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import static teotihuacan.teotihuacan.Main.*;

public class pisteDesMortsController extends GameController{

    @FXML
    ImageView pionJaune;

    @FXML
    ImageView pionRouge;

    @FXML
    ImageView pionBleu;

    @FXML
    ImageView pionVert;

    public void actualiserPiste(){
        pionVert.setY(model.getPlayerVert());//ou Y
        System.out.println(model.getPlayerVert() + " vert");
        pionBleu.setY(model.getPlayerBleu());
        System.out.println(model.getPlayerBleu() + " bleu");
        pionJaune.setY(model.getPlayerJaune());
        System.out.println(model.getPlayerJaune() + " jaune");
        pionRouge.setY(model.getPlayerRouge());
        System.out.println(model.getPlayerRouge() + " rouge");
    }

    @Override
    public void quitter() {
        super.quitter();
    }
}
