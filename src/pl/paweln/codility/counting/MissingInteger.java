package pl.paweln.codility.counting;

import pl.paweln.codility.core.BaseCodilitySolution;

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
public class MissingInteger extends BaseCodilitySolution {

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


}
