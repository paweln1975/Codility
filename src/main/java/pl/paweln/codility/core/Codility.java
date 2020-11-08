package pl.paweln.codility.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

public class Codility {
    private static final Log logger = LogFactory.getLog(Codility.class);
    public static void main(String[] args) {
        logger.debug("Starting Codility algorithms execution ...");

        SolutionFactory factory = new SolutionFactory();

        for (SolutionFactory.CodilityTask task : SolutionFactory.CodilityTask.values()) {
            CodilitySolution solution = factory.getSolution(task);
            int[] output = solution.runWithDefaultParameters();
            if (output.length > 0) {
                logger.debug("Result: " + Arrays.toString(output));
            }
        }

        logger.debug("End of Codility algorithms execution.");
    }
}
