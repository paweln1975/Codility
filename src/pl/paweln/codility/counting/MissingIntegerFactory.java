package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class MissingIntegerFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new MissingInteger();
    }
}
