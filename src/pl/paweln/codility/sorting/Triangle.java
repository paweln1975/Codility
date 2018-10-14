package pl.paweln.codility.sorting;

import pl.paweln.codility.core.CodilitySolution;

import java.util.Arrays;

/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and
returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

public class Triangle implements CodilitySolution {
    @Override
    public int solution(int[] A) {
        if (A.length < 3) {
            throw new IllegalArgumentException("Array to small.");
        }
        Arrays.sort(A);
        for (int i = A.length-1; i >= 2; i--)
        {

            int l = 0; // index of the first element in A[0..i-1]
            int r = i-1; // index of the last element in A[0..i-1]
            while (l < r)
            {
                // A triplet found
                if (isTriplet(A[l], A[r], A[i]))
                    return 1;

                if (A[l] + A[r] <= A[i])
                    l++;
                else
                    r--;
            }
        }

        return 0;
    }

    private boolean isTriplet(int X, int Y, int Z) {
        return (X + Y > Z && X + Z > Y && Z + Y > X);
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
    public int solution(int X, int Y, int Z) {
        return 0;
    }

    @Override
    public int[] solution(String S, int[] P, int[] Q) {
        return new int[0];
    }
}
