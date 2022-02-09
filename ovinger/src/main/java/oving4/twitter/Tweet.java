package oving4.twitter;

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

        return true;
    }

    public Tweet(TwitterAccount account, Tweet tweet) {
        this.tweet = tweet;
    }

    public String getText() {
        if(tweet.equals(null)) return this.text;
        return tweet.getText();
    }

    public TwitterAccount getOwner() {
        if(tweet.equals(null)) return account;
        return tweet.getOwner();
    }

    public Tweet getOriginalTweet() {
        return tweet;
    }

    public int getRetweetCount() {

        return retweetCount;
    }

    
    
}
