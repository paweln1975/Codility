package pl.paweln.codility.leader;

import java.util.Arrays;

public class DominatorNLogN extends Dominator {
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
    @Override
    public int solution (int[] A) {
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
