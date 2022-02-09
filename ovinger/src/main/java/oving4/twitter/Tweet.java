package oving4.twitter;

public class Tweet {

    private String text;
    private TwitterAccount account;
    private Tweet tweet;
    private int retweetCount;

    public Tweet(TwitterAccount account, String tweet) {


        if(isValidTweet(tweet)) this.text = tweet;
    }

    private boolean isValidTweet(String tweet) {

        return true;
    }

    public Tweet(TwitterAccount account, Tweet tweet) {

    }

    public String getText() {
        return this.text;
    }

    public TwitterAccount getOwner() {

        return account;
    }

    public Tweet getOriginalTweet() {

        return tweet;
    }

    public int getRetweetCount() {

        return retweetCount;
    }

    
    
}
