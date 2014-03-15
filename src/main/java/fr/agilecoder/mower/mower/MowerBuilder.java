package fr.agilecoder.mower.mower;

import fr.agilecoder.mower.Direction;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Build a mower object
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 23:54
 */
public class MowerBuilder {

    private Mower current;

    /**
     * build a mower from initial script
     * @param mowerPosition
     * @return
     */
    public static Mower build(String mowerPosition) {
        String[] parts = mowerPosition.split(" ");
        if (parts.length < 3)
            throw new IllegalArgumentException("Invalid mower position");

        int x = 0;
        if (NumberUtils.isNumber(parts[0])) {
            x = Integer.parseInt(parts[0]);
        } else {
            throw new IllegalArgumentException("Invalid mower X position : a number is required : " + parts[0]);
        }

        int y = 0;
        if (NumberUtils.isNumber(parts[1])) {
            y = Integer.parseInt(parts[1]);
        } else {
            throw new IllegalArgumentException("Invalid mower Y position : a number is required : " + parts[1]);
        }

        Direction direction = Direction.fromSingleLetterCode(parts[2].charAt(0));
        return build().withX(x).withY(y).withDirection(direction).getCurrent();
    }

    /**
     * build a mower with fluent approach.
     * @return
     */
    public static MowerBuilder build() {
        return new MowerBuilder(new Mower());
    }

    public MowerBuilder(Mower current) {
        this.current = current;
    }

    public MowerBuilder withDirection(Direction direction) {
        this.current.setDirection(direction);
        return this;
    }

    public MowerBuilder withX(int x) {
        this.current.setX(x);
        return this;
    }

    public MowerBuilder withY(int y) {
        this.current.setY(y);
        return this;
    }

    public Mower getCurrent() {
        return current;
    }
}
