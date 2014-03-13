package fr.agilecoder.mower;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 21:42
 */
public enum Direction {
    EAST,
    WEST,
    NORTH,
    SOUTH;

    private Direction toLeft;
    private Direction toRight;

    public void setToLeft(Direction toLeft) {
        this.toLeft = toLeft;
    }

    public void setToRight(Direction toRight) {
        this.toRight = toRight;
    }

    public Direction getToLeft() {
        return toLeft;
    }

    public Direction getToRight() {
        return toRight;
    }

    // initialize toLeft, to Right directions
    static {
        Direction.NORTH.setToLeft(Direction.WEST);
        Direction.NORTH.setToRight(Direction.EAST);
        Direction.SOUTH.setToLeft(Direction.EAST);
        Direction.SOUTH.setToRight(Direction.WEST);
        Direction.WEST.setToLeft(Direction.SOUTH);
        Direction.WEST.setToRight(Direction.NORTH);
        Direction.EAST.setToLeft(Direction.NORTH);
        Direction.EAST.setToRight(Direction.SOUTH);
    }
}
