package pl.paweln.codility.arrays;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;
import pl.paweln.codility.prefixsums.GenomicRangeQuery;

public class CyclicRotationFactory extends SolutionFactory {
    @Override
    protected CodilitySolution<Integer[]> createSpecificSolution() {
        return new CyclicRotation();
    }
}
