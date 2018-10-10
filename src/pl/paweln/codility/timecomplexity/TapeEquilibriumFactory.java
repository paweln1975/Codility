package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class TapeEquilibriumFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new TapeEquilibrium();
    }
}
