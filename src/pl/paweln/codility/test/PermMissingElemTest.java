package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.timecomplexity.PermMissingElemFactory;

public class PermMissingElemTest {
    private final SolutionFactory solutionFactory = new PermMissingElemFactory();
    private CodilitySolution codilitySolution;

    @Before
    public void setUp() {
        this.codilitySolution = this.solutionFactory.createSolution();
    }
    @Test
    public void testEmpty() {
        int [] tab = {};
        Assert.assertEquals(1, this.codilitySolution.solution(tab));

    }

    @Test
    public void testOneElementArray() {

        int [] tab = {1};
        Assert.assertEquals(2, this.codilitySolution.solution(tab));

        tab = new int[] {2};
        Assert.assertEquals(1, this.codilitySolution.solution(tab));
    }

    @Test
    public void testMultipleElementArray() {

        int [] tab = {1, 5, 7, 8, 9, 2, 3, 6};
        Assert.assertEquals(4, this.codilitySolution.solution(tab));

    }

    @Test
    public void testMultipleElementArrayMissingFirst() {

        int [] tab = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertEquals(1, this.codilitySolution.solution(tab));

    }

    @Test
    public void testMultipleElementArrayMissingLast() {
        int [] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Assert.assertEquals(16, this.codilitySolution.solution(tab));
    }

    @Test
    public void test100000() {

        final int N = 100000;
        int [] tab = new int [N];

        for (int i = 0; i < N ; i++) {
            tab[i] = i+1;
        }
        Assert.assertEquals(N + 1, this.codilitySolution.solution(tab));


        // replace one element
        tab[5000] = N + 1;
        Assert.assertEquals(5001, this.codilitySolution.solution(tab));

    }
}
