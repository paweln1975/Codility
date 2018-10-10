package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class MaxCountersFactory extends SolutionFactory<Integer[]> {
    @Override
    protected CodilitySolution<Integer[]> createSpecificSolution() {
        return new MaxCounters();
    }
}
