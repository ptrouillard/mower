package fr.agilecoder.mower;

import org.testng.annotations.Test;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:44
 */
public class LineTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_mower_is_null() {
        new Line(null, "GA");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_moves_are_null() {
        new Line(new Mower(), null);
    }
}
