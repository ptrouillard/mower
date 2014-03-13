package fr.agilecoder.mower;

import org.testng.annotations.Test;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:25
 */
public class BorderTest {

    @Test
    public void verify_border_over_x_limit() {
        new Border(0, 5);
    }
    @Test
    public void verify_border_over_y_limit() {
        new Border(5, 0);
    }
    @Test
    public void verify_border_ok() {
        new Border(5, 5);
    }
}
