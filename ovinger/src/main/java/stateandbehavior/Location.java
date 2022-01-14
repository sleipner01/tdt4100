package stateandbehavior;

public class Location {
    
    int x;
    int y;

    public Location() {
        x = 0;
        y = 0;
    }

    public void up() {
        y--;
    }

    public void down() {
        y++;
    }

    public void left() {
        x--;
    }

    public void right() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Location location = new Location();
        System.out.println(location);
    }

    @Override
    public String toString() {
        return "[xPos: " + x + " | yPos: " + y + "]";
    }

}
