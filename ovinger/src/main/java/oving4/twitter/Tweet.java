package oving4.twitter;

import java.util.Objects;

public class Tweet {

    private String text;
    private TwitterAccount account;
    private Tweet tweet;
    private int retweetCount;

    public Tweet(TwitterAccount account, String tweet) {
        if(!isValidTweet(tweet)) 
            throw new IllegalArgumentException("The tweet must be a string.");
        this.text = tweet;
        this.account = account;
    }

    private boolean isValidTweet(String tweet) {
        if(tweet.length() > 140) return false;
        return true;
    }

    public Tweet(TwitterAccount account, Tweet tweet) throws IllegalArgumentException {
        if(!isValidRetweet(account, tweet))
            throw new IllegalArgumentException("You cannot retweet your own tweet.");
        this.tweet = tweet;
    }

    public boolean isValidRetweet(TwitterAccount account, Tweet tweet) {
        for(int i = 0; i < account.getTweetCount(); i++)
            if(account.getTweet(i).equals(tweet))
                return false;
        return true;
    }

    public String getText() {
        if(Objects.isNull(this.tweet)) return this.text;
        return this.tweet.getText();
    }

    public TwitterAccount getOwner() {
        if(Objects.isNull(this.tweet)) return account;
        return this.tweet.getOwner();
    }

    public Tweet getOriginalTweet() {
        return tweet;
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }

    public void addRetweetCount() {
        this.retweetCount++;
    }

    
    
}
