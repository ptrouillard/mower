package fr.agilecoder.mower;

import fr.agilecoder.mower.mower.MowerDriver;
import fr.agilecoder.mower.utils.MyAssert;

import java.util.regex.Pattern;

/**
 * Describes a shearing sequence : a shearing sequence is a sequence of moves applied by a driver to a mower.
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:43
 */
public class ShearingSequence {

    private final String moves;
    private final MowerDriver driver;

    public ShearingSequence(MowerDriver driver, String moves) {
        this.driver = new MyAssert<MowerDriver>().notNull(driver, "driver cannot be null");
        this.moves = new MyAssert<String>().notNull(moves, "moves cannot be null");
        checkMoves(this.moves);
    }

    private void checkMoves(String moves) {
        Pattern pattern = Pattern.compile("(A*G*D*)+");
        if (!pattern.matcher(moves).matches())
            throw new IllegalArgumentException("moves are not using the expected sequence of characters : only A,G or D are allowed.");
    }

    public void run() {
        for (int index=0; index<moves.length();index++) {
            char move = moves.charAt(index);
            switch( move) {
                case 'A' : this.driver.goAhead(); break;
                case 'D' : this.driver.turnRight(); break;
                case 'G' : this.driver.turnLeft(); break;
            }
        }
    }

    public MowerDriver getDriver() {
        return this.driver;
    }
}
