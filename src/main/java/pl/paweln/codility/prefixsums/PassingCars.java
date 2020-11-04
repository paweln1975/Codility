package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class PassingCars implements CodilitySolution {
    private final static int MAX_RESULT = 1000000000;
    private final static int VAL_EAST = 0;
    private final static int VAL_WEST = 1;

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big.");
        }


        return new int[] {this.solution(A)};
    }

    public int solution (int[] A) {
        int pairsCnt = 0;
        int eastDirCars = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != VAL_EAST) {
                if (A[i] != VAL_WEST) {
                    throw new IllegalArgumentException("Found value different then 0 or 1 at index:" + i);
                }
            }

            if (A[i] == VAL_EAST) eastDirCars++;
            if (A[i] == VAL_WEST) {
                pairsCnt+= eastDirCars;
                if (pairsCnt > MAX_RESULT) {
                    pairsCnt = -1;
                    break;
                }
            }

        }
        return pairsCnt;
    }

}
