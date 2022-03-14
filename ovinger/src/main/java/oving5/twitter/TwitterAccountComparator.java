package oving5.twitter;

import java.util.Comparator;

public class TwitterAccountComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        Comparator<TwitterAccount> followersComparator = new FollowersCountComparator();
        int firstTry = followersComparator.compare(account1, account2);
        if(firstTry != 0) return firstTry;

        Comparator<TwitterAccount> tweetsComparator = new TweetsCountComparator();
        int secondTry = tweetsComparator.compare(account1, account2);
        if(secondTry != 0) return secondTry;

        Comparator<TwitterAccount> userNameComparator = new UserNameComparator();
        int thirdTry = userNameComparator.compare(account1, account2);
        return thirdTry;
    }
    
}
