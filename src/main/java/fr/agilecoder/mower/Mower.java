package fr.agilecoder.mower;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 21:41
 */
public class Mower {

    private Direction direction;
    private int x;
    private int y;
    private Border border;

    public Mower() {
        this.x=0;
        this.y=0;
    }

    public Mower(Border border) {
        this.x=0;
        this.y=0;
        this.border = border;
    }

    public Mower withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public void goAhead() {
        switch(direction) {
            case NORTH:
                this.y+=1;
                break;
            case SOUTH:
                this.y-=1;
                break;
            case EAST:
                this.x+=1;
                break;
            case WEST:
                this.x-=1;
                break;
        }
        checkBounds();
    }

    private void checkBounds() {
        if (this.x < 0)
            this.x = 0;
        if (this.y < 0)
            this.y = 0;
        if (border != null) {
            if (this.x > border.getX()) {
                this.x = border.getX();
            }
            if (this.y > border.getY()) {
                this.y = border.getY();
            }
        }
    }

    public Mower withPositionX(int x) {
        this.x = x;
        return this;
    }

    public Mower withPositionY(int y) {
        this.y = y;
        return this;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void turnRight() {
        this.direction = this.direction.getToRight();
    }

    public void turnLeft() {
        this.direction = this.direction.getToLeft();
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y) + " " + direction.getSingleLetterCode();
    }
}
