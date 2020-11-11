package pl.paweln.codility.counting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class FrogRiverOneTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.COUNTING_FROG_RIVER_ONE);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] tabA = new int[] {1, 3, 1, 4, 2, 3, 5, 4};

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setX(5).build();

        Assert.assertEquals(6, this.codilitySolution.solution(this.params)[0]);
    }

    @Test
    public void testSingleValue() {
        int[] tabA = new int[] {1};
        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setX(1).build();

        Assert.assertEquals(0, this.codilitySolution.solution(this.params)[0]);

    }

    @Test
    public void testMaxValues10position() {
        int[] tabA = new int[100000];
        for (int i = 0; i < tabA.length; i++) {
            tabA[i] = i+1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setX(10).build();

        Assert.assertEquals(9, this.codilitySolution.solution(this.params)[0]);
    }
    @Test
    public void testMaxValuesMaxPosition() {
        int[] tabA = new int[100000];
        for (int i = 0; i < tabA.length; i++) {
            tabA[i] = i+1;
        }

        this.params = this.paramsBuilder
                .setFirstArray(tabA)
                .setX(tabA.length).build();

        Assert.assertEquals(99999, this.codilitySolution.solution(this.params)[0]);
    }
}
