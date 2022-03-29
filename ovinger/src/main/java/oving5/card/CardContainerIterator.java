package oving5.card;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {

    private CardContainer cardContainer;
    private int position;

    public CardContainerIterator(CardContainer cardContainer) {
        this.cardContainer = cardContainer;
    }

    @Override
    public boolean hasNext() {
        if(position == cardContainer.getCardCount())
            return false;
        return true;
    }

    @Override
    public Card next() {
        if(!hasNext())
            return null;
        return cardContainer.getCard(position++);
    }
    
}
