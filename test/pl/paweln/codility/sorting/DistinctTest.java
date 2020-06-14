package pl.paweln.codility.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class DistinctTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_DISTINCT);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] A = { 2, 1, 1, 2, 3, 1 };
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(3, this.s.solution(this.params)[0]);
    }

    @Test
    public void testPerformanceDifferent() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = N - i;
        }
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(N, this.s.solution(this.params)[0]);
    }

    @Test
    public void testPerformanceTheSame() {
        final int N = 100000;
        int[] A = new int[N];
        Arrays.fill(A, 10);

        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(1, this.s.solution(this.params)[0]);
    }

    @Test
    public void testSmall() {
        int[] A = new int[0];
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(0, this.s.solution(this.params)[0]);

        A = new int[] {10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(1, this.s.solution(this.params)[0]);
    }

    @Test
    public void testRandom2() {
        int[] A = new int[] {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(2, this.s.solution(this.params)[0]);
    }
}
