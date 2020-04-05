package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class CyclicRotationTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.ARRAYS_CYCLIC_ROTATION);

    private CodilitySolution solution;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        this.solution = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testShiftNone() {
        int[] A = { 1, 3, 4, 6 };
        int[] result = new int[A.length];

        int[] resultInteger = this.solution.solutionTab(A, A.length);
        for (int i = 0; i < A.length; i++) {
            result[i] = resultInteger[i];
        }


        Assert.assertArrayEquals(A, result);

    }

    @Test
    public void testShift1() {
        int[] A = { 1, 3, 4, 6 };
        int[] B = { 6, 1, 3, 4 };

        int[] result = new int[A.length];

        int[] resultInteger = this.solution.solutionTab(A, 1);
        for (int i = 0; i < A.length; i++) {
            result[i] = resultInteger[i];
        }

        Assert.assertArrayEquals(B, result);

    }

    @Test
    public void testShift35() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] B = { 2, 10, 15, 1, 3, 4, 6, 3 };

        int[] result = new int[A.length];

        int[] resultInteger = this.solution.solutionTab(A, 35);
        for (int i = 0; i < A.length; i++) {
            result[i] = resultInteger[i];
        }

        Assert.assertArrayEquals(B, result);

    }

    @Test
    public void testShift2() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] B = { 10, 15, 1, 3, 4, 6, 3, 2 };

        int[] result = new int[A.length];

        int[] resultInteger = this.solution.solutionTab(A, 2);
        for (int i = 0; i < A.length; i++) {
            result[i] = resultInteger[i];
        }

        Assert.assertArrayEquals(B, result);

    }

}