package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class MinPerimeterRectangle implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive greater then 0.");
        }

        if (N > 1000000000) {
            throw new IllegalArgumentException("Value of N too big. Max value is 1 000 000 000.");
        }
        return new int[] {this.solution(N)};
    }

    private int solution(int N) {
        int i = 2;
        int minPerimeter;

        if (N == 1) {
            minPerimeter = 4;
        } else {
            minPerimeter = 2 * (N + 1);
        }
        long square = (long)i * i;
        while (square <= N) {
            if (N % i == 0) {
                int pairFactor =  N / i;
                int perimeter = 2 * (i + pairFactor);
                minPerimeter = Math.min(perimeter, minPerimeter);
            }
            i++;
            square = i * i;
        }
        return minPerimeter;
    }

}
