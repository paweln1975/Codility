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
    public void testSingle() {
        int[] A = {1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int[] nonDivisors = this.s.solution(this.params);

        int[] expected = {0};

        Assert.assertArrayEquals (expected, nonDivisors);
    }

    @Test
    public void testDouble() {
        int[] A = {1, 2};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int[] nonDivisors = this.s.solution(this.params);

        int[] expected = {1, 0};

        Assert.assertArrayEquals (expected, nonDivisors);
    }

    @Test
    public void testTriple() {
        int[] A = {1, 2, 3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int[] nonDivisors = this.s.solution(this.params);

        int[] expected = {2, 1, 1};

        Assert.assertArrayEquals (expected, nonDivisors);
    }

    @Test
    public void testExample() {
        int[] A = {3, 1, 2, 3, 6};

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int[] nonDivisors = this.s.solution(this.params);

        int[] expected = {2, 4, 3, 2, 0};

        Assert.assertArrayEquals (expected, nonDivisors);
    }

    @Test
    public void testPerformance() {
        int size = 50000;
        int[] tab = new int[size];
        for (int i = 1; i <= size; i++) {
            tab[i-1] = i;
        }

        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int[] nonDivisors = this.s.solution(this.params);

        int[] first19NonDivisors = new int[19];
        System.arraycopy(nonDivisors, 0, first19NonDivisors, 0, first19NonDivisors.length);

        int[] expected = {49999,49998,49998,49997,49998,49996,49998,49996,49997,49996,49998,49994,49998,49996,49996,49995,49998,49994,49998};
        Assert.assertArrayEquals (expected, first19NonDivisors);
    }
}
