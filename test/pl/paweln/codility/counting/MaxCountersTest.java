package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class MaxCountersTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private Solution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_MAX_COUNTERS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[] {3, 4, 4, 6, 1, 4, 4};

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setN(5).build();

        int[] retArr = this.s.solution(this.params);

        Assert.assertArrayEquals(new int[] {3, 2, 2, 4, 2}, retArr);
    }

    @Test
    public void testMaxValues() {
        int[] A = new int[100000];

        Arrays.fill(A, 100000);
        A[A.length-1] = 100001;

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setN(100000).build();

        int[] retArr = this.s.solution(this.params);

        int[] expArr = new int[100000];
        Arrays.fill(expArr, 99999);

        Assert.assertArrayEquals(expArr, retArr);
    }
}

