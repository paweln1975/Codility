package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class Distinct implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big.");
        }


        return new int[] {this.solution(A)};
    }

    private int solution(int[] A) {
        int distinct = 0;
        if (A.length > 0) {
            Arrays.sort(A);
            distinct=1;
        }
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] != A[i+1]) {
                distinct++;
            }
        }
        return distinct;
    }

}
