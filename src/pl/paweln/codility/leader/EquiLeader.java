package pl.paweln.codility.leader;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

/*
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.
An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and
A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
public class EquiLeader implements CodilitySolution {

    @Override
    public int[] solution(SolutionInputParams params) {
        int[] A = params.getFirstArray();

        if (A.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty.");
        }

        if (A.length > 100000) {
            throw new IllegalArgumentException("Input array too big.");
        }
        return new int[] {this.solution(A)};
    }

    public int solution (int[] A) {
        int equiLeaderCount = 0;
        int leader;
        int leaderCount = 0;
        int localLeaderCount = 0;

        // first find the leader
        Dominator dominator = new Dominator();
        int idx = dominator.solution(A);
        if (idx >=0) {
            leader = A[idx];
            // count how many leaders are in the table
            for (int value : A) {
                if (value == leader) {
                    leaderCount++;
                }
            }
            // if we split array into two parts leader will be same in both parts as the leader for the whole table
            // iterate over source array and count the number of leader occurrences till current index and after it
            for (int i = 0; i < A.length; i++) {
                if (A[i] == leader) {
                    localLeaderCount++;
                }

                if (localLeaderCount > (i+1) / 2 && (leaderCount - localLeaderCount) > (A.length - i - 1) / 2 ) {
                    equiLeaderCount++;
                }

            }
        }

        return equiLeaderCount;
    }
}
