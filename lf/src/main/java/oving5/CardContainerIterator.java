package oving5;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {

	private CardContainer container;
	private int pos;

	public CardContainerIterator(CardContainer container) {
		this.container = container;
		this.pos = 0;
	}

	@Override
	public boolean hasNext() {
		return this.pos < this.container.getCardCount();
	}

	@Override
	public Card next() {
		// Longer version:
		Card card = this.container.getCard(this.pos);
		this.pos += 1;
		return card;
		// Short version, using that "this.pos++" returns the value before incrementing by
		// 1. "++this.pos" will return the value after incrementing.
		// return container.getCard(this.pos++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("CardContainerIterator does not not support remove");
	}
}
