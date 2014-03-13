package fr.agilecoder.mower;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:38
 */
public class ShearingTest {

    @Test
    public void runMowers() {

        // prepare mowers
        Mower mower1 = new Mower().withDirection(Direction.NORTH).withPositionX(1).withPositionY(2);
        Mower mower2 = new Mower().withDirection(Direction.EAST).withPositionX(3).withPositionY(3);

        // prepare the field
        Border border = new Border(5,5);

        // prepare command lines
        Line[] lines = new Line[] {
            new Line(mower1, "GAGAGAGAA"),
            new Line(mower2, "AADAADADDA"),
        };

        // run the sequence
        for (Line line : lines) {
            line.moveIt();
        }

        // test all moves
        assertThat(mower1.getPositionX(), equalTo(1));
        assertThat(mower1.getPositionY(), equalTo(3));
        assertThat(mower1.getDirection(), equalTo(Direction.NORTH));

        assertThat(mower2.getPositionX(), equalTo(5));
        assertThat(mower2.getPositionY(), equalTo(1));
        assertThat(mower2.getDirection(), equalTo(Direction.EAST));



    }
}
