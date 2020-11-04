package pl.paweln.codility.sorting;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxProductOfThree2Test extends MaxProductOfThreeTest {
    @Override
    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_MAX_PRODUCT_OF_THREE_2);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}
