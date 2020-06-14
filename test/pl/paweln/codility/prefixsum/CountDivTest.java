package pl.paweln.codility.prefixsum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class CountDivTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PREFIX_SUMS_COUNT_DIV);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int A = 6;
        int B = 11;
        int K = 2;
        this.params = this.paramsBuilder
                .setA(A)
                .setB(B)
                .setK(K).build();

        Assert.assertEquals(3, s.solution(this.params)[0]);

    }

    @Test
    public void testTheSame1() {
        int A = 10;
        int B = 10;
        int K = 2;
        this.params = this.paramsBuilder
                .setA(A)
                .setB(B)
                .setK(K).build();

        Assert.assertEquals(1, s.solution(this.params)[0]);
    }

    @Test
    public void testTheSame2() {
        int A = 13;
        int B = 13;
        int K = 7;
        this.params = this.paramsBuilder
                .setA(A)
                .setB(B)
                .setK(K).build();

        Assert.assertEquals(0, s.solution(this.params)[0]);
    }

    @Test
    public void testExtremeValues1() {
        int A = 0;
        int B = 2000000000;
        int K = 2000000000;
        this.params = this.paramsBuilder
                .setA(A)
                .setB(B)
                .setK(K).build();

        Assert.assertEquals(2, s.solution(this.params)[0]);
    }

    @Test
    public void testExtremeValues2() {
        int A = 0;
        int B = 2000000000;
        int K = 1;
        this.params = this.paramsBuilder
                .setA(A)
                .setB(B)
                .setK(K).build();

        Assert.assertEquals(2000000001, s.solution(this.params)[0]);
    }
}
