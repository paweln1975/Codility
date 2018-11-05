package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;


public class PermCheckTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.COUNTING_PERM_CHECK);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void solutionSimple() {
        int[] tab = {4, 1, 2, 3};
        Assert.assertEquals(1, this.s.solution(tab));

        tab = new int[]{4, 1, 2};
        Assert.assertEquals(0, this.s.solution(tab));
    }

    @Test
    public void solutionMaxNumbers() {
        int[] tab = new int[100000];
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = i + 1;
        }

        Assert.assertEquals(1, this.s.solution(tab));

        tab[99999] = 100001;
        Assert.assertEquals(0, this.s.solution(tab));

    }

    @Test
    public void solutionEmpty() {
        int[] tab = {};

        Assert.assertEquals(0, this.s.solution(tab));

    }

    @Test
    public void solutionSingle() {
        int[] tab = {1};
        Assert.assertEquals(1, this.s.solution(tab));

        tab[0] = 2;

        Assert.assertEquals(0, this.s.solution(tab));

    }
}