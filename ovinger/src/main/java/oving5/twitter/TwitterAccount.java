package oving5.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TwitterAccount {

    private String userName;
    private List<Tweet> tweets = new ArrayList<>();
    private List<TwitterAccount> following = new ArrayList<>();
    private List<TwitterAccount> followers = new ArrayList<>();


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
        account.addFollower(this);
    }

    public void unfollow(TwitterAccount account) throws IllegalArgumentException{
        if(!this.following.contains(account))
        throw new IllegalArgumentException("You are not following this account");
        
        this.following.remove(account);
        account.removeFollower(this);
    }
    
    protected void addFollower(TwitterAccount account) {
        this.followers.add(account);
    }
    
    protected void removeFollower(TwitterAccount account) {
        this.followers.remove(account);
    }

    public boolean isFollowing(TwitterAccount account) {
        return this.following.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return account.isFollowing(this);
    }

    public void tweet(String text) {
        this.tweets.add(0, new Tweet(this, text));
    }

    public void retweet(Tweet tweet) {
        if(Objects.isNull(tweet.getOriginalTweet())) 
            this.tweets.add(0, new Tweet(this, tweet));
        else
            this.tweets.add(0, new Tweet(this, tweet.getOriginalTweet()));
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

    public int getFollowerCount() {
        return this.followers.size();
    }

    public int getFollowingCount() {
        return this.following.size();
    }

    public int getRetweetCount() {
        int count = 0;
        for (Tweet tweet: this.tweets) {
            if(tweet.getOwner().equals(this))
                count += tweet.getRetweetCount();
        }

        return count;
    }

    public List<TwitterAccount> getFollowers() {
        return new ArrayList<>(followers);
    }

    public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
        Collections.sort(followers, comparator);
        return new ArrayList<>(followers);
    }

    @Override
    public String toString() {
        return "TwitterAccount [followers=" + followers.size() + ", following=" + following.size() + ", tweets=" + tweets.size()
                + ", userName=" + userName + "]";
    }

    public static void main(String[] args) {
        
        TwitterAccount sleipner = new TwitterAccount("Sleipner");
        TwitterAccount helligTonne = new TwitterAccount("Hellig Tønne");
        TwitterAccount tarald = new TwitterAccount("Tarald");
        TwitterAccount nissen = new TwitterAccount("Nissen");
        // System.out.println(sleipner.getUserName());

        sleipner.tweet("Har du noen gang tenkt på at jorda er flat?");
        sleipner.tweet("Jeg er jævlig kul");
        // helligTonne.retweet(sleipner.getTweet(1));


        // System.out.println(sleipner.getTweet(1).getText());
        // System.out.println(sleipner.getTweet(2).getText());
        // System.out.println(sleipner.getTweet(1).getOwner().getUserName());


        // System.out.println(helligTonne.getUserName());

        // System.out.println(helligTonne.getTweet(1).getText());
        // System.out.println(helligTonne.getTweet(1).getOwner().getUserName());
        // System.out.println(helligTonne.getTweet(1).getOriginalTweet().getOwner().getUserName());
        // System.out.println(helligTonne.getTweet(1).getOriginalTweet().getRetweetCount());



        helligTonne.follow(sleipner);
        tarald.follow(sleipner);
        nissen.follow(sleipner);

        System.out.println();
        System.out.println();
        System.out.println("________________________");
        System.out.println();

        System.out.println(sleipner);
        System.out.println(helligTonne);
        System.out.println(tarald);
        System.out.println(nissen);

        System.out.println();
        System.out.println("________________________");
        System.out.println();


        Comparator<TwitterAccount> comparator = new TwitterAccountComparator();
        List<TwitterAccount> unsorted = new ArrayList<>(sleipner.getFollowers());
        List<TwitterAccount> sorted = new ArrayList<>(sleipner.getFollowers(comparator));
        for(TwitterAccount account : unsorted)
            System.out.println(account.getUserName());
        System.out.println();
        for(TwitterAccount account : sorted)
            System.out.println(account.getUserName());



        System.out.println();
        System.out.println();
        System.out.println();

    }

}
