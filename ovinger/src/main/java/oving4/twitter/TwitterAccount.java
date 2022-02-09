package oving4.twitter;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {

    private String userName;
    private List<Tweet> tweets = new ArrayList<>();
    private int retweetCount;
    private List<TwitterAccount> following = new ArrayList<>();

    public TwitterAccount(String userName) {
        if(!isValidUserName(userName)) 
            throw new IllegalArgumentException("The username isn't valid.");
        this.userName = userName;
    }

    private boolean isValidUserName(String userName) {

        if (!userName.matches("[a-zA-Z0-9]")) 
            throw new IllegalArgumentException("The username isn't valid");


        return true;
    }

    public String getUserName() {
        return this.userName;
    }

    public void follow(TwitterAccount account) {
        following.add(account);
        account.follow(this);
    }
    
    public void unfollow(TwitterAccount account) {
        following.remove(account);
        account.unfollow(this);
    }

    public boolean isFollowing(TwitterAccount account) {
        return following.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return account.isFollowing(this);
    }

    public void tweet(String text) {
        tweets.add(new Tweet(this, text));
    }

    public void retweet(Tweet tweet) {
        
    }

    public Tweet getTweet(int i) {
        int id = i - 1;
        if(!isValidTweetId(id))
            throw new IllegalArgumentException("Not valid id for tweet.");
        
        Tweet tweet;
        
        try { tweet = this.tweets.get(id); }
        catch (Exception e) {
            throw new IllegalArgumentException("We couldn't find the tweet you were looking for with index:" + i);
        }

        return tweet;
    }

    private boolean isValidTweetId(int i) {
        
        return true;
    }

    public int getTweetCount() {
        return this.tweets.size();
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }

}
