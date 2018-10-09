package pl.paweln.codility.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class CyclicRotationTest {
    private SolutionFactory solutionFactory = new CyclicRotationFactory();
    private CodilitySolution<Integer[]> s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.createSolution();
    }

    @After
    public void tearDown() {
    }
    @Test
    public void testShiftNone() {
        int[] A = { 1, 3, 4, 6 };
        int[] result = new int[A.length];

        Integer[] resultInteger = this.s.solution(A, A.length);
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

        Integer[] resultInteger = this.s.solution(A, 1);
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

        Integer[] resultInteger = this.s.solution(A, 35);
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

        Integer[] resultInteger = this.s.solution(A, 2);
        for (int i = 0; i < A.length; i++) {
            result[i] = resultInteger[i];
        }

        Assert.assertArrayEquals(B, result);

    }

}
