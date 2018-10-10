package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.timecomplexity.TapeEquilibriumFactory;


public class TapeEquilibriumTest {
    private final SolutionFactory solutionFactory = new TapeEquilibriumFactory();
    private CodilitySolution codilitySolution;

    @Before
    public void setUp() {
        this.codilitySolution = this.solutionFactory.createSolution();
    }

    @Test
    public void solutionSimple() {
        int[] tab = {3,1,2,4,3};
        Assert.assertEquals(1, this.codilitySolution.solution(tab));
    }

    @Test
    public void solutionTwoElem() {
        int[] tab = {1,10};
        Assert.assertEquals(9, this.codilitySolution.solution(tab));
    }

    @Test
    public void solution100000() {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = -1000;
        }
        Assert.assertEquals(0, this.codilitySolution.solution(tab));
    }
}