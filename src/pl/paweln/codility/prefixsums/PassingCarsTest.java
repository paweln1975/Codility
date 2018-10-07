package pl.paweln.codility.prefixsums;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class PassingCarsTest {

    private SolutionFactory solutionFactory = new PassingCarsFactory();
    private CodilitySolution codilitySolution;

    @Before
    public void setUp() {

        this.codilitySolution = this.solutionFactory.createSolution();
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


        Assert.assertEquals(5, this.codilitySolution.solution(A));
    }

    @Test
    public void testMaxNumberOfCarsAllEast() {
        int[] A = new int[100000];
        Assert.assertEquals(0, this.codilitySolution.solution(A));
    }

    @Test
    public void testMaxNumberOfCarsLastWest() {
        int[] A = new int[100000];
        A[A.length - 1] = 1;
        Assert.assertEquals(A.length-1, this.codilitySolution.solution(A));
    }
}
