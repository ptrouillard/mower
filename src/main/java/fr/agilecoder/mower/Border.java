package fr.agilecoder.mower;

/**
 * Border of the lawn
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:24
 */
public class Border {

    private int x;
    private int y;

    public Border(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}
