package pl.paweln.codility.counting;

import pl.paweln.codility.core.AbstractCodility;
import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class FrogRiverOne extends AbstractCodility {

    public FrogRiverOne() {
        int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};

        this.defaultParams = this.paramsBuilder
                .setFirstArray(A)
                .setX(5).build();
    }
    @Override
    public int[] solution(SolutionInputParams params) {
        int X = params.getX();
        int[] tab = params.getFirstArray();

        if (tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000.");

        if (X < 0 || X > 100000)
            throw new IllegalArgumentException("X must be within range 1 .. 100000.");

        return new int[] {this.solution(X, tab)};
    }

    private int solution(int X, int[] A) {
        int[] tabPositions = new int[X];
        int expectedSum = (1 + X) * X / 2;
        int pos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < tabPositions.length+1) {
                if (tabPositions[A[i]-1] == 0) {
                    expectedSum-= A[i];
                    tabPositions[A[i]-1]++;
                    if (expectedSum == 0) {
                        pos = i;
                        break;
                    }
                }
            }
        }

        if (expectedSum == 0) {
            return pos;
        } else {
            return -1;
        }
    }



}
