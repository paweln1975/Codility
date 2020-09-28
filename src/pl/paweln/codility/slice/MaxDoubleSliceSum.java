package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 *
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 *
 * For example, array A such that:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * contains the following example double slices:
 *
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class MaxDoubleSliceSum implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        if (A.length < 3) {
            throw new IllegalArgumentException("Array too small. Min 3 elements are required.");
        }
        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big. Max 100 000 elements are supported.");
        }
        return new int[] {this.solution(A)};
    }


    public int solution(int[] A) {
        int max_ending = 0;
        int[] max_ending_sum = new int[A.length];

        int max_starting = 0;
        int[] max_starting_sum = new int[A.length];

        int max_double_slice = 0;

        for (int i = 1; i < A.length - 1; i++) {
            max_ending = Math.max(0, max_ending+A[i]);
            max_ending_sum[i] = max_ending;
        }

        for (int i = A.length - 2; i > 0; --i) {
            max_starting = Math.max(0, max_starting+A[i]);
            max_starting_sum[i] = max_starting;
        }

        for(int i = 0; i < A.length - 2; ++i) {
            max_double_slice = Math.max(max_double_slice, max_ending_sum[i] + max_starting_sum[i+2]);
        }

        return max_double_slice;
    }
}
