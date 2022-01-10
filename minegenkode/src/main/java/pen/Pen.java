package pen;

public class Pen {
    String type = "gel";
    String color = "blue";
    int point = 10;

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
