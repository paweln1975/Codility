package pl.paweln.codility.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class MaxProductOfThreeTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_MAX_PRODUCT_OF_THREE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] A = { -3, 1, 2, -2, 5, 6};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(60, this.s.solution(this.params)[0]);
    }

    @Test
    public void testThree() {
        int[] A = {5, 6, 60};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(A[0] * A[1] * A[2], this.s.solution(this.params)[0]);
    }

    @Test
    public void testSimple() {
        int[] A = new int[]{-4, -6, 3, 4, 5};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(120, this.s.solution(this.params)[0]);

        A = new int[]{4, 7, 3, 2, 1, -3, -5};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(105, this.s.solution(this.params)[0]);
    }

    @Test
    public void testWithLimitedPositives() {
        int[] A = {-2, -1, 0, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(20, this.s.solution(this.params)[0]);

        A = new int[]{-3, -2, -1, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(60, this.s.solution(this.params)[0]);

        A = new int[] {-2, 0, 0, 5, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(0, this.s.solution(this.params)[0]);

        A = new int[] {-2, -1, 0, 5, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(20, this.s.solution(this.params)[0]);

        A = new int[] {-3, -2, -1, 0, 5, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(60, this.s.solution(this.params)[0]);

        A = new int[] {-3, -2, -1, 5, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(60, this.s.solution(this.params)[0]);
    }

    @Test
    public void testExtremeAllTheSame0() {
        int N = 100000;
        int[] A = new int[N];

        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(0, this.s.solution(this.params)[0]);

    }

    @Test
    public void testExtremeAllNegatives() {
        int N = 100000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = -N + i;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(-6, this.s.solution(this.params)[0]);

    }

    @Test
    public void testExtremeAllPositives() {
        int N = 100000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = 1000;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(1000000000, this.s.solution(this.params)[0]);

    }

    @Test
    public void testMediumAllPositives() {
        int N = 1000;
        int[] A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = N-i;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        Assert.assertEquals(1000*999*998, this.s.solution(this.params)[0]);

    }


}
