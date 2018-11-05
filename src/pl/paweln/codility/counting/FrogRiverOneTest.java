package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.CodilitySolutionFactory;

public class FrogRiverOneTest {
    private final CodilitySolutionFactory solutionFactory
            = new CodilitySolutionFactory (CodilitySolutionFactory.TaskType.COUNTING_FROG_RIVER_ONE);

    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getDefaultSolution();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;

        Assert.assertEquals(6, this.s.solution(A, 5));
    }

    @Test
    public void testSolutionSingleValue() {
        int[] A = new int[] {1};
        Assert.assertEquals(0, this.s.solution(A, 1));
    }

    @Test
    public void testSolutionMaxValues10position() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }
        Assert.assertEquals(9, this.s.solution(A, 10));
    }
    @Test
    public void testSolutionMaxValuesMaxPosition() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }
        Assert.assertEquals(99999, this.s.solution(A, A.length));
    }
}
