package oving5.twitter;

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
        this.account = account;
        tweet.addRetweetCount();
    }

    private boolean isValidRetweet(TwitterAccount account, Tweet tweet) {
        if(tweet.getOwner().equals(account))
            return false;
        return true;
    }

    public String getText() {
        if(Objects.isNull(this.tweet)) return this.text;
        return this.tweet.getText();
    }

    public TwitterAccount getOwner() {
        return this.account;
    }

    public Tweet getOriginalTweet() {
        if(Objects.isNull(this.tweet)) return null;
        return this.tweet;

        // if(this.getRetweetCount() == 0 && Objects.isNull(this.tweet)) 
        //     return null;

        // if(Objects.isNull(this.tweet)) return this;
        // return this.tweet.getOriginalTweet();
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }

    private void addRetweetCount() {
        if(Objects.isNull(this.tweet)) this.retweetCount++;
        else this.tweet.addRetweetCount();
    }
}
