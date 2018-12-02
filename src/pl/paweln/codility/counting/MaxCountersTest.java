package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class MaxCountersTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.COUNTING_MAX_COUNTERS);

    private CodilitySolution s;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        this.s = (CodilitySolution)this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[7];
        A[0] = 3;
        A[1] = 4;
        A[2] = 4;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;
        int[] retArr = this.s.solutionTab(A, 5);

        Assert.assertArrayEquals(new int[] {3, 2, 2, 4, 2}, retArr);
    }

    @Test
    public void testMaxValues() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100000;
        }

        A[A.length-1] = 100001;

        int[] retArr = this.s.solutionTab(A, 100000);

        int[] expArr = new int[100000];
        for (int i = 0; i < expArr.length; i++) {
            expArr[i] = 99999;

        }

        Assert.assertArrayEquals(expArr, retArr);
    }
}

