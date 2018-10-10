package pl.paweln.codility.counting;

import pl.paweln.codility.core.CodilitySolution;

import java.util.Arrays;

/*
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MissingInteger implements CodilitySolution {

    public int solution(int[] A) {
        int prevValue = 0;

        // TODO implement quick sort - for training purposes only
        Arrays.sort(A);

        for (int aA : A) {
            if (aA > 0) {
                if (aA - prevValue > 1) {
                    break;
                } else {
                    prevValue = aA;
                }
            }
        }


        return ++prevValue;
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
