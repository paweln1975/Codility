package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class BracketsTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.STACKS_AND_QUEUES_BRACKETS);

    private CodilitySolution solution;

    @Before
    public void setUp() {
        this.solution = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExampleOK() {

        String s = "{[()()]}";
        Assert.assertEquals(1, solution.solution(s));
    }

    @Test
    public void testExampleNotOK() {

        String s = "([)()]";
        Assert.assertEquals(0, solution.solution(s));
    }

    @Test
    public void testEmpty() {

        String s = "";
        Assert.assertEquals(1, solution.solution(s));
    }

    @Test
    public void testLargePositive() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append('(');
        }
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append(')');
        }
        Assert.assertEquals(1, solution.solution(stringBuilder.toString()));
    }

    @Test
    public void testLargeNegative() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 99999 ; i++) {
            stringBuilder.append('[');
        }
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append(']');
        }
        Assert.assertEquals(0, solution.solution(stringBuilder.toString()));
    }

}
