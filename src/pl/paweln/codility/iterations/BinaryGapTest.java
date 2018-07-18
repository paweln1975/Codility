package pl.paweln.codility.iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGapTest {
    @Test
    public void test0() {
        int n = 0;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1() {
        int n = 1;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test2() {
        int n = 2;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test5() {
        int n = 5;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(1, s.solution(n));
    }

    @Test
    public void test15() {
        int n = 15;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test32() {
        int n = 32;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1041() {
        int n = 1041;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(5, s.solution(n));
    }

    @Test
    public void test53456() {
        int n = 53456;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(4, s.solution(n));
    }

    @Test
    public void test2147483647() {
        int n = 2147483647;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test328() {
        int n = 328;
        BinaryGap s = new BinaryGap();
        Assert.assertEquals(2, s.solution(n));
    }
}
