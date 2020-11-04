package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxSlice implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        if (A.length < 1) {
            throw new IllegalArgumentException("Array must contain at least 1 element.");
        }

        if (A.length > 1000000) {
            throw new IllegalArgumentException("Array too big. Max size is 1 000 000.");
        }
        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        int absoluteMax = A[0];
        int localMax = A[0];
        int currentElement;
        int nextSum;

        for (int i = 1; i < A.length; i++) {
            currentElement = A[i];
            nextSum = localMax + currentElement;
            localMax = Math.max(A[i], nextSum);
            absoluteMax = Math.max(absoluteMax, localMax);
        }
        return absoluteMax;
    }


}
