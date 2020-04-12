package pl.paweln.codility.prefixsum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class MinAvgTwoSliceTests {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private Solution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PREFIX_SUMS_MIN_AVG_TWO_SLICE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int [] {4, 2, 2, 5, 1, 5, 8};
        int expectedResult = 1;

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void test2Elements() {
        int[] A = new int[] {5, 6};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(0, result);
    }

    @Test
    public void test4Elements() {
        int[] A = new int[] {4, 3, 2, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(2, result);
    }


    @Test
    public void testPerformance() {
        int size = 100000;
        int[] A = new int[size];
        for (int i = 0; i < size - 3; i++) {
            A[i] = 10000;
        }
        A[size - 3] = -10000;
        A[size - 2] = -10000;
        A[size - 1] = -10000;

        this.params = this.paramsBuilder.setFirstArray(A).build();
        long result = this.s.solution(this.params)[0];

        long expValue = (long)size - 2L;

        Assert.assertEquals(expValue, result);
    }
}
