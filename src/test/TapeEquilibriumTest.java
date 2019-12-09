package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;


public class TapeEquilibriumTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.TIME_COMPLEXITY_TAPE_EQUILIBRIUM);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void solutionSimple() {
        int[] tab = {3,1,2,4,3};
        Assert.assertEquals(1, this.s.solution(tab));
    }

    @Test
    public void solutionTwoElem() {
        int[] tab = {1,10};
        Assert.assertEquals(9, this.s.solution(tab));
    }

    @Test
    public void solution100000() {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = -1000;
        }
        Assert.assertEquals(0, this.s.solution(tab));
    }
}