package oving5.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
public class CardDeck implements CardContainer {

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

    public void deal(CardHand cardHand, int n) {
        int deckSize = cardDeck.size();
        for(int i = deckSize-1; i > (deckSize-n-1); i--) {
            cardHand.addCard(cardDeck.get(i));
            cardDeck.remove(i);
        }
    }

    public boolean hasCard(Predicate<Card> predicate) {
        return this.cardDeck.stream().anyMatch(predicate);
    }

    public int getCardCount(Predicate<Card> predicate) {
        return (int)this.cardDeck.stream().filter(predicate).count();
    }

    public List<Card> getCards(Predicate<Card> predicate) {
        return this.cardDeck.stream().filter(predicate).toList();
    }
    
    @Override
    public Iterator<Card> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(13);
        // CardHand magnus = new CardHand();
        // deck.shufflePerfectly();
        // deck.deal(magnus, 2);

        // System.out.println(deck.hasCard(c -> c.getSuit() == 'S' && c.getFace() == 12));
        // System.out.println(deck.getCardCount(c -> c.getSuit() == 'H'));
        // System.out.println(deck.getCards(c -> c.getFace() == 1));

        Iterator<Card> iterator = new CardContainerIterator(deck);
        System.out.println(deck);
        System.out.println();

        while(iterator.hasNext()) {
            System.out.println(iterator.hasNext() + " " + iterator.next());
        }
        System.out.println(iterator.hasNext());
    }

    
}
