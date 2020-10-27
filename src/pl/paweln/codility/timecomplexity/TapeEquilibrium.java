package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class TapeEquilibrium implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        int N = A.length;
        if (N < 2) throw new IllegalArgumentException("Array too small. Minimal size is 2.");
        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        long sumLeft = 0;
        long sumRight = 0;

        int diff = 0;

        for (int elem:A) sumRight += elem;

        for (int i = 0; i < A.length - 1 ; i++) {
            int nextDiff;

            sumLeft += A[i];
            sumRight -= A[i];

            if (i == 0) {
                diff = (int)Math.abs(sumLeft - sumRight);
            } else {
                nextDiff = (int)Math.abs(sumLeft - sumRight);
                if (nextDiff < diff) {
                    diff = nextDiff;
                }
            }
        }
        return diff;
    }



}
