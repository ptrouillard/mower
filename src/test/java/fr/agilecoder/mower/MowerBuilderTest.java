package fr.agilecoder.mower;

import org.testng.annotations.Test;

import static fr.agilecoder.mower.MowerBuilder.build;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 14/03/14 00:05
 */
public class MowerBuilderTest {

    @Test
    public void verify_basic_case_is_ok() {
        Mower mower = build("1 2 N");
        assertThat(mower.toString(), equalTo("1 2 N"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_missing_direction() {
        build("1 2");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_missing_y() {
        build("1 N");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_missing_position() {
        build("N");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_x_position() {
        build("A 2 N");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_y_position() {
        build("1 A N");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_monkey_can_use_it() {
        build("NAEioipodiqp dlkldkqmdk");
    }

}
