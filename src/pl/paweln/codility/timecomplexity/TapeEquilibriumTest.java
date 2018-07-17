package pl.paweln.codility.timecomplexity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TapeEquilibriumTest {
    TapeEquilibrium t;
    @Before
    public void setUp() throws Exception {
        t = new TapeEquilibrium();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solutionSimple() throws Exception {
        int[] tab = {3,1,2,4,3};
        Assert.assertEquals(1, t.solution(tab));
    }

    @Test
    public void solutionTwoElem() throws Exception {
        int[] tab = {1,10};
        Assert.assertEquals(9, t.solution(tab));
    }

    @Test
    public void solution100000() throws Exception {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = -1000;
        }
        Assert.assertEquals(0, t.solution(tab));
    }
}