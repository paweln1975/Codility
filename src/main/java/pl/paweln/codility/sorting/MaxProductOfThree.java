package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class MaxProductOfThree implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length < 3) {
            throw new IllegalArgumentException("Array too small. Minimal length is 3.");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big. Max size is 100 000.");
        }


        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        int N = A.length;
        int product;
        int positiveCounter = 0;
        int[] values = new int[3];

        if (N == 3) {
            product = A[N-1] * A[N-2] * A[N-3];
        } else {
            Arrays.sort(A);

            for (int i = N-1; i >= 0; i--) {
                if (positiveCounter == 3) {
                    if (A[N-3] * A[N-2] < A[0] * A[1]) {
                        values[1] = A[0];
                        values[2] = A[1];
                    }
                    break;
                }
                if (A[i] > 0) {
                    positiveCounter++;
                    values[positiveCounter-1] = A[i];
                } else if (A[i] <= 0 && (positiveCounter == 1 || positiveCounter == 2)) {
                    values[1] = A[0];
                    values[2] = A[1];
                    break;
                } else if (A[i] <= 0 && positiveCounter == 0) {
                    values[0] = A[i];
                    values[1] = A[i-1];
                    values[2] = A[i-2];
                    break;
                }
            }
            product = values[0] * values[1] * values[2];
        }
        return product;
    }

}
