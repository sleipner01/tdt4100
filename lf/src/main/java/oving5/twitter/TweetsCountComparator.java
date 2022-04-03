package oving5.twitter;

import java.util.Comparator;

/**
 * Sorterer {@link TwitterAccount kontoer} basert på antall tweets. Kontoen
 * med flest tweets vil havne først i listen.
 */
public class TweetsCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount a1, TwitterAccount a2) {
		return a2.getTweetCount() - a1.getTweetCount();
	}
}
