package pl.paweln.codility.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class NestingTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.STACKS_AND_QUEUES_NESTING);

    private CodilitySolution solution;

    @Before
    public void setUp() {
        this.solution = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExampleOK() {
        String s = "(()(())())";
        Assert.assertEquals(1, solution.solution(s));
    }

    @Test
    public void testExampleNotOK() {
        String s = "(()(())()";
        Assert.assertEquals(0, solution.solution(s));
    }

    @Test
    public void testExampleNotOKOnlyOpen() {
        String s = "((((((((((((";
        Assert.assertEquals(0, solution.solution(s));
    }

    @Test
    public void testExampleNotOKOnlyClosed() {
        String s = ")))))))";
        Assert.assertEquals(0, solution.solution(s));
    }

    @Test
    public void testExampleOKEmpty() {
        String s = "";
        Assert.assertEquals(1, solution.solution(s));
    }

    @Test
    public void testExampleOKPerformance() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            buffer.append(Nesting.BRACKET_OPEN);
        }
        for (int i = 0; i < 500000; i++) {
            buffer.append(Nesting.BRACKET_CLOSE);
        }
        Assert.assertEquals(1, solution.solution(buffer.toString()));
    }
    
}
