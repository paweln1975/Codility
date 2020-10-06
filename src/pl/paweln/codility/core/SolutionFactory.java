package pl.paweln.codility.core;

import pl.paweln.codility.arrays.CyclicRotation;
import pl.paweln.codility.arrays.OddOccurrencesInArray;
import pl.paweln.codility.counting.*;
import pl.paweln.codility.iterations.BinaryGap;
import pl.paweln.codility.leader.Dominator;
import pl.paweln.codility.leader.DominatorN2;
import pl.paweln.codility.leader.DominatorNLogN;
import pl.paweln.codility.leader.EquiLeader;
import pl.paweln.codility.prefixsums.CountDiv;
import pl.paweln.codility.prefixsums.GenomicRangeQuery;
import pl.paweln.codility.prefixsums.MinAvgTwoSlice;
import pl.paweln.codility.prefixsums.PassingCars;
import pl.paweln.codility.prime.CountFactors;
import pl.paweln.codility.prime.MinPerimeterRectangle;
import pl.paweln.codility.slice.MaxDoubleSliceSum;
import pl.paweln.codility.slice.MaxProfit;
import pl.paweln.codility.slice.MaxSlice;
import pl.paweln.codility.sorting.Distinct;
import pl.paweln.codility.sorting.MaxProductOfThree;
import pl.paweln.codility.sorting.NumberOfDiscIntersections;
import pl.paweln.codility.sorting.Triangle;
import pl.paweln.codility.stacks.Brackets;
import pl.paweln.codility.stacks.Fish;
import pl.paweln.codility.stacks.Nesting;
import pl.paweln.codility.stacks.StoneWall;
import pl.paweln.codility.timecomplexity.FrogJump;
import pl.paweln.codility.timecomplexity.PermMissingElem;
import pl.paweln.codility.timecomplexity.TapeEquilibrium;

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

        SORTING_DISTINCT,
        SORTING_MAX_PRODUCT_OF_THREE,
        SORTING_TRIANGLE,
        SORTING_NUMBER_OF_DISCS_INTERSECTIONS,

        STACKS_BRACKETS,
        STACKS_FISH,
        STACKS_NESTING,
        STACKS_STONE_WALL,

        TIME_COMPLEXITY_FROG_JUMP,
        TIME_COMPLEXITY_PERM_MISSING_ELEM,
        TIME_COMPLEXITY_TAPE_EQUILIBRIUM,

        LEADER_DOMINATOR,
        LEADER_DOMINATOR_N2,
        LEADER_DOMINATOR_LOG,
        LEADER_EQUILEADER,

        SLICE_MAX_SLICE,
        SLICE_MAX_DOUBLE_SLICE_SUM,
        SLICE_MAX_PROFIT,

        PRIME_COUNT_FACTORS,
        PRIME_MIN_PERIMETER,


    }

    public CodilitySolution getSolution(CodilityTask pTask) {
        if (pTask == null) {
            return null;
        }
        CodilitySolution codilitySolution = null;
        switch (pTask) {
            case ITERATION_BINARY_GAP:
                codilitySolution = new BinaryGap();
                break;
            case ARRAYS_CYCLIC_ROTATION:
                codilitySolution = new CyclicRotation();
                break;
            case ARRAYS_ODD_OCCURRENCES_IN_ARRAY:
                codilitySolution = new OddOccurrencesInArray();
                break;
            case COUNTING_FROG_RIVER_ONE:
                codilitySolution = new FrogRiverOne();
                break;
            case COUNTING_MAX_COUNTERS:
                codilitySolution = new MaxCounters();
                break;
            case COUNTING_MISSING_INTEGER:
                codilitySolution = new MissingInteger();
                break;
            case COUNTING_PERM_CHECK:
                codilitySolution = new PermCheck();
                break;
            case COUNTING_PERM_CHECK2:
                codilitySolution = new PermCheck2();
                break;
            case PREFIX_SUMS_COUNT_DIV:
                codilitySolution = new CountDiv();
                break;
            case PREFIX_SUMS_GENOMIC_RANGE_QUERY:
                codilitySolution = new GenomicRangeQuery();
                break;
            case PREFIX_SUMS_MIN_AVG_TWO_SLICE:
                codilitySolution = new MinAvgTwoSlice();
                break;
            case PREFIX_SUMS_PASSING_CARS:
                codilitySolution = new PassingCars();
                break;
            case SORTING_DISTINCT:
                codilitySolution = new Distinct();
                break;
            case SORTING_MAX_PRODUCT_OF_THREE:
                codilitySolution = new MaxProductOfThree();
                break;
            case SORTING_TRIANGLE:
                codilitySolution = new Triangle();
                break;
            case SORTING_NUMBER_OF_DISCS_INTERSECTIONS:
                codilitySolution = new NumberOfDiscIntersections();
                break;
            case STACKS_BRACKETS:
                codilitySolution = new Brackets();
                break;
            case STACKS_FISH:
                codilitySolution = new Fish();
                break;
            case STACKS_NESTING:
                codilitySolution = new Nesting();
                break;
            case STACKS_STONE_WALL:
                codilitySolution = new StoneWall();
                break;
            case TIME_COMPLEXITY_FROG_JUMP:
                codilitySolution = new FrogJump();
                break;
            case TIME_COMPLEXITY_PERM_MISSING_ELEM:
                codilitySolution = new PermMissingElem();
                break;
            case TIME_COMPLEXITY_TAPE_EQUILIBRIUM:
                codilitySolution = new TapeEquilibrium();
                break;
            case LEADER_DOMINATOR:
                codilitySolution = new Dominator();
                break;
            case LEADER_DOMINATOR_N2:
                codilitySolution = new DominatorN2();
                break;
            case LEADER_DOMINATOR_LOG:
                codilitySolution = new DominatorNLogN();
                break;
            case LEADER_EQUILEADER:
                codilitySolution = new EquiLeader();
                break;
            case SLICE_MAX_SLICE:
                codilitySolution = new MaxSlice();
                break;
            case SLICE_MAX_DOUBLE_SLICE_SUM:
                codilitySolution = new MaxDoubleSliceSum();
                break;
            case SLICE_MAX_PROFIT:
                codilitySolution = new MaxProfit();
                break;
            case PRIME_COUNT_FACTORS:
                codilitySolution = new CountFactors();
                break;
            case PRIME_MIN_PERIMETER:
                codilitySolution = new MinPerimeterRectangle();
                break;
        }
        return codilitySolution;
    }
}
