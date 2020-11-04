package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

public class CountDiv implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int A = params.getA();
        int B = params.getB();
        int K = params.getK();

        if (A > B) throw new IllegalArgumentException("Invalid input parameters: A > B.");
        if (A < 0 || A > 2000000000) throw new IllegalArgumentException("Invalid A value - not in range.");
        if (B > 2000000000) throw new IllegalArgumentException("Invalid B value - not in range.");
        if (K < 1 || K > 2000000000) throw new IllegalArgumentException("Invalid K value - not in range.");

        return new int[] {this.solution(A, B, K)};
    }

    private int solution(int A, int B, int K) {
        if (A > B) throw new IllegalArgumentException("A > B");
        int result = 0;
        if (A % K == 0) {
            result++;
        }
        result+= B / K - A / K;
        return result;
    }


}
