package pl.paweln.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;


public class TapeEquilibriumTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.TIME_COMPLEXITY_TAPE_EQUILIBRIUM);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void solutionSimple() {
        int[] tab = {3,1,2,4,3};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void solutionTwoElem() {
        int[] tab = {1,10};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(9, actualValue);
    }

    @Test
    public void solution100000() {
        int[] tab = new int[100000];
        Arrays.fill(tab, -1000);
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }
}