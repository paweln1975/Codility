package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.prefixsums.MinAvgTwoSliceFactory;

public class MinAvgTwoSliceTests {
    private final SolutionFactory solutionFactory = new MinAvgTwoSliceFactory();
    private CodilitySolution codilitySolution;

    @Before
    public void setUp() {

        this.codilitySolution = this.solutionFactory.createSolution();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int [] {4, 2, 2, 5, 1, 5, 8};
        int expectedResult = 1;

        int result = this.codilitySolution.solution(A);

        Assert.assertEquals(expectedResult, result);
    }
}
