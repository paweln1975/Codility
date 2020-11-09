package pl.paweln.codility.euclidean;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class EuclideanSubtractTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution codilitySolution;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setup() {
        this.codilitySolution = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.EUCLIDEAN_SUBTRACT);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int A = 10;
        int B = 15;
        int gcdExpected = 5;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        int gcd = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals("Example 10, 15", gcdExpected, gcd);

        A = 1122;
        B = 867;
        gcdExpected = 51;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        gcd = this.codilitySolution.solution(this.params)[0];
        Assert.assertEquals("Example 1122, 867", gcdExpected, gcd);
    }

    @Test
    public void testTheSame() {
        int A = 10;
        int B = 10;
        int gcdExpected = 10;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        int gcd = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals(gcdExpected, gcd);
    }

    @Test
    public void testExtremeDifference() {
        int A = 5000;
        int B = 1;
        int gcdExpected = 1;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        int gcd = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals(gcdExpected, gcd);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMaxInteger() {
        int A = Integer.MAX_VALUE;
        int B = 1;
        int gcdExpected = 1;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        int gcd = this.codilitySolution.solution(this.params)[0];

        Assert.assertEquals(gcdExpected, gcd);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationNegativeOrZero() {
        int A = 0;
        int B = -10;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        this.codilitySolution.solution(this.params);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidationTooManyIterations() {
        int A = 30002;
        int B = 2;

        this.params = this.paramsBuilder
                .setA(A)
                .setB(B).build();

        this.codilitySolution.solution(this.params);

    }

}
