package oving3.card;

import java.util.Arrays;
import java.util.List;

public class Card {
    
    private char suit;
    private int face;

    private char spades = 'S';
    private char hearts = 'H';
    private char diamonds = 'D';
    private char clubs = 'C';    

    private List<Character> validSuits = Arrays.asList(spades, hearts, diamonds, clubs);
    private List<Integer> validFaces = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
    
    public Card(char suit, int face) throws IllegalArgumentException {
        if(isValidSuit(suit)) this.suit = suit;
        if(isValidFace(face)) this.face = face;
    }

    private boolean isValidSuit(char suit) throws IllegalArgumentException{
        if(!validSuits.contains(suit))
            throw new IllegalArgumentException("This suit is not valid");

        return true;
    }

    private boolean isValidFace(int face) throws IllegalArgumentException{
        if(!validFaces.contains(face))
            throw new IllegalArgumentException("This is not a valid face");

        return true;
    }

    public char getSuit() {
        return this.suit;
    }

    public int getFace() {
        return this.face;
    }

    @Override
    public String toString() {
        return "" + suit + face;
    }
}
