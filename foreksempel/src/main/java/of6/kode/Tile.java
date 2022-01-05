package of6.kode;

public class Tile {

    private char type = ' ';
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setAir() {
        type = ' ';
    }

    public void setSnake() {
        type = 'o';
    }

    public void setGround() {
        type = '#';
    }

    public void setFruit() {
        type = 'f';
    }

    public void setGoal() {
        type = '@';
    }

    public boolean isAir() {
        return type == ' ';
    }

    public boolean isSnake() {
        return type == 'o';
    }

    public boolean isGround() {
        return type == '#';
    }

    public boolean isFruit() {
        return type == 'f';
    }

    public boolean isGoal() {
        return type == '@';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasCollision() {
        return isGround() || isSnake();
    }

    @Override
    public String toString() {
        return Character.toString(type);
    }
}
