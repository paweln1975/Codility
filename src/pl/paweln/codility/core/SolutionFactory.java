package pl.paweln.codility.core;

import pl.paweln.codility.iterations.BinaryGap;

public class SolutionFactory {
    public enum CodilityTask {
        ITERATION_BINARY_GAP
    }

    public Solution getSolution(CodilityTask pTask) {
        if (pTask == null) {
            return null;
        }
        Solution solution = null;
        switch (pTask) {
            case ITERATION_BINARY_GAP:
                solution = new BinaryGap();
                break;
        }
        return solution;
    }
}
