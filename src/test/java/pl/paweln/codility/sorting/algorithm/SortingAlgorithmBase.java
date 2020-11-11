package pl.paweln.codility.sorting.algorithm;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.core.SolutionInputParams;

public class SortingAlgorithmBase {
    protected final SolutionFactory solutionFactory = new SolutionFactory();

    protected CodilitySolution codilitySolution;
    protected SolutionInputParams.SolutionInputParamsBuilder paramsBuilder;
    protected SolutionInputParams params;


    @Test
    public void testSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};

        this.params = this.paramsBuilder.setFirstArray(tab).build();
        tab = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        this.params = this.paramsBuilder.setFirstArray(tab).build();
        tab = this.codilitySolution.solution(this.params);

        Assert.assertArrayEquals (sorted, tab);
    }
}
