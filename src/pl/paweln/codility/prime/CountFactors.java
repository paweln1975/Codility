package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class CountFactors implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        return new int[] {this.solution(N)};
    }

    public int solution (int N) {
        long i = 2;
        int countFactors;

        if (N == 1) {
            countFactors = 1;
        } else {
            countFactors = 2;
        }
        while (i * i <= N) {
            if (N % i == 0) {
                countFactors++;
                long pairFactor = N / i;
                if (pairFactor != i) {
                    countFactors++;
                }
            }
            i++;
        }
        return countFactors;
    }
}
