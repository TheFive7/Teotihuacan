package teotihuacan.teotihuacan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Player {
    public static List<Player> players = new ArrayList<>();
    static int nbPlayer;
    static Player currentPlayer;

    private int numero;
    private String color;
    private List<Ressource> ressources = new ArrayList<>();

    public Player(int numero, String color){
        setNumero(numero);
        setColor(color);
    }

    /**
     * Renvoie le joueur correspondant au numéro cherché.
     * @param nbPlayer : Numéro du joueur à chercher.
     * @return : Le joueur recherché.
     */
    public static Player searchPlayerByNumber(int nbPlayer){
        Player p = null;
        for (Player player : players){
            if (player.getNumero() == nbPlayer) p = player;
        }
        return p;
    }

    /**
     * Compte le nombre de ressources du joueur.
     * @param type : Type de la ressource à compter.
     * @return : Le nombre de ressources.
     */
    public int countRessource(String type){
        int compteur = 0;
        for (Ressource r : ressources){
            if (r.type.equals(type)) compteur++;
        }
        return compteur;
    }

    /**
     * Créé les joueurs en leur assignant une couleur et un numero.
     */
    public static void createPlayer(){
        players.clear();
        for (int i = 0; i < nbPlayer;i++) {
            if (i == nbPlayer - 4) players.add(new Player(0,"YELLOW"));
            if (i == nbPlayer - 3) players.add(new Player(0,"GREEN"));
            if (i == nbPlayer - 2) players.add(new Player(0,"BLUE"));
            if (i == nbPlayer - 1) players.add(new Player(0,"RED"));
        }
        createOrder();
        currentPlayer = players.get(0);
    }

    /**
     * Assigner le numero du joueur en fonction de son placement et du premier joueur choisi.
     */
    public static void createOrder(){
        Random random = new Random();
        int numFirstPlayer = random.nextInt(nbPlayer);
        for (int i = 0; i < nbPlayer; i++){
            players.get((numFirstPlayer + i) % nbPlayer).setNumero(i+1);
        }
    }

    /**
     * Attribue les ressources de départ à chaque joueur en fonction de son numero.
     */
    public static void attribuerRessourcesDepart(){
        for (Player player : players){
            switch (player.getNumero()) {
                case 1 -> {
                    player.ajouterRessource("cacao", 5);
                    player.ajouterRessource("bois", 1);
                    player.ajouterRessource("pierre", 2);
                    player.ajouterRessource("or", 4);
                }
                case 2 -> {
                    player.ajouterRessource("cacao", 5);
                    player.ajouterRessource("bois", 4);
                    player.ajouterRessource("pierre", 1);
                }
                case 3 -> {
                    player.ajouterRessource("cacao", 4);
                    player.ajouterRessource("bois", 3);
                    player.ajouterRessource("pierre", 4);
                }
                case 4 -> {
                    player.ajouterRessource("bois", 2);
                    player.ajouterRessource("or", 5);
                }
                default -> System.err.println("Numero de joueur inconnu.");
            }
        }
    }

    /**
     * Ajoute un nombre de la ressource voulue.
     * @param type : Type de la ressource à ajouter.
     * @param nbRessource : Nombre de ressources à ajouter.
     */
    public void ajouterRessource(String type, int nbRessource){
        switch (type){
            case "or":
                for (int i = 0; i < nbRessource; i++){getRessources().add(new Or());}
                break;
            case "pierre":
                for (int i = 0; i < nbRessource; i++){getRessources().add(new Pierre());}
                break;
            case "bois":
                for (int i = 0; i < nbRessource; i++){getRessources().add(new Bois());}
                break;
            case "cacao":
                for (int i = 0; i < nbRessource; i++){getRessources().add(new Cacao());}
                break;
            default :
                System.err.println("Type inconnu");
                break;
        }
    }

    /**
     * Enlève un nombre de la ressource voulue
     * @param type : Type de la ressource à enlever.
     * @param nbRessource : Nombre de ressources à enlever.
     */
    public void enleverRessources(String type, int nbRessource){
        int nbCurrentRessource = countRessource(type);
        if(nbCurrentRessource >= nbRessource){
            int nbFinalRessource = nbCurrentRessource - nbRessource;
            Iterator<Ressource> iterator = getRessources().iterator();
            while (iterator.hasNext()){
                Ressource ressource = iterator.next();
                if(nbCurrentRessource > nbFinalRessource) {
                    if (ressource.type.equals(type)) {
                        iterator.remove();
                        nbCurrentRessource = countRessource(type);
                    }
                }
            }
        }
    }


    public static void printPlayer(){
        for (Player player : players){
            player.print();
        }
        System.out.println();
    }

    public void print(){
        System.out.print(
                "Player " + getColor() +
                " : " + getNumero() +
                " -> Ressources >> "
        );
        for (Ressource ressource : ressources){
            System.out.print(ressource + " ");
        }
        System.out.println();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Ressource> getRessources() {
        return ressources;
    }
}
