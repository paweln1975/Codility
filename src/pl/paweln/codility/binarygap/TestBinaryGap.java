package pl.paweln.codility.binarygap;

import org.junit.Assert;
import org.junit.Test;

public class TestBinaryGap {
    @Test
    public void test0() {
        int n = 0;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1() {
        int n = 1;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test2() {
        int n = 2;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test5() {
        int n = 5;
        Solution s = new Solution();
        Assert.assertEquals(1, s.solution(n));
    }

    @Test
    public void test15() {
        int n = 15;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test32() {
        int n = 32;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test1041() {
        int n = 1041;
        Solution s = new Solution();
        Assert.assertEquals(5, s.solution(n));
    }

    @Test
    public void test53456() {
        int n = 53456;
        Solution s = new Solution();
        Assert.assertEquals(4, s.solution(n));
    }

    @Test
    public void test2147483647() {
        int n = 2147483647;
        Solution s = new Solution();
        Assert.assertEquals(0, s.solution(n));
    }

    @Test
    public void test328() {
        int n = 328;
        Solution s = new Solution();
        Assert.assertEquals(2, s.solution(n));
    }
}
