package pl.paweln.codility.timecomplexity;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class PermMissingElem2Test extends PermMissingElemTest {
    @Override
    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(
                SolutionFactory.CodilityTask.TIME_COMPLEXITY_PERM_MISSING_ELEM_2);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}
