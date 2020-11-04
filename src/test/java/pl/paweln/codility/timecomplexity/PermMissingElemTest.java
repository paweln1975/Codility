package pl.paweln.codility.timecomplexity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.*;

public class PermMissingElemTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.TIME_COMPLEXITY_PERM_MISSING_ELEM);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }



    @Test
    public void testEmpty() {
        int [] tab = {};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);

    }

    @Test
    public void testOneElementArray() {
        int [] tab = {1};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(2, actualValue);

        tab = new int[] {2};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        actualValue = this.s.solution(this.params)[0];

        Assert.assertEquals(1, actualValue);
    }

    @Test
    public void testMultipleElementArray() {
        int [] tab = {1, 5, 7, 8, 9, 2, 3, 6};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(4, actualValue);

    }

    @Test
    public void testMultipleElementArrayMissingFirst() {
        int [] tab = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(1, actualValue);

    }

    @Test
    public void testMultipleElementArrayMissingLast() {
        int [] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];
        Assert.assertEquals(16, actualValue);
    }

    @Test
    public void test100000() {
        final int N = 100000;
        int [] tab = new int [N];

        for (int i = 0; i < N ; i++) {
            tab[i] = i+1;
        }
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        int actualValue = this.s.solution(this.params)[0];

        Assert.assertEquals(N + 1, actualValue);


        // replace one element
        tab[5000] = N + 1;

        actualValue = this.s.solution(this.params)[0];

        Assert.assertEquals(5001, actualValue);

    }
}
