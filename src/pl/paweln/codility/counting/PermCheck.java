package pl.paweln.codility.counting;

import java.util.HashSet;
import java.util.Set;

/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class PermCheck {
    public int solution(int[] A) {

        if (A.length == 0) return 0;

        Set<Integer> missingPermValues = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            missingPermValues.add(Integer.valueOf(i+1));
        }

        for (int i = 0; i < A.length; i++) {
            if (missingPermValues.contains(Integer.valueOf(A[i]))) {
                missingPermValues.remove(Integer.valueOf(A[i]));
            }
        }

        return missingPermValues.size() == 0 ? 1 : 0;
    }


    public int solution2(int[] A) {

        if (A.length == 0) return 0;

        int sumOfElements = 0;
        int expectedSumOfElements = 0;
        int[] countArray = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {

            if (A[i] >= countArray.length)
                return 0;

            if (countArray[A[i]] != 0)
                return 0;

            countArray[A[i]]++;

            sumOfElements += A[i];
            expectedSumOfElements += i + 1;

        }

        if (sumOfElements == expectedSumOfElements)
            return 1;
        else
            return 0;
    }
}
