package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types
 * of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of
 * types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of
 * the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries,
 * which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to
 * find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2
 * respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */

public class GenomicRangeQuery implements CodilitySolution<Integer> {
    @Override
    public int[] solution(String S, int[] P, int[] Q) {
        if (P.length != Q.length) {
            throw new IllegalArgumentException("P has different size then Q.");
        }

        int[] result = new int [P.length];
        int dnaLength = S.length();
        int[] resultValues = new int[] {1, 2, 3, 4};

        // table is one element bigger to calculate correctly for the first element
        int[][] prefixSums = new int[S.length()+1][4]; // all set to 0 I believe

         // calculate prefix sum - how many time the letter exists up to current position
        for (int i = 0; i < dnaLength; i++) {
            if (S.charAt(i) == 'A') {
                prefixSums[i+1][0] = prefixSums[i][0] + 1;
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][2] = prefixSums[i][2];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'C') {
                prefixSums[i+1][1] = prefixSums[i][1] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][2] = prefixSums[i][2];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'G') {
                prefixSums[i+1][2] = prefixSums[i][2] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][3] = prefixSums[i][3];
            } else if (S.charAt(i) == 'T') {
                prefixSums[i+1][3] = prefixSums[i][3] + 1;
                prefixSums[i+1][0] = prefixSums[i][0];
                prefixSums[i+1][1] = prefixSums[i][1];
                prefixSums[i+1][2] = prefixSums[i][2];
            } else {
                throw new IllegalArgumentException("DNA contains illegal character.");
            }
        }

        // for each range calculate how many time each letter occurs in the range
        for (int i = 0; i < P.length ; i++) {
            int beginIdx = P[i];
            int endIdx = Q[i] + 1;


            // check how many time each letter exists
            for (int j = 0; j < resultValues.length; j++) {
                int count = prefixSums[endIdx][j] - prefixSums[beginIdx][j];
                if (count > 0) {
                    result[i] = resultValues[j];
                    break;
                }
            }


        }
        return result;
    }

    @Override
    public int solution(int N) {
        return 0;
    }

    @Override
    public Integer solution(int[] A, int N) {
        return 0;
    }

    @Override
    public int solution(int[] A) {
        return 0;
    }

    @Override
    public int solution(int X, int Y, int Z) {
        return 0;
    }


}
