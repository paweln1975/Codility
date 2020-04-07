package pl.paweln.codility.core;

import pl.paweln.codility.arrays.CyclicRotation;
import pl.paweln.codility.arrays.OddOccurrencesInArray;
import pl.paweln.codility.counting.*;
import pl.paweln.codility.iterations.BinaryGap;

public class SolutionFactory {
    public enum CodilityTask {
        ITERATION_BINARY_GAP,
        ARRAYS_CYCLIC_ROTATION,
        ARRAYS_ODD_OCCURRENCES_IN_ARRAY,
        COUNTING_FROG_RIVER_ONE,
        COUNTING_MAX_COUNTERS,
        COUNTING_MISSING_INTEGER,
        COUNTING_PERM_CHECK,
        COUNTING_PERM_CHECK2
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
            case ARRAYS_CYCLIC_ROTATION:
                solution = new CyclicRotation();
                break;
            case ARRAYS_ODD_OCCURRENCES_IN_ARRAY:
                solution = new OddOccurrencesInArray();
                break;
            case COUNTING_FROG_RIVER_ONE:
                solution = new FrogRiverOne();
                break;
            case COUNTING_MAX_COUNTERS:
                solution = new MaxCounters();
                break;
            case COUNTING_MISSING_INTEGER:
                solution = new MissingInteger();
                break;
            case COUNTING_PERM_CHECK:
                solution = new PermCheck();
                break;
            case COUNTING_PERM_CHECK2:
                solution = new PermCheck2();
                break;
        }
        return solution;
    }
}
