package pl.paweln.codility.leader;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

import java.util.Arrays;

/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the
elements of A.
For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7)
and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of
A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

public class Dominator implements CodilitySolution {
    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length > 100000) {
            throw new IllegalArgumentException("Input array too big.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution(int[] A) {
        return this.solutionOptimal(A);
    }

    /**
     * if the sequence A0, A1, . . . ,An-1 contains a leader, then after removing a pair of
     * elements of different values, the remaining sequence still has the same leader. Indeed, if we
     * remove two different elements then only one of them could be the leader.
     * Removing pairs of different elements is not trivial. Let’s create an empty stack onto which
     * we will be pushing consecutive elements. After each such operation we check whether the two
     * elements at the top of the stack are different. If they are, we remove them from the stack.
     * Finally, we should iterate through all the elements and count the occurrences of the candidate
     * @param A input array
     * @return index of the leader otherwise -1
     */
    private int solutionOptimal(int[] A) {
        int stackSize = 0;
        int lastValue = 0;
        int halfSize = A.length/2;
        int candidate;
        int idx = -1;
        for (int value : A) {
            if (stackSize == 0) {
                stackSize++;
                lastValue = value;
            } else {
                if (lastValue != value) {
                    stackSize--;
                } else {
                    stackSize++;
                }
            }
        }

        if (stackSize > 0) {
            candidate = lastValue;
            int count = 0;
            for (int i = 0; i < A.length ; i++) {
                if (A[i] == candidate) {
                    count++;
                    if (count > halfSize) {
                        idx = i;
                        break;
                    }
                }
            }
        }

        return idx;
    }

    /**
     * quadratic computational complexity
     * count the occurrences of every element
     * @param A input array
     * @return index of the leader otherwise -1
     */
    private int solutionNotOptimal1 (int[] A) {

        int idx = -1;
        int halfSize = A.length/2;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int value : A) {
                if (value == A[i]) {
                    count++;
                }
            }
            if (count > halfSize) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    /**
     * nlog(n) complexity
     * Having sorted the sequence, count slices of the same values and find the leader
     * if the leader occurs somewhere in our sequence, then it must occur at index n/2
     * (the central element). This is because, given that the leader occurs in more
     * than half the total values in the sequence, there are more leader values than will fit on either
     * side of the central element in the sequence.
     * @param A input array
     * @return index of the leader otherwise -1
     */
    private int solutionNotOptimal2 (int[] A) {
        //
        int idx = -1;
        int candidate;
        boolean dominatorFound = false;

        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);

        int halfSize = A.length/2;

        if (halfSize < A.length) {
            candidate = B[halfSize];
            int count = 0;
            for (int value : B) {
                if (value == candidate) {
                    count++;
                    if (count > halfSize) {
                        dominatorFound = true;
                        break;
                    }
                }
            }

            if (dominatorFound) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == candidate) {
                        idx = i;
                        break;
                    }
                }
            }


        }

        return idx;
    }
}
