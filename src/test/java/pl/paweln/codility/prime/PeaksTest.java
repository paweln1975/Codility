package pl.paweln.codility.prime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class PeaksTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PRIME_PEAKS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(3, maxNumberOfBlocks);
    }

    @Test
    public void testSingle() {
        int[] A = {0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxNumberOfBlocks);
    }

    @Test
    public void testDouble() {
        int[] A = {0, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxNumberOfBlocks);
    }

    @Test
    public void testTriple() {
        int[] A = {0, 10, 4};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(1, maxNumberOfBlocks);
    }

    @Test
    public void testWithoutPeaks() {
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(0, maxNumberOfBlocks);
    }

    @Test
    public void testPackedPeaks() {
        int[] A = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(8, maxNumberOfBlocks);
    }

    @Test
    public void testPerformance() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = 0;
            } else {
                A[i] = 1;
            }
        }
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(25000, maxNumberOfBlocks);
    }

    @Test
    public void testPrimeLength() {
        int[] A = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int maxNumberOfBlocks = this.s.solution(this.params)[0];

        Assert.assertEquals(1, maxNumberOfBlocks);
    }

}
