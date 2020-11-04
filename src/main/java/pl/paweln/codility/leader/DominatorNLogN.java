package pl.paweln.codility.leader;

import java.util.Arrays;

public class DominatorNLogN extends Dominator {

    @Override
    protected int solution (int[] A) {
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
