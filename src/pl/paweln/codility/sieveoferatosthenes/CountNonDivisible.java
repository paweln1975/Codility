package pl.paweln.codility.sieveoferatosthenes;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class CountNonDivisible implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] array = params.getFirstArray();

        int N = array.length;

        if (N < 1) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        if (N > 50000) {
            throw new IllegalArgumentException("Array too big. Max array size is 50 000.");
        }

        return this.solution(array);
    }

    private int[] solution(int[] A) {
        int size = A.length;

        int[] occurrences = new int[2 * size + 1];
        int[] answer = new int[2 * size + 1];
        int[] result = new int[size];

        for (int k : A) {
            if (k <= 0) {
                throw new IllegalArgumentException("Value of an array element must be greater then 0");
            }
            if (k > 2 * size) {
                throw new IllegalArgumentException("Value of an array element to big. Max value is " + 2 * size + ". Actual value found = " + k);
            }
            occurrences[k]++;
        }

        for (int i = 1; i <= 2 * size; i++) {
            if (occurrences[i] == 0) {
                continue;
            }

            for (int j = i; j <= 2 * size; j+=i) {
                answer[j] -= occurrences[i];
            }
        }

        for (int i = 0; i < size; i++) {
            result[i] = size + answer[A[i]];
        }

        return result;
    }
}
