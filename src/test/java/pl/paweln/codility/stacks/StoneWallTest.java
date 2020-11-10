package pl.paweln.codility.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class StoneWallTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution codilitySolution;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.STACKS_STONE_WALL);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int[] tab = new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8};
        SolutionInputParams params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.codilitySolution.solution(params)[0];
        Assert.assertEquals(7, actualValue);
    }
}
