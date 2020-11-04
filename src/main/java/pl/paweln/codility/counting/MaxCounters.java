package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class MaxCounters implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();
        int[] tab = params.getFirstArray();

        if (tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000.");

        if (N < 0 || N > 100000)
            throw new IllegalArgumentException("N must be within range 1 .. 100000.");

        return this.solution(N, tab);
    }

    private int[] solution(int N, int[] A) {
        int lastMax = 0;
        int maxValue = 0;

        int[] R = new int[N];
        Arrays.fill(R, 0);

        if (N <= 0) {
            throw new IllegalArgumentException("N must be higher of equal to 1.");
        }

        for (int aA : A) {
            if (aA > N + 1 || aA < 0) {
                throw new IllegalArgumentException("Value of an array index is to high.");
            }

            if (aA < N + 1) {
                if (R[aA - 1] < lastMax) {
                    R[aA - 1] = lastMax;
                }

                R[aA - 1]++;

                if (R[aA - 1] > maxValue) {
                    maxValue = R[aA - 1];
                }

            } else {
                lastMax = maxValue;
            }
        }

        for (int i = 0; i < R.length; i++) {
            if (R[i] < lastMax) {
                R[i] = lastMax;
            }

        }

        return R;
    }


}
