package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardHandTest {
	CardHand hand;
	Card s1;
	Card c2;
	List<Card> expected;

	@BeforeEach
	public void setUp() {
		hand = new CardHand(2);
		s1 = new Card('S', 1);
		c2 = new Card('C', 2);
		expected = new LinkedList<Card>(Arrays.asList(s1, c2));
	}

	@Test
	@DisplayName("Test cardCount")
	public void testCardCount() {
		assertTrue(hand instanceof CardContainerImpl);
		assertEquals(0, hand.getCardCount(), "CardCount skulle vært 0 i begynnelsen");
		hand.addCard(new Card('S', 1));
		hand.addCard(new Card('S', 2));
		assertEquals(2, hand.getCardCount(), "CardCount skulle vært 2 i begynnelsen");
	}

	@Test
	@DisplayName("Test at cardDeckImpl implementerer cardContainer")
	public void testCardContainer() {
		hand.addCard(new Card('S', 1));
		hand.addCard(new Card('C', 2));
		testCards(hand, expected);
	}

	@Test
	@DisplayName("Test at cardDeckImpl implementerer iterable")
	public void testDeckIterator() {
		hand.addCard(new Card('S', 1));
		hand.addCard(new Card('C', 2));
		testCards(hand.iterator(), expected.iterator());
	}

	private void testCards(CardContainer it, List<Card> expected) {
		assertEquals(expected.size(), it.getCardCount());
		for (int i = 0; i < expected.size(); i++) {
			Card expectedCard = expected.get(i);
			Card actualCard = it.getCard(i);
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(),
					String.format("Kort nummer %d skulle vært %s men var %s ", i + 1, expectedCard, actualCard));
			assertEquals(expectedCard.getFace(), actualCard.getFace(),
					String.format("Kort nummer %d skulle vært %s men var %s ", i + 1, expectedCard, actualCard));
			i++;
		}
	}

	private void testCards(Iterator<Card> actual, Iterator<Card> expected) {
		while (expected.hasNext()) {
			assertTrue(actual.hasNext());
			Card expectedCard = expected.next();
			Card actualCard = actual.next();
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(),
					String.format("Kortet skulle vært %s men var %s ", expectedCard, actualCard));
			assertEquals(expectedCard.getFace(), actualCard.getFace(),
					String.format("Kortet skulle vært %s men var %s", expectedCard, actualCard));
		}
	}

}
