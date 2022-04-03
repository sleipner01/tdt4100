package oving5.twitter;

import java.util.Comparator;

/**
 * Sorterer {@link TwitterAccount kontoer} basert på brukernavn i leksikalsk
 * rekkefølge.
 */
public class UserNameComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount a1, TwitterAccount a2) {
		return a1.getUserName().compareTo(a2.getUserName());
	}
}
