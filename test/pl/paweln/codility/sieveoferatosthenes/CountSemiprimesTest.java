package pl.paweln.codility.sieveoferatosthenes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class CountSemiprimesTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SIEVE_ERATOSTHENES_COUNT_SEMIPRIMES);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSingle() {
        int N = 1;
        int[] P = {1};
        int[] Q = {1};

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = {0};

        Assert.assertArrayEquals (expected, countSemiprimes);
    }

    @Test
    public void testDouble() {
        int N = 2;
        int[] P = {1, 2};
        int[] Q = {2, 2};

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = {0, 0};

        Assert.assertArrayEquals (expected, countSemiprimes);
    }

    @Test
    public void testExample() {
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = {10, 4, 0};

        Assert.assertArrayEquals (expected, countSemiprimes);
    }

    @Test
    public void testSimple() {
        int N = 26;
        int[] P = {1};
        int[] Q = {26};

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = {10};

        Assert.assertArrayEquals (expected, countSemiprimes);
    }

    @Test
    public void testMaxN() {
        int N = 50000;
        int[] P = {1};
        int[] Q = {26};

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = {10};

        Assert.assertArrayEquals (expected, countSemiprimes);
    }

    @Test
    public void testPerformance() {
        int N = 50000;
        int size = 30000;
        int[] P = new int[size];
        int[] Q = new int[size];

        Arrays.fill(P, 1);
        Arrays.fill(Q, N);

        this.params = this.paramsBuilder
                .setN(N)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] countSemiprimes = this.s.solution(this.params);

        int[] expected = new int[size];
        Arrays.fill(expected, 12110);

        Assert.assertArrayEquals (expected, countSemiprimes);
    }
}
