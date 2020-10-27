package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MaxProfit implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        return new int[] {this.solution(A)};
    }


    private int solution(int[] A) {
        int max_ending = 0;
        int max_slice = 0;

        if (A.length < 1) {
            return 0;
        }

        int[] diff = new int[A.length-1];
        for (int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i+1] - A[i];
        }

        for (int d : diff) {
            max_ending = Math.max(0, max_ending+d);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }


}
