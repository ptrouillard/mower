package fr.agilecoder.mower.border;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Builder the border from its string representation
 * User: ptrouillard@gmail.com
 * Date: 14/03/14 00:19
 */
public class BorderBuilder {

    public static Border build(String size) {

        String[] parts = size.split(" ");
        if (parts.length < 2)
            throw new IllegalArgumentException("Invalid border definition");

        int x = 0;
        if (NumberUtils.isNumber(parts[0])) {
            x = Integer.parseInt(parts[0]);
        } else {
            throw new IllegalArgumentException("Invalid border X size. A number is required : " + parts[0]);
        }

        int y = 0;
        if (NumberUtils.isNumber(parts[1])) {
            y = Integer.parseInt(parts[1]);
        } else {
            throw new IllegalArgumentException("Invalid border Y size. A number is required : " + parts[1]);
        }
        return new Border(x, y);
    }
}
