package fr.agilecoder.mower.mower;

import fr.agilecoder.mower.Direction;
import fr.agilecoder.mower.border.Border;

/**
 * The mower pojo
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 21:41
 */
public class Mower {

    private Direction direction;
    private int x;
    private int y;

    public Mower() {
        this.x=0;
        this.y=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y) + " " + direction.getSingleLetterCode();
    }
}
