package oving5.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        return account2.getFollowerCount() - account1.getFollowerCount();
    }
    
}
