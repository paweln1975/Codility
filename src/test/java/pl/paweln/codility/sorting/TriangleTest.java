package pl.paweln.codility.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class TriangleTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_TRIANGLE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExampleOK() {
        int[] A = { 10, 2, 5, 1, 8, 20};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testExampleNotOK() {
        int[] A = { 10, 50, 5, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testSmall() {
        int[] A = {};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

        A = new int[] {1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

        A = new int[] {2, 3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testMax3Integers() {
        int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void test3TheSame() {
        int[] A = {50, 50, 50};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testNegatives() {
        int[] A = new int[] {-1, -1 , -1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

        A = new int[] {1, -1 , -1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

        A = new int[] {-1, 1 , 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

        A = new int[] {1, -1, 1 , 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);

    }

    @Test
    public void testNegativesExtreme() {
        final int N = 100000;
        int[] A = new int[N];
        Arrays.fill(A, -1);
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testConsecutiveExtreme() {
        final int N = 100000;
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = N - i;
        }
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

}
