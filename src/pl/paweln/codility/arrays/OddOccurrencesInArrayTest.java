package pl.paweln.codility.arrays;

import org.junit.Assert;
import org.junit.Test;

public class OddOccurrencesInArrayTest {
    @Test
    public void testSimple() {
        OddOccurrencesInArray s = new OddOccurrencesInArray();
        int[] A = {4, 5, 6, 7, 6, 5, 4};
        Assert.assertEquals(7, s.solution(A));
    }

    @Test
    public void testSimple2() {
        OddOccurrencesInArray s = new OddOccurrencesInArray();
        int[] A = {100000, 100000, 100000, 100, 100000, 100000, 100000};
        Assert.assertEquals(100, s.solution(A));
    }

    @Test
    public void testAdvanced() {
        OddOccurrencesInArray s = new OddOccurrencesInArray();
        int[] A = {874385, 983983, 983983, 888832, 888832, 989, 874385};
        Assert.assertEquals(989, s.solution(A));
    }

    @Test
    public void testMissingOddOccNumber() {
        OddOccurrencesInArray s = new OddOccurrencesInArray();
        int[] A = {10, 20, 35, 47, 49, 100, 2000, 10, 20, 35, 47, 49, 100, 2000};
        Assert.assertEquals(0, s.solution(A));
    }
}
