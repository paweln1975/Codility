package pl.paweln.codility.leader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DominatorTest {
    protected final SolutionFactory solutionFactory = new SolutionFactory();
    protected CodilitySolution s;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;

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

    @Test
    public void testEmptyArray() {
        int [] A = {};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        Assert.assertEquals(-1, idxResult);
    }

    @Test
    public void testSingleElementArray() {
        int [] A = {3};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        Assert.assertEquals(0, idxResult);
    }

    @Test
    public void testTwoElementsArray() {
        int [] A = {3, 2};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        Assert.assertEquals(-1, idxResult);
    }

    @Test
    public void testThreeElementsArray() {
        int dominator = 3;
        int [] A = {dominator, dominator, 1};
        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        List<Integer> listCorrectValues = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                listCorrectValues.add(i);
            }
        }

        Assert.assertTrue(listCorrectValues.stream().anyMatch(p -> p == idxResult));
    }

    @Test
    public void testPerformance() {
        int dominator = 0;
        int arraySize = 100000;
        int [] A = new int[arraySize];

        for (int i = 0; i < A.length; i++) {
            if (i < A.length / 2 + 1) {
                A[i] = dominator;
            }
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        List<Integer> listCorrectValues = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                listCorrectValues.add(i);
            }
        }

        Assert.assertTrue(listCorrectValues.stream().anyMatch(p -> p == idxResult));
    }

    @Test
    public void testNonDominatorAllDifferent() {
        int arraySize = 100;
        int [] A = new int[arraySize];
        for (int i = 0; i < A.length; i++) {
                A[i] = i;
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        Assert.assertEquals(-1, idxResult);

    }

    @Test
    public void testDominatorAllTheSame() {
        int arraySize = 100;
        int dominator = 5;
        List<Integer> listCorrectValues = new LinkedList<>();

        int [] A = new int[arraySize];
        Arrays.fill(A, dominator);

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                listCorrectValues.add(i);
            }
        }

        Assert.assertTrue(listCorrectValues.stream().anyMatch(p -> p == idxResult));

    }

    @Test
    public void testNonDominatorHalfTheSame() {
        int arraySize = 100;

        int [] A = new int[arraySize];
        for (int i = 0; i < A.length; i++) {
            if (i < A.length / 2) {
                A[i] = 1;
            }
        }

        this.params = this.paramsBuilder.setFirstArray(A).build();
        int idxResult = this.s.solution(this.params)[0];

        Assert.assertEquals(-1, idxResult);
    }
}
