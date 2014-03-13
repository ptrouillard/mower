package fr.agilecoder.mower;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    public void verify_single_go_ahead_move_is_executed() {
        Line line = new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "A");
        line.moveIt();
        assertThat(line.getMower().getPositionX(), equalTo(0));
        assertThat(line.getMower().getPositionY(), equalTo(1));
        assertThat(line.getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test
    public void verify_two_go_ahead_moves_are_executed() {
        Line line = new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "AA");
        line.moveIt();
        assertThat(line.getMower().getPositionX(), equalTo(0));
        assertThat(line.getMower().getPositionY(), equalTo(2));
        assertThat(line.getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test
    public void verify_three_go_left_moves_are_executed() {
        Line line = new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "GGG");
        line.moveIt();
        assertThat(line.getMower().getPositionX(), equalTo(0));
        assertThat(line.getMower().getPositionY(), equalTo(0));
        assertThat(line.getMower().getDirection(), equalTo(Direction.EAST));
    }

    @Test
    public void verify_three_go_right_moves_are_executed() {
        Line line = new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "DDD");
        line.moveIt();
        assertThat(line.getMower().getPositionX(), equalTo(0));
        assertThat(line.getMower().getPositionY(), equalTo(0));
        assertThat(line.getMower().getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_basic_move_is_ok() {
        Line line = new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "AGDAGD");
        line.moveIt();
        assertThat(line.getMower().getPositionX(), equalTo(0));
        assertThat(line.getMower().getPositionY(), equalTo(2));
        assertThat(line.getMower().getDirection(), equalTo(Direction.NORTH));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void verify_invalid_command_is_rejected() {
        new Line(new Mower().withDirection(Direction.NORTH).withPositionX(0).withPositionY(0), "Z");
    }
}
