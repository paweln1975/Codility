package pl.paweln.codility.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class BracketsTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {

        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.STACKS_BRACKETS);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExampleOK() {
        String s = "{[()()]}";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];

        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testExampleNotOK() {
        String s = "([)()]";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

    }

    @Test
    public void testEmpty() {
        String s = "";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);

    }

    @Test
    public void testLargePositive() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append('(');
        }
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append(')');
        }
        this.params = this.paramsBuilder.setStringValue(stringBuilder.toString()).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);

    }

    @Test
    public void testLargeNegative() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 99999 ; i++) {
            stringBuilder.append('[');
        }
        for (int i = 0; i < 100000 ; i++) {
            stringBuilder.append(']');
        }
        this.params = this.paramsBuilder.setStringValue(stringBuilder.toString()).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);

    }

}
