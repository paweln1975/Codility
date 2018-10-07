package pl.paweln.codility.core;

public abstract class SolutionFactory {
    protected abstract CodilitySolution createSpecificSolution();
    public CodilitySolution createSolution() {
        return createSpecificSolution();
    }
}
