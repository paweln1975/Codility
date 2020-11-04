package pl.paweln.codility.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class NumberOfDiscIntersectionsTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.SORTING_NUMBER_OF_DISCS_INTERSECTIONS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] A = {1, 5, 2, 1, 4, 0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(11, actualValue);
    }

    @Test
    public void testSimple() {
        int[] A = {1, 0, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(3, actualValue);
    }

    @Test
    public void testAllCovering() {
        int size = 10;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(45, actualValue);
    }

    @Test
    public void testMaxCapacity() {
        int size = 10000;
        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(-1, actualValue);
    }

    @Test
    public void testOverflow() {
        int[] A = new int[] {1, 2147483647, 0};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(2, actualValue);
    }
}
