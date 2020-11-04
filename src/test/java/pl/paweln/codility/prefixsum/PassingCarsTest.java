package pl.paweln.codility.prefixsum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class PassingCarsTest {

    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.PREFIX_SUMS_PASSING_CARS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[5];
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(5, result);
    }

    @Test
    public void testMaxNumberOfCarsAllEast() {
        int[] A = new int[100000];
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(0, result);
    }

    @Test
    public void testMaxNumberOfCarsLastWest() {
        int[] A = new int[100000];
        A[A.length - 1] = 1;

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int result = this.s.solution(this.params)[0];

        Assert.assertEquals(A.length-1, result);
    }
}
