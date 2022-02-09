package oving4.twitter;

public class TwitterAccount {

    private String userName;

    public TwitterAccount(String username) {

        if(isValidUserName(username)) this.userName = username;
    }

    private boolean isValidUserName(String username) {


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
        if(!isValidTweetId(i))
            throw new IllegalArgumentException("Not valid id for tweet.");
        
        return tweet;
    }

    private boolean isValidTweetId(int i) {
        
        return true;
    }

}
