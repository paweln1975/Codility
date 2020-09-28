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
    public void testEmpty() {
        int [] A = {};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxProfit = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxProfit);
    }
}
