package pl.paweln.codility.stacks;

import pl.paweln.codility.core.BaseCodilitySolution;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in
 * a river, ordered downstream along the flow of the river.
 *
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q.
 * Initially, each fish has a unique position.
 *
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique.
 * Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
 *
 * 0 represents a fish flowing upstream,
 * 1 represents a fish flowing downstream.
 *
 * If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet
 * each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two
 * fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they
 * meet:
 *
 * If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet.
 * The goal is to calculate the number of fish that will stay alive.
 *
 * For example, consider arrays A and B such that:
 *
 *   A[0] = 4    B[0] = 0
 *   A[1] = 3    B[1] = 1
 *   A[2] = 2    B[2] = 0
 *   A[3] = 1    B[3] = 0
 *   A[4] = 5    B[4] = 0
 *
 * Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2
 * and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The
 * remaining two fish, number 0 and 4, never meet and therefore stay alive.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.
 *
 * For example, given the arrays shown above, the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000];
 * each element of array B is an integer that can have one of the following values: 0, 1;
 * the elements of A are all distinct.
 */
public class Fish extends BaseCodilitySolution {
    List<RiverFish> fishList = new LinkedList<>();

    public int solution(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalArgumentException("Arrays sizes are not equal.");
        }
        if (A.length == 0) {
            throw new IllegalArgumentException("Arrays are empty");
        }

        if (A.length == 1) {
            return A.length;
        }

        // initilize list of fishes
        for (int i = 0; i < A.length; i++) {
            Direction direction = Direction.UPSTREAM;
            if (B[i] == 1) {
                direction = Direction.DOWNSTREAM;
            }

            RiverFish riverFish = new RiverFish(A[i], direction, i);
            fishList.add(riverFish);
        }

        ListIterator<RiverFish> fishListIterator = fishList.listIterator();

        RiverFish prevFish = fishListIterator.next();
        RiverFish nextFish = null;
        boolean analysisFinised = false;
        Direction analysisDirection = Direction.DOWNSTREAM;


        while (!analysisFinised) {
            if (analysisDirection == Direction.DOWNSTREAM) {
                if (fishListIterator.hasNext()) {
                    nextFish = fishListIterator.next();
                    if (isConflict(prevFish, nextFish)) {
                        if (prevFish.size > nextFish.size) {
                            // eat current fish and continue downstream
                            fishListIterator.remove();
                        } else {
                            // eat previous fish and continue upstream
                            prevFish = nextFish;
                            RiverFish tmpFish = fishListIterator.previous();
                            if (tmpFish == prevFish) {
                                tmpFish = fishListIterator.previous();
                            }
                            fishListIterator.remove();
                            analysisDirection = Direction.UPSTREAM;
                        }
                    } else {
                        prevFish = nextFish;
                    }
                } else {
                    analysisFinised = true;
                }
            } else {
                if (fishListIterator.hasPrevious()) {
                    nextFish = fishListIterator.previous();
                    if (isConflict(nextFish, prevFish)) {
                        if (prevFish.size > nextFish.size) {
                            // eat current fish and continue upstream
                            fishListIterator.remove();
                        } else {
                            // eat previous fish and continue downstream
                            prevFish = nextFish;
                            fishListIterator.next();
                            fishListIterator.remove();
                            analysisDirection = Direction.DOWNSTREAM;
                        }
                    } else {
                        prevFish = nextFish;
                    }
                } else {
                    // change direction, begin reached
                    prevFish = nextFish;
                    analysisDirection = Direction.DOWNSTREAM;
                }
            }

        }

        return fishList.size();
    }

    private boolean isConflict (RiverFish left, RiverFish right) {
        return left.index < right.index &&
                left.direction == Direction.DOWNSTREAM &&
                right.direction == Direction.UPSTREAM;
    }

}



class RiverFish {
    public RiverFish (int size, Direction direction, int index) {
        this.direction = direction;
        this.size = size;
        this.index = index;
    }
    Direction direction;
    int size;
    int index;
}

enum Direction {
    UPSTREAM,
    DOWNSTREAM
}
