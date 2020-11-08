package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.paweln.codility.core.*;

public class OddOccurrencesInArrayTest {

    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.ARRAYS_ODD_OCCURRENCES_IN_ARRAY);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSingle() {
        int[] A = {4};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(4, s.solution(this.params)[0]);
    }

    @Test
    public void testSimple() {
        int[] A = {4, 5, 6, 7, 6, 5, 4};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(7, s.solution(this.params)[0]);
    }

    @Test
    public void testExample() {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(7, s.solution(this.params)[0]);
    }

    @Test
    public void testSimple2() {
        int[] A = {100000, 100000, 100000, 100, 100000, 100000, 100000};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(100, s.solution(this.params)[0]);

    }

    @Test
    public void testAdvanced() {
        int[] A = {874385, 983983, 983983, 888832, 888832, 989, 874385};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(989, s.solution(this.params)[0]);

    }

    @Test
    public void testMissingOddOccNumber() {
        int[] A = {10, 20, 35, 47, 49, 100, 2000, 10, 20, 35, 47, 49, 100, 2000, 0};
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(0, s.solution(this.params)[0]);

    }

    @Test
    public void testPerformance() {
        int size = 1000000-2;
        int[] A = new int [size + 1];
        A[0] = 50;
        for (int i = 1; i <= size / 2 ; i++) {
                A[i] = i;
                A[i+size/2] = i;

        }
        this.params = this.paramsBuilder
                .setFirstArray(A).build();

        Assert.assertEquals(50, s.solution(this.params)[0]);

    }

}
