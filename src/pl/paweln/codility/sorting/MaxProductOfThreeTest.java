package pl.paweln.codility.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class MaxProductOfThreeTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.SORTING_MAX_PRODUCT_OF_THREE);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExample() {
        int[] A = { -3, 1, 2, -2, 5, 6};
        Assert.assertEquals(60, s.solution(A));
    }

    @Test
    public void testThree() {
        int[] A = {5, 6, 60};
        Assert.assertEquals(A[0] * A[1] * A[2], s.solution(A));
    }

    @Test
    public void testSimple() {
        int[] A = new int[]{-4, -6, 3, 4, 5};
        Assert.assertEquals(120, s.solution(A));

        A = new int[]{4, 7, 3, 2, 1, -3, -5};
        Assert.assertEquals(105, s.solution(A));
    }

    @Test
    public void testWithLimitedPositives() {
        int[] A = {-2, -1, 0, 10};
        Assert.assertEquals(20, s.solution(A));

        A = new int[]{-3, -2, -1, 10};
        Assert.assertEquals(60, s.solution(A));

        A = new int[] {-2, 0, 0, 5, 10};
        Assert.assertEquals(0, s.solution(A));

        A = new int[] {-2, -1, 0, 5, 10};
        Assert.assertEquals(20, s.solution(A));

        A = new int[] {-3, -2, -1, 0, 5, 10};
        Assert.assertEquals(60, s.solution(A));

        A = new int[] {-3, -2, -1, 5, 10};
        Assert.assertEquals(60, s.solution(A));
    }

    @Test
    public void testExtremeAllTheSame0() {
        int N = 100000;
        int[] A = new int[N];

        Assert.assertEquals(0, s.solution(A));

    }

    @Test
    public void testExtremeAllNegatives() {
        int N = 100000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = -N + i;
        }

        Assert.assertEquals(-6, s.solution(A));

    }

    @Test
    public void testExtremeAllPositives() {
        int N = 100000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = 1000;
        }

        Assert.assertEquals(1000000000, s.solution(A));

    }

    @Test
    public void testMediumAllPositives() {
        int N = 1000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = N-i;
        }

        Assert.assertEquals(1000*999*998, s.solution(A));

    }


}
