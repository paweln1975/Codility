package pl.paweln.codility.slice;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxProfitKadaneTest extends MaxProfitTest {
    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SLICE_MAX_PROFIT_KADANE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}
