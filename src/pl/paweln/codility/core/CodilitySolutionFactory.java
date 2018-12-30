package pl.paweln.codility.core;

import pl.paweln.codility.arrays.CyclicRotation;
import pl.paweln.codility.arrays.OddOccurrencesInArray;
import pl.paweln.codility.counting.FrogRiverOne;
import pl.paweln.codility.counting.MaxCounters;
import pl.paweln.codility.counting.MissingInteger;
import pl.paweln.codility.counting.PermCheck;
import pl.paweln.codility.iterations.BinaryGap;
import pl.paweln.codility.prefixsums.CountDiv;
import pl.paweln.codility.prefixsums.GenomicRangeQuery;
import pl.paweln.codility.prefixsums.MinAvgTwoSlice;
import pl.paweln.codility.prefixsums.PassingCars;
import pl.paweln.codility.sorting.Distinct;
import pl.paweln.codility.sorting.MaxProductOfThree;
import pl.paweln.codility.sorting.NumberOfDiscIntersections;
import pl.paweln.codility.sorting.Triangle;
import pl.paweln.codility.stacks.Brackets;
import pl.paweln.codility.stacks.Fish;
import pl.paweln.codility.timecomplexity.FrogJump;
import pl.paweln.codility.timecomplexity.PermMissingElem;
import pl.paweln.codility.timecomplexity.TapeEquilibrium;

public class CodilitySolutionFactory {
    private final TaskType defaultTaskType;

    public enum TaskType {
        ITERATION_BINARY_GAP,
        ARRAYS_CYCLIC_ROTATION,
        ARRAYS_ODD_OCCURRENCES_IN_ARRAY,
        TIME_COMPLEXITY_FROG_JUMP,
        TIME_COMPLEXITY_PERM_MISSING_ELEM,
        TIME_COMPLEXITY_TAPE_EQUILIBRIUM,
        COUNTING_FROG_RIVER_ONE,
        COUNTING_MAX_COUNTERS,
        COUNTING_MISSING_INTEGER,
        COUNTING_PERM_CHECK,
        PREFIX_SUMS_COUNT_DIV,
        PREFIX_SUMS_GENOMIC_RANGE_QUERY,
        PREFIX_SUMS_MIN_AVG_TWO_SLICE,
        PREFIX_SUMS_PASSING_CARS,
        SORTING_DISTINCT,
        SORTING_MAX_PRODUCT_OF_THREE,
        SORTING_TRIANGLE,
        SORTING_NUMBER_OF_DISCS_INTERSECTIONS,
        STACKS_AND_QUEUES_BRACKETS,
        STACKS_AND_QUEUES_FISH
    }

    public CodilitySolutionFactory(TaskType p_defaultType) {
        this.defaultTaskType = p_defaultType;
    }

    public CodilitySolution getDefaultSolution() {
        if (defaultTaskType == null) {
            return null;
        }
        return getSolution(this.defaultTaskType);
    }
    private CodilitySolution getSolution(TaskType p_type) {
        if(p_type == null){
            return null;
        }
        CodilitySolution solution = null;
        switch (p_type) {
            case ITERATION_BINARY_GAP:
                solution = new BinaryGap();
                break;
            case ARRAYS_CYCLIC_ROTATION:
                solution = new CyclicRotation();
                break;
            case ARRAYS_ODD_OCCURRENCES_IN_ARRAY:
                solution = new OddOccurrencesInArray();
                break;
            case TIME_COMPLEXITY_FROG_JUMP:
                solution = new FrogJump();
                break;
            case TIME_COMPLEXITY_PERM_MISSING_ELEM:
                solution = new PermMissingElem();
                break;
            case TIME_COMPLEXITY_TAPE_EQUILIBRIUM:
                solution = new TapeEquilibrium();
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
            case PREFIX_SUMS_COUNT_DIV:
                solution = new CountDiv();
                break;
            case PREFIX_SUMS_GENOMIC_RANGE_QUERY:
                solution = new GenomicRangeQuery();
                break;
            case PREFIX_SUMS_MIN_AVG_TWO_SLICE:
                solution = new MinAvgTwoSlice();
                break;
            case PREFIX_SUMS_PASSING_CARS:
                solution = new PassingCars();
                break;
            case SORTING_DISTINCT:
                solution = new Distinct();
                break;
            case SORTING_MAX_PRODUCT_OF_THREE:
                solution = new MaxProductOfThree();
                break;
            case SORTING_TRIANGLE:
                solution = new Triangle();
                break;
            case SORTING_NUMBER_OF_DISCS_INTERSECTIONS:
                solution = new NumberOfDiscIntersections();
                break;
            case STACKS_AND_QUEUES_BRACKETS:
                solution = new Brackets();
                break;
            case STACKS_AND_QUEUES_FISH:
                solution = new Fish();
                break;
        }
        return solution;
        
        
    }
}
