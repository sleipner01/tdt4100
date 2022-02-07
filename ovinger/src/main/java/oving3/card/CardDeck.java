package oving3.card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private ArrayList<Card> cardDeck = new ArrayList<>();

    private char[] suits = {'S', 'H', 'D', 'C'};

    public CardDeck(int amount) {
        addCards(amount);
    }

    private void addCards(int amount) throws IllegalArgumentException {
        // if(amount < 0 || amount > 13) throw new IllegalArgumentException("You cannot create a deck with " + amount + "cards");
        
        for (char suit : suits) {   
            for(int face = 1; face < (amount+1); face++) {
                Card card = new Card(suit, face);
                this.cardDeck.add(card);
            }
        }
    }

    // public void shufflePerfectly() {
    //     int deckSize = cardDeck.size();
    //     int halfIndex = deckSize/2;
    //     List<Card> firstHalf = cardDeck.subList(0, halfIndex);
    //     List<Card> secondHalf = cardDeck.subList(halfIndex, deckSize);

    //     for(int i = 0; i < (deckSize-2); i += 2) {
    //         cardDeck.set(i, firstHalf.get(i));
    //         cardDeck.set(i+1, secondHalf.get(i));
    //     }

    // }

    // public int getCardCount() {
    //     return this.cardDeck.size();
    // }

    // public Card getCard(int n) {
    //     return this.cardDeck.get(n);
    // }


    public static void main(String[] args) {
        CardDeck deck = new CardDeck(-1);
    }
    
}
