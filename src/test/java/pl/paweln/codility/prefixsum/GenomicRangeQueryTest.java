package pl.paweln.codility.prefixsum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class GenomicRangeQueryTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PREFIX_SUMS_GENOMIC_RANGE_QUERY);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSolutionExample() {
        String S = "CAGCCTA";
        int[] P = new int [] {2, 5, 0};
        int[] Q = new int [] {4, 5, 6};
        int[] expectedResult = new int[] {2, 4, 1};

        this.params = this.paramsBuilder
                .setStringValue(S)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testSolutionVerifier1() {
        String S = "AC";
        int[] P = new int [] {0, 0, 1};
        int[] Q = new int [] {0, 1, 1};
        int[] expectedResult = new int[] {1, 1, 2};

        this.params = this.paramsBuilder
                .setStringValue(S)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] result = this.s.solution(this.params);

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

        this.params = this.paramsBuilder
                .setStringValue(S)
                .setFirstArray(P)
                .setSecondArray(Q).build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(expectedResult, result);
    }
}
