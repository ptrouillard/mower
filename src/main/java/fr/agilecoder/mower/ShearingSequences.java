package fr.agilecoder.mower;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * A list of shearing sequences executed sequentially
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 23:45
 */
public class ShearingSequences {
    private List<ShearingSequence> lines = Lists.newArrayList();

    public ShearingSequences(ShearingSequence... lines) {
        this.lines.clear();
        this.lines.addAll(Arrays.asList(lines));
    }

    public void runShearing() {
        // run the sequence
        for (ShearingSequence line : lines) {
            line.run();
        }
    }
}
