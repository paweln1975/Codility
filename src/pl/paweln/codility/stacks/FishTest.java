package pl.paweln.codility.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class FishTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.STACKS_AND_QUEUES_FISH);

    private CodilitySolution solution;

    @Before
    public void setUp() {
        this.solution = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testExampleOK() {

        int[] A = new int[] {4, 3, 2, 1, 5};
        int[] B = new int[] {0, 1, 0, 0, 0};
        Assert.assertEquals(2, solution.solution(A, B));
    }
}
