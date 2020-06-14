package pl.paweln.codility.prefixsums;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal
 * average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */

public class MinAvgTwoSlice implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length < 2) {
            throw new IllegalArgumentException("Array too small.");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Array too big.");
        }


        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {


        int idxOfMinSliceAvg = 0;
        float minSliceAvg = 0;

        int[] prefixSums = new int [A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            prefixSums[i] = prefixSums[i-1] + A[i-1];
        }

        for (int sliceLength = 2; sliceLength <= 3; sliceLength++) {
            if (A.length == 2 && sliceLength == 3) {
                continue;
            }
            for (int i = 1; i < prefixSums.length - sliceLength + 1; i++) {
                if (i == 1 && sliceLength == 2) {
                    minSliceAvg = this.calculateSliceAvg(prefixSums, i, i + sliceLength - 1);
                    idxOfMinSliceAvg = 0;
                } else {
                    float tmpSliceAvg = this.calculateSliceAvg(prefixSums, i, i + sliceLength - 1);
                    if (tmpSliceAvg < minSliceAvg) {
                        minSliceAvg = tmpSliceAvg;
                        idxOfMinSliceAvg = i - 1;
                    }

                }
            }
        }

        return idxOfMinSliceAvg;
    }

    private float calculateSliceAvg (int[]T, int startIdx, int endIdx) {
        if (endIdx <= startIdx) {
            throw new IllegalArgumentException("Wrong index values.");
        }
        float sum = (float)T[endIdx] - (float)T[startIdx-1];
        float count = (float)endIdx - (float)startIdx + 1f;
        return sum / count;
    }



}
