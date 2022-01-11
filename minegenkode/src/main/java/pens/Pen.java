package pens;

public class Pen {
    public String type = "gel";
    public String color = "blue";
    public int point = 10;

    static boolean clicked = false;

    public void click() {
        clicked = true;
    }

    public void unclick() {
        clicked = false;
    }

    public void write(String text) {
        if(clicked == false) System.out.println("The pen isn't clicked...");
        else System.out.println(text);
    }
}
