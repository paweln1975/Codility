package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.counting.PermCheck;


public class PermCheckTest {
    private PermCheck pc;
        @Before
        public void setUp() {
            this.pc = new PermCheck();
        }

    @Test
        public void solutionSimple() {
        int[] tab = {4, 1, 2, 3};
        Assert.assertEquals(1, pc.solution(tab));
        Assert.assertEquals(1, pc.solution2(tab));

        tab = new int[]{4, 1, 2};
        Assert.assertEquals(0, pc.solution(tab));
        Assert.assertEquals(0, pc.solution2(tab));
    }

    @Test
    public void solutionMaxNumbers() {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = i + 1;
        }

        Assert.assertEquals(1, pc.solution(tab));
        Assert.assertEquals(1, pc.solution2(tab));

        tab[99999] = 100001;
        Assert.assertEquals(0, pc.solution(tab));
        Assert.assertEquals(0, pc.solution2(tab));
    }

    @Test
    public void solutionEmpty() {
        int[] tab = {};

        Assert.assertEquals(0, pc.solution(tab));
        Assert.assertEquals(0, pc.solution2(tab));

    }

    @Test
    public void solutionSingle() {
        int[] tab = {1};
        Assert.assertEquals(1, pc.solution(tab));
        Assert.assertEquals(1, pc.solution2(tab));

        tab[0] = 2;

        Assert.assertEquals(0, pc.solution(tab));
        Assert.assertEquals(0, pc.solution2(tab));
    }
}