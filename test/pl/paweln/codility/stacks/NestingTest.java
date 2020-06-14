package pl.paweln.codility.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class NestingTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.STACKS_NESTING);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExampleOK() {
        String s = "(()(())())";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testExampleNotOK() {
        String s = "(()(())()";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testExampleNotOKOnlyOpen() {
        String s = "((((((((((((";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testExampleNotOKOnlyClosed() {
        String s = ")))))))";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(0, actualValue);
    }

    @Test
    public void testExampleOKEmpty() {
        String s = "";
        this.params = this.paramsBuilder.setStringValue(s).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testExampleOKPerformance() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            buffer.append(Nesting.BRACKET_OPEN);
        }
        for (int i = 0; i < 500000; i++) {
            buffer.append(Nesting.BRACKET_CLOSE);
        }
        this.params = this.paramsBuilder.setStringValue(buffer.toString()).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);
    }
    
}
