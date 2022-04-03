package oving5;

import java.util.Iterator;

public interface CardContainer extends Iterable<Card> {
	/*
	 * @returns the number of cards within this CardContainer
	 */
	public int getCardCount();

	/*
	 * Get a card at the given index
	 * 
	 * @param i The index
	 * 
	 * @throws IllegalArgumentException when the index i is out of bounds
	 * 
	 * @returns the card at the provided index, starting at 0
	 */
	public Card getCard(int i) throws IllegalArgumentException;

	// Not part of the assignment to add this. This allows us to iterate over
	// any card container without explicitly calling new CardContainerIterator.
	@Override
	default Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
}
