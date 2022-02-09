package oving4.twitter;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {

    private String userName;
    private List<Tweet> tweets = new ArrayList<>();
    private List<TwitterAccount> following = new ArrayList<>();

    public TwitterAccount(String userName) throws IllegalArgumentException {
        if(userName.matches("[a-zA-Z0-9]")) 
            throw new IllegalArgumentException("The username isn't valid.");
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void follow(TwitterAccount account) throws IllegalArgumentException {
        if(account.equals(this))
            throw new IllegalArgumentException("You can't follow yourself.");

        if(this.following.contains(account))
            throw new IllegalArgumentException("You are already following this account.");
        this.following.add(account);

        if(!account.isFollowedBy(this)) account.follow(this);
    }
    
    public void unfollow(TwitterAccount account) throws IllegalArgumentException{
        if(this.following.contains(account))
            throw new IllegalArgumentException("You are not following this account");
        this.following.remove(account);
        // To avoid an error when the other object asks this to remove itself
        if(account.isFollowing(this)) account.unfollow(this);
    }

    public boolean isFollowing(TwitterAccount account) {
        return this.following.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return account.isFollowing(this);
    }

    public void tweet(String text) {
        this.tweets.add(new Tweet(this, text));
    }

    public void retweet(Tweet tweet) {
        this.tweets.add(new Tweet(this, tweet));
    }

    public Tweet getTweet(int i) throws IllegalArgumentException {
        if(!isValidTweetId(i))
            throw new IllegalArgumentException("Not valid id for tweet.");
        int id = i - 1;
        
        if(id > this.tweets.size() - 1)
            throw new IllegalArgumentException("The account hasn't tweeted " + i + " tweets.");

        return this.tweets.get(id);
    }

    private boolean isValidTweetId(int i) {
        if(i < 1) return false;
        return true;
    }

    public int getTweetCount() {
        return this.tweets.size();
    }

    public int getRetweetCount() {
        int count = 0;
        for (Tweet tweet: this.tweets) {
            if(tweet.getOriginalTweet().equals(null))
                count += tweet.getRetweetCount();
        }

        return count;
    }

}
