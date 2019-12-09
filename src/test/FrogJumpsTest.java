package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class FrogJumpsTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.TIME_COMPLEXITY_FROG_JUMP);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSimple() {
        int x = 10, y = 85, d = 30;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(3, ret);
    }

    @Test
    public void testLong() {

        int x = 100, y = 100000000, d = 1;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(99999900, ret);
    }

    @Test
    public void testEquality() {
        int x = 250, y = 250, d = 1;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(0, ret);
    }

    @Test
    public void testOneLeap() {
        int x = 250, y = 300, d = 60;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testExactlyOneLeap() {
        int x = 250, y = 300, d = 50;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testOverOneLeap() {
        int x = 250, y = 300, d = 40;

        int ret = s.solution(x, y, d);
        Assert.assertEquals(2, ret);
    }
}






