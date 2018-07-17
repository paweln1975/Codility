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
    public void solution() throws Exception {
        int[] tab = {3,1,2,4,3};
        Assert.assertEquals(1, t.solution(tab));
    }

}