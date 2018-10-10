package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.counting.MaxCountersFactory;

public class MaxCountersTest {
    private final SolutionFactory<Integer[]> solutionFactory = new MaxCountersFactory();
    private CodilitySolution<Integer[]> s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.createSolution();
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
        Integer[] retArr = this.s.solution(A, 5);

        Assert.assertArrayEquals(new Integer[] {3, 2, 2, 4, 2}, retArr);
    }

    @Test
    public void testMaxValues() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100000;
        }

        A[A.length-1] = 100001;

        Integer[] retArr = this.s.solution(A, 100000);

        Integer[] expArr = new Integer[100000];
        for (int i = 0; i < expArr.length; i++) {
            expArr[i] = 99999;

        }

        Assert.assertArrayEquals(expArr, retArr);
    }
}

