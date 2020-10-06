package pl.paweln.codility.prime;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/**
 * An integer N is given, representing the area of some rectangle.
 *
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 *
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
 *
 * For example, given integer N = 30, rectangles of area 30 are:
 *
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 *
 * For example, given an integer N = 30, the function should return 22, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000,000].
 */

public class MinPerimeterRectangle implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int N = params.getN();
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive greater then 0.");
        }

        if (N > 1000000000) {
            throw new IllegalArgumentException("Value of N too big. Max value is 1,000,000,000.");
        }
        return new int[] {this.solution(N)};
    }

    private int solution(int N) {
        int i = 2;
        int minPerimeter;

        if (N == 1) {
            minPerimeter = 4;
        } else {
            minPerimeter = 2 * (N + 1);
        }
        long square = i * i;
        while (square <= N) {
            if (N % i == 0) {
                int pairFactor =  N / i;
                int perimeter = 2 * (i + pairFactor);
                minPerimeter = Math.min(perimeter, minPerimeter);
            }
            i++;
            square = i * i;
        }
        return minPerimeter;
    }

}
