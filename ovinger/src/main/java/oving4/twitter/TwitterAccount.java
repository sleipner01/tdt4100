package oving4.twitter;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {

    private String userName;
    private List<Tweet> tweets = new ArrayList<>();
    private int retweetCount;

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

    }
    
    public void unfollow(TwitterAccount account) {

    }

    public boolean isFollowing(TwitterAccount account) {

        return false;
    }

    public boolean isFollowedBy(TwitterAccount account) {
     
        return false;
    }

    public void tweet(String text) {

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
