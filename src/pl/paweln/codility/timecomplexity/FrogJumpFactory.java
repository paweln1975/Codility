package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionFactory;

public class FrogJumpFactory extends SolutionFactory {
    @Override
    protected CodilitySolution createSpecificSolution() {
        return new FrogJump();
    }
}
