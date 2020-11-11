package pl.paweln.codility.sorting.algorithm;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class HeapSort2Test extends SortingAlgorithmBase {
    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_HEAP_SORT_2);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}
