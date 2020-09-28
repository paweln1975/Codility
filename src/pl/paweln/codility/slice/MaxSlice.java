package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N,
 * is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 *
 * For example, given array A such that:
 *
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 *
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 *
 *
 * Let’s define a problem relating to maximum slices. You are given a sequence of n integers
 * a0, a1, . . . , an−1 and the task is to find the slice with the largest sum. More precisely, we are
 * looking for two indices p, q such that the total ap + ap+1 + . . . + aq is maximal. We assume
 * that the slice can be empty and its sum equals 0.
 * For each position, we compute the largest sum that ends in that position. If we assume that the maximum sum of a slice
 * ending in position i equals max_ending, then the maximum slice ending in position i+1 equals max(0, max_ending+ ai+1).
 */
public class MaxSlice implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        if (A.length < 1) {
            throw new IllegalArgumentException("Array must contain at least 1 element.");
        }

        if (A.length > 1000000) {
            throw new IllegalArgumentException("Array too big.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        int absoluteMax = A[0];
        int localMax = A[0];
        int currentElement;
        int nextSum;

        for (int i = 1; i < A.length; i++) {
            currentElement = A[i];
            nextSum = localMax + currentElement;
            localMax = Math.max(A[i], nextSum);
            absoluteMax = Math.max(absoluteMax, localMax);
        }
        return absoluteMax;
    }


}
