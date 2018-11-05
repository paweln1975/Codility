package pl.paweln.codility.prefixsums;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class GenomicRangeQueryTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.PREFIX_SUMS_GENOMIC_RANGE_QUERY);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSolutionExample() {
        String S = "CAGCCTA";
        int[] P = new int [] {2, 5, 0};
        int[] Q = new int [] {4, 5, 6};
        int[] expectedResult = new int[] {2, 4, 1};

        int[] result = this.s.solution(S, P, Q);

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testSolutionVerifier1() {
        String S = "AC";
        int[] P = new int [] {0, 0, 1};
        int[] Q = new int [] {0, 1, 1};
        int[] expectedResult = new int[] {1, 1, 2};

        int[] result = this.s.solution(S, P, Q);

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testSolutionExtremeInput() {
        int N = 100000;
        int M = 50000;

        StringBuilder buff = new StringBuilder(N);
        char[] tabDNA = new char[] {'A', 'C', 'G', 'T'};
        for (int i = 0; i < N; i++) {
            int mod4 = i % tabDNA.length;
            buff.append(tabDNA[mod4]);
        }

        String S = buff.toString();

        int[] P = new int [M];
        int[] Q = new int [M];
        int[] expectedResult = new int[M];

        for (int i = 0; i < M; i++) {
            P[i] = 0;
            Q[i] = N - 1;
            expectedResult[i] = 1;
        }

        int[] result = this.s.solution(S, P, Q);

        Assert.assertArrayEquals(expectedResult, result);
    }
}
