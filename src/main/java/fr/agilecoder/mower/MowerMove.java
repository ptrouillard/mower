package fr.agilecoder.mower;

import fr.agilecoder.mower.utils.MyAssert;

import java.util.regex.Pattern;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:43
 */
public class MowerMove {

    private final Mower mower;
    private final String moves;

    public MowerMove(Mower mower, String moves) {
        this.mower = new MyAssert<Mower>().notNull(mower, "mower cannot be null");
        this.moves = new MyAssert<String>().notNull(moves, "moves cannot be null");
        checkMoves(this.moves);
    }

    private void checkMoves(String moves) {
        Pattern pattern = Pattern.compile("(A*G*D*)+");
        if (!pattern.matcher(moves).matches())
            throw new IllegalArgumentException("moves are not using the expected sequence of characters : only A,G or D are allowed.");
    }

    public void moveIt() {
        for (int index=0; index<moves.length();index++) {
            char move = moves.charAt(index);
            if (move == 'A')
                this.mower.goAhead();
            if (move == 'D')
                this.mower.turnRight();
            if (move == 'G')
                this.mower.turnLeft();
        }
    }

    public Mower getMower() {
        return mower;
    }
}
