package pl.paweln.codility.prefixsums;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassingCarsTest {
    private PassingCars pc;
    @Before
    public void setUp() {
        this.pc = new PassingCars();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[5];
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;


        Assert.assertEquals(5, this.pc.solution(A));
    }

    @Test
    public void testMaxNumberOfCarsAllEast() {
        int[] A = new int[100000];
        Assert.assertEquals(0, this.pc.solution(A));
    }

    @Test
    public void testMaxNumberOfCarsLastWest() {
        int[] A = new int[100000];
        A[A.length - 1] = 1;
        Assert.assertEquals(A.length-1, this.pc.solution(A));
    }
}
