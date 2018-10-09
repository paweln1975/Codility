package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.timecomplexity.TapeEquilibrium;



public class TapeEquilibriumTest {
    private TapeEquilibrium t;
    @Before
    public void setUp() {
        t = new TapeEquilibrium();
    }

    @Test
    public void solutionSimple() {
        int[] tab = {3,1,2,4,3};
        Assert.assertEquals(1, t.solution(tab));
    }

    @Test
    public void solutionTwoElem() {
        int[] tab = {1,10};
        Assert.assertEquals(9, t.solution(tab));
    }

    @Test
    public void solution100000() {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = -1000;
        }
        Assert.assertEquals(0, t.solution(tab));
    }
}