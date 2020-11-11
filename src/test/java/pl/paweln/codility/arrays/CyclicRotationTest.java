package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class CyclicRotationTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.ARRAYS_CYCLIC_ROTATION);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testEmpty() {
        int[] tabA = {};
        int[] resultExpected = {};
        int k = 3;

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(k)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShiftExample() {
        int[] tabA = { 3, 8, 9, 7, 6 };
        int[] resultExpected = {9, 7, 6, 3, 8};
        int k = 3;

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(k)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShiftNone() {
        int[] tabA = { 1, 3, 4, 6 };
        int[] resultExpected = Arrays.copyOf(tabA, tabA.length);

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(tabA.length)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);

    }

    @Test
    public void testShift1() {
        int[] tabA = { 1, 3, 4, 6 };
        int[] resultExpected = { 6, 1, 3, 4 };

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(1)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShift35() {
        int[] tabA = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] resultExpected = { 2, 10, 15, 1, 3, 4, 6, 3 };

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(35)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShift2() {
        int[] tabA = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] resultExpected = { 10, 15, 1, 3, 4, 6, 3, 2 };

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(2)
                .build();

        int[] result = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationInvalidK() {
        int[] tabA = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int k = 150;

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(k)
                .build();

        this.codilitySolution.solution(this.params);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationTooBigTable() {
        int[] tabA = new int[200];
        int k = 1;

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setK(k)
                .build();

        this.codilitySolution.solution(this.params);
    }

}
