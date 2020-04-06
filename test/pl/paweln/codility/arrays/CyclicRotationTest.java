package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

import java.util.Arrays;

public class CyclicRotationTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private Solution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.ARRAYS_CYCLIC_ROTATION);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testShiftNone() {
        int[] A = { 1, 3, 4, 6 };
        int[] resultExpected = Arrays.copyOf(A, A.length);

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setK(A.length)
                .build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);

    }

    @Test
    public void testShift1() {
        int[] A = { 1, 3, 4, 6 };
        int[] resultExpected = { 6, 1, 3, 4 };

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setK(1)
                .build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShift35() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] resultExpected = { 2, 10, 15, 1, 3, 4, 6, 3 };

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setK(35)
                .build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);
    }

    @Test
    public void testShift2() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] resultExpected = { 10, 15, 1, 3, 4, 6, 3, 2 };

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setK(2)
                .build();

        int[] result = this.s.solution(this.params);

        Assert.assertArrayEquals(resultExpected, result);

    }

}
