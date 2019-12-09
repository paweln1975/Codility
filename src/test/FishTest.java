package test;

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
    public void testExample() {

        int[] A = new int[] {4, 3, 2, 1, 5};
        int[] B = new int[] {0, 1, 0, 0, 0};
        Assert.assertEquals(2, solution.solution(A, B));
    }

    @Test
    public void testSimple1() {

        int[] A = new int[] {1, 2, 3};
        int[] B = new int[] {1, 1, 0};
        Assert.assertEquals(1, solution.solution(A, B));
    }

    @Test
    public void testSimple2() {

        int[] A = new int[] {1, 5, 4, 2, 3};
        int[] B = new int[] {0, 1, 0, 1, 0};
        Assert.assertEquals(2, solution.solution(A, B));
    }

    @Test
    public void testSimple3() {

        int[] A = new int[] {1, 5, 4, 2, 3};
        int[] B = new int[] {1, 0, 1, 0, 1};
        Assert.assertEquals(3, solution.solution(A, B));
    }

    @Test
    public void testSimple4() {

        int[] A = new int[] {1, 2};
        int[] B = new int[] {1, 0};
        Assert.assertEquals(1, solution.solution(A, B));
    }

    @Test
    public void testSimple5() {

        int[] A = new int[] {1, 2};
        int[] B = new int[] {0, 0};
        Assert.assertEquals(2, solution.solution(A, B));
    }

    @Test
    public void testSimple6() {

        int[] A = new int[] {1, 2};
        int[] B = new int[] {1, 1};
        Assert.assertEquals(2, solution.solution(A, B));
    }

    @Test
    public void testSimple7() {

        int[] A = new int[] {1, 2};
        int[] B = new int[] {0, 1};
        Assert.assertEquals(2, solution.solution(A, B));
    }

    @Test
    public void testSimple8() {

        int[] A = new int[] {1, 2, 3, 4, 5};
        int[] B = new int[] {1, 1, 1, 1, 0};
        Assert.assertEquals(1, solution.solution(A, B));
    }

    @Test
    public void testSimple9() {

        int[] A = new int[] {10, 2, 3, 4, 5, 6, 11, 12, 13};
        int[] B = new int[] {1, 1, 1, 0, 0, 0, 0, 0, 0};
        Assert.assertEquals(3, solution.solution(A, B));
    }

    @Test
    public void testSimple10() {

        int[] A = new int[] {8, 6, 5, 3, 2, 4, 7};
        int[] B = new int[] {1, 1, 1, 1, 1, 0, 0};
        Assert.assertEquals(1, solution.solution(A, B));
    }
}
