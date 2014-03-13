package fr.agilecoder.mower;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:38
 */
public class ShearingSequenceTest {

    @Test
    public void runMowers() {

        Border border = BorderBuilder.build("5 5");
        Mower mower1 = MowerBuilder.build("1 2 N");
        Mower mower2 = MowerBuilder.build("3 3 E");

        ShearingSequence shearing = new ShearingSequence(new MowerMove(mower1, "GAGAGAGAA"), new MowerMove(mower2, "AADAADADDA"));
        shearing.runShearing();

        // test all moves
        // expected 1 3 N
        assertThat(mower1.toString(), equalTo("1 3 N"));

        // expected 5 1 E
        assertThat(mower2.toString(), equalTo("5 1 E"));



    }
}
