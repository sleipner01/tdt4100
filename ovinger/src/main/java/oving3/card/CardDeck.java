package oving3.card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private List<Card> cardDeck = new ArrayList<>();

    private char[] suits = {'S', 'H', 'D', 'C'};

    public CardDeck(int amount) throws IllegalArgumentException {
        addCards(amount);
    }

    private void addCards(int amount) throws IllegalArgumentException {
        if(amount < 0 || amount > 13) throw new IllegalArgumentException("You cannot create a deck with " + amount + " cards");
        
        for (char suit : suits) {   
            for(int face = 1; face < (amount+1); face++) {
                Card card = new Card(suit, face);
                this.cardDeck.add(card);
            }
        }
    }

    public void shufflePerfectly() throws IllegalStateException {
        int deckSize = cardDeck.size();
    
        if(deckSize % 2 != 0) 
            throw new IllegalStateException("The deck is not even, and it is not possible to shuffle perfectly");

        int halfIndex = deckSize/2;
        List<Card> cardDeckCopy = new ArrayList<Card>();
        cardDeckCopy.addAll(cardDeck);
        List<Card> firstHalf = cardDeckCopy.subList(0, halfIndex);
        List<Card> secondHalf = cardDeckCopy.subList(halfIndex, deckSize);

        for(int i = 0; i < firstHalf.size(); i++) {
            cardDeck.set((i*2), firstHalf.get(i));
            cardDeck.set(((i*2)+1), secondHalf.get(i));
        }
    }

    public int getCardCount() {
        return this.cardDeck.size();
    }

    public Card getCard(int n) {
        return this.cardDeck.get(n);
    }


    public static void main(String[] args) {
        CardDeck deck = new CardDeck(2);
        deck.shufflePerfectly();
    }
    
}
