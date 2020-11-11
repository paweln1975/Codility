package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.paweln.codility.core.*;

public class OddOccurrencesInArrayTest {

    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.ARRAYS_ODD_OCCURRENCES_IN_ARRAY);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSingle() {
        int[] tabA = {4};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(4, codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSimple() {
        int[] tabA = {4, 5, 6, 7, 6, 5, 4};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(7, codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testExample() {
        int[] tabA = {9, 3, 9, 3, 9, 7, 9};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(7, codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSimple2() {
        int[] tabA = {100000, 100000, 100000, 100, 100000, 100000, 100000};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(100, codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testAdvanced() {
        int[] tabA = {874385, 983983, 983983, 888832, 888832, 989, 874385};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(989, codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testMissingOddOccNumber() {
        int[] tabA = {10, 20, 35, 47, 49, 100, 2000, 10, 20, 35, 47, 49, 100, 2000, 0};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(0, codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testPerformance() {
        int size = 1000000-2;
        int[] tabA = new int [size + 1];
        tabA[0] = 50;
        for (int i = 1; i <= size / 2 ; i++) {
                tabA[i] = i;
                tabA[i+size/2] = i;

        }
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();

        Assert.assertEquals(50, codilitySolution.solution(this.params)[0]);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationArr() {
        int [] tabA = new int[0];
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();
        this.codilitySolution.solution(this.params);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationArrOddSize() {
        int [] tabA = new int[] {2, 3};
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();
        this.codilitySolution.solution(this.params);
    }


}
