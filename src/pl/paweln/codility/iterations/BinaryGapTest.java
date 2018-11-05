package pl.paweln.codility.iterations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class BinaryGapTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.ITERATION_BINARY_GAP);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void test0() {
        int n = 0;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1() {
        int n = 1;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test2() {
        int n = 2;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test5() {
        int n = 5;
        Assert.assertEquals(1, s.solution(n));
    }

    @Test
    public void test15() {
        int n = 15;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test32() {
        int n = 32;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1041() {
        int n = 1041;
        Assert.assertEquals(5, s.solution(n));
    }

    @Test
    public void test53456() {
        int n = 53456;
        Assert.assertEquals(4, s.solution(n));
    }

    @Test
    public void test2147483647() {
        int n = 2147483647;
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test328() {
        int n = 328;
        Assert.assertEquals(2, s.solution(n));
    }
}
