package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class FrogRiverOneTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private Solution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_FROG_RIVER_ONE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSolutionExample() {
        int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setX(5).build();

        Assert.assertEquals(6, this.s.solution(this.params)[0]);
    }

    @Test
    public void testSolutionSingleValue() {
        int[] A = new int[] {1};
        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setX(1).build();

        Assert.assertEquals(0, this.s.solution(this.params)[0]);

    }

    @Test
    public void testSolutionMaxValues10position() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setX(10).build();

        Assert.assertEquals(9, this.s.solution(this.params)[0]);
    }
    @Test
    public void testSolutionMaxValuesMaxPosition() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i+1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(A)
                .setX(A.length).build();

        Assert.assertEquals(99999, this.s.solution(this.params)[0]);
    }
}
