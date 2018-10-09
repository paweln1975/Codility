package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.counting.MaxCounters;

public class MaxCountersTest {
    private MaxCounters mc;

    @Before
    public void setUp() {
        this.mc = new MaxCounters();
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
        int[] retArr = this.mc.solution(5, A);

        Assert.assertArrayEquals(new int[] {3, 2, 2, 4, 2}, retArr);
    }

    @Test
    public void testMaxValues() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100000;
        }

        A[A.length-1] = 100001;

        int[] retArr = this.mc.solution(100000, A);

        int[] expArr = new int[100000];
        for (int i = 0; i < expArr.length; i++) {
            expArr[i] = 99999;

        }

        Assert.assertArrayEquals(expArr, retArr);
    }
}

