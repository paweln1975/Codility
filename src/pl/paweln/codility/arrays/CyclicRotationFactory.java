package pl.paweln.codility.arrays;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;


public class CyclicRotationFactory extends SolutionFactory<Integer[]> {
    @Override
    protected CodilitySolution<Integer[]> createSpecificSolution() {
        return new CyclicRotation();
    }
}
