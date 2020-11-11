package pl.paweln.codility.counting;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

public class MaxCounters extends AbstractCodility {

    public MaxCounters() {
        int[] tabA = new int[] {3, 4, 4, 6, 1, 4, 4};

        this.defaultParams = this.paramsBuilder
                .setFirstArray(tabA)
                .setN(5).build();
    }

    @Override
    public int[] solution(SolutionInputParams params) {
        int n = params.getN();
        int[] tab = params.getFirstArray();

        if (tab == null || tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000.");

        if (n < 0 || n > 100000)
            throw new IllegalArgumentException("N must be within range 1 .. 100000.");

        return this.solution(n, tab);
    }

    private int[] solution(int N, int[] A) {
        int lastMax = 0;
        int maxValue = 0;

        int[] tabR = new int[N];
        Arrays.fill(tabR, 0);

        if (N <= 0) {
            throw new IllegalArgumentException("N must be higher of equal to 1.");
        }

        for (int aA : A) {
            if (aA > N + 1 || aA < 0) {
                throw new IllegalArgumentException("Value of an array index is to high.");
            }

            if (aA < N + 1) {
                if (tabR[aA - 1] < lastMax) {
                    tabR[aA - 1] = lastMax;
                }

                tabR[aA - 1]++;

                if (tabR[aA - 1] > maxValue) {
                    maxValue = tabR[aA - 1];
                }

            } else {
                lastMax = maxValue;
            }
        }

        for (int i = 0; i < tabR.length; i++) {
            if (tabR[i] < lastMax) {
                tabR[i] = lastMax;
            }

        }

        return tabR;
    }


}
