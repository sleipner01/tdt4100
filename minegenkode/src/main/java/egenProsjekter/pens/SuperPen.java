package egenProsjekter.pens;

public class SuperPen extends Pen {
    
    public String color = "gold";
    public int point = 8;
    
    public void write(String text) {
        if(clicked == false) System.out.println("The pen isn't clicked...");
        else System.out.println("Richbitch " + text);
    }

}
