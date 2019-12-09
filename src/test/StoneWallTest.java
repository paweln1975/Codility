package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class StoneWallTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.STACKS_AND_QUEUES_STONE_WALL);

    private CodilitySolution solution;

    @Before
    public void setUp() {
        this.solution = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExample() {
        int[] H = new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8};
        Assert.assertEquals(7, solution.solution(H));
    }
}
