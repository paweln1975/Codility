package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class OddOccurrencesInArrayTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.ARRAYS_ODD_OCCURRENCES_IN_ARRAY);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSimple() {

        int[] A = {4, 5, 6, 7, 6, 5, 4};
        Assert.assertEquals(7, s.solution(A));
    }

    @Test
    public void testSimple2() {

        int[] A = {100000, 100000, 100000, 100, 100000, 100000, 100000};
        Assert.assertEquals(100, s.solution(A));
    }

    @Test
    public void testAdvanced() {

        int[] A = {874385, 983983, 983983, 888832, 888832, 989, 874385};
        Assert.assertEquals(989, s.solution(A));
    }

    @Test
    public void testMissingOddOccNumber() {

        int[] A = {10, 20, 35, 47, 49, 100, 2000, 10, 20, 35, 47, 49, 100, 2000};
        Assert.assertEquals(0, s.solution(A));
    }

    @Test
    public void testPerformance() {
        int size = 1000000;
        int[] A = new int [size + 1];
        A[0] = 50;
        for (int i = 1; i <= size / 2 ; i++) {
                A[i] = i;
                A[i+size/2] = i;

        }

        Assert.assertEquals(50, s.solution(A));
    }
}
