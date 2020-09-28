package pl.paweln.codility.slice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxSliceTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SLICE_MAX_SLICE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int [] A = {5,-7,3,5,-2,4,-1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(10, maxSlice);

    }

    @Test
    public void testExampleSimple() {
        int [] A = {3,2,-6,4,0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(5, maxSlice);

    }

    @Test
    public void testSinglePositive() {
        int [] A = {10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(10, maxSlice);
    }

    @Test
    public void testSingleNegative() {
        int [] A = {-10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(-10, maxSlice);
    }

    @Test
    public void testTwoValuesNegativePositive() {
        int [] A = {-10, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(10, maxSlice);
    }

    @Test
    public void testTwoValuesNegatives() {
        int [] A = {-10, -20};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(-10, maxSlice);
    }

    @Test
    public void testTwoValuesPositive() {
        int [] A = {5, 10};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(15, maxSlice);
    }

    @Test
    public void testTreeValues() {
        int [] A = {5, -5, 6};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(6, maxSlice);
    }

    @Test
    public void testGrowingNegative() {
        int size = 1000000;
        int [] A = new int[size];

        for (int i = 0; i < size; i++) {
            A[i] = 1+ i - 2000000;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(-1000000, maxSlice);
    }
}
