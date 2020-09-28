package pl.paweln.codility.slice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxDoubleSliceSumTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SLICE_MAX_DOUBLE_SLICE_SUM);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int [] A = {3,2,6,-1,4,5,-1,2};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxDoubleSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(17, maxDoubleSlice);

    }

    @Test
    public void testEmpty() {
        int [] A = {1,2,3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxDoubleSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxDoubleSlice);
    }

    @Test
    public void testExampleSimple() {
        int [] A = {0, 10, -5, -2, 0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxDoubleSlice = this.s.solution(this.params)[0];

        Assert.assertEquals(10, maxDoubleSlice);

    }
}
