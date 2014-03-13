package fr.agilecoder.mower;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 21:38
 */
public class MowerTest {

    @Test
    public void verify_that_mower_moves_forward_to_north() {
        Mower mower = new Mower()
                .withDirection(Direction.NORTH)
                .withPositionX(5)
                .withPositionY(4);
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(5));
        assertThat(mower.getPositionY(), equalTo(5));
    }

    @Test
    public void verify_that_mower_moves_forward_to_south() {
        Mower mower = new Mower()
                .withDirection(Direction.SOUTH)
                .withPositionX(5)
                .withPositionY(4);
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(5));
        assertThat(mower.getPositionY(), equalTo(3));
    }

    @Test
    public void verify_that_mower_moves_forward_to_right() {
        Mower mower = new Mower()
                .withDirection(Direction.EAST)
                .withPositionX(5)
                .withPositionY(4);
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(6));
        assertThat(mower.getPositionY(), equalTo(4));
    }

    @Test
    public void verify_that_mower_moves_forward_to_left() {
        Mower mower = new Mower()
                .withDirection(Direction.WEST)
                .withPositionX(5)
                .withPositionY(4);
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(4));
        assertThat(mower.getPositionY(), equalTo(4));
    }

    @Test
    public void verify_that_mower_turns_right() {
        Mower mower = new Mower().withDirection(Direction.WEST);
        mower.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.NORTH));
        mower.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.EAST));
        mower.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.SOUTH));
        mower.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_that_mower_turns_left() {
        Mower mower = new Mower().withDirection(Direction.WEST);
        mower.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.SOUTH));
        mower.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.EAST));
        mower.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.NORTH));
        mower.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_that_mower_stays_inside_borders() {
        Border border = new Border(2,2);
        Mower mower = new Mower(border).withDirection(Direction.NORTH).withPositionX(1).withPositionY(1);
        mower.goAhead();
        mower.goAhead();
        mower.goAhead();
        assertThat(mower.getPositionY(), equalTo(2));
        assertThat(mower.getPositionX(), equalTo(1));
        mower.withDirection(Direction.EAST);
        mower.goAhead();
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(2));
        mower.withDirection(Direction.WEST);
        mower.goAhead();
        mower.goAhead();
        mower.goAhead();
        assertThat(mower.getPositionX(), equalTo(0));
        mower.withDirection(Direction.SOUTH);
        mower.goAhead();
        mower.goAhead();
        mower.goAhead();
        assertThat(mower.getPositionY(), equalTo(0));


    }
}
