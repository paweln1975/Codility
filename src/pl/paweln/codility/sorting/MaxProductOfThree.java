package pl.paweln.codility.sorting;

import pl.paweln.codility.core.Solution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;
/*
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to
A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */

public class MaxProductOfThree implements Solution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length < 3) {
            throw new IllegalArgumentException("Array too small. Minimal length is 3.");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big.");
        }


        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        int N = A.length;
        int product;
        int positiveCounter = 0;
        int[] values = new int[3];

        if (N == 3) {
            product = A[N-1] * A[N-2] * A[N-3];
        } else {
            Arrays.sort(A);

            for (int i = N-1; i >= 0; i--) {
                if (positiveCounter == 3) {
                    if (A[N-3] * A[N-2] < A[0] * A[1]) {
                        values[1] = A[0];
                        values[2] = A[1];
                    }
                    break;
                }
                if (A[i] > 0) {
                    positiveCounter++;
                    values[positiveCounter-1] = A[i];
                } else if (A[i] <= 0 && (positiveCounter == 1 || positiveCounter == 2)) {
                    values[1] = A[0];
                    values[2] = A[1];
                    break;
                } else if (A[i] <= 0 && positiveCounter == 0) {
                    values[0] = A[i];
                    values[1] = A[i-1];
                    values[2] = A[i-2];
                    break;
                }
            }
            product = values[0] * values[1] * values[2];
        }



        return product;
    }


    // solution from internet - nice one as well with three maxes and 2 minis
    public int solution2(int[] A) {

        int[] max_values = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        // Invariant: max_values[0] <= max_values[1] <= max_values[2]

        int[] min_values = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        // Invariant: min_values[0] <= min_values[1]

        // O(n)
        for( int a : A )
        {
            updateMaxValues( a, max_values );
            updateMinValues( a, min_values );
        }

        int obvious = max_values[0] * max_values[1] * max_values[2];
        int twoBigNegs = min_values[0] * min_values[1] * max_values[2];
        return Math.max( obvious, twoBigNegs );
    }

    private static void updateMaxValues(int a, int[] pMaxValues )
    {
        if( a >= pMaxValues[2] ) {
            // Found new max, shift down
            pMaxValues[0] = pMaxValues[1];
            pMaxValues[1] = pMaxValues[2];
            pMaxValues[2] = a;
        } else if( a >= pMaxValues[1] ) {
            pMaxValues[0] = pMaxValues[1];
            pMaxValues[1] = a;
        } else if( a > pMaxValues[0] ) {
            pMaxValues[0] = a;
        }
    }

    private static void updateMinValues(int a, int[] pMinValues )
    {
        if( a <= pMinValues[0] ) {
            // Found new min, shift down
            pMinValues[1] = pMinValues[0];
            pMinValues[0] = a;
        } else if( a < pMinValues[1] ) {
            pMinValues[1] = a;
        }
    }
}
