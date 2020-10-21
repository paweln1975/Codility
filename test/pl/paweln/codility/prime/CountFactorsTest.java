package pl.paweln.codility.prime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class CountFactorsTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PRIME_COUNT_FACTORS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void test1() {
        int N = 1;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(1, countFactors);
    }

    @Test
    public void test2() {
        int N = 2;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(2, countFactors);
    }

    @Test
    public void test3() {
        int N = 3;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(2, countFactors);
    }

    @Test
    public void test4() {
        int N = 4;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(3, countFactors);
    }

    @Test
    public void testExample24() {
        int N = 24;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(8, countFactors);
    }

    @Test
    public void testPrime() {
        int N = 17;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(2, countFactors);
    }

    @Test
    public void test100() {
        int N = 100;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(9, countFactors);
    }

    @Test
    public void testMax() {
        int N = Integer.MAX_VALUE;
        this.params = this.paramsBuilder.setN(N).build();
        int countFactors = this.s.solution(this.params)[0];

        Assert.assertEquals(2, countFactors);
    }




}
