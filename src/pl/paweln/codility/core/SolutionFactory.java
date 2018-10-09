package pl.paweln.codility.core;

public abstract class SolutionFactory<T> {
    protected abstract CodilitySolution<T> createSpecificSolution();
    public CodilitySolution<T> createSolution() {
        return createSpecificSolution();
    }
}
