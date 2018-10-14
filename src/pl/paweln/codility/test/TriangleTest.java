package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.sorting.TriangleFactory;

public class TriangleTest {
    private final SolutionFactory solutionFactory = new TriangleFactory();
    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.createSolution();
    }

    @Test
    public void testExampleOK() {

        int[] A = { 10, 2, 5, 1, 8, 20};
        Assert.assertEquals(1, s.solution(A));
    }

    @Test
    public void testExampleNotOK() {
        int[] A = { 10, 50, 5, 1};
        Assert.assertEquals(0, s.solution(A));
    }
}
