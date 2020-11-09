package pl.paweln.codility.euclidean;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class EuclideanBinaryTest extends EuclideanSubtractTest {
    @Before
    @Override
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.EUCLIDEAN_BINARY);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}

