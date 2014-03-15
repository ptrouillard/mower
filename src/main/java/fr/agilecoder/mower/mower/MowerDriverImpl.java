package fr.agilecoder.mower.mower;

import fr.agilecoder.mower.border.Border;

/**
 * Control the mower position : the driver.
 * User: ptrouillard@gmail.com
 * Date: 15/03/14 15:47
 */
public class MowerDriverImpl implements MowerDriver {

    private final Border border;
    private final Mower mower;

    public MowerDriverImpl(Border border, Mower mower) {
        this.border = border;
        this.mower = mower;
    }

    @Override
    public void goAhead() {
        switch(mower.getDirection()) {
            case NORTH:
                mower.setY(mower.getY()+1);
                break;
            case SOUTH:
                mower.setY(mower.getY()-1);
                break;
            case EAST:
                mower.setX(mower.getX()+1);
                break;
            case WEST:
                mower.setX(mower.getX() - 1);
                break;
        }
        checkBounds();
    }

    private void checkBounds() {
        if (mower.getX() < 0)
            mower.setX(0);
        if (mower.getY() < 0)
            mower.setY(0);
        if (border != null) {
            if (mower.getX() > border.getX()) {
                mower.setX(border.getX());
            }
            if (mower.getY() > border.getY()) {
                mower.setY(border.getY());
            }
        }
    }

    @Override
    public void turnRight() {
        mower.setDirection(mower.getDirection().getToRight());
    }

    @Override
    public void turnLeft() {
        mower.setDirection(mower.getDirection().getToLeft());
    }

    @Override
    public Mower getMower() {
        return mower;
    }

}
