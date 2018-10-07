package pl.paweln.codility.prefixsums;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class GenomicRangeQueryTest {
    private SolutionFactory solutionFactory = new GenomicRangeQueryFactory();
    private CodilitySolution codilitySolution;

    @Before
    public void setUp() {

        this.codilitySolution = this.solutionFactory.createSolution();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSolutionExample() {
        String S = "CAGCCTA";
        int[] P = new int [] {2, 5, 0};
        int[] Q = new int [] {4, 5, 6};
        int[] expectedResult = new int[] {2, 4, 1};

        int[] result = this.codilitySolution.solution(S, P, Q);

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testSolutionVerifier1() {
        String S = "AC";
        int[] P = new int [] {0, 0, 1};
        int[] Q = new int [] {0, 1, 1};
        int[] expectedResult = new int[] {1, 1, 2};

        int[] result = this.codilitySolution.solution(S, P, Q);

        Assert.assertArrayEquals(expectedResult, result);
    }
}
