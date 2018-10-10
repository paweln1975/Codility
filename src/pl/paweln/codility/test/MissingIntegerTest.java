package pl.paweln.codility.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.counting.MissingInteger;
import pl.paweln.codility.counting.MissingIntegerFactory;

public class MissingIntegerTest {
    private final SolutionFactory solutionFactory = new MissingIntegerFactory();
    private CodilitySolution s;

    @Before
    public void setUp() {
        this.s = this.solutionFactory.createSolution();
    }

    @Test
    public void testSolutionExample() {
        int[] exArr = new int[] {1, 3, 6, 4, 1, 2};

        Assert.assertEquals(5, this.s.solution(exArr));
    }

    @Test
    public void testNegatives() {
        int[] testArr = new int[] {-1, -3, -6, -4, -1, -2};

        Assert.assertEquals(1, this.s.solution(testArr));
    }

    @Test
    public void testEmpty() {
        int[] testArr = new int[0];

        Assert.assertEquals(1, this.s.solution(testArr));
    }

    @Test
    public void testSingleValue() {
        int[] testArr = new int[] {0};
        Assert.assertEquals(1, this.s.solution(testArr));

        testArr = new int[] {2};
        Assert.assertEquals(1, this.s.solution(testArr));

        testArr = new int[] {1};
        Assert.assertEquals(2, this.s.solution(testArr));
    }

    @Test
    public void testMaxCapacity() {
        int[] testArr = new int[100000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = 99999-i;
        }
        Assert.assertEquals(100000, this.s.solution(testArr));
    }

    @Test
    public void testSimpleGrowing() {
        int[] testArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(8, this.s.solution(testArr));

        testArr = new int[] {2, 3, 4, 5, 6, 7};
        Assert.assertEquals(1, this.s.solution(testArr));
    }
}
