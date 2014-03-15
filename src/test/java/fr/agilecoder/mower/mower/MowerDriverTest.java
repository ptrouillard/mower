package fr.agilecoder.mower.mower;

import fr.agilecoder.mower.Direction;
import fr.agilecoder.mower.border.Border;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 21:38
 */
public class MowerDriverTest {

    @Test
    public void verify_that_mower_moves_forward_to_north() {
        Mower mower = MowerBuilder.build()
                .withDirection(Direction.NORTH)
                .withX(5)
                .withY(4)
                .getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(5,5), mower);
        driver.goAhead();
        assertThat(mower.getX(), equalTo(5));
        assertThat(mower.getY(), equalTo(5));
    }

    @Test
    public void verify_that_mower_moves_forward_to_south() {
        Mower mower = MowerBuilder.build()
                .withDirection(Direction.SOUTH)
                .withX(5)
                .withY(4)
                .getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(5,5), mower);
        driver.goAhead();
        assertThat(mower.getX(), equalTo(5));
        assertThat(mower.getY(), equalTo(3));
    }

    @Test
    public void verify_that_mower_moves_forward_to_right() {
        Mower mower = MowerBuilder.build()
                .withDirection(Direction.EAST)
                .withX(5)
                .withY(4)
                .getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(6,6), mower);
        driver.goAhead();
        assertThat(mower.getX(), equalTo(6));
        assertThat(mower.getY(), equalTo(4));
    }

    @Test
    public void verify_that_mower_moves_forward_to_left() {
        Mower mower = MowerBuilder.build()
                .withDirection(Direction.WEST)
                .withX(5)
                .withY(4)
                .getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(5,5), mower);
        driver.goAhead();
        assertThat(mower.getX(), equalTo(4));
        assertThat(mower.getY(), equalTo(4));
    }

    @Test
    public void verify_that_mower_turns_right() {
        Mower mower = MowerBuilder.build().withDirection(Direction.WEST).getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(5,5), mower);
        driver.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.NORTH));
        driver.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.EAST));
        driver.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.SOUTH));
        driver.turnRight();
        assertThat(mower.getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_that_mower_turns_left() {
        Mower mower = MowerBuilder.build().withDirection(Direction.WEST).getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(5,5), mower);
        driver.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.SOUTH));
        driver.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.EAST));
        driver.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.NORTH));
        driver.turnLeft();
        assertThat(mower.getDirection(), equalTo(Direction.WEST));
    }

    @Test
    public void verify_that_mower_stays_inside_borders() {
        Mower mower = MowerBuilder.build().withDirection(Direction.NORTH).withX(1).withY(1).getCurrent();
        MowerDriver driver = new MowerDriverImpl(new Border(2,2), mower);
        driver.goAhead();
        driver.goAhead();
        driver.goAhead();
        assertThat(mower.getY(), equalTo(2));
        assertThat(mower.getX(), equalTo(1));
        mower.setDirection(Direction.EAST);
        driver.goAhead();
        driver.goAhead();
        assertThat(mower.getX(), equalTo(2));
        mower.setDirection(Direction.WEST);
        driver.goAhead();
        driver.goAhead();
        driver.goAhead();
        assertThat(mower.getX(), equalTo(0));
        mower.setDirection(Direction.SOUTH);
        driver.goAhead();
        driver.goAhead();
        driver.goAhead();
        assertThat(mower.getY(), equalTo(0));


    }
}
