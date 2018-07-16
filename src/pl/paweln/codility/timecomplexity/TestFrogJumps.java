package pl.paweln.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Test;

public class TestFrogJumps {

    @Test
    public void testSimple() {
        int x = 10, y = 85, d = 30;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(3, ret);
    }

    @Test
    public void testLong() {

        int x = 100, y = 100000000, d = 1;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(99999900, ret);
    }

    @Test
    public void testEquality() {
        int x = 250, y = 250, d = 1;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(0, ret);
    }

    @Test
    public void testOneLeap() {
        int x = 250, y = 300, d = 60;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testExactlyOneLeap() {
        int x = 250, y = 300, d = 50;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testOverOneLeap() {
        int x = 250, y = 300, d = 40;
        FrogJump fj = new FrogJump();
        int ret = fj.solution(x, y, d);
        Assert.assertEquals(2, ret);
    }
}






