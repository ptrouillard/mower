package fr.agilecoder.mower;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 23:45
 */
public class ShearingSequence {
    private List<MowerMove> lines = Lists.newArrayList();

    public ShearingSequence(MowerMove... lines) {
        this.lines.clear();
        this.lines.addAll(Arrays.asList(lines));
    }

    public void runShearing() {

        // run the sequence
        for (MowerMove line : lines) {
            line.moveIt();
        }

    }
}
