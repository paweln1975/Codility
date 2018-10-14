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

    @Test
    public void testSmall() {
        int[] A = {};
        Assert.assertEquals(0, s.solution(A));
        A = new int[] {1};
        Assert.assertEquals(0, s.solution(A));
        A = new int[]{2, 3};
        Assert.assertEquals(0, s.solution(A));
    }

    @Test
    public void testMax3Integers() {
        int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        Assert.assertEquals(1, s.solution(A));
    }

    @Test
    public void test3TheSame() {
        int[] A = {50, 50, 50};
        Assert.assertEquals(1, s.solution(A));
    }

    @Test
    public void testNegatives() {
        int[] A = new int[]{-1, -1 , -1};
        Assert.assertEquals(0, s.solution(A));

        A = new int[]{1, -1 , -1};
        Assert.assertEquals(0, s.solution(A));

        A = new int[]{-1, 1 , 1};
        Assert.assertEquals(0, s.solution(A));

        A = new int[]{1, -1, 1 , 1};
        Assert.assertEquals(1, s.solution(A));

    }

    @Test
    public void testNegativesExtreme() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = -1;
        }
        Assert.assertEquals(0, s.solution(A));
    }

    @Test
    public void testConsecutiveExtreme() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = N - i;
        }
        Assert.assertEquals(1, s.solution(A));
    }

}
