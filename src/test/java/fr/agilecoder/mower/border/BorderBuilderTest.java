package fr.agilecoder.mower.border;

import fr.agilecoder.mower.border.Border;
import org.testng.annotations.Test;

import static fr.agilecoder.mower.border.BorderBuilder.build;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 14/03/14 00:05
 */
public class BorderBuilderTest {

    @Test
    public void verify_basic_case_is_ok() {
        Border border = build("1 2");
        assertThat(border.toString(), equalTo("1 2"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_missing_y() {
        build("1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_x_position() {
        build("A 2");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_y_position() {
        build("1 A");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_monkey_can_use_it() {
        build("NAEioipodiqp dlkldkqmdk");
    }

}
