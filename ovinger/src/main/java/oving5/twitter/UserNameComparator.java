package oving5.twitter;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        return account1.getUserName().compareTo(account2.getUserName());
    }
}
