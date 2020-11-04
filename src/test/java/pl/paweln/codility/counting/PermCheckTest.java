package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;


public class PermCheckTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_PERM_CHECK);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void solutionSimple() {
        int[] testTab = {4, 1, 2, 3};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(1, this.s.solution(this.params)[0]);

    }

    @Test
    public void solutionSimple2() {
        int[] testTab = {4, 1, 2};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(0, this.s.solution(this.params)[0]);
    }

    @Test
    public void solutionMaxNumbers() {
        int[] testTab = new int[100000];
        for (int i = 0; i < testTab.length ; i++) {
            testTab[i] = i + 1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(1, this.s.solution(this.params)[0]);

        testTab[99999] = 100001;
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(0, this.s.solution(this.params)[0]);
    }

    @Test
    public void solutionSingle() {
        int[] testTab = {1};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(1, this.s.solution(this.params)[0]);

        testTab[0] = 2;
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(0, this.s.solution(this.params)[0]);

    }
}