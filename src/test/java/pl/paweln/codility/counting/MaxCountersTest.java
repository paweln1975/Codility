package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class MaxCountersTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_MAX_COUNTERS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] tabA = new int[] {3, 4, 4, 6, 1, 4, 4};

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setN(5).build();

        int[] retArr = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(new int[] {3, 2, 2, 4, 2}, retArr);
    }

    @Test
    public void testMaxValues() {
        int[] tabA = new int[100000];

        Arrays.fill(tabA, 100000);
        tabA[tabA.length-1] = 100001;

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setN(100000).build();

        int[] retArr = this.codilitySolution.solution(this.params);

        int[] expArr = new int[100000];
        Arrays.fill(expArr, 99999);

        Assert.assertArrayEquals(expArr, retArr);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationArr() {
        int [] tabA = new int[0];
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();
        this.codilitySolution.solution(this.params);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationKValue() {
        int [] tabA = new int[] {2, 3};
        int n = -10;
        this.params = this.paramsBuilder
                .setFirstArray(tabA).setN(n).build();
        this.codilitySolution.solution(this.params);
    }
}

