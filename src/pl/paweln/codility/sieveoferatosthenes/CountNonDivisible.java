package pl.paweln.codility.sieveoferatosthenes;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class CountNonDivisible implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] array = params.getFirstArray();
        return this.solution(array);
    }

    private int[] solution(int[] A) {
        int size = A.length;

        int[] occurrences = new int[2 * size + 1];
        int[] answer = new int[2 * size + 1];
        int[] result = new int[size];

        for (int k : A) {
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
