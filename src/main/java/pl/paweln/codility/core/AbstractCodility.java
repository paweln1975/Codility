package pl.paweln.codility.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractCodility implements CodilitySolution {
    protected SolutionInputParams defaultParams;
    protected SolutionInputParams.SolutionInputParamsBuilder
            paramsBuilder;

    private static final Log logger = LogFactory.getLog(AbstractCodility.class);

    public AbstractCodility() {
        paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    public int[] runWithDefaultParameters() {
        if (this.defaultParams != null) {
            logger.debug("Running " + getClass().getSimpleName() + " with default parameters: " + this.defaultParams.toString());
        }
        return solution(this.defaultParams);
    }
}
