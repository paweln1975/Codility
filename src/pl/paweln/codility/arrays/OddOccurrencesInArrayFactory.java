package pl.paweln.codility.arrays;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class OddOccurrencesInArrayFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new OddOccurrencesInArray();
    }
}
