package pl.paweln.codility.leader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.LinkedList;
import java.util.List;

public class DominatorTest {
    private final SolutionFactory solutionFactory = new SolutionFactory();

    private CodilitySolution s;
    private SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    private SolutionInputParams params;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.getSolution(SolutionFactory.CodilityTask.LEADER_DOMINATOR);
        this.paramsBuilder = new SolutionInputParams.SolutionInputParamsBuilder();
    }

    @Test
    public void testExample() {
        int [] A = {3,4,3,2,3,-1,3,3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        List<Integer> listCorrectValues = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 3) {
                listCorrectValues.add(i);
            }
        }

        Assert.assertTrue(listCorrectValues.stream().anyMatch(p -> p == idxResult));
    }
}
