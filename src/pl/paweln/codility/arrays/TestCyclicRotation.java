package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestCyclicRotation {
    @Test
    public void testShiftNone() {
        int[] A = { 1, 3, 4, 6 };
        CyclicRotation cr = new CyclicRotation();

        Assert.assertArrayEquals(A, cr.solution(A, A.length));

    }

    @Test
    public void testShift1() {
        int[] A = { 1, 3, 4, 6 };
        int[] B = { 6, 1, 3, 4 };
        CyclicRotation cr = new CyclicRotation();

        Assert.assertArrayEquals(B, cr.solution(A, 1));

    }

    @Test
    public void testShift15() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] B = { 2, 10, 15, 1, 3, 4, 6, 3 };
        CyclicRotation cr = new CyclicRotation();

        Assert.assertArrayEquals(B, cr.solution(A, 35));

    }

    @Test
    public void testShift2() {
        int[] A = { 1, 3, 4, 6, 3, 2, 10, 15 };
        int[] B = { 10, 15, 1, 3, 4, 6, 3, 2 };
        CyclicRotation cr = new CyclicRotation();

        Assert.assertArrayEquals(B, cr.solution(A, 2));

    }

}
