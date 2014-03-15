package fr.agilecoder.mower;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * A list of shearing sequences executed sequentially
 * User: ptrouillard@gmail.com
 * Date: 13/03/14 23:45
 */
public class ShearingSequences {

    private static Logger logger = LoggerFactory.getLogger(ShearingSequences.class);
    private List<ShearingSequence> sequences = Lists.newArrayList();

    public ShearingSequences(ShearingSequence... sequences) {
        this.sequences.clear();
        this.sequences.addAll(Arrays.asList(sequences));
    }

    public void runShearing() {
        // run the sequence
        for (ShearingSequence sequence : sequences) {
            logger.info("Position/Direction of mower before move is {}", sequence.getDriver().getMower().toString());
            sequence.run();
            logger.info("Position/Direction of mower after move is {}", sequence.getDriver().getMower().toString());
        }
    }
}
