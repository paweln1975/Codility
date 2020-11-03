package pl.paweln.codility.sieveoferatosthenes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class CountNonDivisibleTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SIEVE_ERATOSTHENES_COUNT_NON_DIVISIBLE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] A = {3, 1, 2, 3, 6};

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int[] divisors = this.s.solution(this.params);

        int[] expected = {2, 4, 3, 2, 0};

        Assert.assertArrayEquals (expected, divisors);

        Assert.assertEquals("Input and output array size must be the same.", expected.length, divisors.length);
    }
}
