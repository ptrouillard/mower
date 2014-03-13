package fr.agilecoder.mower;

import javax.validation.constraints.Min;

/**
 * Border of the lawn
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:24
 */
public class Border {

    @Min(1)
    private int x;
    @Min(1)
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
}
