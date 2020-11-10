package pl.paweln.codility.euclidean;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class ChocolatesByNumbersTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution codilitySolution;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.EUCLIDEAN_CHOCOLATES_BY_NUMBERS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int N = 10;
        int D = 4;
        int exp_eaten_choco = 5;

        this.params = this.paramsBuilder
                .setN(N)
                .setD(D).build();

        int result = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Basic example 10, 4", exp_eaten_choco, result);
    }

    @Test
    public void testSmall() {
        int N = 1;
        int D = 1;
        int exp_eaten_choco = 1;

        this.params = this.paramsBuilder
                .setN(N)
                .setD(D).build();

        int result = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Small example 1, 1", exp_eaten_choco, result);
    }

    @Test
    public void testMedium() {
        int N = 947853;
        int D = 4453;
        int exp_eaten_choco = 947853;

        this.params = this.paramsBuilder
                .setN(N)
                .setD(D).build();

        int result = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Small example 1, 1", exp_eaten_choco, result);
    }

    @Test
    public void testExtreme() {
        final int max = 1000000000;
        int D = 1;
        int exp_eaten_choco = 1000000000;

        this.params = this.paramsBuilder
                .setN(max)
                .setD(D).build();

        int result = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Basic example 1 000 000 000, 1", exp_eaten_choco, result);


        D = max;
        exp_eaten_choco = 1;

        this.params = this.paramsBuilder
                .setN(max)
                .setD(D).build();

        result = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Basic example 1 000 000 000, 1 000 000 000", exp_eaten_choco, result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationOutOfScopeN() {
        final int max = 1000000000;
        int N = max+1;
        int D = 1;

        this.params = this.paramsBuilder
                .setN(N)
                .setD(D).build();

        this.codilitySolution.solution(this.params);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationOutOfScopeD() {
        final int max = 1000000000;
        int D = max + 1;

        this.params = this.paramsBuilder
                .setN(max)
                .setD(D).build();

        this.codilitySolution.solution(this.params);
    }


}
