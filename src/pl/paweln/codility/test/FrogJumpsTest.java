package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.timecomplexity.FrogJumpFactory;

public class FrogJumpsTest {
    private final SolutionFactory solutionFactory = new FrogJumpFactory();
    private CodilitySolution fj;

    @Before
    public void setUp() {
        this.fj = this.solutionFactory.createSolution();
    }

    @Test
    public void testSimple() {
        int x = 10, y = 85, d = 30;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(3, ret);
    }

    @Test
    public void testLong() {

        int x = 100, y = 100000000, d = 1;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(99999900, ret);
    }

    @Test
    public void testEquality() {
        int x = 250, y = 250, d = 1;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(0, ret);
    }

    @Test
    public void testOneLeap() {
        int x = 250, y = 300, d = 60;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testExactlyOneLeap() {
        int x = 250, y = 300, d = 50;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testOverOneLeap() {
        int x = 250, y = 300, d = 40;

        int ret = fj.solution(x, y, d);
        Assert.assertEquals(2, ret);
    }
}






