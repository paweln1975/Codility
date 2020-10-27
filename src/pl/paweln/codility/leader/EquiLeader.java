package pl.paweln.codility.leader;

import pl.paweln.codility.core.CodilitySolution;
import pl.paweln.codility.core.SolutionInputParams;

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
