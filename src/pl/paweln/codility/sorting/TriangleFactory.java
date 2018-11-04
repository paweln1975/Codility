package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class TriangleFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new Triangle();
    }
}
