package pl.paweln.codility.iterations;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class BinaryGapTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.ITERATION_BINARY_GAP);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void test0() {
        int n = 0;

        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void test1() {
        int n = 1;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void test2() {
        int n = 2;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void test5() {
        int n = 5;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void test15() {
        int n = 15;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void test32() {
        int n = 32;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testExample() {
        int n = 1041;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void test53456() {
        int n = 53456;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(4, actualValue);
    }

    @Test
    public void testMax() {
        int n = Integer.MAX_VALUE;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void test328() {
        int n = 328;
        this.params = this.paramsBuilder
                .setN(n)
                .build();

        int actualValue = s.solution(params)[0];
        Assert.assertEquals(2, actualValue);
    }
}

