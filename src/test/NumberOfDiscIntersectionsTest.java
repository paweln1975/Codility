package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class NumberOfDiscIntersectionsTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.SORTING_NUMBER_OF_DISCS_INTERSECTIONS);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExample() {

        int[] A = {1, 5, 2, 1, 4, 0};
        Assert.assertEquals(11, this.s.solution(A));
    }

    @Test
    public void testSimple() {
        int[] A = {1, 0, 1};
        Assert.assertEquals(3, this.s.solution(A));
    }

    @Test
    public void testAllCovering() {
        int size = 10;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        Assert.assertEquals(45, this.s.solution(A));
    }

    @Test
    public void testMaxCapacity() {
        int size = 10000;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        Assert.assertEquals(-1, this.s.solution(A));
    }

    @Test
    public void testOverflow() {
        int[] A = new int[] {1, 2147483647, 0};

        Assert.assertEquals(2, this.s.solution(A));
    }
}
