package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class MissingIntegerTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_MISSING_INTEGER);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] testArr = new int[] {1, 3, 6, 4, 1, 2};

        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();

        Assert.assertEquals(5, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testNegatives() {
        int[] testArr = new int[] {-1, -3, -6, -4, -1, -2};

        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();

        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSingleZero() {
        int[] testArr = new int[] {0};

        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();

        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testSingleValue() {
        int[] testArr = new int[] {0};
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

        testArr = new int[] {2};
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);

        testArr = new int[] {1};
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(2, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testMaxCapacity() {
        int[] testArr = new int[100000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = 99999-i;
        }
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(100000, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSimpleGrowing() {
        int[] testArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(8, this.codilitySolution.solution(this.params)[0]);

        testArr = new int[] {2, 3, 4, 5, 6, 7};
        this.params = this.paramsBuilder
                .setFirstArray(testArr).build();
        Assert.assertEquals(1, this.codilitySolution.solution(this.params)[0]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationArr() {
        int[] tabA = new int[0];
        this.params = this.paramsBuilder
                .setFirstArray(tabA).build();
        this.codilitySolution.solution(this.params);
    }
}
