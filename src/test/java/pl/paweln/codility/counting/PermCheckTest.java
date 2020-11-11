package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;


public class PermCheckTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution codilitySolution;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_PERM_CHECK);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExamplePositive() {
        int[] testTab = {4, 1, 2, 3};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testExampleNegative() {
        int[] testTab = {4, 1, 2};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(0, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testMaxNumbers() {
        int[] testTab = new int[100000];
        for (int i = 0; i < testTab.length ; i++) {
            testTab[i] = i + 1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

        testTab[99999] = 100001;
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(0, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSingle() {
        int[] testTab = {1};
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();

        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

        testTab[0] = 2;
        this.params = this.paramsBuilder
                .setFirstArray(testTab).build();
        Assert.assertEquals(0, this.codilitySolution.solution(this.params)[0]);

    }
}