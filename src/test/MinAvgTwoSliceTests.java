package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class MinAvgTwoSliceTests {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.SORTING_DISTINCT);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int [] {4, 2, 2, 5, 1, 5, 8};
        int expectedResult = 1;

        int result = this.s.solution(A);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void test2Elements() {
        int[] A = new int[] {5, 6};
        int result = this.s.solution(A);

        Assert.assertEquals(0, result);
    }

    @Test
    public void test4Elements() {
        int[] A = new int[] {4, 3, 2, 1};
        int result = this.s.solution(A);

        Assert.assertEquals(2, result);
    }


    @Test
    public void testPerformance() {
        int size = 100000;
        int[] A = new int[size];
        for (int i = 0; i < size - 3; i++) {
            A[i] = 10000;
        }
        A[size - 3] = -10000;
        A[size - 2] = -10000;
        A[size - 1] = -10000;

        long result = this.s.solution(A);
        long expValue = (long)size - 2L;

        Assert.assertEquals(expValue, result);
    }
}
