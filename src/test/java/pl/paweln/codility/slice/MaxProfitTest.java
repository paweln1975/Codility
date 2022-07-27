package pl.paweln.codility.slice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxProfitTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SLICE_MAX_PROFIT);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int [] A = {23171,21011,21123,21366,21013,21367};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(356, maxProfit);

    }

    @Test
    public void testEmptyOrSingle() {
        int[] A = {};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxProfit);

        int[] B = {1};
        this.params = this.paramsBuilder.setFirstArray(B).build();
        maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxProfit);
    }

    @Test
    public void testSimple() {
        int[] A = {5, 4, 6, 2, 4, 5, 1, 3, 3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(3, maxProfit);
    }

    @Test
    public void testLowerPriceLater() {
        int[] A = {2, 6, 1, 4};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(4, maxProfit);
    }

    @Test
    public void testSimple2() {
        int[] A = {2, 6, 1, 4, 7};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(6, maxProfit);
    }
}
