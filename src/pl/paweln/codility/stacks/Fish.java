package pl.paweln.codility.stacks;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Fish implements CodilitySolution {
    private List<RiverFish> fishList = new LinkedList<>();

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        int[] B = params.getSecondArray();
        if (A.length != B.length) {
            throw new IllegalArgumentException("Arrays sizes are not equal.");
        }
        if (A.length == 0) {
            throw new IllegalArgumentException("Arrays are empty");
        }

        return new int[] {this.solution(A, B)};
    }

    private int solution(int[] A, int[] B) {
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

        // kind of a stack
        ListIterator<RiverFish> fishListIterator = fishList.listIterator();

        RiverFish prevFish = fishListIterator.next();
        RiverFish nextFish = null;
        boolean moreFishes = true;
        Direction analysisDirection = Direction.DOWNSTREAM;

        // implemenentation based on way how this algorithm works
        while (moreFishes) {
            if (analysisDirection == Direction.DOWNSTREAM) {
                moreFishes = fishListIterator.hasNext();
                if (moreFishes) {
                    nextFish = fishListIterator.next();
                    if (isConflict(prevFish, nextFish)) {
                        if (prevFish.size > nextFish.size) {
                            // eat next fish
                            fishListIterator.remove();
                        } else {
                            analysisDirection = Direction.UPSTREAM;
                            prevFish = nextFish;
                        }
                    } else {
                        prevFish = nextFish;
                    }
                }
            } else {
                // until the next fish will be eaten or prev fish flows upstream
                if (fishListIterator.hasPrevious()) {
                    nextFish = fishListIterator.previous();
                    if (nextFish == prevFish) {
                        if (fishListIterator.hasPrevious()) {
                            nextFish = fishListIterator.previous();
                        }
                    }
                    // previous fishes go upstream - change direction
                    if (nextFish.direction == Direction.UPSTREAM) {
                        analysisDirection = Direction.DOWNSTREAM;
                    } else {
                        if (nextFish.size > prevFish.size) {
                            analysisDirection = Direction.DOWNSTREAM;
                            prevFish = nextFish;
                        } else {
                            // eat previous
                            fishListIterator.remove();
                        }
                    }

                } else {
                    analysisDirection = Direction.DOWNSTREAM;
                    prevFish = nextFish;
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
    RiverFish (int size, Direction direction, int index) {
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
