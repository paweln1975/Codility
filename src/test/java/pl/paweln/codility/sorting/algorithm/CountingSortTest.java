package pl.paweln.codility.sorting.algorithm;

import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class CountingSortTest extends SortingAlgorithmBase {
    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_COUNTING_SORT);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNegativeElements() {
        int[] tab = { 5, -10, 15, 15, 10, 5, 1};

        this.params = this.paramsBuilder.setFirstArray(tab).build();
        this.codilitySolution.solution(this.params);

    }
}
