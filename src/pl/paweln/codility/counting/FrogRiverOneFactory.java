package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class FrogRiverOneFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new FrogRiverOne();
    }
}
