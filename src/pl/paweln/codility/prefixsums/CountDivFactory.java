package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class CountDivFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new CountDiv();
    }
}
