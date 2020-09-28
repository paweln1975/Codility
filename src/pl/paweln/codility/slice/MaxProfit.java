package pl.paweln.codility.slice;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days.
 * If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal
 * to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 *
 * For example, consider the following array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048.
 * If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354.
 * Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
 *
 * Write a function,
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns
 * the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
 *
 * For example, given array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * the function should return 356, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 */
public class MaxProfit implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        return new int[] {this.solution(A)};
    }


    public int solution(int[] A) {
        int max_ending = 0;
        int max_slice = 0;

        if (A.length < 1) {
            return 0;
        }

        int[] diff = new int[A.length-1];
        for (int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i+1] - A[i];
        }

        for (int d : diff) {
            max_ending = Math.max(0, max_ending+d);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }


}
