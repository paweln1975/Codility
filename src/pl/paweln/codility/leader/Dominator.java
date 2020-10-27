package pl.paweln.codility.leader;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class Dominator implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length > 100000) {
            throw new IllegalArgumentException("Input array too big.");
        }
        return new int[] {this.solution(A)};
    }

    protected int solution(int[] A) {
        int stackSize = 0;
        int lastValue = 0;
        int halfSize = A.length/2;
        int candidate;
        int idx = -1;
        for (int value : A) {
            if (stackSize == 0) {
                stackSize++;
                lastValue = value;
            } else {
                if (lastValue != value) {
                    stackSize--;
                } else {
                    stackSize++;
                }
            }
        }

        if (stackSize > 0) {
            candidate = lastValue;
            int count = 0;
            for (int i = 0; i < A.length ; i++) {
                if (A[i] == candidate) {
                    count++;
                    if (count > halfSize) {
                        idx = i;
                        break;
                    }
                }
            }
        }

        return idx;
    }
}
