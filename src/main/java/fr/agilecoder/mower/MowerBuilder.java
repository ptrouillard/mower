package fr.agilecoder.mower;

import org.apache.commons.lang.math.NumberUtils;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 23:54
 */
public class MowerBuilder {

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
        return new Mower().withPositionX(x).withPositionY(y).withDirection(direction);
    }
}
