package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class DistinctTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.SORTING_DISTINCT);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExample() {
        int[] A = { 2, 1, 1, 2, 3, 1 };
        Assert.assertEquals(3, s.solution(A));
    }

    @Test
    public void testPerformanceDifferent() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = N - i;
        }
        Assert.assertEquals(N, s.solution(A));
    }

    @Test
    public void testPerformanceTheSame() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = 10;
        }
        Assert.assertEquals(1, s.solution(A));
    }

    @Test
    public void testSmall() {
        int[] A = new int[0];
        Assert.assertEquals(0, s.solution(A));

        A = new int[] {10};
        Assert.assertEquals(1, s.solution(A));
    }

    @Test
    public void testRandom2() {
        int[] A = new int[] {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        Assert.assertEquals(2, s.solution(A));
    }
}