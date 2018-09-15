package pl.paweln.codility.counting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxCountersTest {
    private MaxCounters mc;

    @Before
    public void setUp() {
        this.mc = new MaxCounters();
    }

    @After
    public void tearDown() {
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
}

