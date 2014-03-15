package fr.agilecoder.mower;

import fr.agilecoder.mower.border.Border;
import fr.agilecoder.mower.border.BorderBuilder;
import fr.agilecoder.mower.mower.Mower;
import fr.agilecoder.mower.mower.MowerBuilder;
import fr.agilecoder.mower.mower.MowerDriverImpl;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:38
 */
public class ShearingSequencesTest {

    @Test
    public void runMowers() {

        // define the border of the lawn
        Border border = BorderBuilder.build("5 5");

        // create the mowers in their initial positions
        Mower mower1 = MowerBuilder.build("1 2 N");
        Mower mower2 = MowerBuilder.build("3 3 E");

        // create drivers for mowers.
        MowerDriverImpl driver1 = new MowerDriverImpl(border, mower1);
        MowerDriverImpl driver2 = new MowerDriverImpl(border, mower2);

        // define the shearing sequences (drivers + list of orders)
        ShearingSequences shearing = new ShearingSequences(
                new ShearingSequence(driver1, "GAGAGAGAA"),
                new ShearingSequence(driver2, "AADAADADDA"));

        // run the sequence
        shearing.runShearing();

        // test all moves
        // expected 1 3 N
        assertThat(mower1.toString(), equalTo("1 3 N"));

        // expected 5 1 E
        assertThat(mower2.toString(), equalTo("5 1 E"));
    }
}
