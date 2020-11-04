package pl.paweln.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class FrogJumpsTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.TIME_COMPLEXITY_FROG_JUMP);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testSimple() {
        int x = 10, y = 85, d = 30;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(3, ret);
    }

    @Test
    public void testLong() {
        int x = 100, y = 100000000, d = 1;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(99999900, ret);
    }

    @Test
    public void testEquality() {
        int x = 250, y = 250, d = 1;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(0, ret);
    }

    @Test
    public void testOneLeap() {
        int x = 250, y = 300, d = 60;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testExactlyOneLeap() {
        int x = 250, y = 300, d = 50;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(1, ret);
    }

    @Test
    public void testOverOneLeap() {
        int x = 250, y = 300, d = 40;
        this.params = this.paramsBuilder
                .setX(x)
                .setY(y)
                .setD(d).build();
        int ret = s.solution(this.params)[0];
        Assert.assertEquals(2, ret);
    }
}






