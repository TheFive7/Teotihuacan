package teotihuacan.teotihuacan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public static List<Player> players = new ArrayList<>();
    public static int nbPlayer;

    private int numero;
    private String color;

    public Player(int numero, String color){
        this.numero = numero;
        this.color = color;
    }

    public static void createPlayer(){
        players.clear();
        for (int i = 0; i < nbPlayer;i++) {
            if (i == nbPlayer - 4) players.add(new Player(0,"RED"));
            if (i == nbPlayer - 3) players.add(new Player(0,"BLUE"));
            if (i == nbPlayer - 2) players.add(new Player(0,"GREEN"));
            if (i == nbPlayer - 1) players.add(new Player(0,"YELLOW"));
        }
        createOrder();
        print();
    }

    /**
     * Assigner le numero du joueur en fonction de son placement et du premier joueur choisi.
     */
    public static void createOrder(){
        Random random = new Random();
        int numFirstPlayer = random.nextInt(nbPlayer);

        // 2 Joueurs
        if (nbPlayer == 2){
            if (numFirstPlayer == 0){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
            } else {
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer - 1).setNumero(2);
            }
        // 3 Joueurs
        } else if (nbPlayer == 3) {
            if (numFirstPlayer == 0){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
                players.get(numFirstPlayer + 2).setNumero(3);
            } else if (numFirstPlayer == 1){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
                players.get(numFirstPlayer - 1).setNumero(3);
            } else {
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer - 1).setNumero(3);
                players.get(numFirstPlayer - 2).setNumero(2);
            }
        // 4 joueurs
        } else {
            if (numFirstPlayer == 0){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
                players.get(numFirstPlayer + 2).setNumero(3);
                players.get(numFirstPlayer + 3).setNumero(4);
            } else if (numFirstPlayer == 1){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
                players.get(numFirstPlayer + 2).setNumero(3);
                players.get(numFirstPlayer - 1).setNumero(4);
            } else if (numFirstPlayer == 2){
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer + 1).setNumero(2);
                players.get(numFirstPlayer - 2).setNumero(3);
                players.get(numFirstPlayer - 1).setNumero(4);
            } else {
                players.get(numFirstPlayer).setNumero(1);
                players.get(numFirstPlayer - 1).setNumero(4);
                players.get(numFirstPlayer - 2).setNumero(3);
                players.get(numFirstPlayer - 3).setNumero(2);
            }
        }
    }

    public static void print(){
        for (Player player : players){
            System.out.println("Player " + player.getColor() + " : " + player.getNumero());
        }
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
}
