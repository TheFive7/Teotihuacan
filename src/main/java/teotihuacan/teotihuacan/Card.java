package teotihuacan.teotihuacan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Classe Carte **/
public class Card {
    private int value;

    public Card(int i){
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/** Classe Deck **/
class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(int nbCards) {
        createNewDeck(nbCards);
    }

    protected void createNewDeck(int nbCards) {
        for (int i = 0; i < nbCards; i++) cards.add(new Card(i));
    }

    protected void shuffle(){
        Collections.shuffle(cards);
    }

    protected void print() {
        for (Card carte : cards) System.out.print(carte.getValue() + " ");
        System.out.println();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
