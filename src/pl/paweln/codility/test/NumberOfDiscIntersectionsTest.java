package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.sorting.NumberOfDiscIntersectionsFactory;

public class NumberOfDiscIntersectionsTest {
    private final SolutionFactory solutionFactory = new NumberOfDiscIntersectionsFactory();
    private CodilitySolution solution;

    @Before
    public void setUp() {

        this.solution = this.solutionFactory.createSolution();
    }

    @Test
    public void testExample() {

        int[] A = {1, 5, 2, 1, 4, 0};
        Assert.assertEquals(11, solution.solution(A));
    }

    @Test
    public void testSimple() {
        int[] A = {1, 0, 1};
        Assert.assertEquals(3, solution.solution(A));
    }

    @Test
    public void testAllCovering() {
        int size = 10;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        Assert.assertEquals(45, solution.solution(A));
    }

    @Test
    public void testMaxCapacity() {
        int size = 10000;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        Assert.assertEquals(-1, solution.solution(A));
    }

    @Test
    public void testOverflow() {
        int[] A = new int[] {1, 2147483647, 0};

        Assert.assertEquals(2, solution.solution(A));
    }
}
