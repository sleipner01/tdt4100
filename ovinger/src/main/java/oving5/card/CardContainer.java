package oving5.card;

import java.util.Iterator;
import java.util.List;

public interface CardContainer extends Iterable<Card> {
    
    int getCardCount();

    Card getCard(int n);

    Iterator<Card> iterator();

}
