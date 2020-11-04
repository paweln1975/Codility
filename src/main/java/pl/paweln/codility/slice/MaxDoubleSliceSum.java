package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxDoubleSliceSum implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        if (A.length < 3) {
            throw new IllegalArgumentException("Array too small. Min 3 elements are required.");
        }
        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big. Max 100 000 elements are supported.");
        }
        return new int[] {this.solution(A)};
    }


    private int solution(int[] A) {
        int max_ending = 0;
        int[] max_ending_sum = new int[A.length];

        int max_starting = 0;
        int[] max_starting_sum = new int[A.length];

        int max_double_slice = 0;

        for (int i = 1; i < A.length - 1; i++) {
            max_ending = Math.max(0, max_ending+A[i]);
            max_ending_sum[i] = max_ending;
        }

        for (int i = A.length - 2; i > 0; --i) {
            max_starting = Math.max(0, max_starting+A[i]);
            max_starting_sum[i] = max_starting;
        }

        for(int i = 0; i < A.length - 2; ++i) {
            max_double_slice = Math.max(max_double_slice, max_ending_sum[i] + max_starting_sum[i+2]);
        }

        return max_double_slice;
    }
}
