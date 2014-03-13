package fr.agilecoder.mower;

import fr.agilecoder.mower.utils.MyAssert;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:43
 */
public class Line {

    private final Mower mower;
    private final String moves;

    public Line(Mower mower, String moves) {
        this.mower = new MyAssert<Mower>().notNull(mower, "mower cannot be null");
        this.moves = new MyAssert<String>().notNull(moves, "moves cannot be null");
    }

    public void moveIt() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Mower getMower() {
        return mower;
    }
}
