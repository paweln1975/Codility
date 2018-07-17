package pl.paweln.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElemTest {
    @Test
    public void testEmpty() {
        PermMissingElem t = new PermMissingElem();
        int [] tab = {};
        Assert.assertEquals(1, t.solution(tab));
        Assert.assertEquals(1, t.solution2(tab));
        Assert.assertEquals(1, t.solution3(tab));

    }

    @Test
    public void testOneElementArray() {
        PermMissingElem t = new PermMissingElem();
        int [] tab = {1};
        Assert.assertEquals(2, t.solution(tab));
        Assert.assertEquals(2, t.solution2(tab));
        Assert.assertEquals(2, t.solution3(tab));

        tab = new int[] {2};
        Assert.assertEquals(1, t.solution(tab));
        Assert.assertEquals(1, t.solution2(tab));
        Assert.assertEquals(1, t.solution3(tab));
    }

    @Test
    public void testMultipleElementArray() {
        PermMissingElem t = new PermMissingElem();
        int [] tab = {1, 5, 7, 8, 9, 2, 3, 6};
        Assert.assertEquals(4, t.solution(tab));
        Assert.assertEquals(4, t.solution2(tab));
        Assert.assertEquals(4, t.solution3(tab));
    }

    @Test
    public void testMultipleElementArrayMissingFirst() {
        PermMissingElem t = new PermMissingElem();
        int [] tab = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertEquals(1, t.solution(tab));
        Assert.assertEquals(1, t.solution2(tab));
        Assert.assertEquals(1, t.solution3(tab));
    }

    @Test
    public void testMultipleElementArrayMissingLast() {
        PermMissingElem t = new PermMissingElem();
        int [] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertEquals(16, t.solution(tab));
        Assert.assertEquals(16, t.solution2(tab));
        Assert.assertEquals(16, t.solution3(tab));
    }

    @Test
    public void test100000() {
        PermMissingElem t = new PermMissingElem();
        final int N = 100000;
        int [] tab = new int [N];

        for (int i = 0; i < N ; i++) {
            tab[i] = i+1;
        }
        Assert.assertEquals(N + 1, t.solution(tab));
        Assert.assertEquals(N + 1, t.solution2(tab));
        Assert.assertEquals(N + 1, t.solution3(tab));

        // replace one element
        tab[5000] = N + 1;
        Assert.assertEquals(5001, t.solution(tab));
        Assert.assertEquals(5001, t.solution2(tab));
        Assert.assertEquals(5001, t.solution3(tab));
    }
}
