package oving5;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	private final String suitOrder;
	private final boolean aceIsHighest;

	public CardComparator(boolean aceIsHighest, char trumph) {
		this(aceIsHighest, trumph, "CDHS");
	}

	public CardComparator(boolean aceIsHighest, String suitOrder) {
		this(aceIsHighest, ' ', suitOrder);
	}

	// suitOrder is part of the voluntary extra task
	public CardComparator(boolean aceIsHighest, char trumph, String suitOrder) {
		this.aceIsHighest = aceIsHighest;

		if (trumph != ' ') {
			// Make sure the trumph is last, so that it is considered "best". This means
			// we don't need to store the trumph anywhere
			this.suitOrder = suitOrder.replace(String.valueOf(trumph), "") + trumph;
		} else {
			this.suitOrder = suitOrder;
		}
	}

	private int getFace(Card card) {
		if (card.getFace() == 1 && this.aceIsHighest) {
			return 14;
		}

		return 1;
	}

	@Override
	public int compare(Card card1, Card card2) {
		int suit1 = this.suitOrder.indexOf(card1.getSuit());
		int suit2 = this.suitOrder.indexOf(card2.getSuit());

		int diff = suit1 - suit2;

		// The suits are the same
		if (diff == 0) {
			int face1 = this.getFace(card1);
			int face2 = this.getFace(card2);
			diff = face1 - face2;
		}

		return diff;
	}
}
