package pl.paweln.codility.counting;

import pl.paweln.codility.core.BaseCodilitySolution;
import pl.paweln.codility.core.Solution;
import pl.paweln.codility.core.SolutionInputParams;

/*
A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river
(position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position
where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only
when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when
all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is
negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can
jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Assume that:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(X) (not counting the storage required for input arguments).
 */
public class FrogRiverOne implements Solution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int X = params.getX();
        int[] tab = params.getFirstArray();

        if (tab.length == 0 || tab.length > 100000)
            throw new IllegalArgumentException("Array size must be within range 1 .. 100000");

        if (X < 0 || X > 100000)
            throw new IllegalArgumentException("X must be within range 1 .. 100000");

        return new int[] {this.solution(X, tab)};
    }

    public int solution(int X, int[] A) {
        int[] tabPositions = new int[X];
        int expectedSum = (1 + X) * X / 2;
        int pos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < tabPositions.length+1) {
                if (tabPositions[A[i]-1] == 0) {
                    expectedSum-= A[i];
                    tabPositions[A[i]-1]++;
                    if (expectedSum == 0) {
                        pos = i;
                        break;
                    }
                }
            }
        }

        if (expectedSum == 0) {
            return pos;
        } else {
            return -1;
        }
    }



}
