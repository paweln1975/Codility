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
import pl.paweln.codility.stacks.Nesting;
import pl.paweln.codility.stacks.StoneWall;
import pl.paweln.codility.timecomplexity.FrogJump;
import pl.paweln.codility.timecomplexity.PermMissingElem;
import pl.paweln.codility.timecomplexity.TapeEquilibrium;

public class CodilitySolutionFactory {
    private final TaskType defaultTaskType;

    public enum TaskType {

        TIME_COMPLEXITY_FROG_JUMP,
        TIME_COMPLEXITY_PERM_MISSING_ELEM,
        TIME_COMPLEXITY_TAPE_EQUILIBRIUM,



        STACKS_AND_QUEUES_BRACKETS,
        STACKS_AND_QUEUES_FISH,
        STACKS_AND_QUEUES_NESTING,
        STACKS_AND_QUEUES_STONE_WALL
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


            case TIME_COMPLEXITY_FROG_JUMP:
                solution = new FrogJump();
                break;
            case TIME_COMPLEXITY_PERM_MISSING_ELEM:
                solution = new PermMissingElem();
                break;
            case TIME_COMPLEXITY_TAPE_EQUILIBRIUM:
                solution = new TapeEquilibrium();
                break;






            case STACKS_AND_QUEUES_BRACKETS:
                solution = new Brackets();
                break;
            case STACKS_AND_QUEUES_FISH:
                solution = new Fish();
                break;
            case STACKS_AND_QUEUES_NESTING:
                solution = new Nesting();
                break;
            case STACKS_AND_QUEUES_STONE_WALL:
                solution = new StoneWall();
                break;
        }
        return solution;
        
        
    }
}
