package oving5.card;

import java.util.ArrayList;
import java.util.List;

public class CardHand {

    private List<Card> hand = new ArrayList<>();

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card play(int n) {
        Card card = this.hand.get(n);
        this.hand.remove(n);
        return card;
    }

    public int getCardCount() {
        return this.hand.size();
    }

    public Card getCard(int n) {
        return this.hand.get(n);
    }

    @Override
    public String toString() {
        return "CardHand [hand=" + this.hand + "]";
    }

}
