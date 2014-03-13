package fr.agilecoder.mower.utils;

import fr.agilecoder.mower.utils.MyAssert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:59
 */
public class MyAssertTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_assert_ko() {
        new MyAssert<String>().notNull(null, "not null required");
    }

    @Test
    public void verify_assert_ok() {
        assertThat(new MyAssert<String>().notNull("not null", "not null required"), equalTo("not null"));
    }
}
