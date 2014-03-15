package fr.agilecoder.mower;

import fr.agilecoder.mower.border.Border;
import fr.agilecoder.mower.mower.Mower;
import fr.agilecoder.mower.mower.MowerBuilder;
import fr.agilecoder.mower.mower.MowerDriverImpl;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 22:44
 */
public class ShearingSequenceTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_mower_is_null() {
        new ShearingSequence(null, "GA");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_moves_are_null() {
        new ShearingSequence(new MowerDriverImpl(sampleBorder(), new Mower()), null);
    }

    private Border sampleBorder() {
        return new Border(5,5);
    }

    @Test
    public void verify_single_go_ahead_move_is_executed() {
        ShearingSequence line = new ShearingSequence(new MowerDriverImpl(sampleBorder(), sampleMower()), "A");
        line.run();
        assertThat(line.getDriver().getMower().getX(), equalTo(0));
        assertThat(line.getDriver().getMower().getY(), equalTo(1));
        assertThat(line.getDriver().getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test
    public void verify_two_go_ahead_moves_are_executed() {
        ShearingSequence line = new ShearingSequence(new MowerDriverImpl(sampleBorder(), sampleMower()), "AA");
        line.run();
        assertThat(line.getDriver().getMower().getX(), equalTo(0));
        assertThat(line.getDriver().getMower().getY(), equalTo(2));
        assertThat(line.getDriver().getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test
    public void verify_three_go_left_moves_are_executed() {
        ShearingSequence line = new ShearingSequence(new MowerDriverImpl(sampleBorder() ,sampleMower()), "GGG");
        line.run();
        assertThat(line.getDriver().getMower().getX(), equalTo(0));
        assertThat(line.getDriver().getMower().getY(), equalTo(0));
        assertThat(line.getDriver().getMower().getDirection(), equalTo(Direction.EAST));
    }

    @Test
    public void verify_three_go_right_moves_are_executed() {
        ShearingSequence line = new ShearingSequence(new MowerDriverImpl(sampleBorder(), sampleMower()), "DDD");
        line.run();
        assertThat(line.getDriver().getMower().getX(), equalTo(0));
        assertThat(line.getDriver().getMower().getY(), equalTo(0));
        assertThat(line.getDriver().getMower().getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_basic_move_is_ok() {
        ShearingSequence line = new ShearingSequence(new MowerDriverImpl(sampleBorder(), sampleMower()), "AGDAGD");
        line.run();
        assertThat(line.getDriver().getMower().getX(), equalTo(0));
        assertThat(line.getDriver().getMower().getY(), equalTo(2));
        assertThat(line.getDriver().getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_command_is_rejected() {
        new ShearingSequence(new MowerDriverImpl(sampleBorder(), sampleMower()), "Z");
    }

    private Mower sampleMower() {
        return MowerBuilder.build().withDirection(Direction.NORTH).withX(0).withY(0).getCurrent();
    }
}
