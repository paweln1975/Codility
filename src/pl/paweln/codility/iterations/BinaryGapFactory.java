package pl.paweln.codility.iterations;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class BinaryGapFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new BinaryGap();
    }
}
