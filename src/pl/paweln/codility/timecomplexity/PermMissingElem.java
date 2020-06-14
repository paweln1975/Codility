package pl.paweln.codility.timecomplexity;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.math.BigInteger;
import java.util.Arrays;

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class PermMissingElem implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();
        int N = A.length;
        if (N > 100000) {
            throw new IllegalArgumentException("Array to big.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution (int [] A) {
        int N = A.length;
        if (N == 0) return 1;

        BigInteger sum = BigInteger.valueOf(0);

        for (int elem: A) {
            sum = sum.add(BigInteger.valueOf(elem));
        }

        BigInteger expectedSum = BigInteger.valueOf(2L + N).multiply(BigInteger.valueOf(1L + N)).divide(BigInteger.valueOf(2));

        return expectedSum.subtract(sum).intValue();
    }


    public int solution2(int[] A) {
        int previous = 0;
        if (A.length != 0) {
            Arrays.sort(A);
            for (int i : A) {
                if (++previous != i) {
                    return previous;
                }
            }
        }
        return ++previous;
    }

    public int solution3(int[] A) {

        long N = 1L + A.length;
        long total = N * (N + 1L) / 2L;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }


}
