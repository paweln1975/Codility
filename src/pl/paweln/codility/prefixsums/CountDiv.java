package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.Solution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible
 * by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
public class CountDiv implements Solution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int A = params.getA();
        int B = params.getB();
        int K = params.getK();

        if (A > B) throw new IllegalArgumentException("A > B");
        if (A < 0 || A > 2000000000) throw new IllegalArgumentException("Invalid A value - not in range.");
        if (B > 2000000000) throw new IllegalArgumentException("Invalid B value - not in range.");
        if (K < 1 || K > 2000000000) throw new IllegalArgumentException("Invalid K value - not in range.");

        return new int[] {this.solution(A, B, K)};
    }

    public int solution(int A, int B, int K) {
        if (A > B) throw new IllegalArgumentException("A > B");
        int result = 0;
        if (A % K == 0) {
            result++;
        }
        result+= B / K - A / K;
        return result;
    }


}
