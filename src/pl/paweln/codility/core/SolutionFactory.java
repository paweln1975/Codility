package pl.paweln.codility.core;

import pl.paweln.codility.arrays.CyclicRotation;
import pl.paweln.codility.arrays.OddOccurrencesInArray;
import pl.paweln.codility.counting.*;
import pl.paweln.codility.iterations.BinaryGap;
import pl.paweln.codility.prefixsums.CountDiv;
import pl.paweln.codility.prefixsums.GenomicRangeQuery;
import pl.paweln.codility.prefixsums.MinAvgTwoSlice;
import pl.paweln.codility.prefixsums.PassingCars;

public class SolutionFactory {
    public enum CodilityTask {
        ITERATION_BINARY_GAP,

        ARRAYS_CYCLIC_ROTATION,
        ARRAYS_ODD_OCCURRENCES_IN_ARRAY,

        COUNTING_FROG_RIVER_ONE,
        COUNTING_MAX_COUNTERS,
        COUNTING_MISSING_INTEGER,
        COUNTING_PERM_CHECK,
        COUNTING_PERM_CHECK2,

        PREFIX_SUMS_COUNT_DIV,
        PREFIX_SUMS_GENOMIC_RANGE_QUERY,
        PREFIX_SUMS_MIN_AVG_TWO_SLICE,
        PREFIX_SUMS_PASSING_CARS,
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
            case PREFIX_SUMS_COUNT_DIV:
                solution = new CountDiv();
                break;
//            case PREFIX_SUMS_GENOMIC_RANGE_QUERY:
//                solution = new GenomicRangeQuery();
//                break;
//            case PREFIX_SUMS_MIN_AVG_TWO_SLICE:
//                solution = new MinAvgTwoSlice();
//                break;
//            case PREFIX_SUMS_PASSING_CARS:
//                solution = new PassingCars();
//                break;
        }
        return solution;
    }
}
