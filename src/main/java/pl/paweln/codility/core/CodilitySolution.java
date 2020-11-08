package pl.paweln.codility.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface CodilitySolution {
    Log logger = LogFactory.getLog(CodilitySolution.class);
    int[] solution(SolutionInputParams params);
    default int[] runWithDefaultParameters() {
        logger.warn("Implement method runWithDefaultParameters() for " + getClass());
        return new int[0];
    }

}
