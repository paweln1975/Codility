package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class NumberOfDiscIntersectionsFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new NumberOfDiscIntersections();
    }
}
