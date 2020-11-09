package pl.paweln.codility.prime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class MinPerimeterRectangleTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PRIME_MIN_PERIMETER);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int N = 30;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(22, minPerimeter);
    }

    @Test
    public void test1() {
        int N = 1;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(4, minPerimeter);
    }

    @Test
    public void test2() {
        int N = 2;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(6, minPerimeter);
    }

    @Test
    public void testPrime() {
        int N = 17;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(2*(1+N), minPerimeter);
    }

    @Test
    public void testPrimeHigh() {
        int N = 15486451;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(2*(1+N), minPerimeter);
    }

    @Test
    public void testSquare() {
        int N = 100000000;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(40000, minPerimeter);
    }

    @Test
    public void testMax() {
        int N = 1000000000;
        this.params = this.paramsBuilder.setN(N).build();
        int minPerimeter = this.s.solution(this.params)[0];

        Assert.assertEquals(126500, minPerimeter);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationsNegativeN() {
        int N = -1;
        this.params = this.paramsBuilder.setN(N).build();
        this.s.solution(this.params);

        N = 1000000001;
        this.params = this.paramsBuilder.setN(N).build();
        this.s.solution(this.params);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationsTooBigN() {
        int N = 1000000001;
        this.params = this.paramsBuilder.setN(N).build();
        this.s.solution(this.params);
    }
}
