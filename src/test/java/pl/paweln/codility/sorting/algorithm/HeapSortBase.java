package pl.paweln.codility.sorting.algorithm;

import org.junit.Before;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class HeapSortBase extends SortingAlgorithmBase {
    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_HEAP_SORT);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }
}
