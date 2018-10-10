package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.prefixsums.CountDivFactory;

public class CountDivTest {
    private final SolutionFactory solutionFactory = new CountDivFactory();
    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.createSolution();
    }

    @Test
    public void testExample() {
        int A = 6;
        int B = 11;
        int K = 2;
        Assert.assertEquals(3, s.solution(A, B, K));
    }

    @Test
    public void testTheSame1() {
        int A = 10;
        int B = 10;
        int K = 2;
        Assert.assertEquals(1, s.solution(A, B, K));
    }

    @Test
    public void testTheSame2() {
        int A = 13;
        int B = 13;
        int K = 7;
        Assert.assertEquals(0, s.solution(A, B, K));
    }

    @Test
    public void testExtremeValues1() {
        int A = 0;
        int B = 2000000000;
        int K = 2000000000;
        Assert.assertEquals(2, s.solution(A, B, K));
    }

    @Test
    public void testExtremeValues2() {
        int A = 0;
        int B = 2000000000;
        int K = 1;
        Assert.assertEquals(2000000001, s.solution(A, B, K));
    }
}
