package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;

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
public class CountDiv implements CodilitySolution {
    @Override
    public int solution(int A, int B, int K) {
        if (A > B) throw new IllegalArgumentException("A > B");
        int result = 0;
        if (A % K == 0) {
            result++;
        }
        result+= B / K - A / K;
        return result;
    }

    @Override
    public int solution(int N) {
        return 0;
    }

    @Override
    public Object solution(int[] A, int N) {
        return null;
    }

    @Override
    public int solution(int[] A) {
        return 0;
    }

    @Override
    public int[] solution(String S, int[] P, int[] Q) {
        return new int[0];
    }
}
