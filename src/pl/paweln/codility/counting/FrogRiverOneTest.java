package pl.paweln.codility.counting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrogRiverOneTest {
    private FrogRiverOne fgo;
    @Before
    public void setUp() {
        this.fgo = new FrogRiverOne();
    }

    @After
    public void tearDown() {
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

        Assert.assertEquals(6, this.fgo.solution(5, A));
    }

    @Test
    public void testSolutionSingleValue() {
        int[] A = new int[] {1};
        Assert.assertEquals(0, this.fgo.solution(1, A));
    }

    @Test
    public void testSolutionMaxValues10position() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }
        Assert.assertEquals(9, this.fgo.solution(10, A));
    }
    @Test
    public void testSolutionMaxValuesMaxPosition() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }
        Assert.assertEquals(99999, this.fgo.solution(A.length, A));
    }
}
