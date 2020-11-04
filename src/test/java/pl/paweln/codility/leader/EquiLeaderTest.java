package pl.paweln.codility.leader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;


public class EquiLeaderTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.LEADER_EQUILEADER);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int [] A = {4,3,4,4,4,2};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(2, equiLeaders);
    }

    @Test
    public void testSingle() {
        int [] A = {1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(0, equiLeaders);
    }

    @Test
    public void testDouble() {
        int [] A = {1,1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(1, equiLeaders);
    }

    @Test
    public void testTriple() {
        int [] A = {1,1,1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(2, equiLeaders);
    }

    @Test
    public void testPerformanceAllTheSame() {
        int arraySize = 100000;
        int [] A = new int[arraySize];
        Arrays.fill(A, 10);

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(arraySize-1, equiLeaders);
    }

    @Test
    public void testPerformanceAllDifferent() {
        int arraySize = 100000;
        int [] A = new int[arraySize];
        for (int i = 0; i < A.length ; i++) {
            A[i] = i;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int equiLeaders = this.s.solution(this.params)[0];

        Assert.assertEquals(0, equiLeaders);
    }
}
