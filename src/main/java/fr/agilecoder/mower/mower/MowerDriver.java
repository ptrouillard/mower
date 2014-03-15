package fr.agilecoder.mower.mower;

/**
 * User: ptrouillard@gmail.com
 * Date: 15/03/14 15:30
 */
public interface MowerDriver {
    void goAhead();
    void turnRight();
    void turnLeft();
    Mower getMower();
}
